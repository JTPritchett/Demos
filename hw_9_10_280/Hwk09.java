package hw_9_10_280;


import java.awt.Dimension;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import jsjf.ArrayOrderedList;
import jsjf.ArrayUnorderedList;
import jsjf.Heap;
import jsjf.HeapSort;
import jsjf.LinkedUnorderedList;
import jsjf.Sorting;
import jsjf.Sorting4;
import jsjf.StackList;


public class Hwk09 {

	//********************************************************************
	//  Hwk09.java       Author: Joshua Pritchett
	//  CS-280-01
	//  Demonstrates the use of an array of objects.
	//********************************************************************
	//-----------------------------------------------------------------
	//  Creates a Athlete Collection object and adds some Athletes to it. Prints
	//  reports on the status of the collection.
	//-----------------------------------------------------------------
	public static void main(String[] args) throws IOException, InterruptedException
	{
		LinkedUnorderedList<Athlete> linkedathletes = new LinkedUnorderedList<Athlete>();
		StackList<Athlete> transactions = new StackList<Athlete>();
		ArrayUnorderedList<Athlete> arrayathletes = new ArrayUnorderedList<Athlete>();
		LinkedUnorderedList<Athlete> sortedlinkedathletes = new LinkedUnorderedList<Athlete>();
		ArrayOrderedList<Athlete> copylist= new  ArrayOrderedList<Athlete>();
		Heap<Athlete> heap=new Heap<Athlete>();
		
		
		Athlete temp,temp2;
		Athlete[] stockArr = new Athlete[9];
	    Athlete[] copystockArr = new Athlete[9];
	  
  		String fname;
  		int number, speed, strength;
  		int count=0,win=0,extrawin=0, place=0;
  		double height;
  		double weight;
  		String file = "heapOut.txt";
        FileWriter fw = new FileWriter (file);                     
        BufferedWriter bw = new BufferedWriter (fw);
        PrintWriter outFile = new PrintWriter (bw);
     
  		
  		Scanner fileScan = new Scanner(new File("input.txt"));
  		JFrame frame = new JFrame ("Display File");
  		frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
  		JPanel panel1 = new JPanel();
      JTextArea ta = new JTextArea (500, 500);
      //-----------------------------------------------------------------
      // Adds or removes athletes by numeric type then what each athlete is.
      //--------------------------------------------------------------
      
      while (fileScan.hasNext())
      {       
    	   number=fileScan.nextInt();
           fname = fileScan.next();
           speed=fileScan.nextInt();
           strength= fileScan.nextInt();
           height=fileScan.nextDouble();
           weight=fileScan.nextDouble();
          // Add the athletes to proper place based on values
        
           		// if three these are the items that are going to be replaced within the list
        	   if (number==3){
        		   transactions.push(new Athlete(fname, speed, strength, height, weight));
        	   }
        		// if the number is one add the athlete to the front of the linked list   
        	   if (number==1){
        		   
        	   linkedathletes.addToFront(new Athlete(fname, speed, strength, height, weight));
        	   //copy list into linked list
        	   Iterator<Athlete> linkeditr = linkedathletes.iterator();
        	   while (linkeditr.hasNext())
               {
                   Athlete athlete = linkeditr.next();
                  arrayathletes.addToFront(new Athlete(athlete));
                  break;
               }
        	   // Copy array into heap as requested
        	   Iterator<Athlete> heapitr = arrayathletes.iterator();
        	   while (heapitr.hasNext())
               {
                   Athlete athlete = heapitr.next();
                  heap.addElement(new Athlete(athlete));
                  break;
               }
        	  
                
        	   }
        	   
         
      }  
      fileScan.close();
      
      // Show unsorted linked list
      String  info= "\nHere is my unsorted Linkedlist of athletes\n";
      info+=linkedathletes.toString();
      // Show unsorted array list
      info+="\nHere is my unsorted Arraylist of athletes\n";
      info+=arrayathletes.toString();
     
  
      
     // Create iterator in order to add to arrays
     Iterator<Athlete> arrayitr = arrayathletes.iterator();
     // Add to arrays with iterator
     while(count<arrayathletes.size())
     {
    	 Athlete arrayathlete = arrayitr.next();
    	 stockArr[count] =arrayathlete;
    	 copystockArr[count]=arrayathlete;
         ++count;
    }
     // Print unsorted array
     info+="Unsorted array of athletes\n";  
     for (int i=0; i<arrayathletes.size();++i)
	  {
		  info+=stockArr[i].toString();
		  
		  info+="\n";
	  }
     
	  // Sort using selection sort returning comparisons
      win=Sorting.selectionSort(stockArr);
	  info+="Sorted array of athletes using selectionSort \n";  
	
	  for (int i=0; i<arrayathletes.size();++i)
	  {
		  info+=stockArr[i].toString();
		  copylist.add(stockArr[i]);
		  info+="\n";
	  }
	  
		Sorting4.bubbleSort(stockArr);
		 info+="Sorted array of athletes using bubbleSort \n";  
			
		  for (int i=0; i<arrayathletes.size();++i)
		  {
			  info+=stockArr[i].toString();
			 
			  info+="\n";
		  }
		  
		  
	// Sort using quicksort returning comparisons
	  extrawin=Sorting4.quickSort(copystockArr);
	  info+="Sorted array of athletes using quickSort \n";  
	 
	  for (int i=0; i<arrayathletes.size();++i)
	  {
		  info+=copystockArr[i].toString();
		
		  info+="\n";
	  }
	  // show copied array into a list
	  info+="Here is my copied array into a list \n";  
	  info+=copylist.toString();

	
	// pop the stack with and update and replace
	  while ( !transactions.isEmpty ())
      {
           temp= transactions.pop ();
           
           place=copylist.find(temp);
           info+="\nHere is the athlete being updated \n";  
          info+=copylist.original(place);
          copylist.replace(place,temp);
      }
	  // Show new list BOOYAH I tried something different here I found this to be simple yet generic lemme know.
	  info+="\nHere is my found and replaced copied array into a list \n"; 
	  info+=copylist.toString();
	  //show copied heap
	  info+="\nHere is my copied heap \n";  
	  Iterator<Athlete> levelitr = heap.iteratorLevelOrder();
      while(levelitr.hasNext())
       {
 	       info+= levelitr.next()+"\n";
 	      
       }
      // Add the contents to the heapout.txt
      Iterator<Athlete> outfilelevelitr = heap.iteratorLevelOrder();
      while(outfilelevelitr.hasNext())
       {
   	   
    	  outFile.println (outfilelevelitr.next());
 	       
        
          }
      // Use heapSort had to implement comparable into the function it was fussing pretty hard about working properly
      HeapSort.HeapSort(copystockArr,0,8);
	  info+="Sorted array of athletes using HeapSort Generic \n";  
	 
	  for (int i=0; i<copystockArr.length;++i)
	  {
		  info+=copystockArr[i].toString();
		 
		  info+="\n";
	  }
      
		  
	  outFile.close();
      //-----------------------------------------------------------------
      //  adds report to text area
      //-----------------------------------------------------------------


      ta.setText (info);
      JScrollPane sp = new JScrollPane(ta);
      sp.setPreferredSize(new Dimension (900,900));
      panel1.add(sp);
 
      frame.getContentPane().add (panel1);
      frame.pack();
      frame.setVisible(true);
   }

	
}

