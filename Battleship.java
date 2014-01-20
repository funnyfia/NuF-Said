/*=======================================================
  Battleship- Driver and Gameplay file for Battleship
  ========================================================*/

import java.io.*;
import java.util.*;
import cs1.Keyboard;

public class Battleship{
 
    /*~~~~~~~~~~~~~~~~INSTANCE VARIABLE~~~~~~~~~~~~~~~~~~~~~~*/
    
    public final static String CORD_LETTERS = "ABCDEFGHIJ";
 
    /*UNCOMMENT IF DOING DIFFICULTY
      creates AI for varying difficulty
      private Easy Bob;
      private Medium Rob;
      private Hard Sob;
    */

    //creates variable for me to allow for user input
    private User Me;
    //if true game is over
    private boolean gameOver;
    /*determines difficulty of AI...determines which subclass of AI to call
      UNCOMMENT IF DOING DIFFICULTY
      private int difficulty;
    */
    private InputStreamReader isr;
    private BufferedReader in;
    private String[][] grid = String[10][10];

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
		String[][] grid = new String[10][10];
                setRand(grid);
            }
            else if (setupnum == 2) {
                boardSetUp();
            }
            else {
                System.out.print(" \n I can only process the numbers 1 and 2. Please try again: \n");
            }
        }
    }

    /*board setup here*/
    public void boardSetUp() {
        //creates grid and records coordinates given by user
	String[][] grid = new String[10][10];
        boolean error = true;
	String cord = "";
	int x = 0;
	int y = 0;
	int dir = 0;
	//carrier setup
	while(error) {
	    System.out.print("Awesome! First, we'll place your Carrier. It'll take up  units on the board. Make sure you choose a letter between A and J, and a number between 1 and 10 for the coordinates. enter the x and y coordinates with no space in between, like so: 'D7' :  ");
	    cord = Keyboard.readString();
	    x = digitify(cord.substring(0, 1));
	    dir = 0;
	    y = Integer.parseInt(cord.substring(1));
		    
	    boolean contains = CORD_LETTERS.contains(cord.substring(0,1));

	    if (contains == false) 
		System.out.println(" \n Error with x axis...please try again \n");
	    else if (y > 10) 
		System.out.println(" \n Error with y axis...please try again \n");
	    else 
		error = false;
	}
	
	
        grid[x][y] = "carrier";
	System.out.print("Do you want the ship to lay horizontally, or vertically? Enter 1 for horizontally, or 2 for vertically: ");
	dir = Keyboard.readInt();
	    
	int carrierCount = 5;
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
		    grid[x][y] = "carrier";;
		    y++;;
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
	else
            System.out.print("Sorry, but I can only interpret 1 and 2. Please try again: ");

	error = true;
	//end carrier setup
	//battleship setup
	while(error) {
	    System.out.print("Next, we'll place your battleship. Like before, enter a letter between A and J, and a number between 1 and 10: ");
	    cord = Keyboard.readString();
            x = digitify(cord.substring(0, 1));
	    dir = 0;
	    y = Integer.parseInt(cord.substring(1));
            
	    boolean contains = CORD_LETTERS.contains(cord.substring(0,1));

	    if (contains == false)
		System.out.print("\n error with x axis...please try again: \n");
            else if (y > 10)
                System.out.print("\n error with y axis...please try again: \n");
            else
                error = false;
	}

	grid[x][y] = "battleship";
	System.out.print("Do you want the ship to lay horizontally, or vertically? Enter 1 for horizontally, or 2 for vertically: ");
	dir = Keyboard.readInt();

	int battleshipCount = 4;
	if (dir == 1) {
	    if (x < 6) {
		while(battleshipCount > 0) {
		    grid[x][y] = "battleship";
		    x++;
		    battleshipCount--;
		}
	    }
	    else {
		while(battleshipCount > 0) {
		    grid[x][y] = "battleship";
		    x--;
		    battleshipCount++;
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
	else 
	    System.out.print("Sorry, but I can only interpret 1 and 2. Please try again: ");
	
	error = true;
	//end battleship set up
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
	    else
		error = false;
	}
	 
	grid[x][y] = "submarine";
	System.out.print("Do you want the ship to lay horizontally, or vertically? Enter 1 for horizontally, or 2 for vertically: ");
	dir = Keyboard.readInt();

	int submarineCount = 3;
	if (dir == 1) {
	    if (x < 6) {
		while(submarineCount > 0) {
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
	    else
		error = false;
	}
        
        grid[x][y] = "destroyer";
	System.out.print("Do you want the ship to lay horizontally, or vertically? Enter 1 for horizontally, or 2 for vertically: ");
	dir = Keyboard.readInt();

	int destroyerCount = 3;
	if (dir == 1) {
	    if (x < 6) {
		while(destroyerCount > 0) {
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
	    else
		error = false;
	}

	grid[x][y] = "patrolboat";
	System.out.print("Do you want the ship to lay horizontally, or vertically? Enter 1 for horizontally, or 2 for vertically: ");
	dir = Keyboard.readInt();

	int patrolboatCount = 2;
	if (dir == 1) {
	    if (x < 6) {
		while(patrolboatCount > 0) {
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
	else 
	    System.out.print("\n Sorry, but I can only interpret 1 and 2. Please try again: \n");
    
    
        System.out.println("\n Your board is all set up!");
    }//end boardsetUp()

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
		printGrid(grid);
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
		if (grid[x][y] == "x") {
		    System.out.println("...What a waste of a turn. You hit where you already have before. I'm disappointed in you, to be honest.");
		}
		else if (grid[x][y] == null) {
		    System.out.println("Gosh! Your missile made quite the explosion! With water. Sorry, man. You missed. Now it's the computer's turn.");
		    grid[x][y] = "x";
		}
		else if (grid[x][y] == "carrier") {
		    grid[x][y] = "x";
		    if (aicctr > 1) {
			System.out.print("You hit your opponent's carrier! Great shot! Go again: ");
		    }
		    else {
			System.out.print("WOOOH! YOU SUNK THE CARRIER!!!! Go again: ");
			aishipctr--;
			aicctr--;
		    }
		}
		else if (grid[x][y] == "battleship") {
		    grid[x][y] = "x";
		    if (aibctr > 1) {
			System.out.print("#swag! You hit the battleship! Awesome! You can take another turn: ");
			aibctr--;
		    }
		    else {
			System.out.print("YAASSS!! You sunk the battleship! Go again: ");
			aishipctr--;
			aibctr--;
		    }
		}
		else if (grid[x][y] == "destroyer") {
		    grid[x][y] = "x";
		    if (aidctr > 1) {
			System.out.print("Woah! You nicked the destroyer! Great shot! Your turn again: ");
			aidctr--;
		    }
		    else {
			System.out.print("woop dee doo! You sunk the destroyer! Go again: ");
			aishipctr--;
			aidctr--;
		    }
		}
		else if (grid[x][y] == "submarine") {
		    grid[x][y] = "x";
		    if (aisctr > 1) {
			System.out.print("Nooice! You hit the sub! I'm not sure how, since it's underwater. You must just be a great shot. Your turn again: ");
			aisctr--;
		    }
		    else {
			System.out.print("Swiggity swag! You sunk the sub! Take another turn: ");
			aishipctr--;
			aisctr--;
		    }
		}
		else if (grid[x][y] == "patrolboat") {
		    grid[x][y] = "x";
		    if (aipctr > 1) {
			System.out.print("You've bombed the elusive patrolboat! Good aim. Your turn again: ");
			aipctr--;
		    }
		    else {
			System.out.print("GNARLY! The patrolboat is sunk! Go again: ");
			aishipctr--;
			aipctr--;
		    }
		}
	    }
	    else {
		shots++;
		if (grid[x][y] == "x") {
		    System.out.println("...What a waste of a turn. You hit where you already have before. I'm disappointed in you, to be honest.");
		}
		else if (grid[x][y] == null) {
		    System.out.println("Gosh! Your missile made quite the explosion! With water. Sorry, man. You missed. Now it's the computer's turn.");
		    grid[x][y] = "x";
		}
		else if (grid[x][y] == "carrier") {
		    grid[x][y] = "x";
		    if (aicctr > 1) {
			System.out.print("You hit your opponent's carrier! Great shot! Go again: ");
		    }
		    else {
			System.out.println("WOOOH! YOU JUST WON THE GAME! and it only took you " + shots + " turns!");
			aishipctr--;
			aicctr--;
		    }
		}
		else if (grid[x][y] == "battleship") {
		    grid[x][y] = "x";
		    if (aibctr > 1) {
			System.out.print("#swag! You hit the battleship! Awesome! You can take another turn: ");
			aibctr--;
		    }
		    else {
			System.out.println("WOOOH! YOU JUST WON THE GAME! and it only took you " + shots + " turns!");
			aishipctr--;
			aibctr--;
		    }
		}
		else if (grid[x][y] == "destroyer") {
		    grid[x][y] = "x";
		    if (aidctr > 1) {
			System.out.print("Woah! You nicked the destroyer! Great shot! Your turn again: ");
			aidctr--;
		    }
		    else {
			System.out.println("WOOOH! YOU JUST WON THE GAME! and it only took you " + shots + " turns!");
			aishipctr--;
			aidctr--;
		    }
		}
		else if (grid[x][y] == "submarine") {
		    grid[x][y] = "x";
		    if (aisctr > 1) {
			System.out.print("Nooice! You hit the sub! I'm not sure how, since it's underwater. You must just be a great shot. Your turn again: ");
			aisctr--;
		    }
		    else {
			System.out.println("WOOOH! YOU JUST WON THE GAME! and it only took you " + shots + " turns!");
			aishipctr--;
			aisctr--;
		    }
		}
		else if (grid[x][y] == "patrolboat") {
		    grid[x][y] = "x";
		    if (aipctr > 1) {
			System.out.print("You've bombed the elusive patrolboat! Good aim. Your turn again: ");
			aipctr--;
		    }
		    else {
			System.out.println("WOOOH! YOU JUST WON THE GAME! and it only took you " + shots + " turns!");
			aishipctr--;
			aipctr--;
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
		shots++;
		if (grid[x][y] == "x") {
		    System.out.println("The ai hit where it already has before. Silly ai. Your turn!");
		}
		else if (grid[x][y] == null) {
		    System.out.println("The ai missed. Your turn.");
		    grid[x][y] = "x";
		}
		else if (grid[x][y] == "carrier") {
		    grid[x][y] = "x";
		    if (usercctr > 1) {
			System.out.println("Ouch! The ai hit your carrier. It goes again!");
			usercctr--;
		    }
		    else {
			System.out.println("The ai sunk your carrier. That sucks.");
			usershipctr--;
			usercctr--;
		    }
		}
		else if (grid[x][y] == "battleship") {
		    grid[x][y] = "x";
		    if (userbctr > 1) {
			System.out.println("The ai hit your battleship. Whoops.");
			userbctr--;
		    }
		    else {
			System.out.println("The ai sunk your battleship. Really? You can do better.");
			usershipctr--;
			userbctr--;
		    }
		}
		else if (grid[x][y] == "destroyer") {
		    grid[x][y] = "x";
		    if (userdctr > 1) {
			System.out.println("The ai bombed your destroyer. I'm disappointed in you.");
			userdctr--;
		    }
		    else {
			System.out.print("woop dee doo! You sunk the destroyer! Go again: ");
			aishipctr--;
			aidctr--;
		    }
		}
		else if (grid[x][y] == "submarine") {
		    grid[x][y] = "x";
		    if (aisctr > 1) {
			System.out.print("Nooice! You hit the sub! I'm not sure how, since it's underwater. You must just be a great shot. Your turn again: ");
			aisctr--;
		    }
		    else {
			System.out.print("Swiggity swag! You sunk the sub! Take another turn: ");
			aishipctr--;
			aisctr--;
		    }
		}
		else if (grid[x][y] == "patrolboat") {
		    grid[x][y] = "x";
		    if (aipctr > 1) {
			System.out.print("You've bombed the elusive patrolboat! Good aim. Your turn again: ");
			aipctr--;
		    }
		    else {
			System.out.println("GNARLY! The patrolboat is sunk! Go again.");
			aishipctr--;
			aipctr--;
		    }
		}
	    }
	    else {
		shots++;
		if (grid[x][y] == "x") {
		    System.out.println("...What a waste of a turn. You hit where you already have before. I'm disappointed in you, to be honest.");
		}
		else if (grid[x][y] == null) {
		    System.out.println("Gosh! Your missile made quite the explosion! With water. Sorry, man. You missed. Now it's the computer's turn.");
		    grid[x][y] = "x";
		}
		else if (grid[x][y] == "carrier") {
		    grid[x][y] = "x";
		    if (aicctr > 1) {
			System.out.print("You hit your opponent's carrier! Great shot! Go again: ");
		    }
		    else {
			System.out.println("WOOOH! YOU JUST WON THE GAME! and it only took you " + shots + " turns!");
			aishipctr--;
			aicctr--;
		    }
		}
		else if (grid[x][y] == "battleship") {
		    grid[x][y] = "x";
		    if (aibctr > 1) {
			System.out.print("#swag! You hit the battleship! Awesome! You can take another turn: ");
			aibctr--;
		    }
		    else {
			System.out.println("WOOOH! YOU JUST WON THE GAME! and it only took you " + shots + " turns!");
			aishipctr--;
			aibctr--;
		    }
		}
		else if (grid[x][y] == "destroyer") {
		    grid[x][y] = "x";
		    if (aidctr > 1) {
			System.out.print("Woah! You nicked the destroyer! Great shot! Your turn again: ");
			aidctr--;
		    }
		    else {
			System.out.println("WOOOH! YOU JUST WON THE GAME! and it only took you " + shots + " turns!");
			aishipctr--;
			aidctr--;
		    }
		}
		else if (grid[x][y] == "submarine") {
		    grid[x][y] = "x";
		    if (aisctr > 1) {
			System.out.print("Nooice! You hit the sub! I'm not sure how, since it's underwater. You must just be a great shot. Your turn again: ");
			aisctr--;
		    }
		    else {
			System.out.println("WOOOH! YOU JUST WON THE GAME! and it only took you " + shots + " turns!");
			aishipctr--;
			aisctr--;
		    }
		}
		else if (grid[x][y] == "patrolboat") {
		    grid[x][y] = "x";
		    if (aipctr > 1) {
			System.out.print("You've bombed the elusive patrolboat! Good aim. Your turn again: ");
			aipctr--;
		    }
		    else {
			System.out.println("WOOOH! YOU JUST WON THE GAME! and it only took you " + shots + " turns!");
			aishipctr--;
			aipctr--;
		    }
		}
	    }
	//need another } to end method but that creates more errors i'm confused with

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
