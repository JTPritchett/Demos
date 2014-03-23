package exam;

//********************************************************************
//Application.java       Author: Joshua Pritchett
//CS-410-01
//Shows my Exam as an application
//********************************************************************


import javax.swing.JFrame;

public class Application 
{
	 public static void main (String[] args)
	   {
	      JFrame frame = new JFrame ("EXAM 02 JP");
	      frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
	     
	     // Primary panel1 = new Primary ();
	      
	      AddAllPanels panel1= new AddAllPanels();
	     
	      frame.getContentPane().add(panel1);

	      frame.pack();
	      frame.setVisible(true);
	   }
	}

