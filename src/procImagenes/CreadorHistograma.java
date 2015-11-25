package procImagenes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class CreadorHistograma {

	//int largoHistograma, altoHistograma;
	//InfoImagen info;
	
	private CreadorHistograma(BufferedImage imagen) {
		//largoHistograma = 300;
		//altoHistograma = 150;

		//info = new InfoImagen(imagen);
		
	}	
	
	public static BufferedImage componerImagen(int ancho, int alto, BufferedImage image){
		int largoHistograma = ancho; //300
		int altoHistograma = alto; //150
    	float offsetX = 20;    	
    	float inicioX = offsetX;
    	float inicioY = altoHistograma - 10;
    	float alturaMax = inicioY - 10;
    	
		BufferedImage h = new BufferedImage(largoHistograma,altoHistograma,BufferedImage.TYPE_INT_RGB);
		Graphics g = h.getGraphics();
		
		g.setColor(Color.gray);
		g.fillRect(0, 0, h.getWidth(), h.getHeight());
		
		float[] frecRelativa = InfoImagen.getFrecuenciaRelativaIntensidadGrises(image);
		
    	for(int i= 0; i<256;i++) {
    		for(int a=0; a<(int) (frecRelativa[i]*alturaMax);a++)
    			h.setRGB((int) inicioX + i, (int) (inicioY-a), 0x0fffff);
    	}

		return h;
	}

	
}
