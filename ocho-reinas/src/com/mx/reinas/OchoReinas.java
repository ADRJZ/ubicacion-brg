package com.mx.reinas;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.text.StyledEditorKit.BoldAction;

public class OchoReinas {

	public static void main(String[] args) {

		Posicion[] reinas = new Posicion[8];

        reinas[0] = new Posicion(1, 1);
		reinas[1] = new Posicion(2, 5);
		reinas[2] = new Posicion(3, 8);
		reinas[3] = new Posicion(4, 6);
		reinas[4] = new Posicion(5, 3);
		reinas[5] = new Posicion(6, 7);
		reinas[6] = new Posicion(7, 2);
		reinas[7] = new Posicion(8, 4);


		ValidarEnLineaRecta(reinas);
		ValidarEnDiagonal(reinas);

	}

	public static void ValidarEnLineaRecta(Posicion[] reinas) {

		boolean isValid = true;
		int i = 0;
		int j = 0;
		while (isValid && i < 8) {
			while (isValid && j < 8) {
				if (j == i) {
					j++;
					continue;
				}
				if (reinas[i].getX() == reinas[j].getX() || reinas[i].getY() == reinas[j].getY()) {
					isValid = false;
				}
				j++;
			}
			i++;
			j = 0;
		}

		System.out.println((isValid) ? "Las reinas NO se atacan entre ellas en linea recta" : "Las reinas SE ATACAN entre ellas en linea recta");

	}

	public static void ValidarEnDiagonal(Posicion[] reinas) {

		boolean isValid = true;
		int i = 0;
		int j = 0;
		int deltaDistance;
		int deltaAltura;
		boolean isRight = true;
		boolean isUp = true;
		Posicion temp = new Posicion(1, 1);
		while (isValid && i < 8) {
			while (isValid && j < 8) {
				if (j == i) {
					j++;
					continue;
				}
				deltaDistance = reinas[i].getX() - reinas[j].getX();
				deltaAltura = reinas[i].getY() - reinas[j].getY();

				isRight = (deltaDistance > 0) ? true : false;
				isUp = (deltaAltura > 0) ? true : false;

				if (isRight && isUp) {
					temp.setX(reinas[i].getX() + deltaDistance);
					temp.setY(reinas[i].getY() + deltaDistance);
				}

				if (isRight && !isUp) {
					temp.setX(reinas[i].getX() + deltaDistance);
					temp.setY(reinas[i].getY() - deltaDistance);
				}

				if (!isRight && isUp) {
					temp.setX(reinas[i].getX() - deltaDistance);
					temp.setY(reinas[i].getY() + deltaDistance);
				}

				if (!isRight && !isUp) {
					temp.setX(reinas[i].getX() - deltaDistance);
					temp.setY(reinas[i].getY() - deltaDistance);
				}

				if (temp.getX() == reinas[j].getX() && temp.getY() == reinas[j].getY())
					isValid = false;

				j++;
			}
			i++;
			j = 0;
		}

		System.out.println((isValid) ? "Las reinas NO se atacan entre ellas en Diagonal" : "Las reinas SE ATACAN entre ellas en Diagonal");

	}
}

/**
		Posiciones validas para que las reinas no se ataquen.
		
		reinas[0] = new Posicion(1, 8);
		reinas[1] = new Posicion(2, 2);
		reinas[2] = new Posicion(3, 4);
		reinas[3] = new Posicion(4, 1);
		reinas[4] = new Posicion(5, 7);
		reinas[5] = new Posicion(6, 5);
		reinas[6] = new Posicion(7, 3);
		reinas[7] = new Posicion(8, 6);


        reinas[0] = new Posicion(1, 6);
		reinas[1] = new Posicion(2, 4);
		reinas[2] = new Posicion(3, 7);
		reinas[3] = new Posicion(4, 1);
		reinas[4] = new Posicion(5, 8);
		reinas[5] = new Posicion(6, 2);
		reinas[6] = new Posicion(7, 5);
		reinas[7] = new Posicion(8, 3);

        reinas[0] = new Posicion(1, 5);
		reinas[1] = new Posicion(2, 7);
		reinas[2] = new Posicion(3, 1);
		reinas[3] = new Posicion(4, 4);
		reinas[4] = new Posicion(5, 2);
		reinas[5] = new Posicion(6, 8);
		reinas[6] = new Posicion(7, 6);
		reinas[7] = new Posicion(8, 3);

        reinas[0] = new Posicion(1, 1);
		reinas[1] = new Posicion(2, 5);
		reinas[2] = new Posicion(3, 8);
		reinas[3] = new Posicion(4, 6);
		reinas[4] = new Posicion(5, 3);
		reinas[5] = new Posicion(6, 7);
		reinas[6] = new Posicion(7, 2);
		reinas[7] = new Posicion(8, 4);

		Posiciones donde NO Se atacan en recta pero SI en diagonal
	
        reinas[0] = new Posicion(1, 1);
		reinas[1] = new Posicion(2, 2);
		reinas[2] = new Posicion(3, 3);
		reinas[3] = new Posicion(4, 4);
		reinas[4] = new Posicion(5, 5);
		reinas[5] = new Posicion(6, 6);
		reinas[6] = new Posicion(7, 7);
		reinas[7] = new Posicion(8, 8);
 
 		Posiciones donde se atacan en El linea recta  pero no en Diagonal
 		
 		
 		reinas[0] = new Posicion(1, 5);
		reinas[1] = new Posicion(2, 7);
		reinas[2] = new Posicion(3, 1);
		reinas[3] = new Posicion(4, 4);
		reinas[4] = new Posicion(5, 2);
		reinas[5] = new Posicion(6, 8);
		reinas[6] = new Posicion(7, 6);
		reinas[7] = new Posicion(8, 3);
 
 
 */






