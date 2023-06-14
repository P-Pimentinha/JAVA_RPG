import java.util.Scanner;
import java.io.IOException;

public class LevelOne {

    Player player;
    Boss boss;

    // constructor
    public LevelOne(Player player){
        this.player = player; 
        
    }

    public LevelOne(Player player, Boss boss){
        this.player = player; 
        this.boss = boss;
    }

    

    public void startLevelOne(Scanner y) {

        enemyIntro();

        while (true) {
            clearConsole();
            System.out.println("Your Health: " + player.getHealth() + " (write exit to exit)");
            Art.levelOnePlayer(); 
            while(true){
                System.out.println("What are you going to do?");
                String action = y.nextLine().toLowerCase();
                if(playerAction(action)){
                    break;
                }
            }
            
            addDelay(2000);
            clearConsole();
            System.out.println("Boss health: " + boss.getHealth());
            Art.levelOneEnemyOne();
            boss.dealDamage(player);
            System.out.println("THe Devil is Working its Magic");
            addDelay(3000);
        }
        
    }

    private boolean playerAction(String action){
        String act = action;
        
        
        if(act.equals("exit")){
                System.exit(1);
            }
        
        if(act.equals("attack")){
                player.dealDamage(boss);
                return true;
            }
        
        
        return false;
    }

    private void enemyIntro() {
        clearConsole();
        Art.levelOneEnemyOne();
        addDelay(400);
        clearConsole();
        Art.levelOneEnemyTwo();
        addDelay(400);
        clearConsole();
         Art.levelOneEnemyOne();
        addDelay(400);
        clearConsole();
        Art.levelOneEnemyTwo();
        addDelay(400);
        clearConsole();
        Art.levelOneEnemyOne();
        
        System.out.println("    I am Going To destroy You!");
        addDelay(3000);
        clearConsole();
         System.out.println(" \n \n \n");
        System.out.println("      An Evil just Showed Up to Protect The Castle!");
        System.out.println("                   Get Ready For a Fight");
        addDelay(4000);
        clearConsole();
        
    }

    private void clearConsole() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void exit(){
        System.exit(1);
    }

    private void addDelay(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
