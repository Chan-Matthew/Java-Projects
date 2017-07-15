import java.awt.*;

public class Menu extends Frame {
	static Frame f = new Menu();
	public TextField display = new TextField (20);
	Panel p = new Panel();
	Panel g = new Panel();
	Panel a = new Panel();
	String name = "Player";
	
	public static void main (String[] args){
		f.resize(300, 550);
		f.show(); 
	}
	
	public Menu() {
		Font myFont = new Font("Helvetica", Font.BOLD, 39);
		Label display = new Label("MASTERMIND");
		Button play = new Button ("Play game");
		Button login = new Button ("Login");
		Button howto = new Button ("How to play");
		Button stats = new Button ("Statistics");
		Button exit = new Button ("Exit");
	
		p.setLayout(new GridLayout(6, 1));
		p.add(display);
		display.setFont(myFont);
		p.add(play);
		p.add(login);
		p.add(howto);
		p.add(stats);
		p.add(exit);
		add("Center", p);
	}
	
	public boolean action(Event evt, Object arg){
		Frame a = new Menu();
		Menu swag = new Menu();
		if (arg.equals("Exit")) 
  			System.exit(0);
		else if (arg.equals("Login")) {
			p.removeAll();
			System.err.println(name);
			 swag.login(p);
		}
		else if (arg.equals("Create profile")) {
			p.removeAll();
			swag.menuScreen(p);
		}
		else if (arg.equals("Play game")) {
			p.removeAll();
			swag.play(p,name);
		}
		else if (arg.equals("How to play"))
			swag.howtoplay(a);
		else if  (arg.equals("Done")) {
			a.setVisible(false);
			dispose();
			System.out.println("You dispose");
		}
  		return true;
	} 

	public boolean handleEvent(Event evt){
   	 	if (evt.id == Event.WINDOW_DESTROY)
 			System.exit(0);
     	 	return super.handleEvent(evt);
  	 }
	
	public void menuScreen(Panel p) {
		Font myFont = new Font("Helvetica", Font.BOLD, 39);
		Label display = new Label("MASTERMIND");
		Button play = new Button ("Play game");
		Button login = new Button ("Login");
		Button howto = new Button ("How to play");
		Button stats = new Button ("Statistics");
		Button exit = new Button ("Exit");
	
		f.resize(300, 550);
		f.show(); 
		
		p.setLayout(new GridLayout(6, 1));
		p.add(display);
		display.setFont(myFont);
		p.add(play);
		p.add(login);
		p.add(howto);
		p.add(stats);
		p.add(exit);
		add("Center", a);
	}
	
	public void login (Panel p){
		Label instruction = new Label("Please enter your name");
		Button exit = new Button("Create profile");
		
		f.resize(500,100);
		f.show();
		
		p.setLayout(new GridLayout(3, 1));
		p.add(instruction);
		p.add(display);
		p.add(exit);
		add("Center",g);
	}
	
	public void play (Panel p,String name) {
		Font myFont = new Font("TimesRoman", Font.BOLD, 39);
		Label display = new Label(name + " THE MASTERMIND");
		Button play = new Button ("qwete");
		Button login = new Button ("qwetwqet");
		Button stats = new Button ("Sqwetqwe");
		f.resize(600, 700);
		f.show(); 
		
		p.setLayout(new GridLayout(4, 1));
		p.add(display);
		display.setFont(myFont);
		p.add(play);
		p.add(login);
		p.add(stats);
		add("Center", g);
		p.setVisible(true);
	}
	
	public void howtoplay (Frame a) {
		Font myFont = new Font("Helvetica", Font.BOLD, 39);
		Label display = new Label("HOW TO PLAY");
		Label instruction = new Label("There will be a 5 number passcode that you must solve. You have a maximum of 8 attempts to find out the passcode. Every time you make a wrong guess, points are subtracted from the maximum points you could achieve. Every time you make a guess, there will be a message saying how many numbers you got correct and how many numbers are in the right place. Goodluck!0");
		Button close = new Button("Done");
		a.removeAll();
		a.setLayout(new GridLayout(3, 1));
		a.add(display);
		display.setFont(myFont);
		a.add(instruction);
		a.add(close);
		a.resize(500, 400);
		a.setVisible(true);
	}
}
