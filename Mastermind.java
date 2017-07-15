// ========================================================================
// 	Java Final Assignment
// 	Matthew Chan
// January 21, 2015
// 	Java 4.0
// ========================================================================
//	Plays the game Mastermind where users guess a randomly generated 5 digit code
//	Each player has 8 guesses and after each guess, if not successful, will display the number
//	of numbers in the correct place and the number of correct numbers
//	Users also have the choice to play another game, keeping track of the total points and total number of games
//	Users can choose to look at the statistics which display the top 10 scores and their respective players
// ========================================================================
// 	List of Indentifiers 	- let frame f,t,q represent frames that will be used
//											- let pane p,g,b,z,y represent panels that will be placed onto frames
//											- let correctposition represent number of numbers in the correct position
//											- let correctnumber represent number of correct numbers
//											- let rcode represent the random 5 digit code
//											- let num1-5 represent their respective digits in the random code
//											- let users represent the file name containing the logins
//											- let rankings represent the file name containing the rankings
//											- let name represent the name of the person playing the game
//											- let password represent the password being entered by the user
//											- let points represent the number of points during a single game
//											- let totalpoints represent the number of total points
//											- let gamenum represent the game number for the current session
//											- let bestattempt represent the best attempt for the user
//											- let averageattempt represent the average number of attempts for the user
//											- let totaltries represent the number of total tries by the user
//											- let play represent the button used to make a guess
//											- let usernamef represent the textfield the user enters their username
//											- let passwordf represent the textfield the user enters their password
//											- let guess represent the textfield that shows what the user is going to guess
//											- let guess1-8 represent the textfields used to show the result of the user`s guess
//											- let pguess1-8 represent the textfields used to show the users guess 
//											- let tgamenum represent the textfield that will show how many games the user has played
//											- let ttotalpoints represent the textfield that will show how the total points
//											- let tbestattempt represent the textfield that will show the best attempt by the user
//											- let taverageattempt represent the textfield that will show the average numbers of attempts by the user
//											- let check represent if a guess is valid or not
//											- let trycount represent number of attempts for the current game
//											- let ranking represent the array to hold the average points for the 1st,2nd .... 10th place user
// ========================================================================

import java.awt.*;
import java.io.*;

public class menu extends Frame {		//start of program
	static Frame f = new menu();		//declare and instantiate frame f
	static Frame t = new menu();		//declare and instantiate frame t
	static Frame q = new menu();		//declare and instantiate frame q
	 Panel p = new Panel();		//declare and instantiate panel p
	 Panel g = new Panel();		//declare and instantiate panel g
	 Panel b = new Panel();		//declare and instantiate panel b
	 Panel z = new Panel();		//declare and instantiate panel z
	 Panel y = new Panel();		//declare and instantiate panel y
	 static int correctposition = 0, correctnumber = 0;	//declare and initialize correctnumber and correct position to 0
	 static String rcode, num1, num2, num3, num4 ,num5;	//declare rcode, num1-5
	 static String users = "C:\\Users\\Matthew Chan\\Desktop\\eclipse\\users.txt";		//declare and initialze users (file location)
	 static String rankings = "C:\\Users\\Matthew Chan\\Desktop\\eclipse\\rankings.txt";		//declare and initialze rankings (file location)
	 static String name = "Player", password;	//declare name & password
	 static String userguess;	//declare userguess
	 static	String points;	//declare points
	 static int totalpoints = 0;		//declare and initialze totalpoints to 0
	 static int gamenum = 0;		//declare and initialize gamenum to 0
	 static int bestattempt;		//declare bestattmpt
	 static double averageattempt;	//declare averageattemp
	 static int totaltries = 0;	//declare and initialze totaltries
	 static Button play = new Button ("Guess");		//declare and instantiate button play
	 static TextField usernamef = new TextField();	//declare and instantiate TextField usernamef
	 static TextField passwordf = new TextField();	//declare and instantiate TextField passwordf
	 static TextField guess = new TextField("");	//declare and instantiate TextField guess
	 static TextField pointlabel;		//declare TextField pointlabel
	 //********** declare and instantiate 8 TextFields used to display the result of the user's guess
	 static TextField guess1 = new TextField(26), guess2= new TextField(), guess3= new TextField(), guess4= new TextField(), guess5= new TextField(), guess6= new TextField(), guess7= new TextField(), guess8= new TextField();
	 //********** declare and instantiate 8 TextFields used to display the user's guess
	 static TextField pguess1 = new TextField(2), pguess2= new TextField(), pguess3= new TextField(), pguess4= new TextField(), pguess5= new TextField(), pguess6= new TextField(), pguess7= new TextField(), pguess8= new TextField();
	 static TextField tgamenum = new TextField();		//declare and instantiate TextField tgamenum
	 static TextField ttotalpoints = new TextField();		//declare and instantiate TextField ttotalpoints
	 static TextField tbestattempt = new TextField();
	 static TextField taverageattempt = new TextField();
	 static boolean check = false;		//declare and initialize check to false
	 static int trycount;		//declare trycount
	 static String ranking[] = new String[10];

	public menu(){		//start of menu
		Font myFont = new Font("TimesRoman", Font.BOLD, 39);	//declare and instantiate font myFont (Times New Roman)
		Label display = new Label("MASTERMIND");	//declare and instantiate label display
		Button play = new Button ("Play game");	//declare and instantiate button play
		Button login = new Button ("Login");	//declare and instantiate button login
		Button register = new Button ("How to play");	//declare and instantiate button register
		Button stats = new Button ("Statistics");	//declare and instantiate button stats
		Button exit = new Button ("Exit");	//declare and instantiate button exit
	
		p.setLayout(new GridLayout(6, 1));	//set a new gridlayout to panel p
		p.add(display);	//add display to panel p
		display.setFont(myFont);	//set the font on label display to myFont (times new roman)
		p.add(play);	//add play to panel p
		p.add(login);	//add login to panel p
		p.add(register);	//add register to panel p
		p.add(stats);	//add stats to panel p
		p.add(exit);	//add exit to panel p
		add("Center", p);	//add panel p to center of frame
	}		//end menu

	public static void main (String[] args){	//start main method
		f.resize(300, 500);	//resize frame f to dimensions 300x500
		f.show(); //show the frame
	}	//end main method
	
	// ========================================================================
	// 	action method
	// ========================================================================
	//	responds to button presses
	// ========================================================================
	//	Calls method login to allow the user to log in
	//	Calls method read to read the file needed to check username + password
	//	Calls method rankings to refresh the standings
	//	Calls randomCode to create a random 5 digit code
	//	Calls howtoplay to tell the user how to play the game
	//	Calls stats to open a new frame displaying ranking
	//	Calls checkCode to check the user's guess compared to the 5 digit code
	// 	========================================================================
	//	@return - true
	// ========================================================================
	public boolean action(Event evt, Object arg){	//start action method
		Frame a = new menu();	//declare and instantiate frame a
		menu swag = new menu();	//declare and instantiate object swag
		if (arg.equals("Exit")) 	//enter if button has text Exit
  			System.exit(0);		//close window
		else if (arg.equals("Login"))	//enter if button has text Login
			swag.login(a);	//call method login with argument frame a
		else if (arg.equals("Log in"))	//enter if button has text Log in
			try {	//start try
				swag.read();	//call method read
			} catch (IOException e) {	//end try, start catch with Exception e
				System.out.println ("File has not been read");
				e.printStackTrace();
			}	//end catch
		else if (arg.equals("Back"))	//enter if button has text Back
				dispose();	//close window
		else if (arg.equals("Create profile")) {	//enter if button has text Create profile
			name = usernamef.getText();	//set name to text in TextField usernamef
			password = passwordf.getText();	//set password to text in TextField passwordf
			System.err.println (name);
			System.out.println(password);
			a.setVisible(false);	//make frame a visible
			dispose();	//close window
		}	//end else if statement
		else if (arg.equals("Back to menu")) {	//enter if button has text Back to menu
			try {	//start try
				swag.rankings();
			} catch (IOException e) {	//end try, start catch with Exception e
				System.out.println ("File has not been read");
				e.printStackTrace();
			}	//end catch
			dispose();	//close window
			b.removeAll();	//remove objects on panel b
			g.removeAll();	//remove objects on panel g
			z.removeAll();	//remove objects on panel z
			y.removeAll();	//remove objects on panel y
			gamenum = 0;	//set gamenum to 0
			totalpoints = 0;	 //set totalpoints to 0
			totaltries = 0;
			bestattempt = 0;
			averageattempt = 0;
			Font myFont = new Font("TimesRoman", Font.BOLD, 39);	//declare and instantiate font myFont (Times New Roman)
			Label display = new Label("MASTERMIND");	//declare and instantiate label display
			Button play = new Button ("Play game");	//declare and instantiate button play
			Button login = new Button ("Login");	//declare and instantiate button login
			Button register = new Button ("How to play");	//declare and instantiate button register
			Button stats = new Button ("Statistics");	//declare and instantiate button stats
			Button exit = new Button ("Exit");	//declare and instantiate button exit
			f.resize(300, 500);	//resize frame f to dimensions 300x500
			f.show(); 	//show frame f
			removeAll();	//remove all objects
			add("Center", p);	//add panel p to center
			
			p.setLayout(new GridLayout(6, 1));	//set a new gridlayout to panel p
			p.add(display);	//add display to panel p
			display.setFont(myFont);	//set the font on label display to myFont (times new roman)
			p.add(play);	//add play to panel p
			p.add(login);	//add login to panel p
			p.add(register);	//add register to panel p
			p.add(stats);	//add stats to panel p
			p.add(exit);	//add exit to panel p
			add("Center", p);	//add panel p to center of frame
		}	//end else if
		
		
		else if (arg.equals("Play game")){	//enter if button has text Play game
			Font myFont = new Font("TimesRoman", Font.BOLD, 39);	//declare and instantiate font myFont (Times New Roman)
			Label display = new Label(name + " the Mastermind");	//declare and instantiate label display
			points = "160";	//set points to 160
			pointlabel  = new TextField("Points: " + points);	//instantiate TextField pointlabel
			play.setLabel("Guess");	//set the text on play to Guess
			Button number = new Button();	//declare and instantiate button number
			Button clear = new Button("Del");	//declare and instaniate button clear
			Button quit = new Button ("Back to menu");	//declare and instantiate button quit
			remove(q);	//remove panel q
			trycount = 0;	//set trycount to 0
			swag.randomCode();	//call method randomCode
			System.out.println ("The code is " + rcode);	//display cheat code in console
			guess.setEditable(false);	//make guess uneditable
			gamenum++;	//add one to gamenum
			//**********clears the Textfield in pguess1-8
			pguess1.setText(""); pguess2.setText(""); pguess3.setText(""); pguess4.setText(""); pguess5.setText(""); pguess6.setText(""); pguess7.setText(""); pguess8.setText("");
			pguess1.setBackground(Color.white); 			pguess2.setBackground(Color.white);
			pguess3.setBackground(Color.white); 			pguess4.setBackground(Color.white);
			pguess5.setBackground(Color.white); 			pguess6.setBackground(Color.white);
			pguess7.setBackground(Color.white); 			pguess8.setBackground(Color.white);
			//**********clears the Textfield in guess1-8
			guess1.setText(""); guess2.setText(""); guess3.setText(""); guess4.setText(""); guess5.setText(""); guess6.setText(""); guess7.setText(""); guess8.setText("");
			guess1.setBackground(Color.white);				 guess2.setBackground(Color.white);
			guess3.setBackground(Color.white);				 guess4.setBackground(Color.white);
			guess5.setBackground(Color.white); 				guess6.setBackground(Color.white);
			guess7.setBackground(Color.white); 				guess8.setBackground(Color.white);
			
			p.removeAll();	//remove objects in panel p
			g.removeAll();	//remove objects in panel g
			y.removeAll();	//remove objects in panel y
			b.removeAll();	//remove objects in panel b
			z.removeAll();	//remove objects in panel z
			add("East", z);	//add panel z to the right side
			add("South",y);	//add panel y to the bottom
			add("North", b);	//add panel b to the top
			add("West", g);	//add panel g to the left side
			
			g.setLayout(new GridLayout(4,4));	//set gridlayout for panel g
			for (int i = 0; i <= 9; i++) {	//start of counted loop
				number = new Button ("" + (char)('0' + i));	//declare and instantiate button [i]
				g.add(number);	//add button [i] to panel g
			}	//end of counted loop
			g.add(clear);	//add clear to panel g
			
			z.setLayout(new GridLayout(8,2));	//set gridlayout for panel z
			z.add(pguess1);			pguess1.setEditable(false); 	//add pguess1 to panel z and make it uneditable
			z.add(guess1);			guess1.setEditable(false);	//add guess1 to panel z and make it uneditable
			z.add(pguess2);			pguess2.setEditable(false);	//add pguess2 to panel z and make it uneditable
			z.add(guess2);			guess2.setEditable(false);	//add guess2 to panel z and make it uneditable
			z.add(pguess3);			pguess3.setEditable(false);	//add pguess3 to panel z and make it uneditable
			z.add(guess3);			guess3.setEditable(false);	//add guess3 to panel z and make it uneditable
			z.add(pguess4);			pguess4.setEditable(false);	//add pguess4 to panel z and make it uneditable
			z.add(guess4);			guess4.setEditable(false);	//add guess4 to panel z and make it uneditable
			z.add(pguess5);			pguess5.setEditable(false);	//add pguess5 to panel z and make it uneditable
			z.add(guess5);			guess5.setEditable(false);	//add guess5 to panel z and make it uneditable
			z.add(pguess6);			pguess6.setEditable(false);	//add pguess6 to panel z and make it uneditable
			z.add(guess6);			guess6.setEditable(false);	//add guess6 to panel z and make it uneditable
			z.add(pguess7);			pguess7.setEditable(false);	//add pguess7 to panel z and make it uneditable
			z.add(guess7);			guess7.setEditable(false);	//add guess7 to panel z and make it uneditable
			z.add(pguess8);			pguess8.setEditable(false);	//add pguess8 to panel z and make it uneditable
			z.add(guess8);			guess8.setEditable(false)	;//add guess8 to panel z and make it uneditable
			
			b.setLayout(new GridLayout(1,1));	//set gridlayout for panel b
			b.add(display);	//add display to panel b
			display.setFont(myFont);	//set font of display to myFont (times new roman)

			y.setLayout(new GridLayout(4,2));	//set gridlayout for panel y
			y.add(play);	//add play to panel y
			y.add(quit);	//add quit to panel y
			y.add(guess);	//add guess to panel y
			y.add(pointlabel);	//add pointlabel to panel y
			y.add(tgamenum);	tgamenum.setEditable(false);	//add tgamenum to panel y and make it uneditable
			tgamenum.setText("Game number: " + gamenum);	//set the text on TextField tgamenum
			y.add(ttotalpoints);	ttotalpoints.setEditable(false);	//add ttotalpoints to panel y and make it uneditable
			ttotalpoints.setText("Total points: " + totalpoints);	//set the text on TextField ttotalpoints
			y.add(tbestattempt); tbestattempt.setEditable(false);
			tbestattempt.setText("Best attempt: " + bestattempt);
			y.add(taverageattempt);  taverageattempt.setEditable(false);
			taverageattempt.setText("Average attempt: " + averageattempt);
			pack();	//packs all objects together
		}	//end of else if
		else if (arg.equals("How to play"))	//enter if button has text How to play
			swag.howtoplay(a);	//call method howtoplay
		else if (arg.equals("Statistics"))
			try {	//start try
				swag.stats(a);
			} catch (IOException e) {	//end try, start catch with Exception e
				System.out.println ("File has not been read");
				e.printStackTrace();
			}	//end catch
		else if  (arg.equals("Done")) {	//enter if button has text Done
			a.setVisible(false);
			dispose();	//close window
		}	//end of else if
		String s = (String) arg;	//declare and initialize s to arg
		 if ('0' <= s.charAt(0) && s.charAt(0) <= '9')	//enter if s has a value from 0-9
        	guess.setText(guess.getText() + s);	//set the text on textfield guess (add a number to the end)
		 else if (arg.equals("Guess")) {	//enter if button has text Guess
			 userguess = guess.getText();	//initialze userguess to the text on guess
		 	guess.setText("");	//clear the textfield guess
		 	swag.checkCode(play);	//call method checkCode
		 }	//end else if
		 else if (arg.equals("Del"))	//enter if button has text Del
			 guess.setText("");	//clear the textfield guess
  		return true;	//returns true
	} 	//end of action method

	// ========================================================================
	// 	handeEvent method
	// ========================================================================
	//	Allows user to close the window
	// ========================================================================
	//	@return - super.handleEvent
	// ========================================================================
	public boolean handleEvent(Event evt){	//start method handleEvent
   	 	if (evt.id == Event.WINDOW_DESTROY)	//enter if window is trying to be closed
   	 		dispose();	//close window
     	 	return super.handleEvent(evt);
  	 }	//end of method handleEvent
	
	// ========================================================================
	// 	login method
	// ========================================================================
	//	Allows the user to log in, displays promt to enter username and password
	// 	========================================================================
	// 	@param - frame a
	//	@return - void
	// ========================================================================
	public void login (Frame a){	//start method login
		Label instruction = new Label("Please enter your username");	//declare and instantiate label instructions
		Label passwordinstruction = new Label ("Please enter your password");	//declare and instantiate label passwordinstruction
		Button exit = new Button("Log in");	//declare and instantiate button exit
		a.removeAll();	//remove objects on frame a
		a.setLayout(new GridLayout(5, 1));	//set gridlayout for frame a
		a.add(instruction);	//add instruction to frame a
		a.add(usernamef);	//add usernamef to frame a
		a.add(passwordinstruction);	//add passwordinstruction to frame a
		a.add(passwordf);	//add passwordf to frame a
		a.add(exit);	//add exit to frame a
		a.resize(500, 200);	//resize frame a
		a.setVisible(true);	//make frame a visible
	}	//end method login
	
	// ========================================================================
	// 	read method
	// ========================================================================
	//	Reads the file to check for valid username and password
	// 	========================================================================
	// 	@param - void
	//	@return - void
	// ========================================================================
	public void read () throws IOException{	//start method read
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(users)));	//declare and instantiate object br from class BufferedReader
	    Label success = new Label("You have logged in");	//declare and instantiate label success
	    Label failure = new Label("Wrong username and/or password");	//declare and instantiate label failure
	    Button okay = new Button("Back");	//declare and instantiate button okay
		try {	//start try
		    String line;	//declare line
		    String userpass = usernamef.getText() + " " + passwordf.getText();	//declare and initialize userpass
		    line = br.readLine();	//initialize line
		    while (line  != null) {	//start while loop
		        if (line.equals(userpass)) {	//enter if line has the same value as userpass
		        	name = usernamef.getText();	//initialize name
		        	check = true;	//check becomes true
		        }	//end if statement
		        line = br.readLine();	//read next line in the file
		    }	//end while loop
		    if (check == false) {	//enter if check is false
				t.removeAll();	//remove objects on frame t
				t.setLayout(new GridLayout(2, 1));	//set gridlayout for frame t
				t.add(failure);	//add failure on frame t
				t.add(okay);	//add okay on frame t
				t.resize(300,200);	//resize frame t
				t.setVisible(true);	//make frame t visible
			}	//end if statement
			else {		//enter if above condititions are not met
				t.removeAll();	//remove objects on frame t
				t.setLayout(new GridLayout(2, 1));	//set gridlayout for frame t
				t.add(success);	//add success to frame t
				t.add(okay);	//add okay to frame t
				t.resize(300,200);	//resize frame t
				t.setVisible(true);	//make frame t visible
				gamenum = 0;	//initialize gamenum
				totalpoints = 0;	//initialize totalpoints
			}	//end else statement
		} 	//end try
		finally {	
		    br.close();	//stop reading
		}
	}	//end method read
	
	// ========================================================================
	// 	howtoplay method
	// ========================================================================
	//	Opens up a new frame that shows instructions on how to play the game
	// 	========================================================================
	// 	@param - frame a
	//	@return - void
	// ========================================================================
	public void howtoplay (Frame a) {	//start method howtoplay
		Font myFont = new Font("Helvetica", Font.BOLD, 39);	//declare and instantiate font myFont 
		Label display = new Label("HOW TO PLAY");	//declare and instantiate label display
		Label instruction = new Label("There will be a 5 number passcode that you must solve.");	//declare and instantiate label instruction
		Label instruction2 = new Label("You have a maximum of 8 attempts to find out the passcode.");	//declare and instantiate label instruction2
		Label instruction3 = new Label("Every time you make a wrong guess, points are subtracted from the maximum points you could achieve.");	//declare and instantiate label instruction3
		Label instruction4 = new Label("Every time you make a guess, there will be a message saying how many numbers you got correct");	//declare and instantiate label instruction4
		Label instruction5 = new Label("and how many numbers are in the right place. Goodluck!");	//declare and instantiate label instruction5
		Button close = new Button("Done");	//declare and instantiate button close
		a.removeAll();	//remove objects on frame a
		a.setLayout(new GridLayout(7,1));	//set gridlayout for frame a
		a.add(display);	//add display to frame a
		display.setFont(myFont);	//set the font of display to myFont
		a.add(instruction);	//add instruction to frame a
		a.add(instruction2);	//add instruction2 to frame a
		a.add(instruction3);	//add instruction3 to frame a
		a.add(instruction4);	//add instruction4 to frame a
		a.add(instruction5);	//add instruction5 to frame a
		a.add(close);	//add close to frame a
		a.resize(600, 400);	//resize frame a
		a.setVisible(true);	//make frame a visible
	}	//end method howtoplay
	
	// ========================================================================
	// 	randomCode method
	// ========================================================================
	//	creates a random 5 digit code
	// 	========================================================================
	// 	@param - void
	//	@return - void
	// ========================================================================
	public void randomCode () {	//start method randomCode
		String rnum1, rnum2, rnum3, rnum4, rnum5;	//declare rnum1-5
		rnum1 = String.valueOf((int) Math.round(Math.random()*9));	//initialize rnum1 to a random number from 0-9
		do  {	//start do...while loop
			rnum2 = String.valueOf((int) Math.round(Math.random()*9));	//initialize rnum2 to a random number from 0-9
		} while (rnum2.equals(rnum1));	//end do while loop if rnum2 does not equal rnum1
		do  {	//start do...while loop
			rnum3 = String.valueOf((int) Math.round(Math.random()*9));	//initialize rnum3 to a random number from 0-9
		} while (rnum3.equals( rnum2) || rnum3.equals( rnum1));	//end do while loop if rnum3 does not equal rnum2 or rnum1
		do  {	//start do...while loop
			rnum4 = String.valueOf((int) Math.round(Math.random()*9));	//initialize rnum4 to a random number from 0-9
		} while (rnum4 .equals (rnum2) || rnum4 .equals (rnum1) || rnum4.equals( rnum3));	//end do while loop if rnum4 does not equal rnum3 or rnum2 or rnum1
		do  {	//start do...while loop
			rnum5 = String.valueOf((int) Math.round(Math.random()*9));	//initialize rnum5 to a random number from 0-9
		} while (rnum5 .equals (rnum2) || rnum5 .equals (rnum1) || rnum5 .equals (rnum3) || rnum5 .equals (rnum4));	//end do while loop if rnum5 does not equal rnnum4 or rnum3 or rnum2 or rnum1
		rcode = rnum1 + rnum2 + rnum3 + rnum4 + rnum5;	//initialize rcode
	}	//end method randomCode
	
	// ========================================================================
	// 	checkCode method
	// ========================================================================
	//	checks the 5 digit guess and checks if it is a valid guess
	// 	========================================================================
	//	Calls method correctNumbers which checks for correct position/number
	//========================================================================
	// 	@param - Button play
	//	@return - void
	// ========================================================================
	public void checkCode(Button play) {	//start method checkCode
		menu swag = new menu();	//declare and instantiate object swag
		correctposition = 0;	//declare and initialize correctposition
		correctnumber = 0;	//declare and initialize correctnumber
		trycount++;	//add 1 to trycount
		boolean validguess = true;	//declare and initialize validguess
		if (userguess.length()==5){	//enter if userguess is 5 characters long
			for (int a = 0; a < 5; a++) {	//start counted loop
				for (int b = 0; b < 5; b++){	//start nested counted loop
					if (userguess.charAt(a)==(userguess.charAt(b)) && a!=b){	//enter if there are 2 numbers that are equal
						validguess = false;	//validguess becomes false
					}	//end if statement
				}	//end nested counted loop
			}	//end counted loop
		}	//end if statement
		else	//start else
			validguess = false;	//valid guess becomes false
		if (validguess==true && trycount <= 8) {	//enter is validguess is true and trycount is less than 8
			for (int x = 0; x< 5; x++) {	//start counted loop
				if (userguess.charAt(x)== rcode.charAt(x))	//enter if the [x] digit of userguess is equal to the [x] digit of rcode
					correctposition++;	//add one to correct position
				for (int y = 0; y < 5; y++) {	//start counted loop
					if (userguess.charAt(x) == rcode.charAt(y))	//enter if there are common numbers between userguess and rcode
						correctnumber++;	//add one to correctnumber
				}	//end counted loop
			}	//end counted loop
			swag.correctNumbers();	//call method correctNumbers
		}	//end if statement
		else {	//enter else if above conditions are not met
			System.out.println ("That is not a valid guess");
			trycount--;	//invalid guesses are do not count as guesses; subtract 1 from trycount
		}	//end else
	}	//end method checkCode
	
	// ========================================================================
	// 	correctNumbers method
	// ========================================================================
	//	displays the correct number/position in the respective textfield relative to the attempt number
	// 	========================================================================
	// 	@param - void
	//	@return - void
	// ========================================================================
	public void correctNumbers() {	//start method correctNumbers
		totaltries++;
		if (trycount == 1) {	//enter if trycount has a value of 1
			pguess1.setText(userguess);	//set pguess1 to the value stored in userguess
			if (correctposition == 5) {	//enter if correctposition has a value of 5
				guess1.setText ("You won gg");	//set the text of guess1
				guess1.setBackground(Color.green);	//sets the colour of the Textfield to be green
				pguess1.setBackground(Color.green);	//sets the colour of the Textfield to be green
			}	//end if statement
			else 
				guess1.setText(correctposition + " placed correct || " + correctnumber + " numbers correct");	//sets guess1 to the number of correct numbers/positions
		}	//end if statement
		else if (trycount ==2){	//enter if trycount has a value of 2
			pguess2.setText(userguess);	//set pguess2 to the value stored in userguess
			if (correctposition == 5) {	//enter if correctposition has a value of 5
				guess2.setText ("You won gg");	//set the text of guess2
				guess2.setBackground(Color.green);	//sets the colour of the Textfield to be green
				pguess2.setBackground(Color.green);	//sets the colour of the Textfield to be green
			}	//end if statement
			else
				guess2.setText(correctposition + " placed correct || " + correctnumber + " numbers correct");	//sets guess2 to the number of correct numbers/positions
		}	//end if statement
		else if (trycount ==3){	//enter if trycount has a value of 3
			pguess3.setText(userguess);	//set pguess3 to the value stored in userguess
			if (correctposition == 5) {	//enter if correctposition has a value of 5
				guess3.setText ("You won gg");	//set the text of guess3
				guess3.setBackground(Color.green);	//sets the colour of the Textfield to be green
				pguess3.setBackground(Color.green);	//sets the colour of the Textfield to be green
			}	//end if statement
			else 
				guess3.setText(correctposition + " placed correct || " + correctnumber + " numbers correct");	//sets guess3 to the number of correct numbers/positions
		}	//end if statement
		else if (trycount ==4){	//enter if trycount has a value of 4
			pguess4.setText(userguess);	//set pguess4 to the value stored in userguess
			if (correctposition == 5) {	//enter if correctposition has a value of 5
				guess4.setText ("You won gg");	//set the text of guess4
				guess4.setBackground(Color.green);	//sets the colour of the Textfield to be green
				pguess4.setBackground(Color.green);	//sets the colour of the Textfield to be green
			}	//end if statement
			else {
				guess4.setText(correctposition + " placed correct || " + correctnumber + " numbers correct");	//sets guess4 to the number of correct numbers/positions
			}
		}	//end if statement
		else if (trycount ==5){	//enter if trycount has a value of 5
			pguess5.setText(userguess);	//set pguess5 to the value stored in userguess
			if (correctposition == 5){	//enter if correctposition has a value of 5
				guess5.setText ("You won gg");	//set the text of guess5
				guess5.setBackground(Color.green);	//sets the colour of the Textfield to be green
				pguess5.setBackground(Color.green);	//sets the colour of the Textfield to be green
			}	//end if statement
			else
				guess5.setText(correctposition + " placed correct || " + correctnumber + " numbers correct");	//sets guess5 to the number of correct numbers/positions
		}	//end if statement
		else if (trycount ==6){	//enter if trycount has a value of 6
			pguess6.setText(userguess);	//set pguess6 to the value stored in userguess
			if (correctposition == 5) {	//enter if correctposition has a value of 5
				guess6.setText ("You won gg");		//set the text of guess6
				guess6.setBackground(Color.green);		//sets the colour of the Textfield to be green
				pguess6.setBackground(Color.green);	//sets the colour of the Textfield to be green
			}	//end if statement
			else 
				guess6.setText(correctposition + " placed correct || " + correctnumber + " numbers correct");	//sets guess6 to the number of correct numbers/positions
		}	//end if statement
		else if (trycount ==7){	//enter if trycount has a value of 7
			pguess7.setText(userguess);	//set pguess7 to the value stored in userguess
			if (correctposition == 5) {	//enter if correctposition has a value of 5
				guess7.setText ("You won gg");	//set the text of guess7
				guess7.setBackground(Color.green);	//sets the colour of the Textfield to be green
				pguess7.setBackground(Color.green);	//sets the colour of the Textfield to be green
			}	//end if statement
			else 
				guess7.setText(correctposition + " placed correct || " + correctnumber + " numbers correct");	//sets guess7 to the number of correct numbers/positions
		}	//end if statement
		else if (trycount ==8){	//enter if trycount has a value of 8
			pguess8.setText(userguess);	//set pguess8 to the value stored in userguess
			if (correctposition == 5) {	//enter if correctposition has a value of 5
				guess8.setText ("You won gg"); 	//set the text of guess8
				guess8.setForeground(Color.green);	//sets the colour of the Textfield to be green
				pguess8.setBackground(Color.green);	//sets the colour of the Textfield to be green
			}	//end if statement
			else {
				guess8.setText(correctposition + " placed correct || " + correctnumber + " numbers correct");	//sets guess8 to the number of correct numbers/positions
				guess8.setBackground(Color.red);
				pguess8.setBackground(Color.red);
				play.setLabel("Play game");
				averageattempt = (double)totaltries/ (double)gamenum;
				taverageattempt.setText("Average attempts: " + averageattempt);
				if (gamenum == 1)
					bestattempt = trycount;
				tbestattempt.setText("Best attempt: " + bestattempt);
			}
		}	//end if statement
		if (correctposition!=5)	//enter if correctposition does not have a valueof 5
			points = String.valueOf(Integer.parseInt(points)-20);	//subtract 20 from points
		else {
			play.setLabel("Play game");	//change the label on button play
			totalpoints = totalpoints + Integer.parseInt(points);	//add points to totalpoints
			ttotalpoints.setText("Total points: " + String.valueOf(totalpoints));	//set ttotalpoints to totalpoints
			averageattempt = (double)totaltries/(double)gamenum;
			taverageattempt.setText("Average attempts: " + averageattempt);
			if (gamenum == 1)
				bestattempt = trycount;
			else if (bestattempt > trycount)
				bestattempt = trycount;
			tbestattempt.setText("Best attempt: " + bestattempt);
		}
		pointlabel.setText("Points: " + points);	//set pointlabel to points
	}	//end method correctNumbers
	
	// ========================================================================
	// 	rankings method
	// ========================================================================
	//	sorts the top 10 rankings using a bubble sort
	// 	========================================================================
	// 	@param - void
	//	@return - void
	// ========================================================================
	public void rankings() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(rankings)));	//declare and instantiate object br from class BufferedReader
		int arraypoints[] = new int[10];
		int averagepoints = totalpoints/gamenum;
		String lastWord;
		try {	//start try
			int counter = 0;
		    String line;	//declare line
		    line = br.readLine();	//initialize line
		    while (line  != null) {	//start while loop
		    	ranking[counter] = line;
		    	counter++;
		    	if (counter==10)
		    		break;
		        line = br.readLine();	//read next line in the file
		    }	//end while loop
		} 	//end try
		finally {	
		    br.close();	//stop reading
		}
	    for (int x = 0;x<10;x++) {
	    	lastWord = ranking[x].substring(ranking[x].lastIndexOf(" ")+1);	//takes the last word from the string at ranking[x]
	    	arraypoints[x] = Integer.parseInt(lastWord);	
	    }
		if (arraypoints[9] < averagepoints) {	//enter if averagepoints is greater than the 10th place
			arraypoints[9] = averagepoints;
			ranking[9] = name + " " + averagepoints;
		}
		int temp;	//declare temp
		String temp2;	//declare temp2
		//start of bubble sort
		for (byte x = 0; x < 10; x ++){	//start counted loop
		    for (byte y = 0; y < 9; y++){	//start counted loop
			    if (arraypoints[y] < arraypoints[y+1]){	//enter if arraypoints[y] is greater than the next index
				temp = arraypoints[y];	//set temp to arraypoints[y]
				temp2 = ranking[y];	//set temp2 to ranking[y]
				arraypoints[y] = arraypoints[y+1];	//copy the next index into the current one
				ranking[y] = ranking[y+1];	//copy the next index into the current one
				arraypoints[y+1] = temp;	//set the next index to temp
				ranking[y+1] = temp2;	//set the next index to temp2
			    }	//end if statement
		    }	//end counted loop
		}	//end counted loop
		try {
			File file = new File("C:\\Users\\Matthew Chan\\Desktop\\eclipse\\rankings.txt");
			FileWriter fw = new FileWriter(file.getAbsoluteFile());	//gets file output
			BufferedWriter bw = new BufferedWriter(fw);
			for (int y = 0;y<10;y++) {
				bw.write(ranking[y]);		//writes to file
				bw.newLine();	//writes to file
			}
			bw.close();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	// ========================================================================
	// 	stats method
	// ========================================================================
	//	opens up a new frame and displayed the top 10 rankings based on average points per round
	// 	========================================================================
	// 	@param - frame a
	//	@return - void
	// ========================================================================
	public void stats (Frame a) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(rankings)));	//declare and instantiate object br from class BufferedReader
		try {	//start try
			int counter = 0;
		    String line;	//declare line
		    line = br.readLine();	//initialize line
		    while (line  != null) {	//start while loop
		    	ranking[counter] = line;
		    	counter++;
		    	if (counter==10)
		    		break;
		        line = br.readLine();	//read next line in the file
		    }	//end while loop
		} 	//end try
		finally {
			br.close();
		}
		Font myFont = new Font("Helvetica", Font.BOLD, 39);	//declare and instantiate font myFont 
		Label display = new Label("RANKINGS (by average points)");	//declare and instantiate label display
		Button close = new Button("Done");	//declare and instantiate button close
		Label first = new Label (ranking[0]);
		Label second = new Label (ranking[1]);
		Label third = new Label (ranking[2]);
		Label fourth = new Label (ranking[3]);
		Label seventh = new Label (ranking[6]);
		Label fifth = new Label (ranking[4]);
		Label sixth = new Label (ranking[5]);
		Label eighth = new Label (ranking[7]);
		Label ninth = new Label (ranking[8]);
		Label tenth = new Label (ranking[9]);
		a.removeAll();	//remove objects on frame a
		a.setLayout(new GridLayout(12,1));	//set gridlayout for frame a
		a.add(display);	//add display to frame a
		a.add(first);
		a.add(second);
		a.add(third);
		a.add(fourth);
		a.add(fifth);
		a.add(sixth);
		a.add(seventh);
		a.add(eighth);
		a.add(ninth);
		a.add(tenth);
		display.setFont(myFont);	//set the font of display to myFont
		
		a.add(close);	//add close to frame a
		a.resize(600, 400);	//resize frame a
		a.setVisible(true);	//make frame a visible
		pack();
	}
}	//end program
