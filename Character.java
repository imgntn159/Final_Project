import java.util.*;

public class Character{
    private int maxHP, maxStamina, maxHunger, maxThirst;
    private int HP, stamina, hunger, thirst;
    private String name;
    private boolean isIll;
    public ArrayList<Item> inventory;

    //Constructor
    public Character(){
	this("Insert Clever Name Here", 75, 25, 50, 50, 75, 25, 75, 75, false);
    }
    public Character(String name){
	this(name, 75, 25, 50, 50, 75, 25, 75, 75, false);
    }
    public Character(String name, int HP, int stamina, int hunger, int thirst){
	this(name, HP, stamina, hunger, thirst, 75, 25, 75, 75,false);
    }
    public Character(String name, int HP, int stamina, int hunger, int thirst, int maxHP, int maxStamina, int maxHunger, int maxThirst, boolean ill){
	setName(name);
	setHP(HP);
	setStamina(stamina);
	setHunger(hunger);
	setThirst(thirst);
	setMaxHP(maxHP);
	setMaxStamina(maxStamina);
	setMaxHunger(maxHunger);
	setMaxThirst(maxThirst);
	inventory=new ArrayList<Item>();
	setSick(ill);
    }



    //All get methods
    public int getHP(){
	return HP;
    }
    public int getStamina(){
	return stamina;
    }
    public int getHunger(){
	return hunger;
    }
    public int getThirst(){
	return thirst;
    }
    public String getName(){
	return name;
    }
    public int getMaxHP(){
	return maxHP;
    }
    public int getMaxStamina(){
	return maxStamina;
    }
    public int getMaxHunger(){
	return maxHunger;
    }
    public int getMaxThirst(){
	return maxThirst;
    }
    public boolean getSick(){
	return isIll;
    }
    public Item getItem(int i){
        return inventory.get(i);
    }

    //All set methods
    public void setHP(int health){
	HP=health;
    }
    public void setStamina(int stam){
	stamina=stam;
    }
    public void setHunger(int hambre){
	hunger=hambre;
    }
    public void setThirst(int sed){
	thirst=sed;
    }
    public void setName(String nombre){
	name=nombre;
    }
    public void setMaxHP(int maxHealth){
	maxHP=maxHealth;
    }
    public void setMaxStamina(int maxStam){
	maxStamina=maxStam;
    }
    public void setMaxHunger(int maxHambre){
	maxHunger=maxHambre;
    }
    public void setMaxThirst(int maxSed){
	maxThirst=maxSed;
    }
    public void setSick(boolean ill){
	isIll=ill;
    }

    public String toString(){
	String str="";
	str+=getName()+" "+"\nHP: "+getHP()+"\nStamina: "+getStamina()+"\nHunger:"+getHunger()+"\nThirst: "+getThirst();
	return str;
    }
    

    //Stuff that will probably be used in the game

    public void getHurt(int dmg){
	setHP(getHP()-dmg);
    }
    public void heal(int recover){
	setHP(getHP()+recover);
	if (getHP()>getMaxHP()){
	    setHP(getMaxHP());
	}
    }
    public void getTired(int energy){
	setStamina(getStamina()-energy);
	if (getStamina()<0){
	    setStamina(0);
	}
    }
    public void sleep(int rest){
	setStamina(getStamina()+rest);
	if (getStamina()>getMaxStamina()){
	    setStamina(getMaxStamina());
	}
    }
    public void getHungry(int calories){
	setHunger(getHunger()-calories);
	if (getHunger()<0){
	    setHunger(0);
	}
    }
    public void eat(int calories){
	setHunger(getHunger()+calories);
	if (getHunger()>getMaxHunger()){
	    setHunger(getMaxHunger());
	}
    }
    public void getThirsty(int sweat){
	setThirst(getThirst()-sweat);
	if (getThirst()<0){
	    setThirst(0);
	}
    }      
    public void drink(int water){
	setThirst(getThirst()+water);
	if (getThirst()>getMaxThirst()){
	    setThirst(getMaxThirst());
	}
    }
    public void addItem(Item i){
	inventory.add(i);
    }
    public void removeitem(Item item){
    inventory.remove(item);
    }
    public void useFood(int i){
	System.out.println(inventory.get(i));
	eat(inventory.get(i).getHungerval());
	inventory.remove(i);
    }
    
}
