import java.awt.*;
import corejava.*;

public class Calculator extends Frame
{  public Calculator()
   {  setTitle("Calculator");
   
      display = new TextField("0");
      display.setEditable(false);
      add("North", display);
      
      Panel p = new Panel();
      p.setLayout(new GridLayout(4, 4));
      for (int i = 0; i <= 9; i++) 
      p.add(new Button("" + (char)('0' + i)));      
      p.add(new Button("+"));
      p.add(new Button("-"));
      p.add(new Button("*"));
      p.add(new Button("/"));
      p.add(new Button("%"));
      p.add(new Button("="));
      add("Center", p);
   }
   
   public boolean handleEvent(Event evt)
   {  if (evt.id == Event.WINDOW_DESTROY) System.exit(0);
      return super.handleEvent(evt);
   }
   
   public boolean action(Event evt, Object arg)
   {  if (arg instanceof String)
      {  String s = (String) arg;
         if ('0' <= s.charAt(0) && s.charAt(0) <= '9')
         {  if (start) display.setText(s);
            else display.setText(display.getText() + s);
            start = false;
         }
         else
         {  if (start)
            {  if (s.equals("-")) 
               { display.setText(s); start = false; }
               else op = s;
            }
            else
            {  calculate(Integer.parseInt(display.getText()));
               op = s;
               start = true;
            }
         }
      }
      else return super.action(evt, arg);
      return true;
   }
   
   public void calculate(int n)
   {  if (op == "+") arg += n;
      else if (op == "-") arg -= n;
      else if (op == "*") arg *= n;
      else if (op == "/") arg /= n;
      else if (op == "%") arg %= n;
      else if (op == "=") arg = n;
      display.setText("" + arg);
   }
   
   public static void main(String[] args)
   {  Frame f = new Calculator();
      f.resize(300, 200);
      f.show();  
   }

   private TextField display;
   private int arg = 0;
   private String op = "=";
   private boolean start = true;
}
