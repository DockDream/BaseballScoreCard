package bsc.views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.border.BevelBorder;

/**
 * 
 * @author Chris Edwards 2017
 * 
 * ScoreCardBox class provides the layout for a single scoring box
 * on the score card layout. An array of ScoreCardBox objects 
 * will be held by the ScoreCard class
 *
 */


public class ScoreCardBox extends JPanel {
	
	// Constants  /////////////////////////////////////////////////////////////////////////////////

		// default font for scoring box info text
		private final Font BOX_INFO_FONT = new Font("Eras Medium ITC", Font.BOLD, 10);
		
		// default font for scoring box out text
		private final Font BOX_OUT_FONT = new Font("Eras Medium ITC", Font.BOLD, 14);
	
		// color for info text
		private final Color BOX_INFO_FONT_COLOR = Color.BLACK;
		
		// color for out text
		private final Color BOX_OUT_FONT_COLOR = Color.RED;
	
		// background color of scoring boxes and thereby the score sheet itself
		private final Color BOX_COLOR = new Color(247, 246, 242);
		
	
	// attributes  ////////////////////////////////////////////////////////////////////////////////
	
		// layout for positioning components
		private SpringLayout layout;
		
		// id of frame
		private FrameNumber frameNumber;
		
		// displays number of outs
		private JLabel outsLabel;
		
		// displays at bat result
		private JLabel outScoringLabel;
		
		// displays number of RBI for at bat
		private JLabel rbiLabel;
		
		// displays reach 1st base info
		private JLabel advFirstLabel;
		
		// displays advance to 2nd base info
		private JLabel advSecondLabel;
		
		// displays advance to 3rd base info
		private JLabel advThirdLabel;
		
		// displays advance to Home info
		private JLabel advHomeLabel;
		
		
		
		
		// image displaying runner reaching 1st base safely
		private JLabel runToFirst;
		
		// image displaying runner reaching 2nd base safely
		private JLabel runToSecond;
		
		// image displaying runner reaching 3rd base safely
		private JLabel runToThird;
		
		// image displaying runner reaching Home safely
		private JLabel runToHome;
		
		// image displaying runner out at 2nd base
		private JLabel outAtSecond;

		// image displaying runner out at 3rd base
		private JLabel outAtThird;

		// image displaying runner out at Home
		private JLabel outAtHome;
		
		
		
		// number of outs
		private int outs = 0;
		
		// number of rbi
		private int rbi = 0;
		
		// current batter's uniform number
		private int uniformNumber = 0;
		
		// at bat result
		private String outScoring = "";
		
		
		// Constructor  ////////////////////////////////////////////////////////////////////////// 
		
		public ScoreCardBox() {
		
			super();
			
			// create and set layout for child components
			layout = new SpringLayout();
			this.setLayout(layout);
			
			// initialize child components of scoring box
			initComponents();
			
			// position and display child components in scoring box
			layoutComponents();
			
			// set background color of scoring box
			setBackground(BOX_COLOR);
			
			// set border around scoring box
			setBorder(BorderFactory.createLineBorder(Color.BLACK));
			
			// set size of scoring box
			setPreferredSize(new Dimension(ScoreCard.BOX_SIZE, ScoreCard.BOX_SIZE));
			
		} // end constructor
		
		
		
		// Initialize Scoring Box Components   ////////////////////////////////////////////////////
		
		private void initComponents() {
			
			// sets Frame Number 
			frameNumber = new FrameNumber();
			frameNumber.setFrameNumber(0, 0);
		
			// displays if and which out was recorded for the scoring box
			outsLabel = new JLabel("");
			outsLabel.setFont(BOX_OUT_FONT);
			outsLabel.setForeground(BOX_OUT_FONT_COLOR);
			
			// displays the result of the at bat for the scoring box
			outScoringLabel = new JLabel("");
			outScoringLabel.setFont(BOX_OUT_FONT);
			outScoringLabel.setForeground(BOX_OUT_FONT_COLOR);
			
			// displays the number of RBI recorded by the batter for the scoring box
			rbiLabel = new JLabel("");
			rbiLabel.setFont(BOX_INFO_FONT);
			rbiLabel.setForeground(BOX_INFO_FONT_COLOR);
			
			// displays the play that advanced the runner to 1st
			advFirstLabel = new JLabel("");
			advFirstLabel.setFont(BOX_INFO_FONT);
			advFirstLabel.setForeground(BOX_INFO_FONT_COLOR);
			
			// displays the number of the batter or the play type that advanced the runner to 2nd
			advSecondLabel = new JLabel("");
			advSecondLabel.setFont(BOX_INFO_FONT);
			advSecondLabel.setForeground(BOX_INFO_FONT_COLOR);
			
			// displays the number of the batter or the play type that advanced the runner to 3rd
			advThirdLabel = new JLabel("");
			advThirdLabel.setFont(BOX_INFO_FONT);
			advThirdLabel.setForeground(BOX_INFO_FONT_COLOR);
			
			// displays the number of the batter or the play type that advanced the runner to Home
			advHomeLabel = new JLabel("");
			advHomeLabel.setFont(BOX_INFO_FONT);
			advHomeLabel.setForeground(BOX_INFO_FONT_COLOR);
			
			
			
			// displays image of runner reaching 1st base safely
			runToFirst = new JLabel(new ImageIcon("images/runToFirst.png"));
			runToFirst.setVisible(false);
			
			// displays image of runner reaching 2nd base safely
			runToSecond = new JLabel(new ImageIcon("images/runToSecond.png"));
			runToSecond.setVisible(false);
						
			// displays image of runner reaching 3rd base safely
			runToThird = new JLabel(new ImageIcon("images/runToThird.png"));
			runToThird.setVisible(false);
						
			// displays image of runner reaching Home safely
			runToHome = new JLabel(new ImageIcon("images/runToHome.png"));
			runToHome.setVisible(false);
			
			// displays image of runner out at 2nd base
			outAtSecond = new JLabel(new ImageIcon("images/outAtSecond.png"));
			outAtSecond.setVisible(false);
						
			// displays image of runner out at 3rd base
			outAtThird = new JLabel(new ImageIcon("images/outAtThird.png"));
			outAtThird.setVisible(false);
						
			// displays image of runner out at Home
			outAtHome = new JLabel(new ImageIcon("images/outAtHome.png"));
			outAtHome.setVisible(false);
			
		} // end initComponents method
		
		
		
		private void layoutComponents() {
			
			// set positions
			
			// outs Label
			layout.putConstraint(SpringLayout.WEST, outsLabel, 3, SpringLayout.WEST, this);
			layout.putConstraint(SpringLayout.NORTH, outsLabel, 3, SpringLayout.NORTH, this);
			
			// out scoring Label
			layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, outScoringLabel, 0, SpringLayout.HORIZONTAL_CENTER, this);
			layout.putConstraint(SpringLayout.VERTICAL_CENTER, outScoringLabel, 0, SpringLayout.VERTICAL_CENTER, this);
			
			// rbi Label
			layout.putConstraint(SpringLayout.WEST, rbiLabel, 3, SpringLayout.WEST, this);
			layout.putConstraint(SpringLayout.NORTH, rbiLabel, 84, SpringLayout.NORTH, this);
			
			// adv first Label
			layout.putConstraint(SpringLayout.WEST, advFirstLabel, 75, SpringLayout.WEST, this);
			layout.putConstraint(SpringLayout.NORTH, advFirstLabel, 71, SpringLayout.NORTH, this);
			
			// adv second Label
			layout.putConstraint(SpringLayout.WEST, advSecondLabel, 75, SpringLayout.WEST, this);
			layout.putConstraint(SpringLayout.NORTH, advSecondLabel, 21, SpringLayout.NORTH, this);
			
			// adv third Label
			layout.putConstraint(SpringLayout.EAST, advSecondLabel, 26, SpringLayout.WEST, this);
			layout.putConstraint(SpringLayout.NORTH, advSecondLabel, 21, SpringLayout.NORTH, this);
			
			// adv home Label
			layout.putConstraint(SpringLayout.EAST, advHomeLabel, 26, SpringLayout.WEST, this);
			layout.putConstraint(SpringLayout.NORTH, advHomeLabel, 71, SpringLayout.NORTH, this);
			
			// runner to first image
			layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, runToFirst, 0, SpringLayout.HORIZONTAL_CENTER, this);
			layout.putConstraint(SpringLayout.VERTICAL_CENTER, runToFirst, 0, SpringLayout.VERTICAL_CENTER, this);
			
			// runner to second image
			layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, runToSecond, 0, SpringLayout.HORIZONTAL_CENTER, this);
			layout.putConstraint(SpringLayout.VERTICAL_CENTER, runToSecond, 0, SpringLayout.VERTICAL_CENTER, this);
			
			// runner to third image
			layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, runToThird, 0, SpringLayout.HORIZONTAL_CENTER, this);
			layout.putConstraint(SpringLayout.VERTICAL_CENTER, runToThird, 0, SpringLayout.VERTICAL_CENTER, this);
			
			// runner to first image
			layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, runToHome, 0, SpringLayout.HORIZONTAL_CENTER, this);
			layout.putConstraint(SpringLayout.VERTICAL_CENTER, runToHome, 0, SpringLayout.VERTICAL_CENTER, this);
			
			// out at second image
			layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, outAtSecond, 0, SpringLayout.HORIZONTAL_CENTER, this);
			layout.putConstraint(SpringLayout.VERTICAL_CENTER, outAtSecond, 0, SpringLayout.VERTICAL_CENTER, this);
			
			// out at third image
			layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, outAtThird, 0, SpringLayout.HORIZONTAL_CENTER, this);
			layout.putConstraint(SpringLayout.VERTICAL_CENTER, outAtThird, 0, SpringLayout.VERTICAL_CENTER, this);
			
			// out at home image
			layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, outAtHome, 0, SpringLayout.HORIZONTAL_CENTER, this);
			layout.putConstraint(SpringLayout.VERTICAL_CENTER, outAtHome, 0, SpringLayout.VERTICAL_CENTER, this);
			
			
			
			// add to layout
			
			this.add(outsLabel);
			this.add(outScoringLabel);
			this.add(rbiLabel);
			this.add(advFirstLabel);
			this.add(advSecondLabel);
			this.add(advThirdLabel);
			this.add(advHomeLabel);
			this.add(runToFirst);
			this.add(runToSecond);
			this.add(runToThird);
			this.add(runToHome);
			this.add(outAtSecond);
			this.add(outAtThird);
			this.add(outAtHome);
			
		} // end layoutComponents method

		
		
		// getters and setters  ///////////////////////////////////////////////////////////////////

		// set outsLabel value
		public void setOutsLabel(int outs) {
			outsLabel.setText(String.valueOf(outs));
		}

		// set outScoringLabel value
		public void setOutScoringLabel(String outScoring) {
			outScoringLabel.setText(outScoring);
		}

		// set rbiLabel value
		public void setRbiLabel(int rbi) {
			rbiLabel.setText(String.valueOf(rbi));
		}

		// set advFirstLabel value
		public void setAdvFirstLabel(int uniformNumber) {
			advFirstLabel.setText(String.valueOf(uniformNumber));
		}

		// set advSecondLabel value
		public void setAdvSecondLabel(int uniformNumber) {
			advSecondLabel.setText(String.valueOf(uniformNumber));
		}

		// set advThirdLabel value
		public void setAdvThirdLabel(int uniformNumber) {
			advThirdLabel.setText(String.valueOf(uniformNumber));
		}

		// set advHomeLabel value
		public void setAdvHomeLabel(int uniformNumber) {
			advHomeLabel.setText(String.valueOf(uniformNumber));
		}

		// return number of outs
		public int getOuts() {
			return outs;
		}

		// set number of outs
		public void setOuts(int outs) {
			this.outs = outs;
		}

		// get number of rbi
		public int getRbi() {
			return rbi;
		}

		// set number of rbi
		public void setRbi(int rbi) {
			this.rbi = rbi;
		}

		// get uniform number
		public int getUniformNumber() {
			return uniformNumber;
		}

		// set uniform number
		public void setUniformNumber(int uniformNumber) {
			this.uniformNumber = uniformNumber;
		}

		// set abResult
		public String getAbResult() {
			return outScoring;
		}

		// get abResult
		public void setAbResult(String outScoring) {
			this.outScoring = outScoring;
		}
		
		
		
		// show and hide methods for base runner images  //////////////////////////////////////////
		
		// display runner to 1st image
		public void showRunnerToFirst() {
	
			runToFirst.setVisible(true);
		}
		
		// hide runner to 1st image
		public void hideRunnerToFirst() {
		
			runToFirst.setVisible(false);
		}
		
		
		// display runner to 2nd image
		public void showRunnerToSecond() {
		
			runToSecond.setVisible(true);
		}
				
		// hide runner to 2nd image
		public void hideRunnerToSecond() {
		
			runToSecond.setVisible(false);
		}
		
		
		// display runner to 3rd image
		public void showRunnerTothird() {
			
			runToThird.setVisible(true);
		}
		
		// hide runner to 3rd image
		public void hideRunnerToThird() {
			
			runToThird.setVisible(false);
		}
		
		
		// show runner to home image
		public void showRunnerToHome() {
			
			runToHome.setVisible(true);
		}
		
		// hide runner to home image
		public void hideRunnerToHome() {
			
			runToHome.setVisible(false);
		}
		
		
		// show runner out at 2nd image
		public void showRunnerOutAtSecond() {
			
			outAtSecond.setVisible(true);
		}
		
		// hide runner out at 2nd image
		public void hideRunnerOutAtSecond() {
			
			outAtSecond.setVisible(false);
		}
		
		
		// show runner out at 3rd image
		public void showRunnerOutAtThird() {
			
			outAtThird.setVisible(true);
		}
		
		// hide runner out at 3rd image
		public void hideRunnerOutAtThird() {
			
			outAtThird.setVisible(false);
		}
		
		
		// show runner out at home image
		public void showRunnerOutAtHome() {
			
			outAtHome.setVisible(true);
		}
		
		// hide runner out at home image
		public void hideRunnerOutAtHome() {
			
			outAtHome.setVisible(false);
		}
		
		// method to clear text in labels  ////////////////////////////////////////////////////////
		public JLabel resetLabel(JLabel label) {
			label.setText("");
			return label;
		}
		
		// method to set Frame Number of Score Card Box instance
		public void setFrameNumber(int x, int y) {
			frameNumber.setFrameNumber(x, y);
		}
		
		// return Frame Number row
		public int getFrameRow() {
			int x = frameNumber.getX();
			return x;
		}
		
		// return Frame Number column
		public int getFrameColumn() {
			int y = frameNumber.getY();
			return y;
		}
		
		///////////////////////////////////////////////////////////////////////////////////////////
		// Frame Number inner class  //////////////////////////////////////////////////////////////
		///////////////////////////////////////////////////////////////////////////////////////////

		private class FrameNumber{


			// attributes  ////////////////////////////////////////////////////////////////////////

			// ints for frame array index
			private int x;
			private int y;
			
			// method  ///////////////////////////////////////////////////////////////////////
			public void setFrameNumber(int x, int y){
				this.setX(x);
				this.setY(y);
			} // end method

			// getters and setters  ///////////////////////////////////////////////////////////////
			public int getX() {
				return x;
			}

			public void setX(int x) {
				this.x = x;
			}

			public int getY() {
				return y;
			}

			public void setY(int y) {
				this.y = y;
			}
			
		} // end FrameNumber inner class
		
} // end class ScoreCardBox
