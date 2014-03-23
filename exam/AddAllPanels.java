package exam;




//********************************************************************
//AddAllPanels.java       Author: Joshua Pritchett
//CS-410-01
//Adds panels for main panel in homework
//********************************************************************

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class AddAllPanels extends JPanel {
	
	AddAllPanels(){
		setPreferredSize(new Dimension (900,900));	
		setLayout (new BoxLayout (this, BoxLayout.X_AXIS));

		setBackground (Color.yellow);
		// create table and button table
		TablePanel  table1 = new TablePanel ();
	    ButtonPanel buttonpanel = new ButtonPanel(this,table1);
	  
	    add(buttonpanel);
	    add(table1);
	   
	    
		validate();
	    
	}
	    
	}

