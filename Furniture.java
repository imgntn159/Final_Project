public class Furniture{
    private String name;
    private int fuel;
    private boolean canCook;
    private boolean canBuildThings;
    private boolean canSleep;
    public Furniture(){
	name = "Default_Furniture";
	fuel = 0;
	canCook = false;
	canBuildThings = false;
	canSleep = false;
    }
    public Furniture(String name,int fuel,boolean canCook,boolean canBuildThings,boolean canSleep){
	this.name = name;
	this.fuel = fuel;
	this.canCook = canCook;
	this.canBuildThings = canBuildThings;
	this.canSleep = canSleep;
    }

    //Getters
    public String getName(){
	return name;
    }
    public int getFuel(){
	return fuel;
    }
    public boolean canSleep(){
	return canSleep;
    }
    public boolean canBuildThings(){
	return canBuildThings;
    }
    public boolean canCook(){
	return canCook;
    }

    //Setters
    public void setName(String name){
	this.name = name;
    }
    public void getFuel(int fuel){
	this.fuel = fuel;
    }
    public void setSleep(boolean canSleep){
	this.canSleep = canSleep;
    }
    public void setBuildThings(boolean canBuildThings){
	this.canBuildThings = canBuildThings;
    }
    public void setCook(boolean canCook){
	this.canCook = canCook;
    }

    //toString
    public String toString(){
        String result = name;
	if(canCook){
	    result+="|Can Cook: F(" + Integer.toString(fuel) + ")|";
	}
	if(canSleep){
	    result+="|Can Sleep|";
	}
	if(canBuildThings){
	    result+="|Can Build|";
	}
	return result;
    }
}