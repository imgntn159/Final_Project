import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class Game{
    
    public static void main(String[]args){
	try{
	    //intitializing stuff
	    int randomSeed=Integer.parseInt(args[0]);
	    
	    //'tutorial'
	    tutorial();

	    //Create character
	    Character player=createCharacter();
	    delay(500);
	    //System.out.println("\n"+player);

	    //Make building
	    Environment building=new Environment(randomSeed);
	    building.setBuilding();
	    delay(500);
	    //System.out.println("\n"+building.getBuilding());
	    
	    
	    survive(player,1,1,building);
	}catch (Exception e){
	    System.out.println("Please enter a seed. (java Game [seed])");
	}

    }


    public static void delay(int time){
	try{
	    Thread.sleep(time);
	}catch(InterruptedException e){
	    e.printStackTrace();		
	}
    }



    public static Character createCharacter(){
	Character player;
	String name;
	Scanner scan=new Scanner(System.in);
	delay(500);
	System.out.println("What is your name survivor?");
	name=scan.nextLine();
	player=new Character(name);
	return player;
    }
    /*
    public static void moveRooms(String decision){
	if (decision.equals("Forward")){
	    
	}else if(decision.equals("Backward")){
	    
	}else if(decision.equals("Up")){
	    
	}else if(decision.equals("Down")){
	    
	}
    }
    */

    public static void endGame(int turns){
        if (turns<1){
	    System.out.println("You Win!");
	}else{
	    System.out.println("You Lose!");
	}
    }

    public static void tutorial(){
	Scanner scan=new Scanner(System.in);
	String decision;
	System.out.println("Read the tediously long tutorial? Enter 'Y' if yes. Otherwise enter any other key.");
	decision=scan.nextLine();
	if (decision.equalsIgnoreCase("Y")){
		delay(750);
		System.out.println("You wake up to find yourself trapped in a building.");
		delay(750);
		System.out.println("You dont remember anything other than taking an arrow to the knee.");
		delay(750);
		System.out.println("You don't know why you're there. But you know that help will come.");
		delay(750);
		System.out.println("Survive by maintaining your health, hunger, thirst, and illness!");
		delay(750);
		System.out.println("Good luck surviving!");
		//delay(1000);
		//And remember...
		//System.out.println("Don't Starve!");
		System.out.println("\n\n");
		delay(750);
	}
    }


    //method that actually moves the game
    public static void survive(Character player, int floorNum, int roomNum, Environment building){
	int turnsLeft=50;
	int floor=floorNum;
	int room=roomNum;
	boolean done=false;
	boolean done2=false;
	Scanner scan=new Scanner(System.in);
	String decision;

	do{
	    //print out current status
	    delay(600);
	    System.out.println("\n\nTurns Left: "+turnsLeft+"\nFloor: "+floor+"  Room: "+room+"\nHas Bed: "+building.getRoom(floor,room).getBed()+"\n\n");
	    delay(500);
	    System.out.println(player+"\n");
	    
	    do{

		//ask for their decision
		delay(500);
		System.out.println("Move to a different room, sleep, use items, or end game early? (M/S/I/E)");
		decision=scan.nextLine();
		if (decision.equalsIgnoreCase("M")){           	        //move to a different room
		    do{
			delay(500);
			System.out.println("Move to previous room, next room, go down a floor, or go up a floor? (P/N/D/U) B to go back.");
			decision=scan.nextLine();
			//check what the user input is
			if (decision.equalsIgnoreCase("P")){
			    if (room!=1){
				room--;
				done=true;
				done2=true;
			    }else{
				System.out.println("Already at the end of the floor.");
				done2=true;
			    }
			}else if (decision.equalsIgnoreCase("N")){
			    if (room!=5){
				room++;
				done=true;
				done2=true;
			    }else{
				System.out.println("Already at the end of the floor.");
				done2=true;
			    }
			}else if(decision.equalsIgnoreCase("U")){
			    if(building.getRoom(floor, room).getStairs()){
				if (floor!=5){
				    floor++;
				    done=true;
				    done2=true;
				}else{
				    System.out.println("Already at highest floor.");
				    done2=true;
				}
			    }else{
				System.out.println("No staircase in this room.");
				done2=true;
			    }
			}else if(decision.equalsIgnoreCase("D")){
			    if(building.getRoom(floor, room).getStairs()){
				if (floor!=1){
				    floor--;
				    done=true;
				    done2=true;
				}else{
				    System.out.println("Already at lowest floor");
				}
			    }else{
				System.out.println("No staircase in this room.");
				done2=true;
			    }
			}else if (decision.substring(0).equalsIgnoreCase("B")){
			    done2 = true;
			}
		    }while(!done2);
		    done2=false;


		}else if(decision.equalsIgnoreCase("S")){   	        //see if there is bed
		    if ((building.getRoom(floor,room)).getBed()){	//if there is go to sleep
			player.sleep(10);
			turnsLeft-=4;
			done=true;
		    }else{                                              //if there is no bed ask for another decision
			delay(500);
			System.out.println("No bed in the room. Cannot sleep.");
		    }


		}else if(decision.equalsIgnoreCase("I")){      	        //view inventory
		    System.out.println("Inventory:\n"+player.inventory);
		    System.out.println("\nItems in Room:\n"+building.getRoom(floor,room).getStuffInRoom());
		    do{
			delay(500);
			System.out.println("\nUse item, add item to inventory, or add item to room? Enter U/I/R and the number of the item. (e.g. i0) B to go back.");
			decision=scan.nextLine();
			if (decision.length() == 1 && decision.substring(0).equalsIgnoreCase("B")){
			    done2 = true;
			}
			if (decision.length()==2){
			    try{
				if (decision.substring(0,1).equalsIgnoreCase("U")){
				    
				    done=true;
				    done2=true;
				}else if (decision.substring(0,1).equalsIgnoreCase("I")){
						int important = Integer.parseInt(decision.substring(1));
				    player.addItem(building.getRoom(floor,room).getItem(important));
				    building.getRoom(floor,room).removeitem(building.getRoom(floor,room).getItem(important));
				    //System.out.println(building.getRoom(floor,room).getStuff().remove(Integer.parseInt(decision.substring(1))));
				    done=true;
				    done2=true;
				}else if (decision.substring(0,1).equalsIgnoreCase("R")){
				    	int important = Integer.parseInt(decision.substring(1));
				    building.getRoom(floor,room).additem(player.getItem(important));
				    player.removeitem(player.getItem(important));
				    done=true;
				    done2=true;
				}else if (decision.substring(0,1).equalsIgnoreCase("B")){
				    done2 = true;
				}
			    }catch (Exception e){
				System.out.println("Nothing in that item slot!");
			    }
			}
			
		    }while(!done2);
		    done2=false;   
    


		}else if(decision.equalsIgnoreCase("E")){               //Give up option to end game early for easy testing
		    player.getHurt(player.getHP());
		    done=true;
		}
	    }while(!done);
	    done=false;

	    //deduct stuff
	    turnsLeft--;
	    player.getHungry(5);
	    player.getThirsty(5);
	    if (player.getHunger()==0){
		player.getHurt(5);
	    }
	    if(player.getSick()){
		player.getHurt(5);
	    }

	}while(turnsLeft>0&&player.getHP()>0);
	delay(1500);
	endGame(turnsLeft);
    }

    
}
