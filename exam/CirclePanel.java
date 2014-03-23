package exam;


//******************************************************************
//CirclePanel.java
//
//A panel with a circle drawn in the center and buttons on the 
//bottom that move the circle.
//Joshua Pritchett in CS410-01
//******************************************************************
import java.awt.*;

import javax.swing.*;

import java.awt.event.*;


public class CirclePanel extends JPanel
{
private final int CIRCLE_SIZE = 50;
private int x,y;
private Color c;
private JButton red;
private JButton green;
private JButton blue;
private JButton grey;
private JButton other;
private JButton left;
private JButton right;
private JButton up;
private JButton down;
private JPanel ham;

//---------------------------------------------------------------
//Set up circle and buttons to move it.
//---------------------------------------------------------------
public CirclePanel(int width, int height)
{
//Set coordinates so circle starts in middle
x = (width/2)-(CIRCLE_SIZE/2);
y = (height/2)-(CIRCLE_SIZE/2); 

c = Color.green;
ColorListener listen = new ColorListener();

//Need a border layout to get the buttons on the bottom
this.setLayout(new BorderLayout());



//Create buttons to move the circle
this.left = new JButton("Left");
this.right = new JButton("Right");
this.up = new JButton("Up");
this.down = new JButton("Down");

//Create buttons to change color of the circle
this.red = new JButton("Red");
this.green = new JButton("Green");
this.blue = new JButton("Blue");
this.grey = new JButton("Grey");
this.other =new JButton("Other");

//Add listeners to the color buttons
red.addActionListener(listen);
green.addActionListener(listen);
blue.addActionListener(listen);
grey.addActionListener(listen);
other.addActionListener(listen);


//Set color for button text
red.setForeground(Color.RED);
green.setForeground(Color.GREEN);
blue.setForeground(Color.BLUE);
grey.setForeground(Color.GRAY);

//Add listeners to the buttons
left.addActionListener(new MoveListener(-50,0));
right.addActionListener(new MoveListener(50,0));
up.addActionListener(new MoveListener(0,-50));
down.addActionListener(new MoveListener(0,50));

//Add Mnumonicts to move buttons
left.setMnemonic(KeyEvent.VK_L);
right.setMnemonic(KeyEvent.VK_R);
up.setMnemonic(KeyEvent.VK_U);
down.setMnemonic(KeyEvent.VK_D);

//Add Tooltips to buttons
left.setToolTipText("Move circle left by 5 pixels");
right.setToolTipText("Move circle right by 5 pixels");
up.setToolTipText("Move circle up by 5 pixels");
down.setToolTipText("Move circle down by 5 pixels");
red.setToolTipText("Make circle red");
green.setToolTipText("Make circle green");
blue.setToolTipText("Make circle blue");
grey.setToolTipText("Make circle grey");
other.setToolTipText("Pick your own color");

//Need a panel to put the buttons on or they'll be on
//top of each other.
JPanel buttonPanel = new JPanel();
buttonPanel.add(left);
buttonPanel.add(right);
buttonPanel.add(up);
buttonPanel.add(down);

//Need another panel to put the buttons on or they'll be on
//top of each other. Still.
JPanel ColorButton = new JPanel();
ColorButton.add(red);
ColorButton.add(green);
ColorButton.add(other);
ColorButton.add(blue);
ColorButton.add(grey);



//Add the button panels to the bottom of the main panel
this.setSize(1500, 1500);
this.add(buttonPanel, "South");
this.add(ColorButton, "North");


}

//---------------------------------------------------------------
//Draw circle on CirclePanel
//---------------------------------------------------------------
public void paintComponent(Graphics page)
{
super.paintComponent(page);

page.setColor(c);
page.fillOval(x,y,CIRCLE_SIZE,CIRCLE_SIZE);
}

//---------------------------------------------------------------
//Class to listen for button clicks that change color of the circle.
//---------------------------------------------------------------
private class ColorListener implements ActionListener
{

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		if(e.getSource() == red)
		{
			c = Color.RED;
		}
		
		if(e.getSource() == green)
		{
			c = Color.GREEN;
		}
		
		if(e.getSource() == grey)
		{
			c = Color.GRAY;
		}
		
		if(e.getSource() == blue)
		{
			c = Color.BLUE;
		}
		
		if(e.getSource() == other)
		{
			c = JColorChooser.showDialog( ham ,"What color", Color.BLACK);
		}
		
		repaint();
	}
	
	
}

//---------------------------------------------------------------
//Class to listen for button clicks that move circle.
//---------------------------------------------------------------
private class MoveListener implements ActionListener
{
private int dx;
private int dy;


//---------------------------------------------------------------
//Parameters tell how to move circle at click.
//---------------------------------------------------------------
public MoveListener(int dx, int dy)
{
 this.dx = dx;
 this.dy = dy;
}

//---------------------------------------------------------------
//Change x and y coordinates and repaint.
//---------------------------------------------------------------
public void actionPerformed(ActionEvent e)
{
	  right.setEnabled(true);
	  left.setEnabled(true);
	  down.setEnabled(true);
	  up.setEnabled(true);
	
 x += dx;
 y += dy;
 
 //Check bounds of circle
 if(x > getSize().getWidth() - CIRCLE_SIZE)
 {
	   right.setEnabled(false);
 }
if(x < 15)
{
	  left.setEnabled(false);
}
if(y > getSize().getHeight() - CIRCLE_SIZE - 100){
	  down.setEnabled(false);
}
if(y < 60)
{
	  up.setEnabled(false);
}
 
 repaint();
}


}
}