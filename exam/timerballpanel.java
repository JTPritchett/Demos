package exam;



import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.event.*;

//********************************************************************
//timerballpanel.java       Author: Joshua Pritchett
//CS-410-01
//panel that has the buttons for the start and stop
//********************************************************************

public class timerballpanel extends JPanel 
{
	private JButton start,stop;
	private Timer timer;
	private  int DELAY = 200;
	TListener listener = new TListener();
	public timerballpanel(Timer timer)
	{
		setPreferredSize (new Dimension (300, 300));// set panel size
		this.timer=timer;
		
		//create the buttons
		start=new JButton("start");
		start.addActionListener(listener);
		stop=new JButton("stop");
		stop.addActionListener(listener);
		
		//stop.addActionListener(new TListener());
		
		add(start);// add the buttons to the panel
		add(stop);
	}
	  private class TListener implements ActionListener
  {
 //--------------------------------------------------------------
 //  Starts and stops the timer for the ball
 //--------------------------------------------------------------
 public void actionPerformed (ActionEvent event)
 	{
  //  bulb.setOn (true);
	 if (event.getSource()==start)
  		{
		 timer.start();
  	
  		}
	 if (event.getSource()==stop)
		{
		 timer.stop();
	
		}

 	}
 
  }
}
