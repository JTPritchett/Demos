package exam;
//********************************************************************
//Primary.java       Author: Joshua Pritchett
//CS-410-01
// Main panel for card homework 
//********************************************************************
import javax.swing.Box;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;



import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
public class Primary extends JPanel 
{
// card array set
	private RealCard[] realset;
	private ProxyCard[] proxyset;
	int count=0;
// primary panel for card hwk
public Primary()
{
		
	   setPreferredSize(new Dimension (900,900));
		realset = new RealCard[52];
		proxyset=new ProxyCard[5];
		realdeck();
		proxydeck();
	     // shuffles cards
		shufflearray();
		// sets layout
		setLayout (new BoxLayout(this, BoxLayout.X_AXIS));
		setBackground (Color.green);
		// add tables to primary tables
		secpanel_hw04 table1 = new secpanel_hw04();
	    Numofcards choose = new Numofcards(this,table1);
	  
	    add(choose);
	    add(table1);
	   
	    
		validate();
	    
	}
//Create a getter and a setter for the card array
public RealCard[] getrealSet() 
{
	return realset;
}

public void setSet(RealCard[] set)
{
	this.realset = set;
}
public ProxyCard[] getproxySet() 
{
	return proxyset;
}
public void proxysetSet(ProxyCard[] set)
{
	this.proxyset = set;
}
// create the  real deck
	public void realdeck()
	{
		int index = 0;   // start with index of 0 

		for(int suit = 0; suit < 4; suit++)
		{
		     for  (int value = 1; value <= 13; value++)
		     {
		             realset[index++] = new RealCard(value,suit);    //puts it into an array indexed 0 to 52   <--- I LIKE THIS WAY BETTER
		     }
		}
		
		
	}
//create the proxy deck for the images
	public void proxydeck()
	{
		
		for (int index=0; index<5; ++index)
		{
			proxyset[index]=new ProxyCard();
		}
	}

// shuffle deck method
public void shufflearray()
{   
	
	Random gen = new Random();
	int y=0;
	RealCard temp;
	for (int x = 0; x < realset.length; x++ )
	{
		y=gen.nextInt(5);
		temp = realset[x];
		realset[x]=realset[y];
		realset[y]=temp;
	}	
		
}	
		


}






