package exam;

//******************************************************************
//SpeedControlPanel.java
//Joshua Pritchett
//The panel for the bouncing square.
//******************************************************************

import java.awt.*;

import java.awt.event.*;

import javax.swing.*;

import javax.swing.event.*;

public class SpeedControlPanel extends JPanel

{

	private final int WIDTH = 600;
	private final int HEIGHT = 700;
	private final int BALL_SIZE = 50;
	private int slidePanelHt = 0;
	private Square bouncingBall; // the object that moves
	private Timer timer;
	private int moveX, moveY; // increment to move each time

	// ---------------------------------------------
	// Sets up the panel, including the timer
	// for the animation
	// ---------------------------------------------

	public SpeedControlPanel()

	{

		timer = new Timer(30, new ReboundListener());
		this.setLayout(new BorderLayout());
		bouncingBall = new Square(BALL_SIZE);
		moveX = moveY = 10;
		// Set up a slider object here
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setBackground(Color.black);
		timer.start();
		timerballpanel spanel = new timerballpanel(timer);
		add(spanel, BorderLayout.SOUTH);

	}
	// --------------------
	// Draw the ball
	// --------------------
	public void paintComponent(Graphics page)
	{

		super.paintComponent(page);
		bouncingBall.draw(page);
	}
	// ***************************************************
	// An action listener for the timer
	// ***************************************************
	public class ReboundListener implements ActionListener
	{
		// ----------------------------------------------------
		// actionPerformed is called by the timer -- it updates
		// the position of the bouncing ball
		// ----------------------------------------------------

		public void actionPerformed(ActionEvent action)
		{

			bouncingBall.move(moveX, moveY);
			// change direction if ball hits a side
			int x = bouncingBall.getX();
			int y = bouncingBall.getY();
			if (x < 0 || x >= getSize().getWidth() - BALL_SIZE)
				moveX = moveX * -1;
			if (y <= 0 || y >= (getSize().getHeight() - 300) - BALL_SIZE)
				moveY = moveY * -1;

			repaint();

		}

	}

}
