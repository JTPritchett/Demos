package exam;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
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
//Numofcards.java       Author: Joshua Pritchett
//CS-410-01
// Labels and action listeners for background and card count
//********************************************************************
public class Numofcards extends JPanel {
	 // create variables
	private JButton deal, show;
	private secpanel_hw04  table;
	private Primary panel1;
	JButton push= new JButton();

	public Numofcards(Primary panel1, secpanel_hw04 table)
	{
		setLayout (new BoxLayout(this, BoxLayout.Y_AXIS));
		// Create buttons and labels for the top panel
		this.table=table;
		this.panel1=panel1;
	
		deal = new JButton ("Deal!");
		deal.setEnabled (true);
		deal.setMnemonic ('D');
		deal.setToolTipText ("Deal the cards");
		deal.addActionListener(new ButtonListener());
		show=new JButton("Show!");
		show.setEnabled(true);
		show.setMnemonic('S');
		show.setToolTipText("Show the cards");
		show.addActionListener(new ButtonListener());
		
		add(show);
		add(deal);
		setPreferredSize (new Dimension(500, 500));
	    setBackground (Color.green);
	    validate();
	}
	// Create action listeners for the panel itself
	

	 private class ButtonListener implements ActionListener
	   {
	      //--------------------------------------------------------------
	      //  Performs the conversion when the enter key is pressed in
	      //  the text field.
	      //--------------------------------------------------------------
	      public void actionPerformed (ActionEvent event)
	      {
	    	 table.removeAll();
	    	 table.repaint();
	    	//table. setLayout (new GridLayout (4, 5));
	         RealCard [] realtemp=panel1.getrealSet();
	         ProxyCard[] proxytemp=panel1.getproxySet();
	         panel1.shufflearray();
            if (event.getSource() == deal)
            {
             for (int x = 0; x < 5; x++)
             {
            	 table.add(realtemp[x]);	
             }
             table.validate();
	        
            }
            if(event.getSource()==show)
            {
            	for(int z=0; z<5; ++z)
            	{
            		table.add(proxytemp[z]);
            	}
            	table.validate();
            }
	         
	       
	      }
	   }

	 
	
}
	 

