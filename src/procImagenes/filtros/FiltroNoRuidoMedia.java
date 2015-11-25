package procImagenes.filtros;

import java.awt.Color;

public class FiltroNoRuidoMedia extends Filtro {

	@Override
	public int[][] aplicarFiltro(int[][] m) {
		
		int columnas = m.length;
		int filas = m[0].length;
		
		int[][] mf = new int [columnas][filas];
		
		int media;
		
		int px[]= new int[9];

		int suma;
		
		for( int x = 1  ; x < columnas-1 ; x++)
			for (int y = 1 ; y < filas-1 ; y++){
				
				suma = 0;
				
				px[0]= m[x-1][y-1];
				px[1]= m[x][y-1];
				px[2]= m[x+1][y-1];
				
				px[3]= m[x-1][y];
				px[4]= m[x][y];
				px[5]= m[x+1][y];
				
				px[6]= m[x-1][y+1];
				px[7]= m[x][y+1];
				px[8]= m[x+1][y+1];
				
				for (int i = 0 ; i < 9 ; i++)
					suma+=px[i];
				
				media = (int)( suma*1.0f / 9 );

				mf[x][y] = m[x][y];
				mf[x][y] = media;
			}
		
		return mf;
	}

}
