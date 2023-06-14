import java.io.Serializable;

public class Player implements Serializable{

  /* Class Variables */
  

  /* Instance Variables */
  private final String name;
  private double health;
  private int numberOfPotions;

  private Weapon currentWeapon;

  private Helmet helmet;
  private Shirt shirt;
  private Trouser trouser;
  private Shoe shoe;
  private static final long serialVersionUID = 1L;
  
  /* Constructors */
  public Player(String name) {
    this.name = name;
    this.currentWeapon = new Weapon("Rusty Short Sword", 3);
    this.health = 100;
    this.numberOfPotions = 3;
  }

  /* Instance Methods */
  /* With getDefenseRating */
  // public void takeDamage(double enemyAttack) {
  //   double damage = enemyAttack - (getDefenseRating() / 5.0);
  //   this.health -= damage;
  //   if (this.health <= 0) {
  //     System.out.println("You have succumbed to the enemy, better luck next time.");
  //     System.exit(1);
  //   } else {
  //     System.out.println("Current Health: " + this.health);
  //   }
  // }

  /* Without getDefenseRating */
  public void takeDamage(double enemyAttack) {
    double damage = enemyAttack;
    this.health -= damage;
    if (this.health <= 0) {
      System.out.println("You have succumbed to the enemy, better luck next time.");
      
    } 
  }

   public void dealDamage(Boss boss){
    Boss bosS = boss;

     double randomNumberInRange = (double) (Math.random() * 16) + 15;
     bosS.takeDamage(randomNumberInRange);
  }

  public void heal() {
    this.health += getHealth() * 0.4;
    this.numberOfPotions --;
    if (this.health > 100) {
      this.health = 100;
    }
    System.out.println("You are now healed: " + getHealth());
  }

  /* Getters & Setters */
  public String getName() {
    return name;
  }

  public String getCurrentWeapon() {
    return "Currently wielding: " +
        currentWeapon.getName() +
        ". This weapon does " +
        currentWeapon.getDamage() +
        " damage.\n";
  }

  public void setCurrentWeapon(Weapon currentWeapon) {
    this.currentWeapon = currentWeapon;
  }

  public int getNumberOfPotions(){
    return this.numberOfPotions;
  }

  public double getHealth() {
    return health;
  }

  public int getDefenseRating() {
    return helmet.getDefenseRating() +
        shirt.getDefenseRating() +
        trouser.getDefenseRating() +
        shoe.getDefenseRating();
  }

  public Helmet getHelmet() {
    return helmet;
  }

  public void setHelmet(Helmet helmet) {
    this.helmet = helmet;
  }

  public Shirt getShirt() {
    return shirt;
  }

  public void setShirt(Shirt shirt) {
    this.shirt = shirt;
  }

  public Trouser getTrouser() {
    return trouser;
  }

  public void setTrouser(Trouser trouser) {
    this.trouser = trouser;
  }

  public Shoe getShoe() {
    return shoe;
  }

  public void setShoe(Shoe shoe) {
    this.shoe = shoe;
  }

  @Override
  public String toString() {
    return "\nCurrent Player: \n" +
        "Name: " + name + "\n" +
        "Health: " + getHealth() + "\n" +
        getCurrentWeapon() +
        "Equipped Armour: " + "\n" +
        "   Helmet: " + helmet +
        "   Shirt: " + shirt +
        "   Trousers: " + trouser +
        "   Shoes: " + shoe;
  }
}