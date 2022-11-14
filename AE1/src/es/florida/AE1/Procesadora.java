package es.florida.AE1;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Procesadora {

	static int limite = 0;
	static double tiempoTotal;

	/**
	 * Método principal. Recoge por argumentos los tipos de croqueta indicados en la
	 * interfaz y se los añadimos a una lista que será nuestro pedido. Obtiene tipo
	 * recorriendo la lista y después inicializa los hilos pasandole a HiloCroqueta
	 * el tipo de croqueta a cocinar. Al final comprueba el tiempo que ha tardado la
	 * ejecución.
	 * 
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		long inicioEjecucion = System.currentTimeMillis();

		int tipoJamon = Integer.parseInt(args[0]);
		int tipoPollo = Integer.parseInt(args[1]);
		int tipoBacalao = Integer.parseInt(args[2]);
		int tipoQueso = Integer.parseInt(args[3]);

		ArrayList<Integer> listaCroquetas = new ArrayList<Integer>();
		listaCroquetas.add(tipoJamon);
		listaCroquetas.add(tipoPollo);
		listaCroquetas.add(tipoBacalao);
		listaCroquetas.add(tipoQueso);

		for (int i = 0; i < listaCroquetas.size(); i++) {
			int tipo = i;

			for (int j = 0; j < listaCroquetas.get(i); j++) {
				while (limite == 100) {
					Thread.sleep(3000);
				}
				HiloCroqueta objetoCroqueta = new HiloCroqueta(tipo);
				Thread hiloCroqueta = new Thread(objetoCroqueta);
				limite++;
				hiloCroqueta.start();
			}
		}

		while (limite != 0) {
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		long finEjecucion = System.currentTimeMillis();
		tiempoTotal = (double) ((finEjecucion - inicioEjecucion) / 1000);
		System.out.println("\n Tiempo total de ejecucion " + tiempoTotal);
		JOptionPane.showMessageDialog(null, "TIEMPO DE ACTIVIDAD CROQUETERA " + tiempoTotal + " segundos");
	}
}
