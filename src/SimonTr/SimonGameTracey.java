package SimonTr;

import guiPractice.GuiApplication;
import guiPractice.Screen;

public class SimonGameTracey extends GuiApplication {

	public SimonGameTracey() {
		super();
	}

	@Override
	public void initScreen() {
		SimonScreenTracey sim = new SimonScreenTracey(getWidth(), getHeight());
		setScreen(sim);
	}

	public static void main(String[] args) {
		SimonGameTracey game = new SimonGameTracey();
		Thread app = new Thread(game);
		app.start();
	}

}
