package juego;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class IniciarJuego implements EventHandler<ActionEvent> {

	private Aplicacion aplicacion;
	
	public IniciarJuego(Aplicacion aplicacion) {

		this.aplicacion = aplicacion;
	}

	@Override
	public void handle(ActionEvent event) {

		aplicacion.iniciar();
	}

}
