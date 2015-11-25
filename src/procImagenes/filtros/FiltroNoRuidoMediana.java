package procImagenes.filtros;

public class FiltroNoRuidoMediana extends Filtro {

	@Override
	public int[][] aplicarFiltro(int[][] m) {
 
			int columnas = m.length;
			int filas = m[0].length;
			
			int[][] mf = new int [columnas][filas];
			
			int mediana;
			
			int px[]= new int[9];
			int aux[]= new int[9];
					
			int orden[]= new int[9];

			int cont[] = new int[9];
			
			int mayor;
			
			for( int x = 1  ; x < columnas-1 ; x++)
				for (int y = 1 ; y < filas-1 ; y++){
					
					
					px[0]= m[x-1][y-1];
					px[1]= m[x][y-1];
					px[2]= m[x+1][y-1];
					
					px[3]= m[x-1][y];
					px[4]= m[x][y];
					px[5]= m[x+1][y];
					
					px[6]= m[x-1][y+1];
					px[7]= m[x][y+1];
					px[8]= m[x+1][y+1];
					
					
					for( int i=0 ; i<9 ; i++)
						aux[i]=px[i];
					
					int a;
					
					for( int j=0 ; j<9 ; j++){
						mayor = 0;
						a=0;
						for( int i=0 ; i<9 ; i++)
							if(mayor<aux[i]){
								mayor = aux[i];
								a = i;
							}
						orden[8-j]=mayor;								
						aux[a]=0;
					}
					
					if ( x== 231 && y == 1)
					{
						System.out.println("ORDENES :");
						System.out.println(orden[0]);
						System.out.println(orden[1]);
						System.out.println(orden[2]);
						System.out.println(orden[3]);
						System.out.println(orden[4]);
						System.out.println(orden[5]);
						System.out.println(orden[6]);
						System.out.println(orden[7]);
						System.out.println(orden[8]);
						
					}
					
					//mf[x][y] = m[x][y];
					mf[x][y] = ( orden[4]);
				}
			
			return mf;
	}

}
