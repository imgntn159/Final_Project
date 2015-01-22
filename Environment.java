import java.util.*;

public class Environment{
    private ArrayList<Room> building;
    private int theSeed;
    
    // ArrayList<String> roomNames= new ArrayList<String>();
    Random rand=new Random();
    Room a;

    //constructors
    public Environment(){
	this(100);
    }
    public Environment(int randomSeed){
	building= new ArrayList<Room>();
	setSeed(randomSeed);
	theSeed = randomSeed;
    }
    

    //get method
    public ArrayList getBuilding(){
	return building;
    }
    public Room getRoom(int floor, int room){
	return building.get((floor-1)*5+room-1);
    }

    //set method
    /*
    public void setRoom(int place, String name){
	a=new Room(name,false);
	building.set(place, a);
    }
    */
    public void setSeed(long seed){
	rand.setSeed(seed);
    }
    public void setBuilding(){
	boolean hasBed;
	boolean hasStairs;
	int tempseed;
	for (int i=1; i<6; i++){
	    for (int x=1; x<6; x++){
		hasBed=false;
		hasStairs=false;
		if (x==5){
		    hasStairs=true;
		}
		if (rand.nextInt()%3==0){
		    hasBed=true;
		}
		tempseed = theSeed + x + i;
		a=new Room(i,x,hasBed,hasStairs,tempseed);
		a.fillItems();
		building.add(a);
	    }
	}
    }
    

    //other methods
    /*
    public void loadWordsFromFile(String fileName) throws FileNotFoundException{
	File input=new File(fileName);
	Scanner scan=new Scanner(input);
	while (scan.hasNext()){
	    for(int i=0; i<input.length();i++){
		roomNames.add(scan.next().toUpperCase());
	    }
	}
    }
    */


    
}
