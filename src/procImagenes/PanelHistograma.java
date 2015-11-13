package procImagenes;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class PanelHistograma extends JPanel {

	private int [][] intensidad;
	private boolean tieneIntensidades;
	
	private long frecNivel[];
	private float frecRelativaNivel[];
	private float probabilidad[];
	private float probabilidadAcum[];
	
	BufferedImage img;
	
	private int anchoHist, altoHist;
	
	int anchoImg, altoImg;
	
	Graphics gg;
	Canvas canvas;
	
    public PanelHistograma(){
    	anchoHist = 300;
    	System.out.print("ancho: "+anchoHist);
    	altoHist= 180;
    	img = new BufferedImage(anchoHist , altoHist , BufferedImage.TYPE_BYTE_GRAY);
    	
    	frecNivel = new long[256];
    	frecRelativaNivel = new float[256];
    	probabilidad= new float[256];
    	probabilidadAcum= new float[256];
    	for(int nivel = 0 ; nivel < 256; nivel ++) 
    		frecNivel[nivel]=0;
    }
    

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        gg=g;
        if ( tieneIntensidades){
	        g.drawImage(img, 0, 0, null);
        }
    }
    
    public void declararIntensidades(int [][] intensidades, int anchoImagen, int altoImagen){    	
    	intensidad = intensidades;

    	this.anchoImg = anchoImagen;
    	this.altoImg= altoImagen;
    	System.out.println("recibiendo ancho: "+anchoImagen+" , alto: "+altoImagen);
    	
    	rehacerImagen();
    	tieneIntensidades= true;
    }
    
    private void rehacerImagen(){
    
    	float offsetX = 20;
    	
    	float inicioX = offsetX;
    	float inicioY = 170;
    	

    	for(int nivel = 0 ; nivel < 256; nivel ++)    	
	    	for( int j = 0; j<altoImg ; j++)
	    		for( int i = 0; i<anchoImg ; i++){
	    			if(intensidad[i][j]== nivel){
	    				frecNivel[nivel]++;
	    			}
	    		}

    	long total=0;
    	long mayor=0;
     	for(int i= 0; i<256;i++) {
     		if(frecNivel[i]>mayor)
     			mayor= frecNivel[i];
    		total+=frecNivel[i]; 
     	}

		
     	
    	//long total= anchoImg*altoImg;
    	for(int i= 0; i<256;i++) {
    		System.out.println("cantidad de pixeles con intensidad "+i+" : "+frecNivel[i]);
    		
    		frecRelativaNivel[i] = frecNivel[i]*1.0f /mayor;
    		probabilidad[i] = frecNivel[i] / total;
    		for(int j=0; j<i;j++)
    			probabilidadAcum[j] += probabilidad[j];
    	}

     	System.out.println("MAYOR: "+mayor);
		System.out.println("TOTAL: "+total);
		
    	for(int i= 0; i<256;i++) {
    		for(int h=0; h<(int) (frecRelativaNivel[i]*150);h++)
    			img.setRGB((int) inicioX + i, (int) (inicioY-h), 0x0fffff);
    	}

    	
    	this.repaint();
    }
    
 	private void ecualizar(){
		//listar las cantidades de pixeles que tiene cada intensidad
 		//hallar probabilidades
 		//hallar probabilidades acumulativas
 		//multiplicar las probabilides acumulativas por 255
	}
}
