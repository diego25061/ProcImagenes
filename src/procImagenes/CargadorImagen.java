package procImagenes;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class CargadorImagen {
	
	public BufferedImage cargarImagen(String direccion){
	       try {                	          
	    	   return ImageIO.read(new File(direccion));
	       } catch (IOException ex) {	    	   
	    	   new RuntimeException("La imagen no se pudo cargar");
	    	   return null;
	       }
	}
}
