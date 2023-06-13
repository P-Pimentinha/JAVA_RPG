import java.util.Scanner;
import java.io.IOException;

public class LevelOne {

    Player player;

    // constructor
    public LevelOne(Player player){
        this.player = player; 
    }

    

    public void startLevelOne(Scanner y) throws Exception {
        while (true) {
            clearConsole();
            System.out.println("Your Health: " + player.getHealth() + "write exit to exit");
            
            
            enemyIntro();
            Art.levelOnePlayer();
            
            System.out.println("What are you going to do?");
            String action = y.nextLine().toLowerCase();
            playerAction(action);
            

            
        }
        


    }

    private void playerAction(String action){
        String act = action;

        if(act.equals("exit")){
                System.exit(1);
            }
        
        
    }

    private void enemyIntro() throws Exception {
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
    }

    private static void clearConsole() {
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
