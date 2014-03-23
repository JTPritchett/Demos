package exam;

//********************************************************************
//  PickImage.java       Authors: Joshua Pritchett
//
//  Demonstrates the use a split pane and a list.
//********************************************************************

import java.awt.*;

import javax.swing.*;

public class PickImage extends JPanel
{
	JLabel imageLabel = new JLabel();
    JPanel imagePanel = new JPanel();
   //-----------------------------------------------------------------
   //  Creates and displays a frame containing a split pane. The
   //  user selects an image name from the list to be displayed.
   //-----------------------------------------------------------------
	public PickImage()
	{
 	 JLabel imageLabel = new JLabel();
	 JPanel imagePanel = new JPanel();
	 imagePanel.add (imageLabel);
     imagePanel.setBackground (Color.black);
     
      ListPanel imageList = new ListPanel (imagePanel,imageLabel);

      JSplitPane sp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
                                     imageList, imagePanel);
      sp.setPreferredSize (new Dimension (1000, 1000));
      sp.setOneTouchExpandable (true);
      add(sp);

      
   }
}
