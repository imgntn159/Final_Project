public class Item{
    private String name;

    public Item(){
	name = "Default_Item";
    }

    public Item(String name){
	this.name = name;
    }

    //Getters
    public String getName(){
	return name;
    }

    //Setters
    public void setName(String name){
	this.name = name;
    }

    //toString
    public String toString(){
	return name;
    }

    //"Helper" functions
    public int getHungerval(){
	return 0;
    }
    public void use(Character player){
    }

}