import java.util.Hashtable;
import java.util.Iterator;
import java.util.ArrayList;

import javax.management.RuntimeErrorException;

import java.util.Enumeration;

/* The library class is a child of the Building class */
public class Library extends Building {
    private Hashtable<String, Boolean> collection;
    private boolean hasElevator;

    /* Default constructor */
    public Library() {
      this("<Name Unknown>", "<Address Unknown>", 1, true);
    }

    /* Library constructor with name and number of floors only */
    public Library(String name, int nfloors) {
      this();
      this.name = name; //overrides name
      this.nFloors = nfloors; //overrides nfloors
    }
    /*
     * Full Constructor for Library
     * @param String name is the name of the library
     * @param String address is the location of the library
     * @param nfloors is the number of floors in the library
     */
    public Library(String name, String address, int nfloors, boolean hasElevator) {
      super(name, address, nfloors);
      this.hasElevator = hasElevator;
      //System.out.println("You have built a library: 📖");
      this.collection = new Hashtable<String, Boolean>();
    }

    /*
     * addTitle adds a book to the library's hashtable and makes it available to checkout
     * @param String title is the title and author of the book that is added
     */
    public void addTitle(String title) {
        this.collection.put(title, true);
    }

    public void addTitle(ArrayList<String> booknames) {  
      for(int i=0; i<booknames.size(); i++) {
        this.collection.put(booknames.get(i), true);
      }
    }
  
    /*
     * removeTitle removes the title from the shelves (removes the key and value from the library's hashtable)
     * @param String title - title and author of the book that is being deleted from the hashtable
     */
    public String removeTitle(String title) {
      this.collection.remove(title);
      return "We removed" + title;
    }

    /*
     * checkOut changes takes a title and changes the available boolean 
     * in the hashtable value from true to false as if the book has been checked out
     * @param String title the title of the book that is being "checked out"/whose value is changing in the hashtable
     */
    public void checkOut(String title) {
      this.collection.replace(title, false);
    }


    /*
     * returnBook takes a title and changes the available boolean 
     * in the hashtable value to true as if the book has been returned
     * @param String title the title of the book that is being "returned"/whose value is changing in the hashtable
     */
    public void returnBook(String title) {
      this.collection.replace(title, true);
    }

    /*
     * containsTitle takes title and tells if the library has the book
     * @param String title the title and author of the book
     * @return a true or false whether the book is in the library
     */
    public boolean containsTitle(String title) {
      return this.collection.contains(title);
    }

    /*
     * printCollection prints the entire collection 
     * by making the keys a Set and elements an enumeration 
     * that is iterated over 
     */
    public void printCollection() {
      Iterator<String> keys = this.collection.keySet().iterator();
      Enumeration<Boolean> values = this.collection.elements();

      while(keys.hasNext()) {
        System.out.print(keys.next());
        if (values.nextElement() == true) {
            System.out.println(" is in stock");
        } 
        else {
          System.out.println(" is not in stock");
        }
      }
    }

    /*goToFloor changes the floor in range of the library if the library has an elevator
     * @param int floorNum is the number that the user wants to go to in the library
    */
    public void goToFloor(int floorNum) {
      if (this.hasElevator == false) {
        throw new RuntimeException("This Library has no elevator you must move floor by floor");
      }
      if (this.activeFloor == -1) {
         throw new RuntimeException("You are not inside this Library. Must call enter() before navigating between floors.");
       }
      if (floorNum < 1 || floorNum > this.nFloors) {
          throw new RuntimeException("Invalid floor number. Valid range for this Library is 1-" + this.nFloors +".");
       }
      System.out.println("You are now on floor #" + floorNum + " of " + this.name + ("(Library)"));
      this.activeFloor = floorNum;
    }

    /* showOptions - method that displays all the methods that can be called on each instance of a library */
   public void showOptions() {
    System.out.print("Available options at " + this.name + ":\n + enter() \n + exit() \n + goUp() \n + goDown()\n + addTitle(title) \n + removeTitle(title)\n + checkOut(title)\n + returnBook(title) \n + containsTitle(title)\n + printCollection()");
    if (this.hasElevator == true) {
      System.out.println(" + goToFloor(n)");
      }
    }

  
    /*
     * Main method for testing
     * @param args the command line args ignored in this context
     */
    public static void main(String[] args) {
      /*Neilson library created as myLibrary to test library methods */
      Library myLibrary = new Library("Neilson", "IDK Chapin way", 4, true);
      myLibrary.addTitle("Cat in the hat by Doctor Seuss");
      myLibrary.addTitle("Dog with a blog by Jenny Dust");
      myLibrary.checkOut("Cat in the hat by Doctor Seuss");
      myLibrary.printCollection();
    }
  
  }