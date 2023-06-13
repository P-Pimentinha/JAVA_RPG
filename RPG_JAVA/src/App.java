import java.util.Scanner;
import java.util.Objects;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.FileInputStream;

public class App {

     /* Instance Variables */
    private Player player;
    private Boss boss;

    public static void main(String[] args) throws Exception {

        
        Scanner console = new Scanner(System.in);
        App game = new App();
        Art.homeScreen();
        game.addDelay(3000);
        // System.out.print("\033[H\033[2J");
        // System.out.flush();
        //cleans the console
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        game.boss = new Boss("Devil");
        game.player = game.start(console);

        LevelOne levelOne = new LevelOne(game.player, game.boss);
        levelOne.startLevelOne(console);

        // System.out.println("Health: " + game.player.getHealth() + " " + game.player.getCurrentWeapon());

        // System.out.print("\033[H\033[2J");
        // System.out.flush();


        
       
    }

    /* Instance Methods */
  private Player start(Scanner console) {
    // // Add start functionality here
    // Player player;
    // Art.homeScreen();

    // //gets user input
    // System.out.println("Would you like to start a new game press y (New Game) or n (to Load Game)");
    // String answer = console.next().toLowerCase();


    // while (true) {
    //     addDelay(500);
        
    //     if (answer.equals("n")) {
    //         System.out.print("\nAhh... I knew I remembered you, what was your name again? Let me see if I can find your backpack: ");
    //         player = load(console.next(), console);
    //         break;

    //      }else if (answer.equals("y")) {
    //         System.out.print("\nWell then, don't be shy, go ahead and tell me your name: ");
    //         String possibleName = console.next();

    //     while (true) {
    //     System.out.println("Welcome " + possibleName + ", am I pronouncing that correctly? (Enter 'y' to confirm, 'n' to enter a new name");
    //     String nameResponse = console.next().toLowerCase();
    //     if (Objects.equals(nameResponse, "y")) break;
    //     System.out.println("So sorry, can you spell it for me again?");
    //     possibleName = console.next();
    //     }

    //     player = new Player(possibleName);
    //     break;
    // } else {
    //     System.out.print("Sorry adventurer, I only speak the common tongue. Please enter 'n' to load a game or 'y' to start a new game: ");
    //     answer = console.next().toLowerCase();
    // }
    // }

    Player player = new Player("Ratatui");
    return player;
  } // End of start

  private void save() {
    // Add save functionality here
    String filename = player.getName() + ".svr";
    try{
      FileOutputStream userSaveFile = new FileOutputStream(filename);
    ObjectOutputStream playerSaver = new ObjectOutputStream(userSaveFile);
    playerSaver.writeObject(player);
    }catch(IOException e){
      System.out.println("Operation not Possible at the moment");
    }
    
  } // End of save

  private Player load(String playerName, Scanner console) {
    // Add load functionality here
    Player loadedPlayer;
    try{
      FileInputStream userSavedFile = new FileInputStream(playerName + ".svr" );
      ObjectInputStream loadsPlayer = new ObjectInputStream(userSavedFile);
       loadedPlayer = (Player)loadsPlayer.readObject();
    }catch(IOException | ClassNotFoundException e){
        addDelay(1500);
        System.out.println("File not Found");
        addDelay(2000);
        loadedPlayer = new Player(playerName);
    }
    return loadedPlayer;
  } // End of load

  // Adds a delay to the console so it seems like the computer is "thinking"
  // or "responding" like a human, not instantly like a computer.
  private void addDelay(int time) {
    try {
      Thread.sleep(time);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
