/*=======================================================
  Battleship- Driver and Gameplay file for Battleship
  ========================================================*/

import java.io.*;
import java.util.*;
import cs1.Keyboard;

public class Battleship{
 
    /*~~~~~~~~~~~~~~~~INSTANCE VARIABLE~~~~~~~~~~~~~~~~~~~~~~*/
    
    public final static String CORD_LETTERS = "ABCDEFGHIJ";
    //if true game is over
    private boolean gameOver;

    private InputStreamReader isr;
    private BufferedReader in;
    private String[][] ugrid = new String[10][10];
    private String[][] agrid = new String[10][10];

    //~~~~~~~~DEFAULT CONSTRUCTOR~~~~~~~~~~~~~~~~~~~~~~
    public Battleship() {
	isr = new InputStreamReader(System.in);
	in = new BufferedReader(isr);
        gameOver = false;
        //String[][] grid = new String[10][10];
        System.out.println("Let's play!");
        //newGame();
    }

    public void setUp() {
        int setupnum = 0;
        System.out.println("Hello, friendly user! Welcome to Battleship!");
        System.out.print("Before we start, you need to place your ships on the board. Please enter 1 if you would like this to be done randomly. If you want to place them yourself, please enter 2: ");
        while (setupnum != 1 || setupnum != 2) {
            setupnum = Keyboard.readInt();
            if (setupnum == 1) {
                String[][] ugrid = new String[10][10];
                setRand(ugrid);
            }
            else if (setupnum == 2) {
                boardSetUp();
            }
            else {
                System.out.print(" \n I can only process the numbers 1 and 2. Please try again: \n");
            }
        }
    }
    /*
      public void boardSetUp() {
      String[][] ugrid = new String[10][10];
      carrierSetup();
      battleshipSetup();
      //submarineSetup();
      //destroyerSetup();
      //patrolSetup();
      }
      public void carrierSetup() {
      boolean error = true;
      boolean contains = false;
      String cord = "";
      int x = 0;
      int y = 0;
      int dir = 0;
      int carrierCount = 5;

      while(error) {
      System.out.print("Awesome! First, we'll place your Carrier. It'll take up  units on the board. Make sure you choose a letter between A and J, and a number between 1 and 10 for the coordinates. enter the x and y coordinates with no space in between, like so: 'D7' :  ");
      cord = Keyboard.readString();
      x = digitify(cord.substring(0, 1));
      dir = 0;
      y = Integer.parseInt(cord.substring(1));
                    
      contains = CORD_LETTERS.contains(cord.substring(0,1));

      if (contains == false) 
      System.out.println(" \n Error with x axis...please try again \n");
      else if (y > 10) 
      System.out.println(" \n Error with y axis...please try again \n");
      else 
      error = false;
      }
        
      ugrid[x][y] = "carrier";
      System.out.print("Do you want the ship to lay horizontally, or vertically? Enter 1 for horizontally, or 2 for vertically: ");
      dir = Keyboard.readInt();
            
      if (dir == 1) {
      if(x < 6) {
      while (carrierCount > 0) {
      ugrid[x+1][y] = "carrier";
      x++;
      carrierCount--;
      }
      }
              
      else {
      while(carrierCount > 0) {
      ugrid[x-1][y] = "carrier";
      x--;
      carrierCount--;
      }
      }
      }
        
      else if (dir == 2) {
      if (y < 6) {
      while(carrierCount > 0) {
      ugrid[x][y+1] = "carrier";
      y++;
      carrierCount--;
      }
      }
        
      else {
      while(carrierCount > 0) {
      ugrid[x][y-1] = "carrier";
      y--;
      carrierCount--;
      }
      }
      }
    
      else 
      System.out.print("Sorry, but I can only interpret 1 and 2. Please try again: ");
    
      error = true;
      }//end carrier setup
        
      //battleship setup
      public void battleshipSetup() {
      boolean error = true;
      boolean contains = false;
      boolean filled = false;

      String cord = "";
      int x = 0;
      int y = 0;
      int dir = 0;
      int battleshipCount = 4;
      while (error) {
      System.out.print("Next, we'll place your battleship. Like before, enter a letter between A and J, and a number between 1 and 10: ");
      cord = Keyboard.readString();
      x = digitify(cord.substring(0, 1));
      y = Integer.parseInt(cord.substring(1));
            
      contains = CORD_LETTERS.contains(cord.substring(0,1));

      if (contains == false)
      System.out.print("\n Error with x axis...please try again: \n");
      else if (y > 10)
      System.out.print("\n Error with y axis...please try again: \n");
      else if(ugrid[x][y] != null)
      System.out.print(" \n Dude you already put a ship there...this is why we can't have nice things!..try again: \n");
      else
      error = false;
      }
      ugrid[x][y] = "battleship";
      error = true;
      while(error) {
      System.out.print("Do you want the ship to lay horizontally, or vertically? Enter 1 for horizontally, or 2 for vertically: ");
      dir = Keyboard.readInt();
      //-------------------------------------------------------
      if (dir == 1) {
      if (x < 6) {
      int temp = x;
      while (battleshipCount > 0 || filled == false) {
      if(ugrid[temp + 1][y] != null) 
      filled = true;
      temp++;
      battleshipCount--;
      }

      battleshipCount = 4;
      if(filled == false) {
      while(battleshipCount > 0) {
      ugrid[x+1][y] = "battleship";
      x++;
      battleshipCount--;
      error = false; //exits while loop
      }
      }
      else
      System.out.print("The direction you have chosen will result in an error try again: ");
      }        
      //--------------------------------------------------
      else {
      int temp = x;
      while(battleshipCount > 0 || filled == false) {
      if(ugrid[temp-1][y] != null)
      filled = true;
      temp--;
      battleshipCount--;
      }
                    
      battleshipCount = 4;
      if(filled == false) {
      while(battleshipCount > 0) {
      ugrid[x-1][y] = "battleship";
      x--;
      battleshipCount--;
      error = false; //exits while loop 
      }
      }
      else
      System.out.print("The direction you have chosen will result in an error try again: ");
      }
      }
      //-------------------------------------------------------
      else if (dir == 2) {
      if (y < 6) {
      int temp = y;
      while (battleshipCount > 0 || filled == false) {
      if(ugrid[x][temp + 1] != null)
      filled = true;
      temp++;
      battleshipCount--;
      }

      battleshipCount = 4;
      if(filled == false) {
      while(battleshipCount > 0) {
      ugrid[x][y+1] = "battleship";
      y++;
      battleshipCount--;
      error = false; //exits while loop 
      }
      }
      else
      System.out.print("The direction you have chosen will result in an error try again: ");
      }
      //-------------------------------------------------------
      else {
      int temp = y;
      while(battleshipCount > 0 || filled == false) {
      if(ugrid[x][temp - 1] != null)
      filled = true;
      temp--;
      battleshipCount--;
      }

      battleshipCount = 4;
      if(filled == false) {
      while(battleshipCount > 0) {
      ugrid[x][y-1] = "battleship";
      y--;
      battleshipCount--;
      error = false; //exits while loop 
      }
      }
      else
      System.out.print("The direction you have chosen will result in an error try again: ");
      }
      }
      }//end while
            
      }//end battleshipSetup  
     
        

      //start of submarine set up
        
      while(error) {
      System.out.print("Next up is your submarine! Letter between A and J, number between 1 and 10. You know the drill: ");
      cord = Keyboard.readString();
      x = digitify(cord.substring(0, 1));
      dir = 0;
      y = Integer.parseInt(cord.substring(1));
            
      boolean contains = CORD_LETTERS.contains(cord.substring(0,1));

      if(contains == false)
      System.out.print("\n Error with x axis...please try again: \n");
      else if (y > 10)
      System.out.print("\n Error with y axis...please try again: \n");
      else if(ugrid[x][y] == "carrier")
      System.out.print(" \n Dude you already put a ship there..this is why we can't have nice things!..try again: \n");
      else
      error = false;
      }
         
      ugrid[x][y] = "submarine";
      System.out.print("Do you want the ship to lay horizontally, or vertically? Enter 1 for horizontally, or 2 for vertically: ");
      dir = Keyboard.readInt();

      int submarineCount = 3;
      if (dir == 1) {
      if (x < 6) {
      while(submarineCount > 0) {
      ugrid[x][y] = "submarine";
      x++;
      submarineCount--;
      }
      }
      else {
      while(submarineCount > 0) {
      ugrid[x][y] = "submarine";
      x--;
      submarineCount--;
      }
      }
      }
      else if (dir == 2) {
      if (y < 6) {
      while(submarineCount > 0) {
      ugrid[x][y] = "submarine";
      y++;
      submarineCount--;
      }
      }
      else {
      while(submarineCount > 0) {
      ugrid[x][y] = "submarine";
      y--;
      submarineCount--;
      }
      }
      }
        
      else 
      System.out.print("Sorry, but I can only interpret 1 and 2. Please try again: ");
      error = true;
      //end submarine setup

      //Destroyer setup
      while (error) {
      System.out.print("DESTROYER TIMEEEEEE. Do I have to tell you what to do again? Enter the coordinates again: ");
      cord = Keyboard.readString();
      x = digitify(cord.substring(0, 1));
      y = Integer.parseInt(cord.substring(1));
            
      boolean contains = CORD_LETTERS.contains(cord.substring(0, 1));

      if(contains == false)
      System.out.print("\n Error with x axis...please try again: \n");
      else if ( y > 10)
      System.out.print("\n Error with y axis...please try again: \n");
      else if(ugrid[x][y] == "carrier")
      System.out.print(" \n Dude you already put a ship there..this is why we can't have nice things!..try again: \n");
      else
      error = false;
      }
        
      ugrid[x][y] = "destroyer";
      System.out.print("Do you want the ship to lay horizontally, or vertically? Enter 1 for horizontally, or 2 for vertically: ");
      dir = Keyboard.readInt();

      int destroyerCount = 3;
      if (dir == 1) {
      if (x < 6) {
      while(destroyerCount > 0) {
      ugrid[x][y] = "destroyer";        
      x++;
      destroyerCount--;
      }
      }
      else {
      while(destroyerCount > 0) {
      ugrid[x][y] = "destroyer";
      x--;
      destroyerCount--;
      }
      }
      }
      else if (dir == 2) {
      if (y < 6) {
      while(destroyerCount > 0) {
      ugrid[x][y] = "destroyer";
      y++;
      destroyerCount--;
      }
      }
      else {
      while(destroyerCount > 0) {
      ugrid[x][y] = "destroyer";
      y--;
      destroyerCount--;
      }
      }
      }
      else 
      System.out.print("Sorry, but I can only interpret 1 and 2. Please try again: ");
      error = true;
      //end destroyer setup
      //patrol boat setup
      while(error) {
      System.out.println("Last ship! Enter a coordinate for your patrolboat.");
      cord = Keyboard.readString();
      x = digitify(cord.substring(0, 1));
      y = Integer.parseInt(cord.substring(1));
            
      boolean contains = CORD_LETTERS.contains(cord.substring(0, 1));
            
      if (contains == false)
      System.out.print("\n Error with x axiss...please try again: \n");
      else if ( y > 10)
      System.out.print("\n Error with y axis...please try again: \n");
      else if(ugrid[x][y] == "carrier")
      System.out.print(" \n Dude you already put a ship there..this is why we can't have nice things!..try again: \n");
      else
      error = false;
      }

      ugrid[x][y] = "patrolboat";
      System.out.print("Do you want the ship to lay horizontally, or vertically? Enter 1 for horizontally, or 2 for vertically: ");
      dir = Keyboard.readInt();

      int patrolboatCount = 2;
      if (dir == 1) {
      if (x < 6) {
      while(patrolboatCount > 0) {
      ugrid[x][y] = "patrolboat";
      x++;
      patrolboatCount--;
      }
      }
      else {
      while(patrolboatCount > 0) {
      ugrid[x][y] = "patrolboat";
      x--;
      patrolboatCount--;
      }
      }
      }
      else if (dir == 2) {
      if (y < 6) {
      while(patrolboatCount > 0) {
      ugrid[x][y] = "patrolboat";
      y++;
      patrolboatCount--;
      }
      }
      else {
      while(patrolboatCount > 0) {
      ugrid[x][y] = "patrolboat";
      y--;
      patrolboatCount--;
      }
      }
      }
      else 
      System.out.print("\n Sorry, but I can only interpret 1 and 2. Please try again: \n");
    
    
      System.out.println("\n Your board is all set up!");
      }//end boardsetUp()
        
    */
    
    public void playTurn() {
	int shots = 0;
	int aishipctr = 5;
	int aicctr = 5;
	int aibctr = 4;
	int aidctr = 3;
	int aisctr = 3;
	int aipctr = 2;
	String cord = "";
	int x = 0;
	int y = 0;
	boolean error = true;
	if (aishipctr > 0) {
	    while(error) {
		System.out.print("A'ight. You know what to do. Where do you think your opponent's ships might be? Enter a coordinate: ");
		printGrid(ugrid);
		cord = Keyboard.readString();
		x = digitify(cord.substring(0, 1));
		y = Integer.parseInt(cord.substring(1));
        
		boolean contains = CORD_LETTERS.contains(cord.substring(0, 1));
                
		if (contains == false)
		    System.out.print(" \n Error with x axis...please try again: \n");
		else if (y > 10)
		    System.out.print(" \n Error with y axis...please try again: \n");
		else
		    error = false;
	    }
               
	    if (aishipctr > 1) {
		shots++;
		if (ugrid[x][y] == "x") {
		    System.out.println("...What a waste of a turn. You hit where you already have before. I'm disappointed in you, to be honest.");
		    aiTurn();
		}
		else if (ugrid[x][y] == null) {
		    System.out.println("Gosh! Your missile made quite the explosion! With water. Sorry, man. You missed. Now it's the computer's turn.");
		    ugrid[x][y] = "x";
		    aiTurn();
		}
		else if (ugrid[x][y] == "carrier") {
		    ugrid[x][y] = "x";
		    if (aicctr > 1) {
			System.out.print("You hit your opponent's carrier! Great shot! Go again: ");
			aicctr--;
			playTurn();
		    }
		    else {
			System.out.print("WOOOH! YOU SUNK THE CARRIER!!!! Go again: ");
			aishipctr--;
			aicctr--;
			playTurn();
		    }
		}
		else if (ugrid[x][y] == "battleship") {
		    ugrid[x][y] = "x";
		    if (aibctr > 1) {
			System.out.print("#swag! You hit the battleship! Awesome! You can take another turn: ");
			aibctr--;
			playTurn();
		    }
		    else {
			System.out.print("YAASSS!! You sunk the battleship! Go again: ");
			aishipctr--;
			aibctr--;
			playTurn();
		    }
		}
		else if (ugrid[x][y] == "destroyer") {
		    ugrid[x][y] = "x";
		    if (aidctr > 1) {
			System.out.print("Woah! You nicked the destroyer! Great shot! Your turn again: ");
			aidctr--;
			playTurn();
		    }
		    else {
			System.out.print("woop dee doo! You sunk the destroyer! Go again: ");
			aishipctr--;
			aidctr--;
			playTurn();
		    }
		}
		else if (ugrid[x][y] == "submarine") {
		    ugrid[x][y] = "x";
		    if (aisctr > 1) {
			System.out.print("Nooice! You hit the sub! I'm not sure how, since it's underwater. You must just be a great shot. Your turn again: ");
			aisctr--;
			playTurn();
		    }
		    else {
			System.out.print("Swiggity swag! You sunk the sub! Take another turn: ");
			aishipctr--;
			aisctr--;
			playTurn();
		    }
		}
		else if (ugrid[x][y] == "patrolboat") {
		    ugrid[x][y] = "x";
		    if (aipctr > 1) {
			System.out.print("You've bombed the elusive patrolboat! Good aim. Your turn again: ");
			aipctr--;
			playTurn();
		    }
		    else {
			System.out.print("GNARLY! The patrolboat is sunk! Go again: ");
			aishipctr--;
			aipctr--;
			playTurn();
		    }
		}
	    }
	    else {
		shots++;
		if (ugrid[x][y] == "x") {
		    System.out.println("...What a waste of a turn. You hit where you already have before. I'm disappointed in you, to be honest.");
		    aiTurn();
		}
		else if (ugrid[x][y] == null) {
		    System.out.println("Gosh! Your missile made quite the explosion! With water. Sorry, man. You missed. Now it's the computer's turn.");
		    ugrid[x][y] = "x";
		    aiTurn();
		}
		else if (ugrid[x][y] == "carrier") {
		    ugrid[x][y] = "x";
		    if (aicctr > 1) {
			System.out.print("You hit your opponent's carrier! Great shot! Go again: ");
			aicctr--;
			playTurn();
		    }
		    else {
			System.out.println("WOOOH! YOU JUST WON THE GAME! and it only took you " + shots + " turns!");
			aishipctr--;
			aicctr--;
			playTurn();
		    }
		}
		else if (ugrid[x][y] == "battleship") {
		    ugrid[x][y] = "x";
		    if (aibctr > 1) {
			System.out.print("#swag! You hit the battleship! Awesome! You can take another turn: ");
			aibctr--;
			playTurn();
		    }
		    else {
			System.out.println("WOOOH! YOU JUST WON THE GAME! and it only took you " + shots + " turns!");
			aishipctr--;
			aibctr--;
			playTurn();
		    }
		}
		else if (ugrid[x][y] == "destroyer") {
		    ugrid[x][y] = "x";
		    if (aidctr > 1) {
			System.out.print("Woah! You nicked the destroyer! Great shot! Your turn again: ");
			aidctr--;
			playTurn();
		    }
		    else {
			System.out.println("WOOOH! YOU JUST WON THE GAME! and it only took you " + shots + " turns!");
			aishipctr--;
			aidctr--;
			playTurn();
		    }
		}
		else if (ugrid[x][y] == "submarine") {
		    ugrid[x][y] = "x";
		    if (aisctr > 1) {
			System.out.print("Nooice! You hit the sub! I'm not sure how, since it's underwater. You must just be a great shot. Your turn again: ");
			aisctr--;
			playTurn();
		    }
		    else {
			System.out.println("WOOOH! YOU JUST WON THE GAME! and it only took you " + shots + " turns!");
			aishipctr--;
			aisctr--;
			playTurn();
		    }
		}
		else if (ugrid[x][y] == "patrolboat") {
		    ugrid[x][y] = "x";
		    if (aipctr > 1) {
			System.out.print("You've bombed the elusive patrolboat! Good aim. Your turn again: ");
			aipctr--;
			playTurn();
		    }
		    else {
			System.out.println("WOOOH! YOU JUST WON THE GAME! and it only took you " + shots + " turns!");
			aishipctr--;
			aipctr--;
			playTurn();
		    }
		}
	    }
	}
	else {
	    System.out.println("Wow. You let a computer beat you. Ouch. Sucks for you, man.");
	}
    }

    public void aiTurn() {
	int x = 0;
	int y = 0;
	int usershipctr = 0;
	int usercctr = 0;
	int userbctr = 0;
	int userdctr = 0;
	int usersctr = 0;
	int userpctr = 0;
	System.out.println("Please wait while the ai takes its turn...");
	x = (int)(Math.random() * 10);
	y = (int)(Math.random() * 10);
	//random 1-10 and 1-10 for x and y, 
	if (usershipctr > 1) {
	    if (agrid[x][y] == "x") {
		System.out.println("The ai hit where it already has before. Silly ai. Your turn!");
		playTurn();
	    }
	    else if (agrid[x][y] == null) {
		System.out.println("The ai missed. Your turn.");
		agrid[x][y] = "x";
		playTurn();
	    }
	    else if (agrid[x][y] == "carrier") {
		agrid[x][y] = "x";
		if (usercctr > 1) {
		    System.out.println("Ouch! The ai hit your carrier. It goes again!");
		    usercctr--;
		    aiTurn();
		}
		else {
		    System.out.println("The ai sunk your carrier. That sucks. And to add insult to injury, it's gonna go again.");
		    usershipctr--;
		    usercctr--;
		    aiTurn();
		}
	    }
	    else if (agrid[x][y] == "battleship") {
		agrid[x][y] = "x";
		if (userbctr > 1) {
		    System.out.println("The ai hit your battleship. Whoops. ai goes again.");
		    userbctr--;
		    aiTurn();
		}
		else {
		    System.out.println("The ai sunk your battleship. Really? You can do better. It goes again.");
		    usershipctr--;
		    userbctr--;
		    aiTurn();
		}
	    }
	    else if (agrid[x][y] == "destroyer") {
		agrid[x][y] = "x";
		if (userdctr > 1) {
		    System.out.println("The ai bombed your destroyer. I'm disappointed in you. As a punishment, the ai will go again.");
		    userdctr--;
		    aiTurn();
		}
		else {
		    System.out.print("Your destroyer done got sunked. lolololol it's the ai's turn again.");
		    usershipctr--;
		    userdctr--;
		    aiTurn();
		}
	    }
	    else if (agrid[x][y] == "submarine") {
		agrid[x][y] = "x";
		if (usersctr > 1) {
		    System.out.print("Your sub took a hit from the ai! It goes again!");
		    usersctr--;
		    aiTurn();
		}
		else {
		    System.out.print("Awww... Your sub done been sunked. On the bright side... oh, wait. Gosh, there is no bright side this round. ai goes again.");
		    usershipctr--;
		    usersctr--;
		    aiTurn();
		}
	    }
	    else if (agrid[x][y] == "patrolboat") {
		agrid[x][y] = "x";
		if (userpctr > 1) {
		    System.out.print("Your patrolboat has come recently come under fire. While I laugh at you, the ai goes again.");
		    userpctr--;
		    aiTurn();
		}
		else {
		    System.out.println("Sick explosion, man. The ai sunk your patrolboat. It goes again!");
		    usershipctr--;
		    userpctr--;
		    aiTurn();
		}
	    }
	}

	else {
	    if (agrid[x][y] == "x") {
		System.out.println("...What a waste of a turn. You hit where you already have before. I'm disappointed in you, to be honest.");
		playTurn();
	    }
	    else if (agrid[x][y] == null) {
		System.out.println("Gosh! Your missile made quite the explosion! With water. Sorry, man. You missed. Now it's the computer's turn.");
		agrid[x][y] = "x";
		playTurn();
	    }
	    else if (agrid[x][y] == "carrier") {
		agrid[x][y] = "x";
		if (usercctr > 1) {
		    System.out.print("You hit your opponent's carrier! Great shot! Go again: ");
		    aiTurn();
		}
		else {
		    System.out.println("Wow. You let a computer beat you. Ouch. Sucks for you, man.");
		    usershipctr--;
		    usercctr--;
		    aiTurn();
		}
	    }
	    else if (agrid[x][y] == "battleship") {
		agrid[x][y] = "x";
		if (userbctr > 1) {
		    System.out.print("#swag! You hit the battleship! Awesome! You can take another turn: ");
		    userbctr--;
		    aiTurn();
		}
		else {
		    System.out.println("Wow. You let a computer beat you. Ouch. Sucks for you, man.");
		    usershipctr--;
		    userbctr--;
		    aiTurn();
		}
	    }
	    else if (agrid[x][y] == "destroyer") {
		agrid[x][y] = "x";
		if (userdctr > 1) {
		    System.out.print("Woah! You nicked the destroyer! Great shot! Your turn again: ");
		    userdctr--;
		    aiTurn();
		}
		else {
		    System.out.println("Wow. You let a computer beat you. Ouch. Sucks for you, man.");
		    usershipctr--;
		    userdctr--;
		    aiTurn();
		}
	    }
	    else if (agrid[x][y] == "submarine") {
		agrid[x][y] = "x";
		if (usersctr > 1) {
		    System.out.print("Nooice! You hit the sub! I'm not sure how, since it's underwater. You must just be a great shot. Your turn again: ");
		    usersctr--;
		    aiTurn();
		}
		else {
		    System.out.println("Wow. You let a computer beat you. Ouch. Sucks for you, man.");
		    usershipctr--;
		    usersctr--;
		    aiTurn();
		}
	    }
	    else if (agrid[x][y] == "patrolboat") {
		agrid[x][y] = "x";
		if (userpctr > 1) {
		    System.out.print("You've bombed the elusive patrolboat! Good aim. Your turn again: ");
		    userpctr--;
		    aiTurn();
		}
		else {
		    System.out.println("Wow. You let a computer beat you. Ouch. Sucks for you, man.");
		    usershipctr--;
		    userpctr--;
		    aiTurn();
		}
	    }
	}
    }

    public int digitify(String x) {
        int ans = 0;
        for (int i = 0; i < 10; i++) {
            if (x.substring(0) == CORD_LETTERS.substring(i))
                ans = i + 1;
        }
        return ans;
    }
    
    public void setRand(String[][] grid) {
        System.out.println("One second, setting up board...");
        int x = 0;
        int y = 0;
        int dir = 0;
        //maybe do String[][] ships to set ships more easily? But how do we do that with length? Do we need an int[][]lens? Maybe...
        int totalShip = 5;
        while(totalShip > 0) {
            dir = (int)(Math.random());//0 is horizontal, 1 is vertical.
            x = (int)(Math.random() * 10);
            y = (int)(Math.random() * 10);
            int carrierCount = 5;
            int battleshipCount = 4;
            int submarineCount = 3;
            int destroyerCount = 3;
            int patrolboatCount = 2;
            if (dir == 1) {
                if(x < 6) {
                    while (carrierCount > 0) {
                        grid[x][y] = "carrier";
                        x++;
                        carrierCount--;
                    }
                }
                else {
                    while(carrierCount > 0) {
                        grid[x][y] = "carrier";
                        x--;
                        carrierCount--;
                    }
                }
            }
            else if (dir == 2) {
                if (y < 6) {
                    while(carrierCount > 0) {
                        grid[x][y] = "carrier";
                        y++;
                        carrierCount--;
                    }
                }
                else {
                    while(carrierCount > 0) {
                        grid[x][y] = "carrier";
                        y--;
                        carrierCount--;
                    }
                }
            }
            totalShip--;
            dir = (int)(Math.random());//0 is horizontal, 1 is vertical.
            x = (int)(Math.random() * 10);
            y = (int)(Math.random() * 10);
            if (dir == 1) {
                if(x < 6) {
                    while (battleshipCount > 0) {
                        grid[x][y] = "battleship";
                        x++;
                        battleshipCount--;
                    }
                }
                else {
                    while(battleshipCount > 0) {
                        grid[x][y] = "battleship";
                        x--;
                        battleshipCount--;
                    }
                }
            }
            else if (dir == 2) {
                if (y < 6) {
                    while(battleshipCount > 0) {
                        grid[x][y] = "battleship";
                        y++;
                        battleshipCount--;
                    }
                }
                else {
                    while(battleshipCount > 0) {
                        grid[x][y] = "battleship";
                        y--;
                        battleshipCount--;
                    }
                }
            }
            totalShip--;
            dir = (int)(Math.random());//0 is horizontal, 1 is vertical.
            x = (int)(Math.random() * 10);
            y = (int)(Math.random() * 10);
            if (dir == 1) {
                if(x < 6) {
                    while (submarineCount > 0) {
                        grid[x][y] = "submarine";
                        x++;
                        submarineCount--;
                    }
                }
                else {
                    while(submarineCount > 0) {
                        grid[x][y] = "submarine";
                        x--;
                        submarineCount--;
                    }
                }
            }
            else if (dir == 2) {
                if (y < 6) {
                    while(submarineCount > 0) {
                        grid[x][y] = "submarine";
                        y++;
                        submarineCount--;
                    }
                }
                else {
                    while(submarineCount > 0) {
                        grid[x][y] = "submarine";
                        y--;
                        submarineCount--;
                    }
                }
            }
            totalShip--;
            dir = (int)(Math.random());//0 is horizontal, 1 is vertical.
            x = (int)(Math.random() * 10);
            y = (int)(Math.random() * 10);
            if (dir == 1) {
                if(x < 6) {
                    while (destroyerCount > 0) {
                        grid[x][y] = "destroyer";
                        x++;
                        destroyerCount--;
                    }
                }
                else {
                    while(destroyerCount > 0) {
                        grid[x][y] = "destroyer";
                        x--;
                        destroyerCount--;
                    }
                }
            }
            else if (dir == 2) {
                if (y < 6) {
                    while(destroyerCount > 0) {
                        grid[x][y] = "destroyer";
                        y++;
                        destroyerCount--;
                    }
                }
                else {
                    while(destroyerCount > 0) {
                        grid[x][y] = "destroyer";
                        y--;
                        destroyerCount--;
                    }
                }
            }
            totalShip--;
            dir = (int)(Math.random());//0 is horizontal, 1 is vertical.
            x = (int)(Math.random() * 10);
            y = (int)(Math.random() * 10);
            if (dir == 1) {
                if(x < 6) {
                    while (patrolboatCount > 0) {
                        grid[x][y] = "patrolboat";
                        x++;
                        patrolboatCount--;
                    }
                }
                else {
                    while(patrolboatCount > 0) {
                        grid[x][y] = "patrolboat";
                        x--;
                        patrolboatCount--;
                    }
                }
            }
            else if (dir == 2) {
                if (y < 6) {
                    while(patrolboatCount > 0) {
                        grid[x][y] = "patrolboat";
                        y++;
                        patrolboatCount--;
                    }
                }
                else {
                    while(patrolboatCount > 0) {
                        grid[x][y] = "patrolboat";
                        y--;
                        patrolboatCount--;
                    }
                }
            }
            totalShip--;
        }
        
        System.out.println("Your boats are all set up!");
    }
    public static void printGrid( String[][] a ) {
        String s = "Array: \t";
        for(int i = 0; i < a.length; i++) {
            s+="[";
            for (int j = 0; j < a[i].length; j++)
                s+= a[i][j] + " ";

            if(s.substring(s.length() -1).equals(" "))
                s = s.substring(0,s.length() - 1);
            s += "] \n \t";
        }
        System.out.println(s);
    }

    public static void main(String args[]) {
        Battleship swag = new Battleship();
            
        swag.setUp();
            
    
    }//end main
}//end class Battleship
