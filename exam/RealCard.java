package exam;


import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.*;
//********************************************************************
//Card.java       Author: Joshua Pritchett
//CS-410-01
// creates a card
//********************************************************************
public class RealCard extends JPanel {
	//My real diamonds
	 private int[] D1x = { 20,  30, 40,30};
     private int[] D1y = {  20, 10,  20,30};
     private int[] D2x = { 60,  70, 80,70};
     private int[] D2y = {  20, 10,  20,30};
     private int[] D3x = { 20,  30, 40,30};
     private int[] D3y = { 120, 110,  120,130};
     private int[] D4x = { 60,  70, 80,70};
     private int[] D4y = {  120, 110,  120,130};
   //My real hearts
     private int[] H1x = { 20,  30, 40, 35, 30, 25};
     private int[] H1y = {  20, 40,  20, 15, 20,15};
     private int[] H2x = { 60,  70, 80, 75, 70, 65};
     private int[] H2y = {  20, 40,  20, 15, 20,15};
     private int[] H3x = { 20,  30, 40, 35, 30, 25};
     private int[] H3y = {  120, 140,  120, 115, 120,115};
     private int[] H4x = { 60,  70, 80, 75, 70, 65};
     private int[] H4y = {  120, 140,  120, 115, 120,115};
    //My real spades
     private int[] S1x = { 20,25, 27,26,34,33,35, 40,  30};
     private int[] S1y = {  30,40, 25,50,50,25,40,  30,  10};
     private int[] S2x = { 60,65, 67,66,74,73,75, 80,  70};
     private int[] S2y = {  30,40, 25,50,50,25,40,  30,  10};
     private int[] S3x = { 20,25, 27,26,34,33,35, 40,  30};
     private int[] S3y = {  130,140, 125,150,150,125,140,  130,  110};
     private int[] S4x = { 60,65, 67,66,74,73,75, 80,  70};
     private int[] S4y = {  130,140, 125,150,150,125,140,  130,  110};
     //My real clubs work in progress
     private int[] C1x = { 15,17,  25, 33,35,25};
     private int[] C1y = {  20,20, 10,  20,20,30};
     
private JLabel face;
private int numface;
private int numsuit;
private JLabel suit;
// card constructor
	public RealCard(int face, int suit)
	{
		
		this.numsuit=suit;
		this.numface=face;
		setFace(face);
		setPreferredSize (new Dimension(100, 150));
		setBackground (Color.white);
	}
	// get face method for card
	public int getFace() {
		
		return numface;
	}
	// set face of the card
	public void setFace(int face) 
	{
		
		if (face == 1)
		    this.face= new JLabel("Ace");
		else{
			if(face > 1  && face < 11)
				this.face=new JLabel(Integer.toString(face));
			else{
				if (face == 11)
				    this.face= new JLabel("Jack");
				if (face == 12)
				    this.face= new JLabel("Queen");
				if (face == 13)
				    this.face= new JLabel("King");
			}
		}
	}
	// determine what suit goes on the card
	public void setSuit(int suit)
	{
		 
		if (suit == 0)
		    this.suit = new JLabel("Clubs");
		if (suit == 1)
		    this.suit = new JLabel("Diamonds");
		if (suit == 2)
		    this.suit = new JLabel("Hearts");
		if (suit == 3)
		    this.suit = new JLabel("Spades");
			}
		
 
	// paint the card
	
	public void paintComponent (Graphics g){
		
		super.paintComponent(g);
		

		//g.fillPolygon(C1x, C1y, C1x.length);
	
	 

	
		switch(numsuit){
		case 0:
			g.setColor(Color.black);
			g.fillOval(20, 20, 20, 20);
			g.fillOval(20, 100, 20, 20);
			g.drawString(Integer.toString(getFace()),50, 60);
			
		    g.drawString("Clubs",30, 75);
			g.fillOval(60, 20, 20, 20);
			g.fillOval(60, 100, 20, 20);
			g.drawRect(0, 0, 99, 149);
			g.setColor(Color.black);
			break;
		case 1:
			g.setColor(Color.red);
		
			g.drawString(Integer.toString(getFace()),50, 60);
			
		    g.drawString("Diamonds",30, 75);
			g.fillPolygon(D1x, D1y, D1x.length);
	      	g.fillPolygon(D2x, D2y, D2x.length);
	     	g.fillPolygon(D3x, D3y, D3x.length);
	      	g.fillPolygon(D4x, D4y, D4x.length);
	      	g.drawRect(0, 0, 99, 149);
		
			g.setColor(Color.black);
			break;
	
		case 2:
			g.setColor(Color.black);
			
			g.drawString(Integer.toString(getFace()),50, 60);
		
		    g.drawString("Spades",30, 75);
			g.fillPolygon(S1x, S1y, S1x.length);
			g.fillPolygon(S2x, S2y, S2x.length);
			g.fillPolygon(S3x, S3y, S3x.length);
			g.fillPolygon(S4x, S4y, S4x.length);
	      
			g.drawRect(0, 0, 99, 149);
			g.setColor(Color.black);
			break;
	
		case 3:
			g.setColor(Color.red);
			g.drawString(Integer.toString(getFace()),50, 60);
		    g.drawString("Hearts",30, 75);
		    g.fillPolygon(H1x, H1y, H1x.length);
		    g.fillPolygon(H2x, H2y, H2x.length);
		    g.fillPolygon(H3x, H3y, H3x.length);
		    g.fillPolygon(H4x, H4y, H4x.length);  
		    g.drawRect(0, 0, 99, 149);
			g.setColor(Color.black);
			break;
	}
	
}

}
