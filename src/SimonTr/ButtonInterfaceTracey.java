package SimonTr;

import java.awt.Color;

import SimonTr.ButtonInterfaceTracey;
import guiPractice.components.Action;
import guiPractice.components.Clickable;

public interface ButtonInterfaceTracey extends Clickable{
	
	ButtonInterfaceTracey getAButton();
	void setColor(Color color);
	void setAction(Action a);
	void setX(int x);
	void setY(int y);
	void highlight();
	void dim();
		
}
