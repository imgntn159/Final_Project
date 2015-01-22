import java.util.*;
import java.io.*;

public class Room{
//private String roomName;
    private ArrayList<Item> items;
    private Boolean hasBed, hasStairs;
    private int floor, roomNum,seed;
    Random rand = new Random();

//constructors
    public Room(){
        this(0,0,10,false,false,100);
    }
    public Room(int floor, int roomNum){
        this(floor,roomNum,10,false,false,100);
    }
    public Room(int floor, int roomNum, Boolean bed, Boolean stairs, int seed){
        this(floor,roomNum,10,bed,stairs,seed);
    }
    public Room(int floor, int roomNum, int space, Boolean bed, Boolean stairs, int seed){
        setFloor(floor);
        setRoomNum(roomNum);
        setStuff(space);
        setBed(bed);
        setStairs(stairs);
        items=new ArrayList<Item>();
        setSeed(seed);
    }   


//get methods
    public Item getItem(int i){
        return items.get(i);
    }

    public String getStuffInRoom(){
	String str="";
	for (int i=0; i<items.size();i++){
	    str+=i+ ": "+items.get(i).getName()+", ";
	}
        return str.substring(0,str.length()-2);
    }
    public ArrayList getStuff(){
	return items;
    }
    public Boolean getBed(){
        return hasBed;
    }
    public int getFloor(){
        return floor;
    }
    public int getRoomNum(){
        return roomNum;
    }
    public Boolean getStairs(){
        return hasStairs;
    }

//set methods
    public void additem(Item item){
        items.add(item);
    }
    public void removeitem(Item item){
        items.remove(item);
    }
    public void setBed(boolean bed){
        hasBed=bed;
    }
    public void setStuff(int size){
        items=new ArrayList<Item>(size);
    }
    public void setFloor(int floor){
        this.floor=floor;
    }
    public void setRoomNum(int roomNum){
        this.roomNum=roomNum;
    }
    public void setStairs(boolean stairs){
        hasStairs=stairs;
    }
    public void setSeed(int seed){
        this.seed = seed;
    }


    public String toString(){
        String str="";
        str+="Floor: "+getFloor()+"  Room Number: "+getRoomNum()+"  Stuff in Room: "+getStuff()+"  Has Bed: "+getBed()+"  Has Stairs: "+getStairs();
        return str;
    }

    public void fillItems(){
        ArrayList<Item> a = new ArrayList<Item>();
        try{
            Scanner s = new Scanner(new File("Foods.txt"));
            while(s.hasNextLine()){
                a.add(new Food(s.nextLine(), Integer.parseInt(s.nextLine()), Integer.parseInt(s.nextLine()), Boolean.parseBoolean(s.nextLine())));
            }
        } catch (FileNotFoundException e){
            System.out.println("Food failed");
            return;
        }
        try{
            Scanner s = new Scanner(new File("Medicines.txt"));
            while(s.hasNextLine()){
                a.add(new Medicine(s.nextLine(), Integer.parseInt(s.nextLine()), Integer.parseInt(s.nextLine())));
            }
        } catch (FileNotFoundException e){
            System.out.println("Medicine failed");
            return;
        }
        int num = rand.nextInt(4) + 1;
        for (int i = 0;i < num;i++){
            items.add(a.get(rand.nextInt(a.size())));
        }
    }
}
