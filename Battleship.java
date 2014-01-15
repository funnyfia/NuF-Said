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
 //turncounter determines who's turn it is
    private int TurnCtr;
    /*determines difficulty of AI...determines which subclass of AI to call
      UNCOMMENT IF DOING DIFFICULTY
    private int difficulty;
    */

 //~~~~~~~~DEFAULT CONSTRUCTOR~~~~~~~~~~~~~~~~~~~~~~
    public Battleship() {
	gameOver = false;
	TurnCtr = 0;
	//newGame();
    
}//end class Battleship
