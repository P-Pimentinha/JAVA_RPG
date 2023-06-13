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

    

    @Override
    public String toString() {
        return name + " " + health;
    }


}
