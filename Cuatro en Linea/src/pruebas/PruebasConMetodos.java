package pruebas;

import static org.junit.Assert.*;

import org.junit.Test;

import juego.Casillero;
import juego.CuatroEnLinea;

public class PruebasConMetodos {

	@Test
	public void PruebaContarFilas1() {
		CuatroEnLinea nuevoJuego = new CuatroEnLinea(5, 10, "Jugador 1", "Jugador 2");
		assertEquals(5, nuevoJuego.contarFilas());
	}
	
	@Test
	public void PruebaContarFilas2() {
		CuatroEnLinea nuevoJuego = new CuatroEnLinea(10, 15, "Jugador 1", "Jugador 2");
		assertEquals(10, nuevoJuego.contarFilas());
	}
	
	@Test
	public void PruebaContarFilas3() {
		CuatroEnLinea nuevoJuego = new CuatroEnLinea(15, 20, "Jugador 1", "Jugador 2");
		assertEquals(15, nuevoJuego.contarFilas());
	}
	
	@Test
	public void PruebaContarFilas4() {
		CuatroEnLinea nuevoJuego = new CuatroEnLinea(20, 25, "Jugador 1", "Jugador 2");
		assertEquals(20, nuevoJuego.contarFilas());
	}
	
	@Test
	public void PruebaContarFilas5() {
		CuatroEnLinea nuevoJuego = new CuatroEnLinea(25, 30, "Jugador 1", "Jugador 2");
		assertEquals(25, nuevoJuego.contarFilas());
	}
	
	@Test
	public void PruebaContarColumnas1() {
		CuatroEnLinea nuevoJuego = new CuatroEnLinea(10, 5, "Jugador 1", "Jugador 2");
		assertEquals(5, nuevoJuego.contarColumnas());
	}
	
	@Test
	public void PruebaContarColumnas2() {
		CuatroEnLinea nuevoJuego = new CuatroEnLinea(15, 10, "Jugador 1", "Jugador 2");
		assertEquals(10, nuevoJuego.contarColumnas());
	}
	
	@Test
	public void PruebaContarColumnas3() {
		CuatroEnLinea nuevoJuego = new CuatroEnLinea(20, 15, "Jugador 1", "Jugador 2");
		assertEquals(15, nuevoJuego.contarColumnas());
	}

	@Test
	public void PruebaContarColumnas4() {
		CuatroEnLinea nuevoJuego = new CuatroEnLinea(25, 20, "Jugador 1", "Jugador 2");
		assertEquals(20, nuevoJuego.contarColumnas());
	}
	
	@Test
	public void PruebaContarColumnas5() {
		CuatroEnLinea nuevoJuego = new CuatroEnLinea(30, 25, "Jugador 1", "Jugador 2");
		assertEquals(25, nuevoJuego.contarColumnas());
	}

	@Test
	public void PruebaObtenerCasilleroVacio() {
		CuatroEnLinea nuevoJuego = new CuatroEnLinea(10, 5, "Jugador 1", "Jugador 2");
		assertSame(Casillero.VACIO, nuevoJuego.obtenerCasillero(5, 5));
	}
	
	@Test
	public void PruebaObtenerCasilleroVacio2() {
		CuatroEnLinea nuevoJuego = new CuatroEnLinea(10, 5, "Jugador 1", "Jugador 2");
		assertSame(Casillero.VACIO, nuevoJuego.obtenerCasillero(10, 5));
	}
	
	@Test
	public void PruebaObtenerCasilleroVacio3() {
		CuatroEnLinea nuevoJuego = new CuatroEnLinea(10, 5, "Jugador 1", "Jugador 2");
		assertSame(Casillero.VACIO, nuevoJuego.obtenerCasillero(2, 4));
	}
	
	@Test
	public void PruebaObtenerCasilleroVacio4() {
		CuatroEnLinea nuevoJuego = new CuatroEnLinea(10, 5, "Jugador 1", "Jugador 2");
		assertSame(Casillero.VACIO, nuevoJuego.obtenerCasillero(1, 4));
	}
	
	@Test
	public void PruebaObtenerCasilleroVacio5() {
		CuatroEnLinea nuevoJuego = new CuatroEnLinea(10, 5, "Jugador 1", "Jugador 2");
		assertSame(Casillero.VACIO, nuevoJuego.obtenerCasillero(7, 1));
	}
	
	@Test
	public void PruebaSoltarFicha1() {
		CuatroEnLinea nuevoJuego = new CuatroEnLinea(10, 5, "Jugador 1", "Jugador 2");
		nuevoJuego.soltarFicha(1);
		assertTrue(nuevoJuego.obtenerCasillero(nuevoJuego.contarFilas(), 1) != Casillero.VACIO);
	}
	
	@Test
	public void PruebaSoltarFicha2() {
		CuatroEnLinea nuevoJuego = new CuatroEnLinea(10, 5, "Jugador 1", "Jugador 2");
		nuevoJuego.soltarFicha(3);
		assertTrue(nuevoJuego.obtenerCasillero(nuevoJuego.contarFilas(), 3) != Casillero.VACIO);
	}
	
	@Test
	public void PruebaSoltarFicha3() {
		CuatroEnLinea nuevoJuego = new CuatroEnLinea(10, 5, "Jugador 1", "Jugador 2");
		nuevoJuego.soltarFicha(5);
		assertTrue(nuevoJuego.obtenerCasillero(nuevoJuego.contarFilas(), 5) != Casillero.VACIO);
	}
	
	@Test
	public void PruebaSoltarFicha4() {
		CuatroEnLinea nuevoJuego = new CuatroEnLinea(10, 5, "Jugador 1", "Jugador 2");
		nuevoJuego.soltarFicha(2);
		assertTrue(nuevoJuego.obtenerCasillero(nuevoJuego.contarFilas(), 2) != Casillero.VACIO);
	}
	
	@Test
	public void PruebaSoltarFicha5() {
		CuatroEnLinea nuevoJuego = new CuatroEnLinea(10, 5, "Jugador 1", "Jugador 2");
		nuevoJuego.soltarFicha(4);
		assertTrue(nuevoJuego.obtenerCasillero(nuevoJuego.contarFilas(), 4) != Casillero.VACIO);
	}
	
	@Test
	public void PruebaSoltarFichaEncimaDeOtra() {
		CuatroEnLinea nuevoJuego = new CuatroEnLinea(10, 5, "Jugador 1", "Jugador 2");
		nuevoJuego.soltarFicha(1);
		nuevoJuego.soltarFicha(1);
		assertTrue(nuevoJuego.obtenerCasillero(nuevoJuego.contarFilas() - 1, 1) != Casillero.VACIO);
	}
	
	@Test
	public void PruebaSoltarFichaEncimaDeOtra2() {
		CuatroEnLinea nuevoJuego = new CuatroEnLinea(10, 5, "Jugador 1", "Jugador 2");
		nuevoJuego.soltarFicha(3);
		nuevoJuego.soltarFicha(3);
		assertTrue(nuevoJuego.obtenerCasillero(nuevoJuego.contarFilas() - 1, 3) != Casillero.VACIO);
	}

	@Test
	public void PruebaSoltarFichaEncimaDeOtra3() {
		CuatroEnLinea nuevoJuego = new CuatroEnLinea(10, 5, "Jugador 1", "Jugador 2");
		nuevoJuego.soltarFicha(2);
		nuevoJuego.soltarFicha(2);
		nuevoJuego.soltarFicha(2);
		assertTrue(nuevoJuego.obtenerCasillero(nuevoJuego.contarFilas() - 2, 2) != Casillero.VACIO);
	}

	@Test
	public void PruebaSoltarFichaEncimaDeOtra4() {
		CuatroEnLinea nuevoJuego = new CuatroEnLinea(10, 5, "Jugador 1", "Jugador 2");
		nuevoJuego.soltarFicha(3);
		nuevoJuego.soltarFicha(3);
		nuevoJuego.soltarFicha(3);
		nuevoJuego.soltarFicha(3);
		assertTrue(nuevoJuego.obtenerCasillero(nuevoJuego.contarFilas() - 3, 3) != Casillero.VACIO);
	}

	@Test
	public void PruebaSoltarFichaEncimaDeOtra5() {
		CuatroEnLinea nuevoJuego = new CuatroEnLinea(10, 5, "Jugador 1", "Jugador 2");
		nuevoJuego.soltarFicha(4);
		nuevoJuego.soltarFicha(4);
		nuevoJuego.soltarFicha(4);
		nuevoJuego.soltarFicha(4);
		nuevoJuego.soltarFicha(4);
		assertTrue(nuevoJuego.obtenerCasillero(nuevoJuego.contarFilas() - 4, 4) != Casillero.VACIO);
	}

	@Test
	public void PruebaSoltarFichaEncimaDeOtra6() {
		CuatroEnLinea nuevoJuego = new CuatroEnLinea(10, 10, "Jugador 1", "Jugador 2");
		nuevoJuego.soltarFicha(8);
		nuevoJuego.soltarFicha(8);
		assertTrue(nuevoJuego.obtenerCasillero(nuevoJuego.contarFilas() - 1, 8) != Casillero.VACIO);
	}
	
	@Test
	public void PruebaSoltarFichaEncimaDeOtra7() {
		CuatroEnLinea nuevoJuego = new CuatroEnLinea(10, 10, "Jugador 1", "Jugador 2");
		nuevoJuego.soltarFicha(5);
		nuevoJuego.soltarFicha(5);
		nuevoJuego.soltarFicha(5);
		nuevoJuego.soltarFicha(5);
		assertTrue(nuevoJuego.obtenerCasillero(nuevoJuego.contarFilas() - 3, 5) != Casillero.VACIO);
	}
	
	@Test
	public void PruebaSoltarFichaEncimaDeOtra8() {
		CuatroEnLinea nuevoJuego = new CuatroEnLinea(10, 10, "Jugador 1", "Jugador 2");
		nuevoJuego.soltarFicha(9);
		nuevoJuego.soltarFicha(9);
		nuevoJuego.soltarFicha(9);
		assertTrue(nuevoJuego.obtenerCasillero(nuevoJuego.contarFilas() - 2, 9) != Casillero.VACIO);
	}
	
	@Test
	public void PruebaSoltarFichaEncimaDeOtra9() {
		CuatroEnLinea nuevoJuego = new CuatroEnLinea(10, 10, "Jugador 1", "Jugador 2");
		nuevoJuego.soltarFicha(10);
		nuevoJuego.soltarFicha(10);
		assertTrue(nuevoJuego.obtenerCasillero(nuevoJuego.contarFilas() - 1, 10) != Casillero.VACIO);
	}
	
	@Test
	public void PruebaSoltarFichaEncimaDeOtra10() {
		CuatroEnLinea nuevoJuego = new CuatroEnLinea(10, 10, "Jugador 1", "Jugador 2");
		nuevoJuego.soltarFicha(2);
		nuevoJuego.soltarFicha(2);
		nuevoJuego.soltarFicha(2);
		nuevoJuego.soltarFicha(2);
		nuevoJuego.soltarFicha(2);
		nuevoJuego.soltarFicha(2);
		assertTrue(nuevoJuego.obtenerCasillero(nuevoJuego.contarFilas() - 5, 2) != Casillero.VACIO);
	}
}
