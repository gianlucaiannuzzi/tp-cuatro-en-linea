package juego;

/**
 * Juego Cuatro en Lí­nea
 * 
 * Reglas: - Juego para 2 jugadores obligatoriamente.
 * 		   - Cada jugador utilizara fichas de un color(rojo o amarillo) que le quedara para toda la partida.
 *         - Una vez que un jugador tire, le tocara al otro y asi sucesivamente.
 *         - Ganara el que alinee cuatro fichas del mismo color horizontal, vertical, o diagonalmente.
 *         - Si el tablero se llena quedara en empate.
 */
public class CuatroEnLinea {
	
	private Casillero[][] tablero;
	private String nombreRojo;
	private String nombreAmarillo;
	private Casillero jugadorActual;
	private int ultimaFila;
	private int ultimaColumna;
	private Casillero casilleroAComparar;

	/**
	 * pre : 'filas' y 'columnas' son mayores o iguales a 4.
	 * post: empieza el juego entre el jugador que tiene fichas rojas, identificado como 
	 * 		 'jugadorRojo' y el jugador que tiene fichas amarillas, identificado como
	 * 		 'jugadorAmarillo'. 
	 * 		 Todo el tablero está vacío.
	 * 
	 * @param filas : cantidad de filas que tiene el tablero.
	 * @param columnas : cantidad de columnas que tiene el tablero.
	 * @param jugadorRojo : nombre del jugador con fichas rojas.
	 * @param jugadorAmarillo : nombre del jugador con fichas amarillas.
	 */
	public CuatroEnLinea(int filas, int columnas, String jugadorRojo, String jugadorAmarillo) {
		if(filas >= 4) {
			if(columnas >= 4) {
				tablero = new Casillero[filas][columnas];
				for(int fila = 0; fila < tablero.length; fila++) {
					for(int columna = 0; columna < tablero[fila].length; columna++) {
						tablero[fila][columna] = Casillero.VACIO;
					}
				}
				asignarPrimerJugador();
				nombreRojo = jugadorRojo;
				nombreAmarillo = jugadorAmarillo;
			} else {
				throw new Error("La cantidad de columnas debe ser mayor o igual a 4.");
			}
		} else {
			throw new Error("La cantidad de filas a crear debe ser mayor o igual a 4.");
		}
	}
	
	/**
	 * post: asigna aleatoriamente cual sera el jugador que tire la primer ficha de la partida, donde 1 es el jugador que usara las fichas rojas
	 *       y 2 sera el jugador que usara las fichas amarillas.		 
	 */
	private void asignarPrimerJugador() {
		int numeroGanador = (int)(Math.random() * 2) + 1;
		if(numeroGanador == 1) {
			jugadorActual = Casillero.ROJO;
		} else {
			jugadorActual = Casillero.AMARILLO;
		}
	}
	
	/**
	 * post: cambia el jugador actual, que es el que establece el color de la ficha en cada turno.
	 *  	 Si es rojo el ultimo jugador, pasa a ser amarillo, y viceversa. 		 
	 */
	private void cambioDeJugador() {
		if(jugadorActual == Casillero.ROJO) {
			jugadorActual = Casillero.AMARILLO;
		} else {
			jugadorActual = Casillero.ROJO;
		}
	}
	
	/**
	 * post: devuelve la ficha que va a ser tirada en el siguiente turno.		 
	 */
	public Casillero obtenerJugadorActual() {
		return jugadorActual;
	}
	
	/**
	 * post: devuelve la cantidad máxima de fichas que se pueden apilar en el tablero.
	 */
	public int contarFilas() {
		return tablero.length;
	}

	/**
	 * post: devuelve la cantidad máxima de fichas que se pueden alinear en el tablero.
	 */
	public int contarColumnas() {
		return tablero[0].length;
	}

	/**
	 * pre : fila está en el intervalo [1, contarFilas()],
	 * 		 columnas está en el intervalo [1, contarColumnas()].
	 * post: indica qué ocupa el casillero en la posición dada por fila y columna.
	 * 
	 * @param fila
	 * @param columna
	 */
	public Casillero obtenerCasillero(int fila, int columna) {
		if((fila >= 1) && (fila <= contarFilas())){ 
			if((columna >= 1) && (columna <= contarColumnas())) {
				return tablero[fila - 1][columna - 1];
			} else {
				throw new Error("La columna solicitada no pertenece al intervalo [1, contarFilas()]");
			}
		} else {
			throw new Error("La fila solicitada no pertenece al intervalo [1, contarColumnas()]");
		}
	}
	
	/**
	 * pre : el juego no terminó, columna está en el intervalo [1, contarColumnas()]
	 * 		 y aún queda un Casillero.VACIO en la columna indicada. 
	 * post: deja caer una ficha en la columna indicada, almacena el color del ultimo turno para comprobar si este gano
	 * 	     y cambia el color del siguiente jugador.
	 * 
	 * @param columna
	 */
	public void soltarFicha(int columna) {
		boolean continuaJugada = true;
		if(!termino() && (columna >= 1) && (columna <= contarColumnas())) {
			for(int fila = tablero.length - 1; (fila >= 0) && continuaJugada; fila--) {
				if(tablero[fila][columna - 1] == Casillero.VACIO) {
					tablero[fila][columna - 1] = jugadorActual;
					continuaJugada = false;
					ultimaFila = fila;
					ultimaColumna = columna - 1;
					casilleroAComparar = jugadorActual;
					cambioDeJugador();
				}
			}
		}
	}
	
	/**
	 * post: indica si el juego terminó porque uno de los jugadores
	 * 		 ganó o no existen casilleros vacíos.
	 */
	public boolean termino() {
		boolean finDeLaPartida = false;
		if(comprobarSiCasillerosEstanLlenos() || hayGanador()) {
			finDeLaPartida = true;
		}
		return finDeLaPartida;
	}

	/**
	 * post: indica si todos los casilleros se encuentran llenos.
	 *  	 	 
	 */
	private boolean comprobarSiCasillerosEstanLlenos() {
		boolean casillerosLlenos = true;
		for(int fila = 0; fila < tablero.length; fila++) {
			for(int columna = 0; columna < tablero[fila].length; columna++) {
				if(tablero[fila][columna] == Casillero.VACIO) {
					casillerosLlenos = false;
				}
			}
		}
		return casillerosLlenos;
	}
	
	/**
	 * post: indica si el juego terminó y tiene un ganador, comprobando las cuatro formas posibles de victoria.
	 */
	public boolean hayGanador() {
		boolean hayGanador = false;
		if(victoriaVertical() || victoriaHorizontal() || victoriaDiagonalIzquierda() || victoriaDiagonalDerecha()) {
			hayGanador = true;
		}
		return hayGanador;
	}
	
	/**
	 * pre : el juego terminó.
	 * post: devuelve el nombre del jugador que ganó el juego.
	 */
	public String obtenerGanador() {
		if(termino()) {
			if(casilleroAComparar == Casillero.ROJO) {
				return nombreRojo;
			}else {
				return nombreAmarillo;
			}
		} else {
			return null;
		}
	}
	
	/**
	 * post: comprueba si el ultimo jugador gano alineando cuatro fichas verticalmente.		 
	 */
	private boolean victoriaVertical() {
		boolean victoriaVertical = false;
		boolean continuarAnalizando = true;
		if(ultimaFila < (tablero.length - 3)) {
			for(int i = 0; (i < 4) && continuarAnalizando; i++) {
				if(obtenerCasillero((ultimaFila + 1) + i, ultimaColumna + 1) == casilleroAComparar) {
					victoriaVertical = true;
				}else{
					victoriaVertical = false;
					continuarAnalizando = false;
				}
			}
		}
		return victoriaVertical;
	}
	
	/**
	 * post: comprueba si el ultimo jugador gano alineando cuatro fichas horizontalmente.	 
	 */
	private boolean victoriaHorizontal() {
		boolean victoriaHorizontal = false;
		if(victoriaHorizontal1() || victoriaHorizontal2() || victoriaHorizontal3() || victoriaHorizontal4()) {
			victoriaHorizontal = true;
		}
		return victoriaHorizontal;
	}
	
	/**
	 * post: comprueba si el ultimo jugador gano alineando cuatro fichas diagonalmente a la izquierda.		 
	 */
	private boolean victoriaDiagonalIzquierda() {
		boolean victoriaDiagonal = false;
		if(victoriaDiagonalIzquierda1() || victoriaDiagonalIzquierda2() || victoriaDiagonalIzquierda3() || victoriaDiagonalIzquierda4()) {
			victoriaDiagonal = true;
		}
		return victoriaDiagonal;
	}
	
	/**
	 * post: comprueba si el ultimo jugador gano alineando cuatro fichas diagonalmente a la derecha.		 
	 */
	private boolean victoriaDiagonalDerecha() {
		boolean victoriaDiagonal = false;
		if(victoriaDiagonalDerecha1() || victoriaDiagonalDerecha2() || victoriaDiagonalDerecha3() || victoriaDiagonalDerecha4()) {
			victoriaDiagonal = true;
		}
		return victoriaDiagonal;
	}
	
	/**
	 * post: comprueba si el ultimo jugador gano alineando cuatro fichas horizontalmente de izquierda a derecha.	 
	 */
	private boolean victoriaHorizontal1() {
		boolean victoriaHorizontal = false;
		boolean continuarAnalizando = true;
		if(ultimaColumna < tablero[0].length - 3) {
			for(int i = 0; (i < 4) && continuarAnalizando; i++) {
				if(obtenerCasillero((ultimaFila + 1), (ultimaColumna + 1) + i) == casilleroAComparar) {
					victoriaHorizontal = true;
				}else{
					victoriaHorizontal = false;
					continuarAnalizando = false;
				}
			}
		}
		return victoriaHorizontal;
	}
	
	/**
	 * post: comprueba si el ultimo jugador gano alineando cuatro fichas horizontalmente de izquierda a derecha empezando desde la segunda ficha.	 
	 */
	private boolean victoriaHorizontal2() {
		boolean victoriaHorizontal = false;
		boolean continuarAnalizando = true;
		if((ultimaColumna < tablero[0].length - 2) && (ultimaColumna > 0)) {
			for(int i = 0; (i < 4) && continuarAnalizando; i++) {
				if(obtenerCasillero((ultimaFila + 1), (ultimaColumna + 1) - 1 + i) == casilleroAComparar) {
					victoriaHorizontal = true;
				}else{
					victoriaHorizontal = false;
					continuarAnalizando = false;
				}
			}
		}
		return victoriaHorizontal;
	}
	
	/**
	 * post: comprueba si el ultimo jugador gano alineando cuatro fichas horizontalmente de izquierda a derecha empezando desde la tercer ficha.	 
	 */
	private boolean victoriaHorizontal3() {
		boolean victoriaHorizontal = false;
		boolean continuarAnalizando = true;
		if((ultimaColumna < tablero[0].length - 1) && (ultimaColumna > 1)) {
			for(int i = 0; (i < 4) && continuarAnalizando; i++) {
				if(obtenerCasillero((ultimaFila + 1), (ultimaColumna + 1) - 2 + i) == casilleroAComparar) {
					victoriaHorizontal = true;
				}else{
					victoriaHorizontal = false;
					continuarAnalizando = false;
				}
			}
		}
		return victoriaHorizontal;
	}
	
	/**
	 * post: comprueba si el ultimo jugador gano alineando cuatro fichas horizontalmente de izquierda a derecha empezando desde la cuarta ficha.	 
	 */
	private boolean victoriaHorizontal4() {
		boolean victoriaHorizontal = false;
		boolean continuarAnalizando = true;
		if((ultimaColumna < tablero[0].length) && (ultimaColumna > 2)) {
			for(int i = 0; (i < 4) && continuarAnalizando; i++) {
				if(obtenerCasillero((ultimaFila + 1), (ultimaColumna + 1) - 3 + i) == casilleroAComparar) {
					victoriaHorizontal = true;
				}else{
					victoriaHorizontal = false;
					continuarAnalizando = false;
				}
			}
		}
		return victoriaHorizontal;
	}
	
	/**
	 * post: comprueba si el ultimo jugador gano alineando cuatro fichas diagonalmente a la izquierda, desde direccion derecha a izquierda.	 
	 */
	private boolean victoriaDiagonalIzquierda1() {
		boolean victoriaDiagonalIzquierda = false;
		boolean continuarAnalizando = true;
		if((ultimaFila < (tablero.length - 3)) && (ultimaColumna > 2)) {
			for(int i = 0; (i < 4) && continuarAnalizando; i++) {
				if(obtenerCasillero((ultimaFila + 1) + i, (ultimaColumna + 1) - i) == casilleroAComparar) {
					victoriaDiagonalIzquierda = true;
				}else{
					victoriaDiagonalIzquierda = false;
					continuarAnalizando = false;
				}
			}
		}
		return victoriaDiagonalIzquierda;
	}

	/**
	 * post: comprueba si el ultimo jugador gano alineando cuatro fichas diagonalmente a la izquierda, desde direccion derecha a izquierda, empezando desde la segunda ficha. 
	 */
	private boolean victoriaDiagonalIzquierda2() {
		boolean victoriaDiagonalIzquierda = false;
		boolean continuarAnalizando = true;
		if((ultimaFila < (tablero.length - 2)) && (ultimaColumna > 1) && (ultimaColumna < tablero[0].length - 1) && (ultimaFila > 0)) {
			for(int i = 0; (i < 4) && continuarAnalizando; i++) {
				if(obtenerCasillero((ultimaFila + 1) - 1 + i, (ultimaColumna + 1) + 1 - i) == casilleroAComparar) {
					victoriaDiagonalIzquierda = true;
				}else{
					victoriaDiagonalIzquierda = false;
					continuarAnalizando = false;
				}
			}
		}
		return victoriaDiagonalIzquierda;
	}
	
	/**
	 * post: comprueba si el ultimo jugador gano alineando cuatro fichas diagonalmente a la izquierda, desde direccion derecha a izquierda, empezando desde la tercer ficha.	 
	 */
	private boolean victoriaDiagonalIzquierda3() {
		boolean victoriaDiagonalIzquierda = false;
		boolean continuarAnalizando = true;
		if((ultimaFila < (tablero.length - 1)) && (ultimaColumna > 0) && (ultimaColumna < tablero[0].length - 2) && (ultimaFila > 1)) {
			for(int i = 0; (i < 4) && continuarAnalizando; i++) {
				if(obtenerCasillero((ultimaFila + 1) - 2 + i, (ultimaColumna + 1) + 2 - i) == casilleroAComparar) {
					victoriaDiagonalIzquierda = true;
				}else{
					victoriaDiagonalIzquierda = false;
					continuarAnalizando = false;
				}
			}
		}
		return victoriaDiagonalIzquierda;
	}
	
	/**
	 * post: comprueba si el ultimo jugador gano alineando cuatro fichas diagonalmente a la izquierda, desde direccion derecha a izquierda, empezando desde la cuarta ficha.	 
	 */
	private boolean victoriaDiagonalIzquierda4() {
		boolean victoriaDiagonalIzquierda = false;
		boolean continuarAnalizando = true;
		if((ultimaFila < tablero.length) && (ultimaColumna >= 0) && (ultimaColumna < tablero[0].length - 3) && (ultimaFila > 2)) {
			for(int i = 0; (i < 4) && continuarAnalizando; i++) {
				if(obtenerCasillero((ultimaFila + 1) - 3 + i, (ultimaColumna + 1) + 3 - i) == casilleroAComparar) {
					victoriaDiagonalIzquierda = true;
				}else{
					victoriaDiagonalIzquierda = false;
					continuarAnalizando = false;
				}
			}
		}
		return victoriaDiagonalIzquierda;
	}
	
	/**
	 * post: comprueba si el ultimo jugador gano alineando cuatro fichas diagonalmente a la derecha, desde direccion izquierda a derecha, empezando desde la primer ficha.	 
	 */
	private boolean victoriaDiagonalDerecha1() {
		boolean victoriaDiagonalDerecha = false;
		boolean continuarAnalizando = true;
		if((ultimaFila < (tablero.length - 3)) && (ultimaColumna < tablero[0].length - 3)) {
			for(int i = 0; (i < 4) && continuarAnalizando; i++) {
				if(obtenerCasillero((ultimaFila + 1) + i, (ultimaColumna + 1) + i) == casilleroAComparar) {
					victoriaDiagonalDerecha = true;
				}else{
					victoriaDiagonalDerecha = false;
					continuarAnalizando = false;
				}
			}
		}
		return victoriaDiagonalDerecha;
	}
	
	/**
	 * post: comprueba si el ultimo jugador gano alineando cuatro fichas diagonalmente a la derecha, desde direccion izquierda a derecha, empezando desde la segunda ficha.	 
	 */
	private boolean victoriaDiagonalDerecha2() {
		boolean victoriaDiagonalDerecha = false;
		boolean continuarAnalizando = true;
		if((ultimaFila < (tablero.length - 2)) && (ultimaColumna < tablero[0].length - 2) && (ultimaColumna > 0) && (ultimaFila > 0)) {
			for(int i = 0; (i < 4) && continuarAnalizando; i++) {
				if(obtenerCasillero((ultimaFila + 1) - 1 + i, (ultimaColumna + 1) - 1 + i) == casilleroAComparar) {
					victoriaDiagonalDerecha = true;
				}else{
					victoriaDiagonalDerecha = false;
					continuarAnalizando = false;
				}
			}
		}
		return victoriaDiagonalDerecha;
	}
	
	/**
	 * post: comprueba si el ultimo jugador gano alineando cuatro fichas diagonalmente a la derecha, desde direccion izquierda a derecha, empezando desde la tercer ficha.	 
	 */
	private boolean victoriaDiagonalDerecha3() {
		boolean victoriaDiagonalDerecha = false;
		boolean continuarAnalizando = true;
		if((ultimaFila < (tablero.length - 1)) && (ultimaColumna < tablero[0].length - 1) && (ultimaColumna > 1) && (ultimaFila > 1)) {
			for(int i = 0; (i < 4) && continuarAnalizando; i++) {
				if(obtenerCasillero((ultimaFila + 1) - 2 + i, (ultimaColumna + 1) - 2 + i) == casilleroAComparar) {
					victoriaDiagonalDerecha = true;
				}else{
					victoriaDiagonalDerecha = false;
					continuarAnalizando = false;
				}
			}
		}
		return victoriaDiagonalDerecha;
	}
	
	/**
	 * post: comprueba si el ultimo jugador gano alineando cuatro fichas diagonalmente a la derecha, desde direccion izquierda a derecha, empezando desde la cuarta ficha.	 
	 */
	private boolean victoriaDiagonalDerecha4() {
		boolean victoriaDiagonalDerecha = false;
		boolean continuarAnalizando = true;
		if((ultimaFila < tablero.length) && (ultimaColumna < tablero[0].length) && (ultimaColumna > 2) && (ultimaFila > 2)) {
			for(int i = 0; (i < 4) && continuarAnalizando; i++) {
				if(obtenerCasillero((ultimaFila + 1) - 3 + i, (ultimaColumna + 1) - 3 + i) == casilleroAComparar) {
					victoriaDiagonalDerecha = true;
				}else{
					victoriaDiagonalDerecha = false;
					continuarAnalizando = false;
				}
			}
		}
		return victoriaDiagonalDerecha;
	}
}