package exam;

//********************************************************************
//  ListPanel.java       Authors: Lewis/Loftus
//
//  Represents the list of images for the PickImage program.
//********************************************************************

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.*;



public class ListPanel extends JPanel
{
   private  JPanel imagepanel;
   private JLabel label;
   private JButton picture1,picture2,picture3,picture4,picture5;
   private JList list;
   private BufferedImage image;
   private TListener listener= new TListener();
   //-----------------------------------------------------------------
   //  Loads the list of buttons into the panel 
   //-----------------------------------------------------------------
   public ListPanel ( JPanel imagePanel,JLabel imageLabel)
   {
      this.label=imageLabel;
      this.imagepanel=imagePanel;
      //Create the buttons and add listeners
      picture1=new JButton("picture1");
      picture1.addActionListener(listener);
	  picture2=new JButton("picture2");
	  picture2.addActionListener(listener);
	  picture3=new JButton("picture3");
	  picture3.addActionListener(listener);
	  picture4=new JButton("picture4");
	  picture4.addActionListener(listener);
	  picture5=new JButton("picture5");
	  picture5.addActionListener(listener);
 
	  //Add buttons to Panel
      add (picture1);
      add (picture2);
      add (picture3);
      add (picture4);
      add (picture5);
      setBackground (Color.white);
   }

   //*****************************************************************
   //  Represents the listener for the buttons of images.
   //*****************************************************************
   private class TListener implements ActionListener
   {
   
      public void actionPerformed(ActionEvent event)
      {
      
       if (event.getSource()==picture1)
       {
    	   String pic = "picture1.gif";
    	   ImageIcon image = new ImageIcon (pic);
    	   label.setIcon(image);
    	
		}
       if (event.getSource()==picture2)
       {
    	   String pic = "picture2.gif";
    	   ImageIcon image = new ImageIcon (pic);
    	   label.setIcon(image);
    	
		}
       if (event.getSource()==picture3)
       {
    	   String pic1 = "picture3.gif";
    	   ImageIcon image = new ImageIcon (pic1);
    	   label.setIcon(image);
    	
		}
       if (event.getSource()==picture4)
       {
    	   String pic1 = "picture4.gif";
    	   ImageIcon image = new ImageIcon (pic1);
    	   label.setIcon(image);
    	
		}
       if (event.getSource()==picture5)
       { 	   String pic1 = "picture5.gif";
	   	ImageIcon image = new ImageIcon (pic1);
	   label.setIcon(image);
		}
       }
       
  
   }

   
 
  
}
	





	


