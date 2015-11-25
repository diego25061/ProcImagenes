package procImagenes;

import java.awt.Color;
import java.awt.image.BufferedImage;

public class InfoImagen {

	//BufferedImage img;
	
	private InfoImagen(BufferedImage imagen){
	//	img = imagen;
	}
	public static int[] getFrecuenciaIntensidadesGrises(int [][] m){
		int columnas = m.length;
		int filas = m[0].length;
		int frecuenciaIntensidad[] = new int[256];
	    	for( int y = 0; y < filas ; y++)
	    		for( int x = 0; x < columnas ; x++){
	    				frecuenciaIntensidad[m[x][y]]++;
	    		} 
		return frecuenciaIntensidad;
	}
	
	public static int[] getFrecuenciaIntensidadesGrises(BufferedImage img){
		int intensidad[][] = getMatrizIntensidadesGris(img);
		int frecuenciaIntensidad[] = new int[256];
		/*
    	for(int nivel = 0 ; nivel < 256; nivel ++)    	
	    	for( int j = 0; j<img.getHeight() ; j++)
	    		for( int i = 0; i< img.getWidth() ; i++){
	    			if(intensidad[i][j]== nivel){
	    				frecuenciaIntensidad[nivel]++;
	    			}
	    		} 
		return frecuenciaIntensidad;
		*/ 	
	    	for( int y = 0; y < img.getHeight() ; y++)
	    		for( int x = 0; x < img.getWidth() ; x++){
	    				frecuenciaIntensidad[getEscalaGris(x,y, img)]++;
	    		} 
		return frecuenciaIntensidad;
		
	}

    public static int [][] getMatrizIntensidadesGris(BufferedImage img){
    	int alto = img.getHeight(), ancho = img.getWidth();
    	int [][] matriz = new int[ancho][alto];
    	for( int j = 0; j<alto ; j++)
    		for( int i = 0; i<ancho ; i++){
    			matriz[i][j] = getEscalaGris(i,j, img);
    		} 
    	return matriz;
    }
    
    public static float[] getFrecuenciaRelativaIntensidadGrises(BufferedImage img){
		int frecuenciaIntensidad[] = getFrecuenciaIntensidadesGrises(img);

    	float frecRelativaNivel[] = new float[256];
    	
    	long total=0;
    	long mayor=0;
     	for(int i= 0; i<256;i++) {
     		if(frecuenciaIntensidad[i]>mayor)
     			mayor= frecuenciaIntensidad[i];
    		total+=frecuenciaIntensidad[i]; 
     	}

    	for(int i= 0; i<256;i++) {
    		System.out.println("Cantidad de pixeles con intensidad "+i+" : "+frecuenciaIntensidad[i]);
    		
    		frecRelativaNivel[i] = frecuenciaIntensidad[i]*1.0f /mayor;
    		/*
    		probabilidad[i] = frecuenciaIntensidad[i] / total;
    		for(int j=0; j<i;j++)
    			probabilidadAcum[j] += probabilidad[j];
    			*/
    	}
    	
		//System.out.println("Cantidad de pixeles: "+total);
		
    	return frecRelativaNivel;
    }
    
    /*
	public static int getIntensidadR(int x, int y){
		return 0;
	}
	
	public static int getIntensidadG(int x, int y){
		return 0;
	}
	
	public static int getIntensidadB(int x, int y){
		return 0;
	}
	*/
	
	public static int getEscalaGris(int x, int y, BufferedImage img){
		//return img.getRGB(x, y) % 256+ 255;
		
		Color c =  new Color(img.getRGB(x, y));
		int color = (c.getBlue() + c.getRed() + c.getGreen()) /3;
		if(x>0 && x<10 && y== 1)
			System.out.println("OP: R="+c+"- intensidad en pixel, x: "+x+", y: "+y+" = "+color);
		//System.out.println("OP: R="+c.getRed()+" G=" + c.getGreen() +" B="+c.getBlue()+"- intensidad en pixel, x: "+x+", y: "+y+" = "+color);
		
		return color;
		
	}

}
