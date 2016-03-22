package net.rover;

public class RoverMoveImpl implements IRoverMove {

	private String trajectoire;
	private Integer corner_x;
	private Integer corner_y;

	public RoverMoveImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public Rover roverTravling(Rover rover) {
		Rover roverArrive = rover;
		for (int i = 0; i < trajectoire.length(); i++) {
			switch (trajectoire.charAt(i)) {
			case 'M':
				roverArrive = move(roverArrive);
				break;
			case 'L':
				roverArrive = turnLeft(roverArrive);
				break;
			case 'R':
				roverArrive = turnRight(roverArrive);
				break;
			}
		}
		return roverArrive;
	}

	public Rover move(Rover rover) {
		switch (rover.getDirection()) {
		case 'E':
			if (rover.getX() < corner_x)
				rover.setX(rover.getX() + 1);
			break;
		case 'O':
			if (rover.getX() > 0)
				rover.setX(rover.getX() - 1);
			break;
		case 'N':
			if (rover.getY() < corner_y)
				rover.setY(rover.getY() + 1);
			break;
		case 'S':
			if (rover.getY() > 0)
				rover.setY(rover.getY() - 1);
			break;
		}

		return rover;
	}

	public Rover turnLeft(Rover rover) {
		switch (rover.getDirection()) {
		case 'E':
			rover.setDirection('N');
			break;
		case 'O':
			rover.setDirection('S');
			break;
		case 'N':
			rover.setDirection('O');
			break;
		case 'S':
			rover.setDirection('E');
			break;
		}
		return rover;
	}

	public Rover turnRight(Rover rover) {
		switch (rover.getDirection()) {
		case 'E':
			rover.setDirection('S');
			break;
		case 'O':
			rover.setDirection('N');
			break;
		case 'N':
			rover.setDirection('E');
			break;
		case 'S':
			rover.setDirection('O');
			break;
		}
		return rover;
	}

	public String getTrajectoire() {
		return trajectoire;
	}

	public void setTrajectoire(String trajectoire) {
		this.trajectoire = trajectoire;
	}

	public Integer getCorner_x() {
		return corner_x;
	}

	public void setCorner_x(Integer corner_x) {
		this.corner_x = corner_x;
	}

	public Integer getCorner_y() {
		return corner_y;
	}

	public void setCorner_y(Integer corner_y) {
		this.corner_y = corner_y;
	}

}
