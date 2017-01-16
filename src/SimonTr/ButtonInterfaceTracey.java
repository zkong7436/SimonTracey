package SimonTr;

import java.awt.Color;
import guiPractice.components.Action;
import guiPractice.components.Clickable;

public interface ButtonInterfaceTracey extends Clickable{
	
	void setColor(Color color);
	void setAction(Action a);
	ButtonInterfaceTracey getAButton();
	void setX(int x);
	void setY(int y);
	void highlight();
	void dim();
	
}
