/*=======================================================
  Battleship- Driver and Gameplay file for Battleship
  ========================================================*/

import java.io.*;
import java.util.*;

public class Battleship{
 
    /*~~~~~~~~~~~~~~~~INSTANCE VARIABLE~~~~~~~~~~~~~~~~~~~~~~~
 
      constants that determine how many hits specific ships take before destroyed*/ 
    public final static int CARRIER_CTR = 5;
    public final static int BATTLESHIP_CTR = 4;
    public final static int SUBMARINE_CTR = 3;
    public final static int DESTROYER_CTR = 3;
    public final static int PATROLBOAT_CTR = 2;
    //constant that determines if you have sunken all ships and one game
    public final static int SHIP_CTR = 5;
 
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

    //~~~~~~~~DEFAULT CONSTRUCTOR~~~~~~~~~~~~~~~~~~~~~~
    public Battleship() {
	isr = new InputStreamReader(System.in);
	in = new BufferedReader(isr);
        gameOver = false;
	String[][] grid = new String[10][10];
	System.out.println("Let's play!");
	//newGame();
    }

    public void setUp() {
	System.out.println("Hello, friendly user! Welcome to Battleship!");
	System.out.println("Before we start, you need to place your ships on the board. Please enter 1 if you would like this to be done randomly. If you want to place them yourself, please enter 2.");
	try {
	    int num = Integer.parseInt(in.readLine());
	}
	catch (IOEception e) {}
	
	if (num == 1) {
		System.out.println("Setting up ships...");
		//setRand(String[][] x);
		//sets up ships randomly uncomment when created
	}
	else if (num == 2) {
	    System.out.println("Awesome! First, we'll place your Carrier. It'll take up  units on the board. Make sure you choose a letter between A and J, and a number between 1 and 10. enter the x and y coordinates with no space in between, like so: 'D7'.");
	    try {
		String cor = in.readLine();
	    }
	    catch (IOEception e) {}
	    //read cor, put in spot, ask if wants to cont ship l,r,u,d.
	}
    }

    public void  playTurn() {
	int shots = 0;
    }
    
   /* public void setRand(String[][] x) {
    	
    	int totalShip = 5;
    	while(totalShip > 0)
    		for(int i = 0; i < x.length; i++) {
    			for (int j = 0; j < x[i].length; j++) {
 				double bias = Math.random();
 				if (bias > 0.5) {
 				
 			}
    		}
    	}
    } */
    
}//end class Battleship
