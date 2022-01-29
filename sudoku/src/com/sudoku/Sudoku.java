package com.sudoku;

public class Sudoku {

	/**
	 * Divide el sudoku en bloques de 3 x 3 y manda a validar cada bloque
	 * 
	 * @param sudoku
	 * @return
	 */
	public static boolean validarBloques(int[][] sudoku) {

		final int TAMANIO = 9;
		boolean isvalid = true;
		int[] bloque = new int[TAMANIO];

		int i = 0;
		int k = 0;
		int n = 0;
		int upsell = 0;

		while (isvalid && i < TAMANIO * TAMANIO) {

			bloque[k] = sudoku[n][(i % 3) + upsell];
//			System.out.print(bloque[k]);
			if (i % 3 == 2) {
//				System.out.println();
				n++;
			}
			if (k == 8) {
				k = -1;
				isvalid = validarBloque(bloque);
			}
			if (n == 9) {
				n = 0;
				upsell += 3;
			}
			k++;
			i++;
		}

		if (isvalid) {
			System.out.println("El sudoku es valido en todas sus filas");
			return isvalid;
		}
		
		System.out.println(" *** El sudoku NO es valido en alguna de sus filas");
		return isvalid;
	}

	/***
	 * Se Valida las lineas horizontales del sudoku. Sunsecciona en bloques de 9 y
	 * los valida.
	 * 
	 * @param sudoku
	 * @return
	 */
	public static boolean validarHotizontalmente(int[][] sudoku) {

		final int TAMANIO = 9;
		boolean isvalid = true;
		int[] bloque = new int[TAMANIO];

		int i = 0;
		int j = 0;

		while (isvalid && i < TAMANIO) {
			while (j < TAMANIO) {
				bloque[j] = sudoku[i][j];
				j++;
			}
			j = 0;
			isvalid = validarBloque(bloque);
			i++;
		}

		if (isvalid) {
			System.out.println("El sudoku es valido en todas sus filas");
			return isvalid;
		}

		System.out.println(" *** El sudoku NO es valido en alguna de sus filas");
		return isvalid;
	}

	/***
	 * Se Valida las lineas Verticalmente del sudoku. Sunsecciona en bloques de 9 y
	 * los valida.
	 * 
	 * @param sudoku
	 * @return
	 */
	public static boolean validarVerticalmente(int[][] sudoku) {

		final int TAMANIO = 9;
		boolean isvalid = true;
		int[] bloque = new int[TAMANIO];

		int i = 0;
		int j = 0;

		while (isvalid && i < TAMANIO) {
			while (j < TAMANIO) {
				bloque[j] = sudoku[j][i];
//				System.out.println(bloque[j]);
				j++;
			}
			isvalid = validarBloque(bloque);
			j = 0;
			i++;
		}

		if (isvalid) {
			System.out.println("El sudoku es valido en todas sus columnas");
			return isvalid;
		}

		System.out.println(" *** El sudoku NO es valido en alguna de sus columnas");
		return isvalid;
	}

	/**
	 * Valida que un bloque de numeros, no tenga repetidos y sus digitos sean del 1
	 * al 9, valida que el bloque sea de 9 numeros.
	 * 
	 * @param bloque
	 * @return
	 */
	public static boolean validarBloque(int[] bloque) {

		boolean isvalid = true;
		int i;
		int j;

		if (bloque.length != 9)
			return false;

		i = 0;
		j = 0;

		while (isvalid && i < bloque.length) {
			if (bloque[i] > 9 || bloque[i] < 1) {
				isvalid = false;
				break;
			}
			while (isvalid && j < bloque.length) {
				if (i == j) {
					break;
				}
				if (bloque[i] == bloque[j])
					isvalid = false;
				j++;
			}
			i++;
			j = 0;
		}
		return isvalid;
	}

}
