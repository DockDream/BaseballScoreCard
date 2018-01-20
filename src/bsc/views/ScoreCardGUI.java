package bsc.views;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Iterator;
import java.util.LinkedList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SpringLayout;

import bsc.common.NewScoreCard;

/**
 * 
 * @author Chris Edwards 2017
 * 
 * ScoreCardGUI class provides the container to hold ScoreCard container and PlayerCard container
 * on the score card layout.
 *
 */


public class ScoreCardGUI extends JFrame {

	// attributes  ////////////////////////////////////////////////////////////////////////////////
	
	// score card containing all components
	private ScoreCard scoreCard;
	
	// scrolling pane for scorecard
	private JScrollPane scoreCardPane;
	
	// WILL USE TO IMPLEMENT BUTTON CONTROLS ON TOP OF INTERFACE - MUST CREATE CLASS (INNER?)
	private ControlPanel controlPanel;
	
	// layout containing all child elements
	private SpringLayout layout;
	
	// screen width used for calculating best display size
	private int screenWidth;
	
	private ImageIcon icon = new ImageIcon("images/baseballFieldIcon.png");
	
	
	// constructor  ///////////////////////////////////////////////////////////////////////////////
	
	public ScoreCardGUI() {
		
		super("Baseball Scorecard");
		
		// listener for user closing window
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dispose();
				System.exit(0);
			} // end windowClosing
		}); // end addWindowListener
		
		// set window icon
		this.setIconImage(icon.getImage());
		
		// screen width of running machine
		screenWidth = (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth();
				
		// set layout
		getContentPane().setLayout(new BorderLayout());
				
		// set the size of the window		
		resizeGUI();
				
		// validate all components
		validate();
		
		
	} // end ScoreCardGUI constructor
	
	
			
			
			// methods  ///////////////////////////////////////////////////////////////////////////
	
			// initialize the GUI
			public void initializeGUI(ScoreCard scoreCard) {
			
				// create button control panel
				controlPanel = new ControlPanel();
				
				// set up colony view with default dimensions
				scoreCardPane = new JScrollPane(scoreCard);
				scoreCardPane.setPreferredSize(new Dimension(800, 600));
				
				// add control panel and colony view
				getContentPane().add(controlPanel, BorderLayout.NORTH);
				getContentPane().add(scoreCardPane, BorderLayout.CENTER);
				
				// validate all components
				validate();
				
			} // end initializeGui
			
			
			// change GUI to fit machine's display
			private void resizeGUI() {
			
				// set window size
				if (screenWidth >= 1280) {
					setSize(1024, 768);
				}
				else if (screenWidth >= 1024) {
					setSize(800, 600);
				}
				else if (screenWidth >= 800) {
					setSize(640, 480);
				}
				
				// maximize window
				setExtendedState(this.getExtendedState() | this.MAXIMIZED_BOTH);
				
			} // end resizeGUI
			
			
			// sets score at top of window - calls setScore method from Control Panel inner class
			public void setScore(String score) {
			
				controlPanel.setScore(score);		
			}
			
			
			
			///////////////////////////////////////////////////////////////////////////////////////
			// control panel inner class  /////////////////////////////////////////////////////////
			///////////////////////////////////////////////////////////////////////////////////////
			
			private class ControlPanel extends JPanel{
			
				
				// attributes  ////////////////////////////////////////////////////////////////////
				
				// start new game 
				private JButton newGame;
				
				// enter scoring for batter
				private JButton scoreBatter;
				
				// enter scoring for runner at first base
				private JButton scoreRunnerAtFirst;
				
				// enter scoring for runner at second base
				private JButton scoreRunnerAtSecond;
				
				// enter scoring for runner at third base
				private JButton scoreRunnerAtThird;
				
				// advance to next batter
				private JButton nextBatter;
				
				// switch to home team scoring
				private JButton homeButton;
				
				// switch to visiting team scoring
				private JButton visitorButton;
				
				// score display in control panel
				private JLabel scoreLabel;
				
				// button press event handler
				private ButtonHandler buttonHandler;
				
				
				// constructor  ///////////////////////////////////////////////////////////////////
				
				public ControlPanel() {
				
					// call superclass constructor
					super();
					
					// create handler for button press events
					buttonHandler = new ButtonHandler();
					
					// initialize child components
					initializeComponents();
					
					// position child components
					layoutComponents();
					
				} // end ControlPanel constructor
				
				
				// control panel components  //////////////////////////////////////////////////////
				
				private void initializeComponents() {
				
					
					// new game button
					newGame = new JButton("New Game");
					newGame.addActionListener(buttonHandler);
					newGame.setToolTipText("Start new game");
					
					// score batter button
					scoreBatter = new JButton("Score Batter");
					scoreBatter.addActionListener(buttonHandler);
					scoreBatter.setToolTipText("Score play for the batter");
					
					// score runner at first base button
					scoreRunnerAtFirst = new JButton("Runner at First");
					scoreRunnerAtFirst.addActionListener(buttonHandler);
					scoreRunnerAtFirst.setToolTipText("Score play for the runner at 1st base");
					
					// score runner at second base button
					scoreRunnerAtSecond = new JButton("Runner at Second");
					scoreRunnerAtSecond.addActionListener(buttonHandler);
					scoreRunnerAtSecond.setToolTipText("Score play for the runner at 2nd base");
					
					// score runner at third base button
					scoreRunnerAtThird = new JButton("Runner at Third");
					scoreRunnerAtThird.addActionListener(buttonHandler);
					scoreRunnerAtThird.setToolTipText("Score play for the runner at 3rd base");
					
					// soldier test button
					nextBatter = new JButton("Next Batter");
					nextBatter.addActionListener(buttonHandler);
					nextBatter.setToolTipText("Move to next batter");
					
					// button for running simulation continuously
					homeButton = new JButton("Home");
					homeButton.addActionListener(buttonHandler);
					homeButton.setToolTipText("Switch to home team");
					
					// button for running simulation one turn at a time
					visitorButton = new JButton("Visitor");
					visitorButton.addActionListener(buttonHandler);
					visitorButton.setToolTipText("Switch to visitor team");
					
					// label for displaying simulation time
					scoreLabel = new JLabel();
					scoreLabel.setFont(new Font("Eras Medium ITC", Font.BOLD, 12));
					
				} // end intializeComponents
			
				
				// add components  ////////////////////////////////////////////////////////////////
				
				private void layoutComponents() {
				
					this.add(newGame);
					this.add(scoreBatter);
					this.add(scoreRunnerAtFirst);
					this.add(scoreRunnerAtSecond);
					this.add(scoreRunnerAtThird);
					this.add(nextBatter);
					this.add(homeButton);
					this.add(visitorButton);
					this.add(scoreLabel);
					
				} // end layoutComponents
				
				
				// setScore method called by method of same name in parent class
				public void setScore(String score) {
				
					scoreLabel.setText(score);
				}
			
			
			
				///////////////////////////////////////////////////////////////////////////////////
				// ButtonHandler inner class  /////////////////////////////////////////////////////
				///////////////////////////////////////////////////////////////////////////////////
				
				private class ButtonHandler implements ActionListener{
				
					
					// methods  ///////////////////////////////////////////////////////////////////
					
					public void actionPerformed(ActionEvent e) {
					
						// get the button that was pressed
						JButton b = (JButton)e.getSource();
			
						// if New Game button pressed
						if (b.getText().equals("New Game")) {
						
							// open new score card
							NewScoreCard nsc = new NewScoreCard();
						}
						
						// if Score Batter button pressed
						else if (b.getText().equals("Score Batter")) {
						
							// INSERT METHOD HERE
							
						}
						
						// if Runner at First button pressed
						else if (b.getText().equals("Runner at First")) {
						
							// INSERT METHOD HERE
							
						}
						
						// if Runner at Second button is pressed
						else if (b.getText().equals("Runner at Second")) {
						
							// INSERT METHOD HERE
							
						}
						
						// if Runner at Third button is pressed
						else if (b.getText().equals("Runner at Third")) {
						
							// INSERT METHOD HERE
							
						}
						
						// if Next Batter button is pressed
						else if (b.getText().equals("Next Batter")) {
						
							// INSERT METHOD HERE
						}
						
						// if Home button is pressed
						else if (b.getText().equals("Home")) {
						
							// INSERT METHOD HERE
						}
						
						// if Visitor button is pressed
						else if (b.getText().equals("Visitor")) {
						
							// INSERT METHOD HERE
						}
						
					} // end action performed
					
				} // end ButtonHandler class
				
			} // end ControlPanel class
		
		
	
} // end ScoreCard GUI class
