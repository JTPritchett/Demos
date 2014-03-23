package hw_9_10_280;








//********************************************************************
//  Athlete.java       Author: Joshua Pritchett
//	CS-280
//  Represents a Athlete.
//********************************************************************



public class Athlete implements Comparable<Athlete>
{
   private String name;
   private int speed=0, strength=0;
   private double height=0;
   private double weight=0.0; 
   //-----------------------------------------------------------------
   //  Creates a new Athlete with the specified information.
   //-----------------------------------------------------------------
   public Athlete (String name, int speed, int strength, double height,
      double weight)
   {
      this.name = name;
      this.speed = speed;
      this.strength = strength;
      this.height = height;
      this.weight = weight;
   }
   
   public Athlete(Athlete temp)
   {
	   this.name = temp.getName();
	   this.speed = temp.getSpeed();
	   this.strength = temp.getStrength();
	   this.height = temp.getHeight();
	   this.weight = temp.getWeight();
   }
   public Athlete(String name)
   {
	this.name=name;   
   }
   //-----------------------------------------------------------------
   //  Returns a string description of an Athlete.
   //-----------------------------------------------------------------
   public String toString()
   {
      

      String description;
      description =  name+ "\t" + speed + "\t" + strength+ "\t"+ height+ "\t"+ weight;

      return description;
   }
   public int compareTo(Athlete obj)
   {
	  
			int result = 0;
			result = name.compareTo(obj.getName());
			return result;
	}

 //-----------------------------------------------------------------
 //  Getters and Setters
 //-----------------------------------------------------------------
public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public int getSpeed() {
	return speed;
}

public void setSpeed(int speed) {
	this.speed = speed;
}

public int getStrength() {
	return strength;
}

public void setStrength(int strength) {
	this.strength = strength;
}

public double getHeight() {
	return height;
}

public void setHeight(double height) {
	this.height = height;
}

public double getWeight() {
	return weight;
}

public void setWeight(double weight) {
	this.weight = weight;
}
   
}




