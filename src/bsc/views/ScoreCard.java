package bsc.views;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.SpringLayout;

/**
 * 
 * @author Chris Edwards 2017
 * 
 * ScoreCard class provides the container to hold the individual scoring boxes
 * from the ScoreCardBox class on the score card layout.
 *
 */

public class ScoreCard extends JPanel {

	// Constants  /////////////////////////////////////////////////////////////////////////////////
	
		// size for an individual box on the score card
		public final static int BOX_SIZE = 100;
		
		// background color
		private final Color BACKGROUND_COLOR = new Color(247, 246, 242);
	
		
		
	// Attributes  ////////////////////////////////////////////////////////////////////////////////
		
		// layout for positioning score card components
		private SpringLayout layout;
		
		
		
	// Constructor  ///////////////////////////////////////////////////////////////////////////////
		/**
		 * 
		 * @param cardRows = number of players to be entered in the score sheet as batters (typically 9-11)
		 * @param cardColumns = number of innings on the score card (typically 7-10)
		 */
		public ScoreCard(int cardRows, int cardColumns) {
		
			// call superclass constructor
			super();
			
			// create and set layout
			layout = new SpringLayout();
			setLayout(layout);
			
			// set size of this view
			setPreferredSize(new Dimension(cardColumns * BOX_SIZE, cardRows * BOX_SIZE));
			
			// set background color
			setBackground(BACKGROUND_COLOR);
			
		} // end ScoreCard constructor
		
		
		
	// Methods  ///////////////////////////////////////////////////////////////////////////////////
		
		/**
		 * 
		 * @param cardBox = instance of Score Card Box being added to Score Card
		 * @param x = x coordinate of Score Card Box
		 * @param y = y coordinate of Score Card Box
		 */
		public void addScoreCardBox(ScoreCardBox cardBox, int y, int x) {
		
			// position node view
			layout.putConstraint(SpringLayout.WEST, cardBox, x * BOX_SIZE, SpringLayout.WEST, this);
			layout.putConstraint(SpringLayout.NORTH, cardBox, y * BOX_SIZE, SpringLayout.NORTH, this);
			
			// add node view to layout
			this.add(cardBox);
			
		} // end addScoreCardBox method
	
} // end ScoreCard class
