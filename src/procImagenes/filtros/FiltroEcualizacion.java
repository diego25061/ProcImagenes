package procImagenes.filtros;

import procImagenes.InfoImagen;

public class FiltroEcualizacion extends Filtro {

	int limiteInferior, limiteSuperior;
	
	public FiltroEcualizacion(int limiteInferior,int limiteSuperior){
		this.limiteInferior= limiteInferior;
		this.limiteSuperior = limiteSuperior;
	}
	
	public void cambiarLimites(int limiteInferior, int limiteSuperior){

		this.limiteInferior= limiteInferior;
		this.limiteSuperior = limiteSuperior;
	
	}
	
	@Override
	public int[][] aplicarFiltro(int[][] m) {
		int distancia = limiteSuperior - limiteInferior;
		
		int columnas = m.length;
		int filas = m[0].length;
		
		int[][] mf = new int [columnas][filas];
		int pixeles = columnas*filas;
		float [] prob = new float[256];
		float [] acumProb = new float[256];
		int[] frec = InfoImagen.getFrecuenciaIntensidadesGrises(m);
		for( int i = 0 ;i <256 ;i++){
			prob[i] = frec[i] *1.0f/ pixeles; 
		}
		for(int j=0;j<256;j++)
			for(int i = 0; i<j;i++)
				acumProb[j]+=prob[i];
		
		for(int x = 0; x < columnas; x++)
			for(int y = 0; y < filas; y++)
				mf[x][y]= (int) (limiteInferior + acumProb[m[x][y]]*distancia);
				
		return mf;
	}

}
