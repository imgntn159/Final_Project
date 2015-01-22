import java.util.Scanner;
import java.io.*;

public class TesterChar{
    public static void main(String[]args) throws FileNotFoundException{
	Character a= new Character();
	Character b= new Character("Dohvakin");
	Food x = new Food("Banana",10,0,false);
	Tool y = new Tool("Pickaxe",10,10);
	Medicine z = new Medicine("Adrenaline",10,0);

	/**System.out.println(a);
	   System.out.println(b);
	   b.getHurt(10);
	   b.getTired(100);
	   b.getHungry(9);
	   b.getThirsty(15);**/

	/**System.out.println();
	   System.out.println(b);
	   b.heal(9000);
	   b.sleep(125);
	   b.drink(3);**/

	/**System.out.println();
	   System.out.println(b);**/

	//~Item toString tests and Food~//
	/**System.out.println(b.inventory);
	   b.addItem(x);
	   System.out.println(b.inventory);
	   b.addItem(new Item());
	   System.out.println(b.inventory);
	   System.out.println();
	   System.out.println(b.inventory.get(0));
	   b.useFood(0);
	   System.out.println(b);
	   System.out.println(b.inventory);**/

	//~Tool toString tests and usage~//
	/**System.out.println(b.inventory);
	   b.addItem(y);
	   System.out.println(b.inventory);
	   b.useTool(0,5);
	   System.out.println(b.inventory);
	   b.useTool(0,20);
	   System.out.println(b.inventory);**/

	//Food Scanning Test//
	/**try{
	   Scanner s = new Scanner(new File("Foods.txt"));
	   while(s.hasNextLine()){
	   b.addItem(new Food(s.nextLine(), Integer.parseInt(s.nextLine()), Integer.parseInt(s.nextLine()), Boolean.parseBoolean(s.nextLine())));
	   }
	   } catch (FileNotFoundException e){
	   System.out.println("failed");
	   }
	   System.out.println(b.inventory);**/

	//~Quick Medicine Test~//
	b.addItem(z);
	System.out.println(b.inventory);

    }

}
