package procImagenes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class PanelImagen extends JPanel {

	public static enum TipoEscala{ ESTIRADO , CENTRADO , SIMPLE};
	
	private static TipoEscala escala = TipoEscala.ESTIRADO;
	private BufferedImage imagen;
	
	public PanelImagen(BufferedImage img){
		imagen = img;
	}
	
	public PanelImagen(){
	}
	
	public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        if(imagen!=null){
        	int altoPanel = (int) this.getSize().getHeight();
        	int anchoPanel = (int) this.getSize().getWidth();
        	
        	switch (escala){
        	case ESTIRADO:
	        	g.drawImage(imagen, 0,0, anchoPanel, altoPanel, null);
	        	break;
        	
        	case CENTRADO:
        		g.setColor(Color.BLACK);
        		g.fillRect(0,0,anchoPanel, altoPanel);

        		float ratio =  imagen.getWidth()*1.0f / imagen.getHeight();
        		
        		int anchoConvertido = (int) (altoPanel*ratio);
        		int altoConvertido = altoPanel;

        		int x,y;

        		if(anchoPanel>anchoConvertido){
        			x = (int) (anchoPanel/2.0f - anchoConvertido/2.0f);
        			y = 0; 
        		}
        		else{
        			anchoConvertido = anchoPanel;
            		altoConvertido = (int) (anchoPanel/ratio);            		
        			x = 0;
        			y = (int) (altoPanel/2.0f - altoConvertido/2.0f);        			
        		}
    			g.drawImage(imagen, x ,y,anchoConvertido, altoConvertido, null);
	        	break;	        	
         	case SIMPLE:
	        	g.drawImage(imagen, 0,0,  null);
	        	break;
        	
			default:				
				break;
        	}
        }
	}
	
	public void setImagen(BufferedImage img){
		imagen = img;
	}
	
	public BufferedImage getDuplicadoImagen(){
		BufferedImage nueva = new BufferedImage(0,0,0);
		return nueva;
	}
	
	//????????????????????????????????????????????
	public BufferedImage getImagen(){
		return imagen;
	}
	
	public static BufferedImage procesarImagenGrises(int[][] matriz){
		int columnas = matriz.length;
		int filas = matriz[0].length;
		
		BufferedImage img = new BufferedImage(columnas , filas , BufferedImage.TYPE_INT_RGB);
		
		for( int x = 0  ; x < columnas ; x++)
			for (int y = 0 ; y < filas ; y++){
				img.setRGB(x, y, new Color(matriz[x][y], matriz[x][y], matriz[x][y]).getRGB());

				if(x>0 && x<10 && y== 1)
					System.out.println("intensidad en pixel, x: "+x+", y: "+y+" = "+matriz[x][y]);
				}
		
		return img;
	}
	
	public static void cambiarTipoEscala(TipoEscala tipo){
		escala = tipo;
	}
	
}
