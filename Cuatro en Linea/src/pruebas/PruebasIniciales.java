package pruebas;

import static org.junit.Assert.*;
import org.junit.Test;
import juego.CuatroEnLinea;

public class PruebasIniciales {
	
	//Pruebas con filas.
	@Test (expected = Error.class)
	public void PruebaIniciarJuegoConFilaNegativa() {
		new CuatroEnLinea(-5, 5, "Jugador 1", "Jugador 2");
	}
	
	@Test (expected = Error.class)
	public void PruebaIniciarJuegoConFilaCero() {
		new CuatroEnLinea(0, 5, "Jugador 1", "Jugador 2");
	}
	
	@Test (expected = Error.class)
	public void PruebaIniciarJuegoConFilaUno() {
		new CuatroEnLinea(1, 5, "Jugador 1", "Jugador 2");
	}
	
	@Test (expected = Error.class)
	public void PruebaIniciarJuegoConFilaDos() {
		new CuatroEnLinea(2, 5, "Jugador 1", "Jugador 2");
	}
	
	@Test (expected = Error.class)
	public void PruebaIniciarJuegoConFilaTres() {
		new CuatroEnLinea(3, 5, "Jugador 1", "Jugador 2");
	}

	@Test
	public void PruebaIniciarJuegoConFilaCuatro() {
		CuatroEnLinea nuevoJuego = new CuatroEnLinea(4, 5, "Jugador 1", "Jugador 2");
		assertEquals(4, nuevoJuego.contarFilas());
	}
	
	@Test
	public void PruebaIniciarJuegoConFilaCinco() {
		CuatroEnLinea nuevoJuego = new CuatroEnLinea(5, 5, "Jugador 1", "Jugador 2");
		assertEquals(5, nuevoJuego.contarFilas());
	}
	
	@Test
	public void PruebaIniciarJuegoConFilaSeis() {
		CuatroEnLinea nuevoJuego = new CuatroEnLinea(6, 5, "Jugador 1", "Jugador 2");
		assertEquals(6, nuevoJuego.contarFilas());
	}
	
	@Test
	public void PruebaIniciarJuegoConFilaSiete() {
		CuatroEnLinea nuevoJuego = new CuatroEnLinea(7, 5, "Jugador 1", "Jugador 2");
		assertEquals(7, nuevoJuego.contarFilas());
	}
	
	@Test
	public void PruebaIniciarJuegoConFilaOcho() {
		CuatroEnLinea nuevoJuego = new CuatroEnLinea(8, 5, "Jugador 1", "Jugador 2");
		assertEquals(8, nuevoJuego.contarFilas());
	}
	
	@Test
	public void PruebaIniciarJuegoConFilaNueve() {
		CuatroEnLinea nuevoJuego = new CuatroEnLinea(9, 5, "Jugador 1", "Jugador 2");
		assertEquals(9, nuevoJuego.contarFilas());
	}
	
	@Test
	public void PruebaIniciarJuegoConFilaDiez() {
		CuatroEnLinea nuevoJuego = new CuatroEnLinea(10, 5, "Jugador 1", "Jugador 2");
		assertEquals(10, nuevoJuego.contarFilas());
	}
	
	//Pruebas con columnas.
	@Test (expected = Error.class)
	public void PruebaIniciarJuegoConColumnaNegativa() {
		new CuatroEnLinea(5, -5, "Jugador 1", "Jugador 2");
	}
	
	@Test (expected = Error.class)
	public void PruebaIniciarJuegoConColumnaCero() {
		new CuatroEnLinea(5, 0, "Jugador 1", "Jugador 2");
	}
	
	@Test (expected = Error.class)
	public void PruebaIniciarJuegoConColumnaUno() {
		new CuatroEnLinea(5, 1, "Jugador 1", "Jugador 2");
	}
	
	@Test (expected = Error.class)
	public void PruebaIniciarJuegoConColumnaDos() {
		new CuatroEnLinea(5, 2, "Jugador 1", "Jugador 2");
	}
	
	@Test (expected = Error.class)
	public void PruebaIniciarJuegoConColumnaTres() {
		new CuatroEnLinea(5, 3, "Jugador 1", "Jugador 2");
	}
	
	@Test
	public void PruebaIniciarJuegoConColumnaCuatro() {
		CuatroEnLinea nuevoJuego = new CuatroEnLinea(5, 4, "Jugador 1", "Jugador 2");
		assertEquals(4, nuevoJuego.contarColumnas());
	}
	
	@Test
	public void PruebaIniciarJuegoConColumnaCinco() {
		CuatroEnLinea nuevoJuego = new CuatroEnLinea(5, 5, "Jugador 1", "Jugador 2");
		assertEquals(5, nuevoJuego.contarColumnas());
	}
	
	@Test
	public void PruebaIniciarJuegoConColumnaSeis() {
		CuatroEnLinea nuevoJuego = new CuatroEnLinea(5, 6, "Jugador 1", "Jugador 2");
		assertEquals(6, nuevoJuego.contarColumnas());
	}
	
	@Test
	public void PruebaIniciarJuegoConColumnaSiete() {
		CuatroEnLinea nuevoJuego = new CuatroEnLinea(5, 7, "Jugador 1", "Jugador 2");
		assertEquals(7, nuevoJuego.contarColumnas());
	}
	
	@Test
	public void PruebaIniciarJuegoConColumnaOcho() {
		CuatroEnLinea nuevoJuego = new CuatroEnLinea(5, 8, "Jugador 1", "Jugador 2");
		assertEquals(8, nuevoJuego.contarColumnas());
	}
	
	@Test
	public void PruebaIniciarJuegoConColumnaNueve() {
		CuatroEnLinea nuevoJuego = new CuatroEnLinea(5, 9, "Jugador 1", "Jugador 2");
		assertEquals(9, nuevoJuego.contarColumnas());
	}
	
	@Test
	public void PruebaIniciarJuegoConColumnaDiez() {
		CuatroEnLinea nuevoJuego = new CuatroEnLinea(5, 10, "Jugador 1", "Jugador 2");
		assertEquals(10, nuevoJuego.contarColumnas());
	}
}
