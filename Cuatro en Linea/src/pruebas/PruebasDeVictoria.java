package pruebas;

import static org.junit.Assert.*;
import juego.Casillero;
import juego.CuatroEnLinea;

import org.junit.Test;

public class PruebasDeVictoria {

	@Test
	public void PruebaComprobarCasillerosLlenos() {
		CuatroEnLinea nuevoJuego = new CuatroEnLinea(5, 10, "Jugador 1", "Jugador 2");
		for(int i = 1; i <= nuevoJuego.contarFilas(); i++){
			for(int j = 1; j <= nuevoJuego.contarColumnas(); j++) {
				nuevoJuego.soltarFicha(j);
			}
		}
		assertTrue(nuevoJuego.termino());
	}
	
	@Test
	public void PruebaComprobarVictoriaVertical1() {
		CuatroEnLinea nuevoJuego = new CuatroEnLinea(5, 10, "Jugador 1", "Jugador 2");
		for(int i = 1; i <= 4; i++) {
			nuevoJuego.soltarFicha(1);
			nuevoJuego.soltarFicha(2);
		}
		assertTrue(nuevoJuego.termino());
	}
	
	@Test
	public void PruebaComprobarVictoriaVertical2() {
		CuatroEnLinea nuevoJuego = new CuatroEnLinea(5, 10, "Jugador 1", "Jugador 2");
		for(int i = 1; i <= 4; i++) {
			nuevoJuego.soltarFicha(10);
			nuevoJuego.soltarFicha(7);
		}
		assertTrue(nuevoJuego.termino());
	} 
	
	@Test
	public void PruebaComprobarVictoriaVertical3() {
		CuatroEnLinea nuevoJuego = new CuatroEnLinea(5, 10, "Jugador 1", "Jugador 2");
		for(int i = 1; i <= 4; i++) {
			nuevoJuego.soltarFicha(3);
			nuevoJuego.soltarFicha(1);
		}
		assertTrue(nuevoJuego.termino());
	} 
	
	@Test
	public void PruebaComprobarVictoriaVertical4() {
		CuatroEnLinea nuevoJuego = new CuatroEnLinea(5, 10, "Jugador 1", "Jugador 2");
		for(int i = 1; i <= 4; i++) {
			nuevoJuego.soltarFicha(8);
			nuevoJuego.soltarFicha(3);
		}
		assertTrue(nuevoJuego.termino());
	} 
	
	@Test
	public void PruebaComprobarVictoriaVertical5() {
		CuatroEnLinea nuevoJuego = new CuatroEnLinea(5, 10, "Jugador 1", "Jugador 2");
		for(int i = 1; i <= 4; i++) {
			nuevoJuego.soltarFicha(5);
			nuevoJuego.soltarFicha(1);
		}
		assertTrue(nuevoJuego.termino());
	} 

	@Test
	public void PruebaComprobarVictoriaHorizontal1() {
		CuatroEnLinea nuevoJuego = new CuatroEnLinea(5, 10, "Jugador 1", "Jugador 2");
		for(int i = 1; i <= 4; i++) {
			nuevoJuego.soltarFicha(i);
			nuevoJuego.soltarFicha(((int)Math.random() * 10) + 5);
		}
		assertTrue(nuevoJuego.termino());
	}
	
	@Test
	public void PruebaComprobarVictoriaHorizontal2() {
		CuatroEnLinea nuevoJuego = new CuatroEnLinea(5, 10, "Jugador 1", "Jugador 2");
		for(int i = 1; i <= 4; i++) {
			nuevoJuego.soltarFicha(i);
			nuevoJuego.soltarFicha(5);
		}
		assertTrue(nuevoJuego.termino());
	}
	
	@Test
	public void PruebaComprobarVictoriaHorizontal3() {
		CuatroEnLinea nuevoJuego = new CuatroEnLinea(5, 10, "Jugador 1", "Jugador 2");
		for(int i = 4; i >= 1; i--) {
			nuevoJuego.soltarFicha(i + 1);
			nuevoJuego.soltarFicha(7);
		}
		assertTrue(nuevoJuego.termino());
	}
	
	@Test
	public void PruebaComprobarVictoriaHorizontal4() {
		CuatroEnLinea nuevoJuego = new CuatroEnLinea(5, 10, "Jugador 1", "Jugador 2");
		for(int i = 1; i <= 4; i++) {
			nuevoJuego.soltarFicha(i + 2);
			nuevoJuego.soltarFicha(7);
		}
		assertTrue(nuevoJuego.termino());
	}
	
	@Test
	public void PruebaComprobarVictoriaHorizontal5() {
		CuatroEnLinea nuevoJuego = new CuatroEnLinea(5, 10, "Jugador 1", "Jugador 2");
		for(int i = 1; i <= 4; i++) {
			nuevoJuego.soltarFicha(i + 3);
			nuevoJuego.soltarFicha(10);
		}
		assertTrue(nuevoJuego.termino());
	}
	
	@Test
	public void PruebaComprobarVictoriaHorizontal6() {
		CuatroEnLinea nuevoJuego = new CuatroEnLinea(5, 10, "Jugador 1", "Jugador 2");
		for(int i = 1; i <= 4; i++) {
			nuevoJuego.soltarFicha(10 - i);
			nuevoJuego.soltarFicha(2);
		}
		assertTrue(nuevoJuego.termino());
	}
	
	@Test
	public void PruebaComprobarVictoriaHorizontal7() {
		CuatroEnLinea nuevoJuego = new CuatroEnLinea(5, 10, "Jugador 1", "Jugador 2");
		for(int i = 1; i <= 4; i++) {
			nuevoJuego.soltarFicha(8 - i);
			nuevoJuego.soltarFicha(2);
		}
		assertTrue(nuevoJuego.termino());
	}
	
	@Test
	public void PruebaComprobarVictoriaHorizontal8() {
		CuatroEnLinea nuevoJuego = new CuatroEnLinea(5, 10, "Jugador 1", "Jugador 2");
		for(int i = 1; i <= 4; i++) {
			nuevoJuego.soltarFicha(5 - i);
			nuevoJuego.soltarFicha(10);
		}
		assertTrue(nuevoJuego.termino());
	}
	
	@Test
	public void PruebaComprobarVictoriaHorizontal9() {
		CuatroEnLinea nuevoJuego = new CuatroEnLinea(5, 10, "Jugador 1", "Jugador 2");
		for(int i = 1; i <= 4; i++) {
			nuevoJuego.soltarFicha(7 - i);
			nuevoJuego.soltarFicha(9);
		}
		assertTrue(nuevoJuego.termino());
	}
	
	@Test
	public void PruebaComprobarVictoriaHorizontal10() {
		CuatroEnLinea nuevoJuego = new CuatroEnLinea(5, 10, "Jugador 1", "Jugador 2");
		for(int i = 1; i <= 4; i++) {
			nuevoJuego.soltarFicha(9 - i);
			nuevoJuego.soltarFicha(4);
		}
		assertTrue(nuevoJuego.termino());
	}
	
	@Test
	public void PruebaComprobarVictoriaDiagonal1() {
		CuatroEnLinea nuevoJuego = new CuatroEnLinea(5, 10, "Jugador 1", "Jugador 2");
		nuevoJuego.soltarFicha(1);
		nuevoJuego.soltarFicha(2);
		nuevoJuego.soltarFicha(2);
		nuevoJuego.soltarFicha(4);
		nuevoJuego.soltarFicha(4);
		nuevoJuego.soltarFicha(4);
		nuevoJuego.soltarFicha(4);
		nuevoJuego.soltarFicha(3);
		nuevoJuego.soltarFicha(5);
		nuevoJuego.soltarFicha(3);
		nuevoJuego.soltarFicha(3);
		assertTrue(nuevoJuego.termino());
	}
	
	@Test
	public void PruebaComprobarVictoriaDiagonal2() {
		CuatroEnLinea nuevoJuego = new CuatroEnLinea(5, 10, "Jugador 1", "Jugador 2");
		nuevoJuego.soltarFicha(3);
		nuevoJuego.soltarFicha(4);
		nuevoJuego.soltarFicha(4);
		nuevoJuego.soltarFicha(6);
		nuevoJuego.soltarFicha(6);
		nuevoJuego.soltarFicha(6);
		nuevoJuego.soltarFicha(6);
		nuevoJuego.soltarFicha(5);
		nuevoJuego.soltarFicha(8);
		nuevoJuego.soltarFicha(5);
		nuevoJuego.soltarFicha(5);
		assertTrue(nuevoJuego.termino());
	}
	
	@Test
	public void PruebaComprobarVictoriaDiagonal3() {
		CuatroEnLinea nuevoJuego = new CuatroEnLinea(5, 10, "Jugador 1", "Jugador 2");
		nuevoJuego.soltarFicha(6);
		nuevoJuego.soltarFicha(7);
		nuevoJuego.soltarFicha(7);
		nuevoJuego.soltarFicha(9);
		nuevoJuego.soltarFicha(9);
		nuevoJuego.soltarFicha(9);
		nuevoJuego.soltarFicha(9);
		nuevoJuego.soltarFicha(8);
		nuevoJuego.soltarFicha(1);
		nuevoJuego.soltarFicha(8);
		nuevoJuego.soltarFicha(8);
		assertTrue(nuevoJuego.termino());
	}
	
	@Test
	public void PruebaComprobarVictoriaDiagonal4() {
		CuatroEnLinea nuevoJuego = new CuatroEnLinea(5, 10, "Jugador 1", "Jugador 2");
		nuevoJuego.soltarFicha(10);
		nuevoJuego.soltarFicha(9);
		nuevoJuego.soltarFicha(9);
		nuevoJuego.soltarFicha(7);
		nuevoJuego.soltarFicha(7);
		nuevoJuego.soltarFicha(7);
		nuevoJuego.soltarFicha(7);
		nuevoJuego.soltarFicha(8);
		nuevoJuego.soltarFicha(8);
		nuevoJuego.soltarFicha(6);
		nuevoJuego.soltarFicha(8);
		assertTrue(nuevoJuego.termino());
	}
	
	@Test
	public void PruebaComprobarVictoriaDiagonal5() {
		CuatroEnLinea nuevoJuego = new CuatroEnLinea(5, 10, "Jugador 1", "Jugador 2");
		nuevoJuego.soltarFicha(2);
		nuevoJuego.soltarFicha(2);
		nuevoJuego.soltarFicha(4);
		nuevoJuego.soltarFicha(4);
		nuevoJuego.soltarFicha(4);
		nuevoJuego.soltarFicha(4);
		nuevoJuego.soltarFicha(3);
		nuevoJuego.soltarFicha(5);
		nuevoJuego.soltarFicha(3);
		nuevoJuego.soltarFicha(3);
		nuevoJuego.soltarFicha(1);
		assertTrue(nuevoJuego.termino());
	}

	@Test
	public void PruebaComprobarVictoriaDiagonal6() {
		CuatroEnLinea nuevoJuego = new CuatroEnLinea(5, 10, "Jugador 1", "Jugador 2");
		nuevoJuego.soltarFicha(9);
		nuevoJuego.soltarFicha(9);
		nuevoJuego.soltarFicha(7);
		nuevoJuego.soltarFicha(7);
		nuevoJuego.soltarFicha(7);
		nuevoJuego.soltarFicha(7);
		nuevoJuego.soltarFicha(8);
		nuevoJuego.soltarFicha(8);
		nuevoJuego.soltarFicha(6);
		nuevoJuego.soltarFicha(8);
		nuevoJuego.soltarFicha(10);
		assertTrue(nuevoJuego.termino());
	}
	
	@Test
	public void PruebaComprobarVictoriaDiagonal7() {
		CuatroEnLinea nuevoJuego = new CuatroEnLinea(5, 10, "Jugador 1", "Jugador 2");
		nuevoJuego.soltarFicha(1);
		nuevoJuego.soltarFicha(2);
		nuevoJuego.soltarFicha(2);
		nuevoJuego.soltarFicha(4);
		nuevoJuego.soltarFicha(4);
		nuevoJuego.soltarFicha(4);
		nuevoJuego.soltarFicha(4);
		nuevoJuego.soltarFicha(3);
		nuevoJuego.soltarFicha(8);
		nuevoJuego.soltarFicha(3);
		nuevoJuego.soltarFicha(3);
		assertTrue(nuevoJuego.termino());
	}
	
	@Test
	public void PruebaComprobarVictoriaDiagonal8() {
		CuatroEnLinea nuevoJuego = new CuatroEnLinea(5, 10, "Jugador 1", "Jugador 2");
		nuevoJuego.soltarFicha(1);
		nuevoJuego.soltarFicha(2);
		nuevoJuego.soltarFicha(2);
		nuevoJuego.soltarFicha(4);
		nuevoJuego.soltarFicha(4);
		nuevoJuego.soltarFicha(4);
		nuevoJuego.soltarFicha(4);
		nuevoJuego.soltarFicha(3);
		nuevoJuego.soltarFicha(8);
		nuevoJuego.soltarFicha(3);
		nuevoJuego.soltarFicha(3);
		assertTrue(nuevoJuego.termino());
	}
	
	@Test
	public void PruebaComprobarVictoriaDiagonal9() {
		CuatroEnLinea nuevoJuego = new CuatroEnLinea(5, 10, "Jugador 1", "Jugador 2");
		nuevoJuego.soltarFicha(1);
		nuevoJuego.soltarFicha(2);
		nuevoJuego.soltarFicha(2);
		nuevoJuego.soltarFicha(4);
		nuevoJuego.soltarFicha(4);
		nuevoJuego.soltarFicha(4);
		nuevoJuego.soltarFicha(4);
		nuevoJuego.soltarFicha(3);
		nuevoJuego.soltarFicha(8);
		nuevoJuego.soltarFicha(3);
		nuevoJuego.soltarFicha(3);
		assertTrue(nuevoJuego.termino());
	}
	
	@Test
	public void PruebaComprobarVictoriaDiagonal10() {
		CuatroEnLinea nuevoJuego = new CuatroEnLinea(5, 10, "Jugador 1", "Jugador 2");
		nuevoJuego.soltarFicha(4);
		nuevoJuego.soltarFicha(3);
		nuevoJuego.soltarFicha(3);
		nuevoJuego.soltarFicha(1);
		nuevoJuego.soltarFicha(1);
		nuevoJuego.soltarFicha(1);
		nuevoJuego.soltarFicha(1);
		nuevoJuego.soltarFicha(2);
		nuevoJuego.soltarFicha(2);
		nuevoJuego.soltarFicha(7);
		nuevoJuego.soltarFicha(2);
		assertTrue(nuevoJuego.termino());
	}
	
	
	@Test
	public void PruebaObtenerGanador() {
		CuatroEnLinea nuevoJuego = new CuatroEnLinea(5, 10, "Jugador 1", "Jugador 2");
		for(int i = 1; i <= 4; i++) {
			nuevoJuego.soltarFicha(1);
			nuevoJuego.soltarFicha(((int)Math.random() * 10) + 2);
		}
		String jugadorGanador;
		if(nuevoJuego.obtenerJugadorActual() == Casillero.ROJO) {
			jugadorGanador = "Jugador 2";
		} else {
			jugadorGanador = "Jugador 1";
		}
		assertEquals(jugadorGanador, nuevoJuego.obtenerGanador());
	}
	
	@Test
	public void PruebaObtenerGanador2() {
		CuatroEnLinea nuevoJuego = new CuatroEnLinea(5, 10, "Jugador 1", "Jugador 2");
		for(int i = 1; i <= 4; i++) {
			nuevoJuego.soltarFicha(3);
			nuevoJuego.soltarFicha(2);
		}
		String jugadorGanador;
		if(nuevoJuego.obtenerJugadorActual() == Casillero.ROJO) {
			jugadorGanador = "Jugador 2";
		} else {
			jugadorGanador = "Jugador 1";
		}
		assertEquals(jugadorGanador, nuevoJuego.obtenerGanador());
	}
	
	@Test
	public void PruebaObtenerGanador3() {
		CuatroEnLinea nuevoJuego = new CuatroEnLinea(5, 10, "Jugador 1", "Jugador 2");
		for(int i = 1; i <= 4; i++) {
			nuevoJuego.soltarFicha(1);
			nuevoJuego.soltarFicha(8);
		}
		String jugadorGanador;
		if(nuevoJuego.obtenerJugadorActual() == Casillero.ROJO) {
			jugadorGanador = "Jugador 2";
		} else {
			jugadorGanador = "Jugador 1";
		}
		assertEquals(jugadorGanador, nuevoJuego.obtenerGanador());
	}
	
	@Test
	public void PruebaObtenerGanador4() {
		CuatroEnLinea nuevoJuego = new CuatroEnLinea(5, 10, "Jugador 1", "Jugador 2");
		for(int i = 1; i <= 4; i++) {
			nuevoJuego.soltarFicha(6);
			nuevoJuego.soltarFicha(2);
		}
		String jugadorGanador;
		if(nuevoJuego.obtenerJugadorActual() == Casillero.ROJO) {
			jugadorGanador = "Jugador 2";
		} else {
			jugadorGanador = "Jugador 1";
		}
		assertEquals(jugadorGanador, nuevoJuego.obtenerGanador());
	}
	
	@Test
	public void PruebaObtenerGanador5() {
		CuatroEnLinea nuevoJuego = new CuatroEnLinea(5, 10, "Jugador 1", "Jugador 2");
		for(int i = 1; i <= 4; i++) {
			nuevoJuego.soltarFicha(9);
			nuevoJuego.soltarFicha(5);
		}
		String jugadorGanador;
		if(nuevoJuego.obtenerJugadorActual() == Casillero.ROJO) {
			jugadorGanador = "Jugador 2";
		} else {
			jugadorGanador = "Jugador 1";
		}
		assertEquals(jugadorGanador, nuevoJuego.obtenerGanador());
	}
}
