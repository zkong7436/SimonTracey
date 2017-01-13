package SimonTr;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import SimonTr.ButtonInterfaceTracey;
import SimonTr.SimonScreenTracey;
import SimonTr.ButtonInterfaceTracey;
import SimonTr.Random;
import guiPractice.components.Action;
import guiPractice.components.TextLabel;
import guiPractice.components.Visible;
import guiPractice.sampleGames.ClickableScreen;

public class SimonScreenTracey extends ClickableScreen implements Runnable {

	private TextLabel label;
	private ButtonInterfaceTracey[] button;
	private ProgressInterfaceTracey progress;
	private ArrayList<MoveInterfaceTracey> sequence;
	
	private int roundNumber;
	private boolean acceptingInput;
	private int sequenceIndex;
	private int lastSelectedButton;
	
	public SimonScreenTracey(int width, int height) {
		super(width, height);
		Thread app = new Thread(this);
		app.start();
	}

	@Override
	public void run() {
		

	}

	@Override
	public void initAllObjects(ArrayList<Visible> viewObjects) {
		
		sequence = new ArrayList<MoveInterfaceTracey>();
		addButtons(viewObjects);
		progress = getProgress();
		label = new TextLabel(150,230,60,60,"Go.");
		//add 2 moves to start
		lastSelectedButton = -1;
		sequence.add(randomMove());
		sequence.add(randomMove());
		roundNumber = 0;
		viewObjects.add(progress);
		viewObjects.add(label);


	}

	private MoveInterfaceTracey randomMove() {
		//code that randomly selects a ButtonInterfaceTracey
		
		int rand=(int)(Math.random()*button.length);
		while(rand==lastSelectedButton){
			rand=(int)(Math.random()*button.length);
		}
		ButtonInterfaceTracey b = button[rand];
		lastSelectedButton = rand;
		return new Random(b);
	}

	private ProgressInterfaceTracey getProgress() {
		/**
		Placeholder until partner finishes implementation of ProgressInterface
		*/
		return null;
	}

	private void addButtons(ArrayList<Visible> viewObjects) {
		int numberOfButtons = 6;
		button = new ButtonInterfaceTracey[numberOfButtons];
		Color[] colors = {Color.blue, Color.red, Color.black, Color.cyan, Color.green, Color.orange};
		for(int i=0; i<numberOfButtons; i++){
			button[i] = getAButton();//create the button, modified by partner
			button[i].setColor(colors[i]);
			button[i].setX(160+(int)(100*Math.cos(i*2*Math.PI/(numberOfButtons))));
			button[i].setY(250-(int)(100*Math.sin(i*2*Math.PI/(numberOfButtons))));
			final ButtonInterfaceTracey b = button[i];
			b.dim();
			b.setAction(new Action(){
				public void act(){
					if(acceptingInput && sequence.get(sequenceIndex).getButton() == b){
						sequenceIndex++;
					}else if(acceptingInput){
						progress.gameOver();
						return;
					}
					
					if(sequenceIndex == sequence.size()){
						Thread nextRound = new Thread(SimonScreenTracey.this);
						nextRound.start();
					}
				}
			});
			Thread blink = new Thread(new Runnable(){

				public void run() {
					b.highlight();
					try {
						Thread.sleep(400);
					}catch(InterruptedException e) {
						e.printStackTrace();
					}
					b.dim();
				}

			});
			viewObjects.add(button[i]);
			
		}
	}

	private ButtonInterfaceTracey getAButton() {
		return new SimonButton();
	}
	
}
