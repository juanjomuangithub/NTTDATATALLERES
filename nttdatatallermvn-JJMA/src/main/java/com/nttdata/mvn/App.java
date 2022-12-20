package com.nttdata.mvn;

import java.util.Scanner;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

/**
 * 
 * @author Juan Jose Muñoz Ansotegui
 *
 */
public class App {

	public static void main(String[] args) {

		String[] arrayCajas = { "", "", "SORPRESA!!", "", "" };
		int[] numerosIntroducidos = new int[4];
		boolean caja = true;
		String eleccion;
		Scanner keyboard = new Scanner(System.in);

		System.out.println("Vamos a jugar a un juego. Hay cinco cajas [1] [2] [3] [4] [5] y cuatro estan vacias. "
				+ "Tienes que ir eliminando las cajas vacias y dejar para el final la que contiene una sorpresa. ");

		for (int i = 0; i < numerosIntroducidos.length; i++) {

			do {
				System.out.println("Elige numero de caja y despues pulsa enter: "); //Bucle que controla la entrada por teclado.
				eleccion = keyboard.nextLine();
			} while (!eleccion.matches("[1-5]"));

			int numero = Integer.parseInt(eleccion) - 1;

			if (ArrayUtils.contains(numerosIntroducidos, numero + 1)) { //Bucle que controla si la caja introducida ya se ha elegido antes.
				System.out.println("Esa caja ya la has elegido. Selecciona otra.");
				i--;
				continue;
			}

			caja = comprobarCaja(arrayCajas, numero);

			if (caja == true) { //Bucle que controla si la caja introducida esta vacia o contiene la sorpresa.
				numerosIntroducidos[i] = numero + 1;
				System.out.println("Bien!! La caja esta vacia");

			} else {
				System.out.println("Has fallado! Has elegido la que contiene la sorpresa!");
				keyboard.close();
				break;
			}
		}

		if (caja == true) { 
			System.out.println("Enhorabuena!! Has conseguido la " + StringUtils.join(arrayCajas, '*'));
			keyboard.close();
		}

	}
	
	/**
	 * 
	 * Metodo que comprueba si la caja esta vacia
	 * @param caja El array con las cajas.
	 * @param numeroCaja El numero que ha introducido el jugador.
	 * @return Devuelve true o false si la caja esta vacia o tiene la sorpresa
	 */
	public static boolean comprobarCaja(String[] caja, int numeroCaja) {
		return StringUtils.isEmpty(caja[numeroCaja]);
	}
}
