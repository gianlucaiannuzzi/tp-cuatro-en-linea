package juego;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * Acción ejecutada al presionar un botón para soltar una ficha en 
 * una columna determinada.
 * 
 */
public class SoltarFicha implements EventHandler<ActionEvent> {

	private Tablero tablero;
	private CuatroEnLinea juego;
	private int columna;

	/**
	 * post: asocia la acción de soltar una ficha en el juego 'cuatroEnLinea' en la 
	 * 		 columna 'columnaSeleccionada' del tablero 'tableroCuatroEnLinea'.
	 * 
	 * @param tableroCuatroEnLinea
	 * @param cuatroEnLinea
	 * @param columnaSeleccionada
	 */
	public SoltarFicha(Tablero tableroCuatroEnLinea, CuatroEnLinea cuatroEnLinea, int columnaSeleccionada) {

		tablero = tableroCuatroEnLinea;
		juego = cuatroEnLinea; 
		columna = columnaSeleccionada;
	}

	@Override
	public void handle(ActionEvent evento) {

		juego.soltarFicha(columna);
		
		tablero.dibujar();
		
		if (juego.termino()) {
			
			tablero.mostrarResultado();
		}
	}
}
