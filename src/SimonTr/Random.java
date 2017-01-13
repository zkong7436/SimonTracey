package SimonTr;

import SimonTr.ButtonInterfaceTracey;

public class Random implements MoveInterfaceTracey {

	@Override
	public ButtonInterfaceTracey getButton() {
		return b;
	}
	
	private ButtonInterfaceTracey b; 
	
	public Random(ButtonInterfaceTracey b) {
		this.b = b;
	}


}
