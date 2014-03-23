package exam;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


//********************************************************************
//ButtonPanel.java       Author: Joshua Pritchett
//CS-410-01
//********************************************************************
public class ButtonPanel extends JPanel
{
	private TablePanel  table;
	private AddAllPanels panel;
	private JButton b1,b2,b3,b4;

	private SpeedControlPanel imageanimation=new SpeedControlPanel();
	private PickImage pick_panel=new PickImage();
	private CirclePanel circle_panel = new CirclePanel(300,500);
	private Primary deal_panel = new Primary();
   //-----------------------------------------------------------------
   //  Sets up this panel with some buttons to show how a vertical
   //  box layout (and invisible components) affects their position.
   //-----------------------------------------------------------------
   public ButtonPanel(AddAllPanels panel, TablePanel  table)
   {
	  this.table=table;
	  this.panel=panel;
	  //set layout
	  setPreferredSize (new Dimension(100, 50));
      setLayout (new BoxLayout (this, BoxLayout.Y_AXIS));
      setBackground(Color.gray);
      // create button panel one
      JPanel panel1=new JPanel();
      b1 = new JButton ("PRB01");
      b1.addMouseListener(new ButtonListener());
      panel1.setBackground (Color.white);
      // create button panel two
      JPanel panel2=new JPanel();
      b2 = new JButton ("PRB02");
      b2.addMouseListener(new ButtonListener());
      panel2.setBackground (Color.yellow);
      // create button panel three
      JPanel panel3=new JPanel();
      b3 = new JButton ("PRB03");
      b3.addMouseListener(new ButtonListener());
      panel3.setBackground (Color.red);
      // create button panel four
      JPanel panel4=new JPanel();
      b4 = new JButton ("PRB04");
      b4.addMouseListener(new ButtonListener());
      panel4.setBackground (Color.black);
      
     
      // add the buttons and the panels to the button panel
      panel1.add(b1);
      add(panel1);
     
      panel2.add(b2);
      add(panel2);
      
      panel3.add(b3);
      add(panel3);
      
      panel4.add(b4);
      add(panel4);
      
     
     
      add (Box.createVerticalGlue());
      
      validate();
   
   }
  
private class ButtonListener implements MouseListener,MouseMotionListener
{
//--------------------------------------------------------------
//Captures the initial position at which the mouse button is
//pressed.
//--------------------------------------------------------------
public void mousePressed (MouseEvent event)
{
if (event.getSource() == b1)
{
	 System.out.println("I pressed b1");
	 table.removeAll();
	 table.repaint();
	 table.add(imageanimation, BorderLayout.CENTER);
	 table.add(new JLabel ("PRB01"), BorderLayout.NORTH);
	 table.add(new JLabel ("Joshua Pritchett 11/7/2013"), BorderLayout.SOUTH);
	
	 table.validate();
}
if (event.getSource() == b2)
{
	
	 table.removeAll();
	 table.repaint();
	 table.add(deal_panel, BorderLayout.CENTER);
	 table.add(new JLabel ("PRB02"), BorderLayout.NORTH);
	 table.add(new JLabel ("Joshua Pritchett 11/7/2013"), BorderLayout.SOUTH);
	
	 table.validate();
}
if (event.getSource() == b3)
{

	 table.removeAll();
	 table.repaint();
	 table.add(circle_panel, BorderLayout.CENTER);
	 table.add(new JLabel ("PRB03"), BorderLayout.NORTH);
	 table.add(new JLabel ("Joshua Pritchett 11/7/2013"), BorderLayout.SOUTH);
	
	 table.validate();
}
if (event.getSource() == b4)
{
	 
	 table.removeAll();
	 table.repaint();
	 table.add(pick_panel, BorderLayout.CENTER);
	 table.add(new JLabel ("PRB04"), BorderLayout.NORTH);
	 table.add(new JLabel ("Joshua Pritchett 11/7/2013"), BorderLayout.SOUTH);
	
	 table.validate();
}


}

//--------------------------------------------------------------
//Gets the current position of the mouse as it is dragged and
//redraws the line to create the rubberband effect.
//--------------------------------------------------------------
public void mouseDragged (MouseEvent event)
{

}

//--------------------------------------------------------------
//Provide empty definitions for unused event methods.
//--------------------------------------------------------------
public void mouseClicked (MouseEvent event) {}
public void mouseReleased (MouseEvent event) {}
public void mouseEntered (MouseEvent event) {}
public void mouseExited (MouseEvent event) {}
public void mouseMoved (MouseEvent event) {}
}
}