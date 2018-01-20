package bsc.common;

import bsc.views.*;

public class NewScoreCard {
	
	/**
	 * 
	 * @author Chris Edwards 2017
	 * 
	 * NewScoreCard class instantiates and initializes instances of ScoreCardGUI,
	 * ScoreCard, PlayerCard and the ScoreCardBox array for a new instance of 
	 * the application.
	 *
	 */
	
		// attributes  ////////////////////////////////////////////////////////////////////////////
	
		// the following variables are available project wide
		public static int homeScore = 0;
		public static int visitorScore = 0;
		
		
		/*
		 *  Score Card is  set to 11 x 10 to accommodate 11 rows of player names for 
		 *  scoring and 10 columns for 10 innings of play.
		 */
		
		//public static ScoreCard scoreCard = new ScoreCard(11, 10);
		public static ScoreCard scoreCard;
		
		
		
		 // 2D Array to hold ScoreCardBox objects.

		static ScoreCardBox[][] scoreCardBox = new ScoreCardBox[11][10];
		
		
		//  Constructor  //////////////////////////////////////////////////////////////////////////
		public NewScoreCard(){
		// instantiating GUI class instance
		ScoreCardGUI scGUI = new ScoreCardGUI();
		scoreCard = new ScoreCard(11, 10);
		scGUI.initializeGUI(scoreCard);
		scGUI.setScore("Home: " + homeScore + " Away: " + visitorScore);
		this.normalSetupInit();
		scGUI.setVisible(true);
		
		} // end constructor
		
		
		// normalSetupInit called from New Game Button in ScoreCardGUI
		public void normalSetupInit(){
			
			// Initializing individual scoring frames
			for(int i = 0; i < 11; i ++){
				for(int j = 0; j < 10; j ++){
					ScoreCardBox cardBox = new ScoreCardBox();
					cardBox.setFrameNumber(i, j);	
					
					scoreCard.addScoreCardBox(cardBox, i, j);
					cardBox.setVisible(true);
					
				} // end for j loop
			} // end for i loop
			
			
		} // end normalSetupInit method


} // end NewScoreCard class
