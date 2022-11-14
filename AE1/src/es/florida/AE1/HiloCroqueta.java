package es.florida.AE1;

/**
 * Clase HiloCroqueta implenta Runnable. Permite ejecutar Run. Es la clase en
 * donde se crean las croquetas de la aplicación.
 */
public class HiloCroqueta implements Runnable {

	int tipo = 0;

	int tiempoJamon = 5000;
	int tiempoPollo = 6000;
	int tiempoBacalao = 7000;
	int tiempoQueso = 8000;

	/**
	 * Método constructor. Recibe como parámetro un entero con el tipo de croqueta
	 * que recoge el pedido en la clase Procesadora.
	 * 
	 * @param tipo
	 */
	public HiloCroqueta(int tipo) {
		this.tipo = tipo;
	}

	/**
	 * Método encargado de realizar las croquetas según el tipo. Marcamos un trozo
	 * de códico como synchronized para que la aplicación sea thread safe.
	 * Permitiendo la comunicación entre los hilos para que accedan de forma
	 * sincronizada. Otorga un tiempo de ejecución diferente según el tipo de
	 * croqueta. Imprime por consola un mensaje cuando se crea y finaliza una
	 * croqueta según el tipo requerido.
	 */
	void creaCroqueta() {

		if (tipo == 0) {
			System.out.println("Se ha creado una croqueta de jamon");
			try {
				Thread.sleep(tiempoJamon);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Finaliza creacion croqueta de jamon");
		}
		if (tipo == 1) {
			System.out.println("Se ha creado una croqueta de pollo");
			try {
				Thread.sleep(tiempoPollo);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
			System.out.println("Finaliza creacion croqueta de pollo");
		}
		if (tipo == 2) {
			System.out.println("Se ha creado una croqueta de bacalao");
			try {
				Thread.sleep(tiempoBacalao);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
			System.out.println("Finaliza creacion croqueta de bacalao");
		}
		if (tipo == 3) {
			System.out.println("Se ha creado una croqueta de queso");
			try {
				Thread.sleep(tiempoQueso);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
			System.out.println("Finaliza creacion croqueta de queso");
		}
		synchronized (this) {
			Procesadora.limite--;
		}
	}

	/**
	 * Método Run que ejecutará el método creaCoqueta() generando los hilos según el
	 * tipo de croqueta. Podríamos haber implementado creaCroqueta() directamente en
	 * este método.
	 */
	@Override
	public void run() {
		creaCroqueta();
	}

}
