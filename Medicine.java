public class Medicine extends Item{
    private int stamval;
    private int healval;
    public Medicine(){
	super("Default_Pill");
    }
    public Medicine(int stamval,int healval){
	this.stamval = stamval;
	this.healval = healval;
    }
    public Medicine(String name,int stamval, int healval){
	super(name);
	this.stamval = stamval;
	this.healval = healval;
    }

    //Getters
    public int getHealval(){
	return healval;
    }
    public int getStamval(){
	return stamval;
    }
    //Setters
    public void setHealval(int healval){
	this.healval = healval;
    }
    public void setStamval(int stamval){
	this.stamval = stamval;
    }
    //toString
    public String toString(){
	return getName() + " Stam:" + getStamval() + " Heal:" + getHealval();
    }

    public void use(Character player){
    if (!player.getSick()){
        player.setSick(false);
    }
    player.heal(healval);
    player.sleep(stamval); //PUT INTO CHARACTER.JAVA
    }
}