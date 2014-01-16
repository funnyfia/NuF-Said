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
	String[][] grid = new String[10][10];
	int num = 0;
	String cor = "";
	String dir = "";
	System.out.println("Hello, friendly user! Welcome to Battleship!");
	System.out.println("Before we start, you need to place your ships on the board. Please enter 1 if you would like this to be done randomly. If you want to place them yourself, please enter 2.");
	try {
	    num = Integer.parseInt(in.readLine());
	}
	catch (IOException e) {}
	
	if (num == 1) {
		System.out.println("Setting up ships...");
		//setRand(String[][] x);
		//sets up ships randomly uncomment when created
	}
	else if (num == 2) {
	    System.out.println("Awesome! First, we'll place your Carrier. It'll take up  units on the board. Make sure you choose a letter between A and J, and a number between 1 and 10 for the coordinates. enter the x and y coordinates with no space in between, like so: 'D7'.");
	    try {
		cor = in.readLine();
	    }
	    catch (IOException e) {}
	    int number = digitify(cor);
	    grid[number][Integer.parseInt(cor.substring(1))] = "carrier";
	    System.out.println("Cool! Do you want your ship to continue left, right, up, or down? Enter one.");
	    try {
	    	dir = in.readLine();
	    }
	    catch (IOException e) {}
	    if (dir == "left") {
	    	
	    }
	    number = digitify(cor);
	    grid[number][Integer.parseInt(cor.substring(1))] = "carrier";
	    
	    //put ship parts in spot, ask if wants to cont ship l,r,u,d.
	}
    }

    public void  playTurn() {
	int shots = 0;
    }
    
    public int digitify(String x) {
    	int ans = 0;
    	for (int i = 0; i < 10; i++) {
	    if (x.substring(0) == CORD_LETTERS.substring(i))
		ans = i + 1;
    	}
    	return ans;
    }
    
    /* public void setRand(String[][] grid) {
    	int x = 0;
	int y = 0;
	int dir = 0;
	//maybe do String[][] ships to set ships more easily? But how do we do that with length? Do we need an int[][]lens? Maybe...
	int totalShip = 5;
	while(totalShip > 0) {
		dir = (int)(Math.random());//0 is horizontal, 1 is vertical.
	 	x = (int)(Math.random() * 10);
	 	y = (int)(Math.random() * 10);
	 	if (dir == 0) {
	 		if (x <= 5) {
	 			grid[x][y] = "carrier";
	 			grid[x + 1][y] = "carrier";
	 			grid[x + 2][y] = "carrier";
	 			grid[x + 3][y] = "carrier";
	 			grid[x + 4][y] = "carrier";
	    			totalShip--;
	 		}
	 		else {
	 			grid[x][y] = "carrier";
	 			grid[x - 1][y] = "carrier";
	 			grid[x - 2][y] = "carrier";
	 			grid[x - 3][y] = "carrier";
	 			grid[x - 4][y] = "carrier";
	 			totalShip--;
	 		}
	 	}
	 	else {
	 		if (y <= 5) {
	 			grid[x][y] = "carrier";
	 			grid[x][y + 1] = "carrier";
	 			grid[x][y + 2] = "carrier";
	 			grid[x][y + 3] = "carrier";
	 			grid[x][y + 4] = "carrier";
	    			totalShip--;
	 		}
	 		else {
	 			grid[x][y] = "carrier";
	 			grid[x][y - 1] = "carrier";
	 			grid[x][y - 2] = "carrier";
	 			grid[x][y - 3] = "carrier";
	 			grid[x][y - 4] = "carrier";
	 			totalShip--;
	 		}
	 	}
	}
	}*/
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
	System.out.println(swag);
	
	//printGrid(grid);
    
    }//end main
}//end class Battleship
