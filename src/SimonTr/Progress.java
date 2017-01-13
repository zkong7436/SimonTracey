package SimonTr;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import guiPractice.components.Component;

public class Progress extends Component implements ProgressInterfaceTracey {

	private static final int WIDTH = 150;
	private static final int HEIGHT = 50;

	private String round;
	private String sequence;
	private boolean gameOver;
	
	// Colors selections for Game Over box
	private int redOver = 46;
	private int greenOver = 53;
	private int blueOver = 63;
	
	// Color selections for during game box
	private int redOn = 178;
	private int greenOn = 207;
	private int blueOn = 255;
	
	public Progress() {
		super(10,30,WIDTH,HEIGHT);
	}

	public void gameOver() {
		gameOver = true;
		update();
	}

	public void setRound(int r) {
		round = "Round# " + r;
		update();
	}

	public void setSequenceSize(int s) {
		sequence = "Longest sequence: "  + s;
		update();
	}

	public void update(Graphics2D g) {
		//boxCreate(g);
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		if(gameOver){
			runOver(g);
		}else{
			runSequence(g);
		}
	}

	private void runSequence(Graphics2D g) {
		FontMetrics fm = g.getFontMetrics();
		g.setColor(new Color(redOn,greenOn,blueOn));
		g.fillRect(0, 0, WIDTH, HEIGHT);
		g.setColor(Color.black);
		g.drawRect(0, 0, WIDTH-1, HEIGHT-1);
		if(round !=null && sequence != null){

			g.drawString(round, (WIDTH - fm.stringWidth(round))/2, 20);
			g.drawString(sequence, (WIDTH - fm.stringWidth(sequence))/2, 40);
		}
		
	}

	private void runOver(Graphics2D g) {
		FontMetrics fm = g.getFontMetrics();
		g.setColor(new Color(redOver,greenOver,blueOver));
		g.fillRect(0, 0, WIDTH, HEIGHT);
		g.setColor(Color.white);
		String gameEnd = "GAME OVER! RESTART!";
		g.drawString(gameEnd, (WIDTH - fm.stringWidth(gameEnd))/2, 20);
		g.drawString(sequence, (WIDTH - fm.stringWidth(sequence))/2, 40);
	}

}
