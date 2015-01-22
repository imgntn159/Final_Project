public class TesterRoom{
    public static void main(String[]args){
	
	Room a= new Room();
	//System.out.println(a);
	a.fillItems();
	System.out.println(a.getStuff());
	
	Environment b= new Environment();
	b.setBuilding();
	//System.out.println(b.getBuilding());
	//System.out.println(b.getRoom(5,5));
	
	}

}
