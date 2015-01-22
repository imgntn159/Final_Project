public class Tool extends Item{
    private int durability;
    private int maxDurability;

    public Tool(){
	durability = 10;
	maxDurability = 10;
    }
    public Tool(String name,int durability,int maxDurability){
	super(name);
	this.durability = durability;
	this.maxDurability = maxDurability;
    }
    public Tool(int durability){
	this.durability = durability;
	maxDurability = durability;
    }

    //Getters
    public int getDurability(){
	return durability;
    }
    public int getMaxDurability(){
	return maxDurability;
    }

    //Setters
    public void setDurability(int durability){
	this.durability = durability;
    }
    public void setMaxDurability(int durability){
	this.maxDurability = maxDurability;
    }

    //Useful Functions
    public void use(int usage,boolean canUse){
	if(! canUse){
	    System.out.println("Can't use item here!");
	    return;
	}
	if((durability - usage) < 0){
	    System.out.println("Not durable enough to use!");
	    return;
	}
	durability-= usage;
    }
    public void repair(int repairval){
	durability += repairval;
	if (durability > maxDurability){
	    durability = maxDurability;
	}
    }

    //toString
    public String toString(){
	return getName() + " | Dur:" + durability + "/" + maxDurability;
    }
}