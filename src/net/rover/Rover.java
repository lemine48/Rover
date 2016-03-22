package net.rover;

public class Rover {
	private int x;
	private int y;
	private char direction;

	@Override
	public String toString() {
		return "" + x + " " + y + " " + direction;
	}

	public Rover() {
		super();
		// TODO Auto-generated constructor stub
	}

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

	public char getDirection() {
		return direction;
	}

	public void setDirection(char direction) {
		this.direction = direction;
	}

}
