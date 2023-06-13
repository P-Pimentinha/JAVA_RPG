public class Boss {
    
    /* Class Variables */
  

    /* Instance Variables */
    private final String name;
    private float health;

    /* Constructors */
    public Boss(String name) {
        this.name = name;
        this.health = 100;
    }


    /* Instance Methods */
    public void takeDamage(float enemyAttack) {
    float damage = enemyAttack;
    this.health -= damage;
    if (this.health <= 0) {
      System.out.println("The Enemy is Dead");
      System.exit(1);
    } else {
      System.out.println("Current Health: " + this.health);
    }
  }

    /* Getters & Setters */
    public String getName() {
        return name;
    }

    public float getHealth() {
    return health;
    }

    @Override
    public String toString() {
        return name + " " + health;
    }


}
