/*=======================================================
  Battleship- Driver and Gameplay file for Battleship
  ========================================================*/

import java.io.*;
import java.util.*;
import cs1.Keyboard;

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
        int setupnum = 0;
        System.out.println("Hello, friendly user! Welcome to Battleship!");
        System.out.println("Before we start, you need to place your ships on the board. Please enter 1 if you would like this to be done randomly. If you want to place them yourself, please enter 2.");
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
                System.out.println("I can only process the numbers 1 and 2. Please try again.");
            }
        }
    }

    public void boardSetUp() {
        String[][] grid = new String[10][10];
        System.out.println("Awesome! First, we'll place your Carrier. It'll take up  units on the board. Make sure you choose a letter between A and J, and a number between 1 and 10 for the coordinates. enter the x and y coordinates with no space in between, like so: 'D7'.");
        String cord = "";
        int x = 0;
        int dir = 0;
        int y;
        while (!CORD_LETTERS.contains(cord.substring(0)) || Integer.parseInt(cord.substring(1)) > 10) {
            cord = Keyboard.readString();
            y = Integer.parseInt(cord.substring(1));
            if (CORD_LETTERS.contains(cord.substring(0)) && y <= 10) {
                x = digitify(cord);
                grid[x][y] = "carrier";
                System.out.println("Do you want the ship to lay horizontally, or vertically? Enter 1 for horizontally, or 2 for vertically.");
                while (dir != 1 || dir != 2) {
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
                }
            }
            
            else  {
                System.out.println("Sorry, but I can only interpret 1 and 2. Please try again.");
            }
        }
    
        System.out.println("Next, we'll place your battleship. Like before, enter a letter between A and J, and a number between 1 and 10.");
        while (!CORD_LETTERS.contains(cord.substring(0)) || Integer.parseInt(cord.substring(1)) > 10) {
            cord = Keyboard.readString();
            y = Integer.parseInt(cord.substring(1));
            if (CORD_LETTERS.contains(cord.substring(0)) && y <= 10) {
                x = digitify(cord);
                grid[x][y] = "battleship";
                System.out.println("Do you want the ship to lay horizontally, or vertically? Enter 1 for horizontally, or 2 for vertically.");
                while (dir != 1 || dir != 2) {
                    dir = Keyboard.readInt();
                    int battleshipCount = 4;
                    if (dir == 1) {
                        if (x < 6) {
			    while(battleshipCount > 5) {
				grid[x][y] = "battleship";
				x++;
				battleshipCount--;
			    }
                        }
                        else {
                            while(battleshipCount < 5) {
				grid[x][y] = "battleship";
				x--;
				battleshipCount++;
                            }
                        }
                    }
                    else if (dir == 2) {
                        if (y < 6) {
                            while(battleshipCount > 5) {
                                grid[x][y] = "battleship";
                                y++;
                                battleshipCount--;
                            }
                        }
                        else {
                            while(battleshipCount > 5) {
                                grid[x][y] = "battleship";
                                y--;
                                battleshipCount--;
                            }
                        }
                    }
                }
            }
            else {
                System.out.println("Sorry, but I can only interpret 1 and 2. Please try again.");
            }
        }
        
        System.out.println("Next up is your submarine! Letter between A and J, number between 1 and 10. You know the drill.");
        while (!CORD_LETTERS.contains(cord.substring(0)) || Integer.parseInt(cord.substring(1)) > 10) {
            cord = Keyboard.readString();
            y = Integer.parseInt(cord.substring(1));
            if (CORD_LETTERS.contains(cord.substring(0)) && y <= 10) {
                x = digitify(cord);
                grid[x][y] = "submarine";
                System.out.println("Do you want the ship to lay horizontally, or vertically? Enter 1 for horizontally, or 2 for vertically.");
                while (dir != 1 || dir != 2) {
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
                }
            }
            
            else {
                System.out.println("Sorry, but I can only interpret 1 and 2. Please try again.");
            }
        }
        
        System.out.println("DESTROYER TIMEEEEEE. Do I have to tell you what to do again? Enter the coordinate.");
        while (!CORD_LETTERS.contains(cord.substring(0)) || Integer.parseInt(cord.substring(1)) > 10) {
            cord = Keyboard.readString();
            y = Integer.parseInt(cord.substring(1));
            if (CORD_LETTERS.contains(cord.substring(0)) && y <= 10) {
                x = digitify(cord);
                grid[x][y] = "destroyer";
                System.out.println("Do you want the ship to lay horizontally, or vertically? Enter 1 for horizontally, or 2 for vertically.");
                while (dir != 1 || dir != 2) {
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
                }
            }
            else {
                System.out.println("Sorry, but I can only interpret 1 and 2. Please try again.");
            }
        }
        
        System.out.println("Last ship! Enter a coordinate for your patrolboat.");
        while (!CORD_LETTERS.contains(cord.substring(0)) || Integer.parseInt(cord.substring(1)) > 10) {
            cord = Keyboard.readString();
            y = Integer.parseInt(cord.substring(1));
            if (CORD_LETTERS.contains(cord.substring(0)) && y <= 10) {
                x = digitify(cord);
                grid[x][y] = "patrolboat";
                System.out.println("Do you want the ship to lay horizontally, or vertically? Enter 1 for horizontally, or 2 for vertically.");
                while (dir != 1 || dir != 2) {
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
                }
            }
            else {
                System.out.println("Sorry, but I can only interpret 1 and 2. Please try again.");
            }
        }
        System.out.println("Your board is all set up!");
    }//end boardsetUp()

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
    
    public void setRand(String[][] grid) {
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
	    System.out.println(swag);
        
        //printGrid(grid);
    
    }//end main
}//end class Battleship
