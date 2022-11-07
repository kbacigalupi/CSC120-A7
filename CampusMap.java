import java.util.ArrayList;

public class CampusMap {

    ArrayList<Building> buildings;

    /* Default constructor, initializes empty ArrayList */
    public CampusMap() {
        buildings = new ArrayList<Building>();
    }

    /**
     * Adds a Building to the map
     * @param b the Building to add
     */
    public void addBuilding(Building b) {
        System.out.println("Adding building...");
        buildings.add(b);
        System.out.println("-->Successfully added " + b.getName() + " to the map.");
    }

    /**
     * Removes a Building from the map
     * @param b the Building to remove
     * @return the removed Building
     */
    public Building removeBuilding(Building b) {
        System.out.println("Removing building...");
        buildings.remove(b);
        System.out.println("-->Successfully removed " + b.getName() + " to the map.");
        return b;
    }

    public String toString() {
        String mapString = "DIRECTORY of BUILDINGS";

        for (int i = 0; i < this.buildings.size(); i ++) {
            mapString += "\n  " + (i+1) + ". "+ this.buildings.get(i).getName() + " (" + this.buildings.get(i).getAddress() + ")";
        }
        return mapString;
    }

    public static void main(String[] args) {
        CampusMap myMap = new CampusMap();
        myMap.addBuilding(new Building("Ford Hall", "100 Green Street Northampton, MA 01063", 4));
        myMap.addBuilding(new Building("Bass Hall", "4 Tyler Court Northampton, MA 01063", 4));
        myMap.addBuilding(new House("BOTQ", "1 Mendhall Road", 4, false, false));
        myMap.addBuilding(new House("Scales", 4));
        myMap.addBuilding(new Building("Seeyle Hall", "<Address Unknown>", 4));     
        myMap.addBuilding(new Cafe("Compass", 10, 10, 10, 10));
        myMap.addBuilding(new Cafe("Campus Centre Cafe", "1 Chapin Way Northhampton, MA 01063", 1, 10, 10, 50, 5));
        myMap.addBuilding(new House("King", "1 Mendhall Road", 4, true, true));
        myMap.addBuilding(new House("Jordan", 4));
        myMap.addBuilding(new House("Gardiner", 4));
        myMap.addBuilding(new House("Wilson", 4));
        myMap.addBuilding(new House("Cushing",4));
        myMap.addBuilding(new House("Emerson", 4));
        myMap.addBuilding(new House("Comstock", "2 Mendhall Road", 4, true, true));
        myMap.addBuilding(new House("Wilder", "2 Mendhall Road", 4, true, true));
        myMap.addBuilding(new Library("Hillyer", 3));
        myMap.addBuilding(new Library("Neilson", 4));
        System.out.println(myMap);
    }
    
}
