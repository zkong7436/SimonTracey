package SimonTr;

import guiPractice.GUIApplication;

public class SimonGameTracey extends GUIApplication {

	public SimonGameTracey() {
		super();
	}

	@Override
	protected void initScreen() {
		SimonScreenTracey sim = new SimonScreenTracey(getWidth(), getHeight());
		setScreen(sim);
	}

	public static void main(String[] args) {
		SimonGameTracey game = new SimonGameTracey();
		Thread app = new Thread(game);
		app.start();
	}

}
