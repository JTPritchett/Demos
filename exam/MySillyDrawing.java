package exam;
	import javax.swing.JPanel;
	import java.awt.*;
	//********************************************************************
	//MySillyDrawing.java       Author: Joshua Pritchett
	//CS-410-01
	//My drawing using the paint component class
	//********************************************************************
public class MySillyDrawing extends JPanel {
	
	 private final int MAX_WIDTH = 600, NUM_RINGS = 5, RING_WIDTH = 25;
	   //-----------------------------------------------------------------
	   //  Sets up the bullseye panel. 
	   //-----------------------------------------------------------------
	   public MySillyDrawing ()
	   {
	      setBackground (Color.orange);
	      
	   }
	   //-----------------------------------------------------------------
	   //  Paints a bullseye target. That I used From the authors drawing
	   //-----------------------------------------------------------------
	   public void paintComponent (Graphics page)
	   {
	      super.paintComponent (page);

	      int x = 0, y = 0, diameter = MAX_WIDTH;

	      page.setColor (Color.white);

	      for (int count = 0; count < NUM_RINGS; count++)
	      {
	         if (page.getColor() == Color.black)  // alternate colors
	            page.setColor (Color.white);
	         else
	            page.setColor (Color.black);

	         page.fillOval (x, y, diameter, diameter);

	         diameter -= (2 * RING_WIDTH);
	         x += RING_WIDTH;
	         y += RING_WIDTH;
	      }

	      // Draw the red bullseye in the center
	      page.setColor (Color.red);
	      page.fillOval (x, y, diameter, diameter);
	   }
}
