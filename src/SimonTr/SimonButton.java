package SimonTr;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

import guiPractice.components.Action;
import guiPractice.components.Component;

public class SimonButton extends Component implements ButtonInterfaceTracey {

	private static final int WIDTH = 40;
	private static final int HEIGHT = 40;
	
	private Action action;
	private Color c;
	private Color displayColor;
	private boolean selected;
	private String name;
	
	public SimonButton() {
		super(0, 0, WIDTH, HEIGHT);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isHovered(int x, int y) {
		double distance = Math.sqrt(Math.pow(x-(getX()+WIDTH/2), 2)+Math.pow(y-(getY()+HEIGHT/2), 2));
		return distance < WIDTH/2;
	}

	@Override
	public void act() {
		action.act();
	}

	@Override
	public BufferedImage getImage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getX() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getY() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getWidth() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isAnimated() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub

	}

	@Override
	public ButtonInterfaceTracey getAButton() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setColor(Color color) {
		this.c = color;
		displayColor = c;
		update();
	}

	@Override
	public void setAction(Action a) {
		this.action = a;
	}

	@Override
	public void setX(int x) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setY(int y) {
		// TODO Auto-generated method stub

	}
	
	public void setName(String s){
		this.name = s;
	}
	
	public String toString(){
		return name;
	}

	@Override
	public void highlight() {
		if(c != null) displayColor = c;
		selected = true;
		update();

	}

	@Override
	public void dim() {
		displayColor = Color.gray;
		selected = false;
		update();
	}

	@Override
	public void update(Graphics2D g) {
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		if(displayColor != null){
			g.setColor(displayColor);
		}else
			g.setColor(Color.gray);
			g.fillOval(0, 0, WIDTH, HEIGHT);
			g.setColor(Color.black);
			g.drawOval(0, 0, WIDTH-1, HEIGHT-1);
		if(selected){
			polygonFill(g);
		}
	}
	
	private void polygonFill(Graphics2D g) {
		g.setColor(Color.white);
		Polygon polygon = new Polygon();
		int s = (int)(5/8.0 * WIDTH);
		int t = (int)(1.0/5*HEIGHT)+4;
		polygon.addPoint(s-4, t-4);
		polygon.addPoint(s+7, t-2);
		polygon.addPoint(s+10, t);
		polygon.addPoint(s+14, t+10);
		polygon.addPoint(s+12, t+14);
		polygon.addPoint(s+8, t+3);
		g.fill(polygon);
		
	}

}
