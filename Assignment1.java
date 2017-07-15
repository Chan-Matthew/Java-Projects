// ========================================================================
// 	Java Assignment 1
// 	Matthew Chan
// 	October 24, 2014
// 	Java 4.0
// ========================================================================
//	Using a menu, allows the user to choose between different programs
//  - Binary converter (binary to decimal/ decimal to binary)
//  - Pi table (allows user to choose the accuracy and number of decimal places of pi)
//  - Factorial table 
// Gives users the option to repeat the program they are running
//	========================================================================
//	Calls method firstChoice to display and receive choice for the main menu
//	Calls method binaryMeny to display the menu for the binary programs
// 	Calls method piProgram to ask and display a number of terms of pi to a specific number of decimal places 
//		both entered by the user
// Calls method factorialProgram to ask and display the factorial of a number entered by the user
// ========================================================================
// 	List of Indentifiers 	- let choice represent the integer used in the switch/case
//                                         	- let exit represent the variable which the program checks if true before breaking
// ========================================================================

import java.io.*;		//allow access to the coding within the io library 
public class Assignment1 {	//Start of class Assignment1

	public static void main(String[] args) throws IOException{ 	//Start of main method
		int choice;		//declare variable 'choice'
		boolean exit = false;		//declare and initialize variable 'exit'
		Assignment1 num = new Assignment1(); 	//declare and instantiate object 'num'
		do {		//start do...while loop
			choice = num.firstChoice();		//initialize variable 'choice' and call method 'firstChoice'
			switch (choice){ 		//start switch/case using variable 'choice'
				case 1: 		//enter if user inputs '1'
					num.binaryMenu(); 		//call method 'binaryMenu
					break;		//go to bottom of case/switch
				case 2:		//enter if user inputs '2'
					do {		//start do..while loop
						num.piProgram();		//call method 'piProgram'
					} while (num.repeat()==true);		//end do...while if method 'piProgram' returns false
					break;		// go to bottom of case/switch
				case 3: 		//enter if user enters '3'
					do {		//start do...while loop
						num.factorialProgram();		//call method 'factorialProgram'
					} while(num.repeat()==true);		//end do...while if method 'factorialProgram' returns false
					break;		//go to bottom of case/switch
				case 4:		//enter if user enters '4'
					exit = true;		//give boolean 'exit' the value true
					break;		//go to bottom of case/switch
				default:		//enter if user does not enter '1', '2', '3', or '4'
					System.err.println("That's not an option!");		//tell user they made an error
					System.out.println("-----------------------------------------------------------------------------------");
			}		//end case/switch
		} while (exit != true);		//exit do...while loop if boolean 'exit' has the value true (user entered 4 in the menu)
		System.out.println("Bye!");
	}		//end main method
	
	// ========================================================================
	// 	firstChoice method
	// ========================================================================
	//	Displays a menu showing different option for the user
	//	Gets user input for which choice they want
	// ========================================================================
	//	Calls method getNum to get an integer value entered by the user
	// 	========================================================================
	// 	@param - none
	//	@return - user input (integer)
	// ========================================================================
	public int firstChoice() throws IOException{		//start method 'firstChoice'
		Assignment1 num = new Assignment1();		//declare and instantiate object 'num'
		System.out.println("");
		System.out.println("Welcome to the program! What would you like to do?");		//
		System.out.println ("1. Binary conversion");																		//
		System.out.println("2. Pi calculator");																					//Display menu for the user
		System.out.println ("3. Factorial calculator");																	//
		System.out.println ("4. Exit");																									//
		return num.getNum("your choice");		//UFP, calls method 'getNum' and returns user input1
	}		//end method 'firstChoice'
	
	// ========================================================================
	// 	getInput method
	// ========================================================================
	//	Allows input to be received from the user
	// ========================================================================
	// 	@param - none
	//	@return - br.readLine (allows user to input anything)
	// ========================================================================
	public String getInput() throws IOException{		//start method 'getInput'
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		//declares and instantiates object br from class BufferedReader which allows user input
		return br.readLine();		//return method readLine which gets user input
	}		//end method getInput
	
	// ========================================================================
	// 	getNum method
	// ========================================================================
	//	Gets an integer value from the user
	//	Checks for any characters, decimals and displays an error
	// ========================================================================	
	//	Calls the getInput method which allows for user input
	//	========================================================================
	// 	@param - String 'number' (variable used to to tell user what specifically to enter based on program
	//	@return - the value entered by the user (numbers only, no characters)
	// ========================================================================
	// List of identifiers: let 'input' represent the integer value inputed by the user
	//										let 'inputstring' represent the string inputed by the user
	//	========================================================================
	public int getNum(String number) throws IOException{		//start method 'getNum'
		Assignment1 num = new Assignment1();		//declare and instantiate object 'num'
		String inputstring;		//declare String variable 'inputstring'
		int input;		//declare integer variable 'input'
		System.out.println("Please enter " + number);		//UFP
		while(true) {		//start while loop
		    try {	//start try
			inputstring = num.getInput();		//calls method 'getInput', which gets user input, and initializes variable 'inputstring' to the value entered by user
			input = (Integer.valueOf (inputstring)).intValue( ); 		//tries to turn user input into an integer
			break;		//exit try
		    }		//end try
		    catch (NumberFormatException e) {		//start catch with parameters 'Number Format Exception e'
				System.err.println("That is not a valid number, try again");		//tells user they have an error
				System.out.println("-----------------------------------------------------------------------------------");
			}		//end catch	
		}		//end while loop
			return input;			//return integer variable input
	}		//end method 'getNum'
	
	// ========================================================================
	// 	repeat method
	// ========================================================================
	//	Displays a menu and asks user if they want to repeat the program they are currently in
	// ========================================================================
	//	Calls the getNum method to get an integer value entered by the user
	//	========================================================================
	// 	@param - none
	//	@return - boolean value of true or false (yes or no to repeat the program)
	// ========================================================================
	public boolean repeat() throws IOException {		//start method 'repeat'
		Assignment1 num = new Assignment1();		//declare and instantiate object 'num'
		int choice;	//declare integer variable 'choice'
		System.out.println ("");
		System.out.println("Would you like to repeat the program?");		//
		System.out.println("1. Yes");																			//display repeat menu
		System.out.println("2. No, go back to menu");										//
		do {		//start do..while loop
			choice = num.getNum("your choice");		//UFP, calls method 'getNum' and returns user input, initialize variable 'choice' with user input
			switch (choice) {		//start case/switch using variable choice
			case 1:		//enter if user enters '1'
				return true;	//return value true
			case 2:		//enter if user enters '2'
				return false;		//return value false
			default:		//enter if user does not enter '1' or '2'
				System.err.println("That is not an option");		//tell user that there is an error
				System.out.println ("-----------------------------------------------------------------------------------");
			}		//end case/switch
		} while (true);		//end while loop
	}		//end method 'repeat'
	
	// ========================================================================
	// 	binaryMenu method
	// ========================================================================
	//	The menu program for when a user chooses to use the binary program from the main menu
	//	Allows users to choose between a binary to decimal program, or a decimal to binary program,
	//	or to exit back to the main menu
	//	Gives users the option to repeat the program they are running
	// ========================================================================
	// Calls method binaryOption to display the menu for the binary programs and
	//		gets the choice entered by the user
	//	Calls method binaryProgram, which runs the program to convert a binary sequence to a 
	//		decimal number
	//	Calls method decimalProgram, which runs the program to convert a decimal number to
	//		a binary sequence
	//	========================================================================
	// 	@param - none
	//	@return - none
	// ========================================================================
	// List of identifiers: let 'choice' represent the integer used in the case/switch
	//										let 'exit' represent the variable which the program checks before breaking
	//	========================================================================
	public void binaryMenu () throws IOException{		//start method 'binaryMenu' 
		Assignment1 num = new Assignment1();		//declare and instantiate object 'num'
		int choice;		//declare integer variable 'choice'
		boolean exit = false;		//declare and give boolean variable 'exit' initial value of false
		do {		//start do...while loop
			choice = num.binaryOption();		//initialize variable 'choice', call method 'binaryOption'
			switch (choice) {		//start switch/case
			case 1:		//enter if user enters '1'
				do {		//start do...while loop
					num.binaryProgram();		//call method 'binaryProgram'
				} while (num.repeat()==true);		//end do...while loop if method 'repeat' returns false
				break;		//exit case/switch
			case 2:		//enter if user enters '2'
				do {		//start do...while loop
					num.decimalProgram();		//call method 'decimalProgram'
				} while (num.repeat()==true);		//end do...while loop if method 'repeat' returns false
				break;		//exit case/switch
			case 3:		//enter if user enters '3'
				exit = true;		//give variable 'exit' the value true
				break;		//exit case switch
			default:		//enter if user does not enter '1', '2', or '3'
				System.err.println("That is not an option");		//tell user that there is an error
			}		//end case/switch
		} while (exit != true);		//end do...while loop if variable 'exit' has a value of true
	}		//end method 'binaryMenu'
	
	// ========================================================================
	// 	binaryOption method
	// ========================================================================
	//	The menu program for when a user chooses to use the binary program from the main menu
	//	Allows users to choose between a binary to decimal program, or a decimal to binary program,
	//	or to exit back to the main menu
	//	Gives users the option to repeat the program they are running
	// ========================================================================
	//	Calls method getNum to get an integer value entered by the user
	//	========================================================================
	// 	@param - none
	//	@return - the user's choice (integer)
	// ========================================================================
	public int binaryOption () throws IOException{		//start method 'binaryOption'
		Assignment1 num = new Assignment1();		//declare and instantiate object 'num'
		System.out.println ("");
		System.out.println ("Welcome to the binary program! What would you like to do?");		//
		System.out.println ("1. Binary to decimal conversion");																//Display menu
		System.out.println ("2. Decimal to binary conversion");																//
		System.out.println ("3. Exit");																													//
		return num.getNum("your choice"); //calls method 'getNum' and returns user input
	}		//end method 'binaryOption'
	
	// ========================================================================
	// 	binaryProgram method
	// ========================================================================
	//	The program gets the binary sequence from the user, checks to see if it is a valid binary 
	//	sequence, and if there are negatives
	// ========================================================================
	//	Calls method getNum to get an integer value entered by the user
	//	Calls method numCheck to check whether the binary sequence is negative
	//	Calls method validBinaryCheck to check whether the binary sequence is valid
	//	Calls method convertBinary to convert the binary sequence to a decimal number
	//	Calls method outputBinary to display the converted binary sequence
	//	========================================================================
	// 	@param - none
	//	@return - none
	// ========================================================================
	// List of identifiers: let 'binarynum' represent the binary sequence entered by the user
	//										let 'convertint' represent the converted binary sequence into decimal
	//	========================================================================
	public  void binaryProgram()throws IOException {		//start method 'binaryProgram'
		Assignment1 num = new Assignment1();		//declare and instantiate object 'num'
		int binarynum, convertint;		//declare integer variables 'binarynum' and 'convertint'
		System.out.println("This program will turn a binary number to an integer");		//tell user what the program does
		do {		//start do...while loop
			do {		//start do...while loop
				binarynum = num.getNum("a binary number");		//UFP, initialize variable 'binarynum' and call method 'getNum'
			} while (num.numCheck(binarynum) == false);		//exit do...while loop, call method 'numCheck' and repeat loop if method returns false
		}	while (num.validBinarycheck(binarynum) == false);		//exit do...while loop, call method 'validBinaryCheck' and repeat loop if method returns false
		convertint = num.convertBinary(binarynum);		//initialize variable 'convertint' and call method 'convertBinary'
		num.outputBinary(binarynum, convertint);		//call method 'outputBinary'
		}		//end method 'binaryProgram'
	
	// ========================================================================
	// 	convertBinary method
	// ========================================================================
	//	The program used to convert a binary sequence into a decimal number
	//	It takes and checks each digit within a sequence, whether it is a 0 or a 1 and based
	//	on their digit placements, uses it as an exponent for a base 2 and adds it all together
	//	to find the decimal equivalent of a binary sequence	
	// ========================================================================
	// 	@param - the binary sequence entered by the user
	//	@return - the converted binary sequence 
	// ========================================================================
	// List of identifiers: let 'x' represent the binary sequence converted to a string
	//										let 'length' represent the length of the binary sequence
	//										let converted represent the value of the binary sequence converted to decimal
	//	========================================================================
	public int convertBinary(int binarynum) {		//start method 'convertBinary'
		String x = Integer.toString(binarynum);		//declare and initialize variable 'x' with value 'binarynum' converted to a string value
		int length = x.length();		//declare and initialize variable 'length' with the number of characters in the string 'x'
		int converted = 0;		//declare and initialize variable 'converted' with value 0
		for (int y=0; y<length;y++){		/* Sets value of y to 0, terminate the program when y is one less than the length of string y
		 																	 the value of y increases by one each loop*/
			if (x.charAt(length-1-y) == '1') {		//enter if statement if a character in the string x has a value of '1'
				converted += Math.pow(2,y);		//add 2^y to the variable 'converted'
			}		//end if statement
		}		//end counted loop
		return converted;		//return integer variable converted number which contains the value of the binary sequence converted to decimal
	}		//end method 'convertBinary'
	
	// ========================================================================
	// 	outputBinary method
	// ========================================================================
	//	Displays the original binary sequence and its decimal equivalent
	// ========================================================================
	// 	@param - the binary sequence entered by the user
	//						- the converted decimal number
	//	@return - none
	// ========================================================================
	public void outputBinary(int binarynum, int convertint){		//start method 'outputBinary'
		System.out.println ("The binary sequence " + binarynum + " converted to decimal is " + convertint); 		//output a message, original binary sequence, and its decimal conversion
	}		//end method 'outputBinary'
	
	// ========================================================================
	// 	validBinaryCheck method
	// ========================================================================
	//	Checks if a binary sequence is valid (only 1's and 0's)
	//	Checks each digit in the sequence and rejects it if any of the numbers are not 1 or 0
	// ========================================================================
	// 	@param - the binary sequence entered by the user
	//	@return - boolean value true or false (if the binary sequence is valid or not)
	// ========================================================================
	// List of identifiers: let 'x' represent the binary sequence converted to a string
	//										let 'length' represent the length of the binary sequence
	//	========================================================================
	public boolean validBinarycheck(int binarynum){		//start method 'validBinaryCheck'
		  String x = Integer.toString(binarynum);		//declare and initialize variable 'x' with value 'binarynum' converted to a string value
		  int length = x.length();		////declare and initialize variable 'length' with the number of characters in the string 'x'
		  for (int y=0; y<length;y++){		/* Sets value of y to 0, terminate the program when y is one less than the length of string y
				 															the value of y increases by one each loop*/
			  if (x.charAt(length-1-y) != '1' && x.charAt(length-1-y) != '0'){		//enter if statement if a character in the string x does not have a value of '1' or '0'
				  System.err.println ("That is an invalid binary sequence");		//tell the user that there is an error
					System.out.println("-----------------------------------------------------------------------------------");
				  return false;		//return a false value
			  }		//end if statement
		  }		//end counted loop
		  return true; 		//return a true value
	}		//end method 'validBinaryCheck'
	
	// ========================================================================
	// 	decimalProgram method
	// ========================================================================
	//	Gets the user input (decimal number) and then converts it into a binary sequence
	// ========================================================================
	// Calls method getNum to get an integer value entered by the user
	//	Calls method decimalConvert to convert the decimal number to a binary sequence
	//	========================================================================
	// 	@param - none
	//	@return - none
	// ========================================================================
	// List of identifiers: let decnum represent the decimal number entered by the user
	//	========================================================================
	public void decimalProgram() throws IOException {		//start method 'decimalProgram'
		Assignment1 num = new Assignment1();		//declare and instantiate object 'num'
		int decnum;		//declare integer variable decum
		System.out.println ("This program will convert a decimal value to a binary sequence");		//tell user what the program does
		decnum = num.getNum("an integer");		//UFP, initialize variable 'decnum' and call method 'getNum'
		num.decimalConvert(decnum);		//call method 'decimalConvert'
	}		//end method 'decimalProgram'
	
	// ========================================================================
	// 	decimalConvert method
	// ========================================================================
	//	converts the decimal number into a binary sequence by using the long division method
	//	Divides the decimal number by 2 and the remainders are put together to create the
	//	binary sequence
	// ========================================================================
	// Calls method getNum to get an integer value entered by the user
	//	Calls method decimalConvert to convert the decimal number to a binary sequence
	//	========================================================================
	// 	@param - the decimal number entered by the user
	//	@return - none
	// ========================================================================
	// List of identifiers: let originalnum represent the decimal number entered by the user
	//										let decnum represent the number being used to convert
	//										let remainder represent the remainder after being divided by 2
	//										let binary represent the binary sequence
	//	========================================================================
	public void decimalConvert (int decnum){		//start method 'decimalConvert'
		int remainder, originalnum = decnum;		//declare integer variables 'remainder' and 'originalnum', initialize 'originalnum' to have the same value as 'decnum'
		String binary = "";		//declare and initialize string variable 'binary' to an empty space
		do {		//start do...while loop
			remainder = decnum % 2;		//initialze 'remainder' to the value of the remainder of 'decnum' when divided by 2
			decnum = decnum/2;		//divide 'decnum' by 2
			if (remainder ==1) {		//enter if statement if integer variable 'remainder' has a value of 1
				binary = 1 +binary;		//add 1 to the string 'binary' (the beginning of the string)
			}		//end if statement
			else 		//enter if 'remainder' is not equal to 1
				binary = 0 + binary;		//add 0 to the string 'binary' (the beginning of the string)
		} while (decnum!=0);		//end do...while loop if decnum is 0
		System.out.println ("Your number " + originalnum + " converted to binary is " + binary);		//output a message, orginal decimal number, and its converted binary sequence
	}		//end method 'decimalConvert'
	
	// ========================================================================
	// 	piProgram method
	// ========================================================================
	//	Gets the number of terms and decimal places for pi entered by the user
	// ========================================================================
	// Calls method getNum to get an integer value entered by the user
	//	Calls method numCheck to check for numbers 0 and below
	//	Calls piTable to display the table using the information given by the user
	//	========================================================================
	// 	@param - none
	//	@return - none
	// ========================================================================
	// List of identifiers: let decimals represent the number of decimal places desired by the user
	//										let terms represent the number of terms of pi desired by the user
	//	========================================================================
	public void piProgram() throws IOException{		//start method 'piProgram'
		Assignment1 num = new Assignment1();		//declare and instantiate object 'num'
		int decimals, terms;		//declare integer variables 'decimals' and 'terms'
		System.out.println ("This program will print out a table for the amount of terms of pi specified by the user");		//tells user what the program does
		do {		//start do...while loop
			terms = num.getNum("the amount of terms of pi desired.");		//UFP, initialize variable 'terms', call method 'getNum'
		} while (num.numCheck(terms) == false);		//exit do...while loop, call method 'numCheck' and repeat loop if method returns false
		do {		//start do...while loop
			do {		//start do...while loop
				decimals = num.getNum("number of decimal places desired");		//UFP, initialize variable 'decimals' and call method 'getNum'
			} while (num.highNum(decimals, 10) == false);		//exit do...while loop, call methiod 'highNum' and repeat loop if method returns false
		} while (num.numCheck(decimals) == false);		//exit do...while loop, call method 'numCheck' and repeat loop if method returns false
		num.piTable(terms, decimals);		//call method 'piTable'
	}		//end method 'piProgram'
	
	// ========================================================================
	// 	piTable method
	// ========================================================================
	//	Displays in tabular format the term of pi and its respective value to the decimal place 
	//	specified by the user
	// ========================================================================
	// Calls method roundNum to round the value of pi to the number of decimal places
	//		specified by the user
	//	========================================================================
	// 	@param - number of terms entered by the user
	//						- number of decimal places enter by the user
	//	@return - none
	// ========================================================================
	// List of identifiers: let pivalue represent the value of pi
	//										let denominator represent the denominator when adding or subtracting terms
	//	========================================================================
	public void piTable(int terms, int decimals){		//start method 'piTable'
		Assignment1 num = new Assignment1();		//declare and instantiate object 'num'
		double pivalue = 0;		//declare and initialize double variable 'pivalue' a value of 0
		double denominator = 1;		//declare and initialize double variable 'denominator' a valur of 0
		System.out.println("# of Terms		Value of Pi");		//Display header of table
		for (int x=1; x<=terms; x++ ){		/* Sets value of x to 1, terminate the program when x is equal to 'terms'
																		the value of x increases by one each loop*/
			if (x % 2 == 0){		//enter if x divided by 2 has a remainder of 0
				pivalue = pivalue - (4/denominator);		//subtract 4 divided by the variable 'denominator' from 'pivalue'
			}		//end if statement
			else {		//enter if x divided by 2 does not have a remainder of 0
				pivalue = pivalue + (4/denominator);		//add 4 divided by he variabe 'denominator' from 'pivalue'
			}		//end else statement
			pivalue = num.roundNum(decimals, pivalue);		//round the value of pivalue by calling method 'roundNum'
			System.out.println (x + "				" + pivalue);		//display table, term value on the left, pivalue on the right
			denominator += 2;		//add 2 to the variable 'denominator'
		}		//end counted loop
	}		//end method 'piTable'
	
	// ========================================================================
	// roundNum method
	// ========================================================================
	//	Rounds the number to the number of decimal places entered by the user
	// ========================================================================
	// 	@param - number of decimal places desired by the user
	//						- the value of pi
	//	@return - the value of pi rounded to the number of decimal places entered by the user
	// ========================================================================
	public double roundNum (double decimals, double pivalue) {		//start method 'roundNum'
		pivalue = (double) Math.round(pivalue*(Math.pow(10,decimals))) / (Math.pow(10,decimals));		
		/* rounds the value of double variable 'pivalue' by using the function Math.round
		 	it takes 'pivalue', multiplies it by 10^(number of decimal places desired) and then
		 	divides that number by 10^(number of decimal places desired) */
		return pivalue;		//return the rounded pivalue
	}		//end method 'roundNum'
	
	// ========================================================================
	//	numCheck method
	// ========================================================================
	//	Checks if the number is a negative
	//	========================================================================
	// 	@param - num = the number used to check for negatives
	//	@return - true/false (if the number is a negative or not[yes/no])
	// ========================================================================
	public boolean numCheck (int num){		//start method 'numCheck'
		if (num<=0){		//enter if 'num' is 0 or under
			System.err.println("That is not a valid number for the program <Use numbers above zero>");		//tell the user that there is an error
			System.out.println("-----------------------------------------------------------------------------------");
			return false;		//return a boolean value of false
		}		//end if statement
		return true;		//return a boolean value of true
	}		//end method 'numCheck'
	
	// ========================================================================
	// factorialProgram method
	// ========================================================================
	//	Gets the factorial of an integer entered by the user
	//	Multiplies the number by each number below it until it reaches 0
	// ========================================================================
	// Calls method getNum to get an integer value entered by the user
	//	Calls method numCheck to check for numbers 0 and below
	//	Calls factorialTable to display the table using the information given by the user
	//	========================================================================
	// 	@param - none
	//	@return - none
	// ========================================================================
	// List of identifiers: let terms represent the number the user wants factorialed
	//	========================================================================
	public void factorialProgram() throws IOException{		//start method 'factorialProgram'
		Assignment1 num = new Assignment1();		//declare and instantiate object 'num'
		int terms;		//declare integer variable 'terms'
		System.out.println ("This program will show find the factorial of your number");		//tells user what the program does
		do {		//start do...while loop
			do {		//start do...while loop
				terms = num.getNum("the integer that you would like factorialed");		//UFP, initializes integer variable 'terms' and calls method 'getNum'
			} while (num.highNum(terms, 20) == false);
		} while (num.numCheck(terms) == false);		//exit do...while loop, call method 'numCheck' and repeat loop if method returns false
		num.factorialTable(terms);		//call method 'factorialTable'
	}
	
	// ========================================================================
	// 	factorialTable method
	// ========================================================================
	//	Displays the term number and the factorialed number in a tabular format
	//	========================================================================
	// 	@param - terms = the number the user wants factorialed
	//	@return - none
	// ========================================================================
	// List of identifiers: let factorialed represent the the value of the number as it goes through the factorial process
	//										let count represent the term number
	//	========================================================================
	public void factorialTable(int terms) {		//start method 'factorialTable'
		long factorialed=terms, factorialfinal = 0;		//declare and initialize long variable 'factorialed' a value equal to variable 'terms'
		int counter=1;		//declare and initialize integer variable 'counter' a value of 1
		System.out.println("Term			Factorialed");		//display header of table
		for (int x = terms-1; x >=0; x--){			/* Sets value of x to 'terms' subtract 1, terminate the program when x is equal to 0
																				the value of x decreases by one each loop*/
			System.out.println(counter + "				" + factorialed);		//display table, 'counter' value on the left, 'factorialed' value on the right
			factorialfinal = factorialed;
			factorialed = factorialed*x;		//multiply the variable 'factorialed' by x
			counter++;		//increase the counter by 1
		}		//end counted loop
		System.out.println ("The number " + terms + " factorialed is " + factorialfinal);
	}		//end method 'factorialTable'
	
	// ========================================================================
	// 	highNum method
	// ========================================================================
	//	Checks if the number entered by the user is too high
	//	========================================================================
	// 	@param - num = the number entered by the user
	//						-	highnum = the highest number allowed
	//	@return - true or false (if the number is higher or not)
	// ========================================================================
	public boolean highNum (int num, int highnum) {		//start method 'highNum'
		if (num < highnum) {		//enter if num is lower than highnum
			return true;		//return boolean value true
		}		//end if statement
		System.err.println("That number is too high. Try again using a lower number.");		//tell user that there is an error
		return false;		//return boolean value false
	}		//end method 'highNum'
}		//end of class 'Assignment1'