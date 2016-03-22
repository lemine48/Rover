package net.rover;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Rover rover = new Rover();

		/*
		 * Deux fichiers à lire
		 */
		try {

			/*
			 * Lecture du fichier qui contient le nom de la classe fille utilisée
			 * pour instancier un objet de type IRoverMover
			 */
			Scanner config = new Scanner(new File("config.txt"));

			/*
			 * Instanciation d'un objet de type IRoverMove
			 */
			String roverClassName = config.nextLine();
			Class roverClass = Class.forName(roverClassName);
			IRoverMove roverMove = (IRoverMove) roverClass.newInstance();

			/*
			 * Lecture de données
			 */
			Scanner input = new Scanner(new File("input.txt"));
			/*
			 * the upper-right coordinates
			 */
			String corners = input.nextLine();
			corners = corners.replace(" ", "");
			Integer corners_x = Integer.parseInt("" + corners.charAt(0));
			Integer corners_y = Integer.parseInt("" + corners.charAt(1));

			// Parcourir le ficher de données
			while (input.hasNextLine()) {

				/*
				 * La lecture et l'injection des cordonées de départ
				 */
				String attributRover = input.nextLine();
				attributRover = attributRover.replaceAll(" ", "");
				int x = Integer.parseInt("" + attributRover.charAt(0));
				int y = Integer.parseInt("" + attributRover.charAt(1));

				rover.setX(x);
				rover.setY(y);
				rover.setDirection(attributRover.charAt(2));

				/*
				 * La lecture et l'injection de la trajectoire à parcourir
				 */
				String trajectoire = input.nextLine();
				Method m = roverClass.getDeclaredMethod("setTrajectoire", new Class[] { String.class });
				m.invoke(roverMove, trajectoire);

				/*
				 * Injection des coordonnées maximum
				 */
				m = roverClass.getDeclaredMethod("setCorner_x", new Class[] { Integer.class });
				m.invoke(roverMove, corners_x);

				m = roverClass.getDeclaredMethod("setCorner_y", new Class[] { Integer.class });
				m.invoke(roverMove, corners_y);

				/*
				 * Parcourir la trajectoire fournie
				 */

				m = roverClass.getDeclaredMethod("roverTravling", new Class[] { Rover.class });
				rover = (Rover) m.invoke(roverMove, rover);

				System.out.println(rover);
			}

		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

}
