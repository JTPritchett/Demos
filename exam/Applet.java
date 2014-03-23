package exam;

//********************************************************************
//Applet.java       Author: Joshua Pritchett
//CS-410-01
//Shows my Exam as an applet
//********************************************************************



import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.*;
import javax.swing.JApplet;
public class Applet extends JApplet{
	public void init()
	   {
		Container cp = getContentPane();
	      
	     // Create as an applet 
	    
	      
	      AddAllPanels panel1= new AddAllPanels();
	     
	      cp.add(panel1);
	   }
	}

	
