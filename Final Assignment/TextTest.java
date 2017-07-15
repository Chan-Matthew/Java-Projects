import java.awt.*;

public class TextTest extends Frame
{  public TextTest()
   {  setTitle("TextTest");
      Panel p = new Panel();
      p.setLayout(new FlowLayout());
      p.add(new Button("Tick"));
      p.add(new Button("Set time"));
      hourField = new TextField("12", 3);
      p.add(hourField);
      minuteField = new TextField("00", 3);
      p.add(minuteField);
    
      add("South", p);
      clock = new ClockCanvas();
      add("Center", clock);
   }
   
   public boolean handleEvent(Event evt)
   {  if (evt.id == Event.WINDOW_DESTROY) System.exit(0);
      return super.handleEvent(evt);
   }
   
   public boolean action(Event evt, Object arg)
   {  if (arg.equals("Tick")) clock.tick();
      else if (arg.equals("Set time"))
      {  int hours = Integer.parseInt(hourField.getText().trim());
         int minutes = Integer.parseInt(minuteField.getText().trim());
         System.err.println (hours + "     " + minutes);
         clock.setTime(hours, minutes);
      }
      else return false;
      return true;
   }
   
   private TextField hourField;
   private TextField minuteField;
   private ClockCanvas clock;
   
   public static void main(String[] args)
   {  Frame f = new TextTest();
      f.resize(300, 200);
      f.show();  
   }
}

class ClockCanvas extends Canvas
{  public void paint(Graphics g)
   {  g.drawOval(0, 0, 100, 100);
      double hourAngle = 2 * Math.PI * (minutes - 3 * 60) / (12 * 60);
      double minuteAngle = 2 * Math.PI * (minutes - 15) / 60;
      g.drawLine(50, 50, 50 + (int)(30 * Math.cos(hourAngle)), 
         50 + (int)(30 * Math.sin(hourAngle)));
      g.drawLine(50, 50, 50 + (int)(45 * Math.cos(minuteAngle)), 
         50 + (int)(45 * Math.sin(minuteAngle)));
   }
   
   public void setTime(int h, int m)
   {  minutes = h * 60 + m;
      repaint();
   }
   
   public void tick()
   {  minutes++;  
      repaint();
   }
   
   private int minutes = 0;
}
