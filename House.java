import java.util.ArrayList;

/* The house class is a child of the building class with additional features 
 * of residents and if the house has a dining room. 
 */
public class House extends Building {
  private ArrayList<String> residents;
  private boolean hasDiningRoom;
  private boolean hasElevator;

  
  /* Default constructor */
  public House() {
    this("<Name Unknown>", "<Address Unknown>", 1, false, false);
  }

  /* House with just name and floors*/
  public House(String name, int nFloors) {
    this();
    this.name = name;
    this.nFloors = nFloors;
  }

  /* House Constructor-makes a house and tells the user which house has been made
   * @param name of the house is a string
   * @param address string address of the house
   * @param nfloors an integer describing the number of floors of the house
   * @param hDR a boolean telling how many floors the house
   */

  public House(String name, String address, int nfloors, boolean hDR, boolean hasElevator) {
    super(name, address, nfloors);
    this.residents = new ArrayList<String>();
    this.hasDiningRoom = hDR;
    this.hasElevator = hasElevator;

    for (int i = 0; i<residents.size(); i++) {
        System.out.println(residents.get(i));
    }
  }

  /*
   * An accessor for number of residents
   * @return the number of residents living in a house
   */
  public int getnResidents() {
    return this.residents.size();

  }

  /*
   * An accessor for whether the house has a dining room or not
   * @return true (has a dining room) or false (doesn't have a dining room)
   */
  public boolean getHasDiningRoom() {
    return this.hasDiningRoom;
  }

  /*
   * Adds new name to the array list of 
   * @param String name of the new resident
   */
  public void moveIn(String name) {
    this.residents.add(name);
  }

  public void moveIn(ArrayList<String> names) {  
    for(int i=0; i<names.size(); i++) {
      this.residents.add(name);
    }

  }

  /*
   * Removes someone from the residents array
   * @param name of the person moving out
   * @return the name of the person who moved out
   */
  public String moveOut(String name) {
    this.residents.remove(name);
    return name + " moved out";
  }

  /* 
   * isResident 
   * @param name of the person that may/may not be a resident of the house
   * @return boolean whether the person is in the arraylist of residents
   */
  public boolean isResident(String person) {
    return this.residents.contains(person);
  }

  /*goToFloor changes the floor in range of the house if the house has an elevator
   * @param int floorNum is the number that the user wants to go to in the house
  */
  public void goToFloor(int floorNum) {
    if (this.hasElevator == false) {
      throw new RuntimeException("This house has no elevator you must move floor by floor");
    }
    if (this.activeFloor == -1) {
      throw new RuntimeException("You are not inside this house. Must call enter() before navigating between floors.");
    }
    if (floorNum < 1 || floorNum > this.nFloors) {
      throw new RuntimeException("Invalid floor number. Valid range for this house is 1-" + this.nFloors +".");
    }
    System.out.println("You are now on floor #" + floorNum + " of " + this.name + "house");
    this.activeFloor = floorNum;
  }

   /* showOptions - method that displays all the methods that can be called on each instance of a house */
   public void showOptions() {
    System.out.print("Available options at " + this.name + ":\n + enter() \n + exit() \n + goUp() \n + goDown()\n + getnResidents() \n + moveIn(name) \n + moveOut(name) \n + getHasDiningRoom \n + isResident(name) \n + getnResidents() \n");
    if (this.hasElevator == true) {
      System.out.println(" + goToFloor(n)");
    }   
}

  /* main method (for testing)
     * @param args the command line args ignored in this context
    */
  public static void main(String[] args) {
    /* House to test out house methods */
    House BOTQ = new House("BOTQ", "1 Chapin Way", 4, false, false);
    BOTQ.moveIn("Kathleen");
    System.out.println(BOTQ.isResident("Kathleen"));
    System.out.println(BOTQ.moveOut("Kathleen"));
    System.out.println(BOTQ.isResident("Kathleen"));
    House Scales = new House("Scales", "1 Mendall Road", 4, true, true);
    Scales.showOptions();
    BOTQ.showOptions();
  }

}