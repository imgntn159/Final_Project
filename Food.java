public class Food extends Item{
    private boolean spoiled;
    private int hungerval;
    private int thirstval;
    public Food(){
	hungerval = 0;
	thirstval = 0;
	spoiled = false;
    }
    public Food(String name,int hunger,int thirst,boolean spoilage){
	super(name);
	hungerval = hunger;
	thirstval = thirst;
	spoiled = spoilage;
    }
    public Food(int hunger,int thirst,boolean spoilage){
	hungerval = hunger;
	thirstval = thirst;
	spoiled = spoilage;
    }

    //Getters
    public int getHungerval(){
	if(spoiled){
	    return hungerval*(-1);
	}
	return hungerval;
    }
    public int getThirstval(){
	return thirstval;
    }
    public boolean getSpoilage(){
	return spoiled;
    }

    //Setters
    public void setHungerval(int hunger){
	hungerval = hunger;
    }
    public void setThirstval(int thirst){
	thirstval = thirst;
    }
    public void setSpoilage(boolean spoilage){
	spoiled = spoilage;
    }

    //toString
    public String toString(){
	return getName() + " H:" + getHungerval() + " T:" + getThirstval() + " Spoiled:" + getSpoilage();
    }

    public void use(Character player){
    if (spoiled){
        player.getHungry(hungerval);
    }else{
        player.eat(hungerval);
    }
    }
}