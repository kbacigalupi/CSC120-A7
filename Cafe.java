/* Cafe class extends the building class but has the ingredients and methods for 
making, selling, and restocking coffee*/
public class Cafe extends Building {
    private int nCoffeeOunces; // The number of ounces of coffee remaining in inventory
    private int nSugarPackets; // The number of sugar packets remaining in inventory
    private int nCreams; // The number of "splashes" of cream remaining in inventory
    private int nCups; // The number of cups remaining in inventory


    /* Default constructor */
    public Cafe() {
        this("<Name Unknown>", "<Address Unknown>", 1, 0, 0, 0, 0);
    }

    /*Constructor with just name, address & the number of floors 
     * @param String name of the cafe
     * @param String address of the cafe
     * @param int nFloors the number of floors in the cafe
    */
    public Cafe(String name, String address, int nFloors) {
        this.name = name;
        this.address = address;
        this.nFloors = nFloors;

    }

    /*Constructor with everything but the address because I never know the address of places
     * @param String name of the cafe
     * @param int nFloors the number of floors in the cafe
     * @param int nCF how many ounces of coffee the cafe starts with
     * @param int nSP number of sugar packets that the cafe starts with
     * @param int nCr number of creams the cafe starts with
     * @param int nCu number of cups the cafe starts with
     */
    public Cafe(String name, int nFloors, int nCF, int nSP, int nCR, int nCu ) {
        this();
        this.name = name;
        this.nFloors = nFloors;
        this.nCoffeeOunces = nCF;
        this.nSugarPackets = nSP;
        this.nCreams = nCR;
        this.nCups = nCu;
    }

    /*Constructor with ONLY the name & ingredients to make coffee (perhaps a virtual cafe?) 
     * @param String name of the cafe
     * @param int nCF how many ounces of coffee the cafe starts with
     * @param int nSP number of sugar packets that the cafe starts with
     * @param int nCr number of creams the cafe starts with
     * @param int nCu number of cups the cafe starts with
    */
    public Cafe(String name, int nCF, int nSP, int nCr, int nCu) {
        this();
        this.name = name;
        this.nCoffeeOunces = nCF;
        this.nSugarPackets = nSP;
        this.nCreams = nCr;
        this.nCups = nCu;
    }

    /*Full cafe constuctor
     * @param String name is the name of the cafe
     * @param String address where the cafe is located
     * @param int nfloors how many floors 
     * @param int nCF how many ounces of coffee the cafe starts with
     * @param int nSP number of sugar packets that the cafe starts with
     * @param int nCr number of creams the cafe starts with
     * @param int nCu number of cups the cafe starts with
     */

    public Cafe(String name, String address, int nfloors, int nCF, int nSP, int nCr, int nCu) {
        super(name, address, nfloors);
        this.nCoffeeOunces = nCF;
        this.nSugarPackets = nSP;
        this.nCreams = nCr;
        this.nCups = nCu;
    }

    /*
     * sellCoffee Changes the inventory as if the coffee has been sold
     * @param int size
     * @param int nSugarPackets
     * @param int nCreams
     */
    public void sellCoffee(int size, int nSugarPackets, int nCreams) {
        this.nCoffeeOunces -= size;
        this.nSugarPackets -= nSugarPackets;
        this.nCreams -= nCreams;
        this.nCups -= 1;

        if (this.nCoffeeOunces <= 0) {
            restock(size, 0, 0, 0);
        }

        if(this.nSugarPackets <= 0) {
            restock(0, nSugarPackets, 0, 0);
        }

        if(this.nCreams <= 0) {
            restock(0, 0, nCreams, 0);
        }

        if(this.nCups<=0){
            restock(0, 0, 0, 1);

        }
    }

    /* Restock - a private method called when the store runs out of an item & replenishes
     * @param 
    */
    private void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        this.nCoffeeOunces += nCoffeeOunces;
        this.nSugarPackets += nSugarPackets;
        this.nCreams += nCreams;
        this.nCups += nCups;
    }

     /*goToFloor changes the floor in range of the cafe but mostly tells the user they can only be on floor 1
     * @param int floorNum is the number that the user wants to go to in the cafe
    */
    public void goToFloor(int floorNum) {
        if (this.activeFloor == -1) {
           throw new RuntimeException("You are not inside this Cafe. Must call enter() before navigating between floors.");
         }
        System.out.println("There is only one publicly accessible floor of the cafe. You must stay on floor 1 of" + this.name);
      }

    /* showOptions - method that displays all the methods that can be called on a cafe */
    public void showOptions() {
        System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() \n + goUp() \n + goDown()\n + goToFloor(n) \n + sellCoffee(size,  nSugarPackets, nCreams)" );
    }
    
    /* main method (for testing)
     * @param args the command line args ignored in this context
    */
    public static void main(String[] args) {
        /*The compass cafe to test the methods */
        Cafe myCafe = new Cafe("Compass Cafe", "IDK", 10);
        myCafe.sellCoffee(30, 10, 15);
        System.out.println(myCafe.nCoffeeOunces);
        Cafe myCafeTwo = new Cafe();
        System.out.println(myCafeTwo.getName());


    }
    
}
