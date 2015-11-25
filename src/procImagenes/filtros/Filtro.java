package procImagenes.filtros;

import java.awt.image.BufferedImage;

public abstract class Filtro {

	public int[][] extraerMatriz( BufferedImage imagen){
		return null;
	}
	
	public abstract int[][] aplicarFiltro (int[][] matrizInicial);
	
}
