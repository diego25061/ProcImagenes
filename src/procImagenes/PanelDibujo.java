package procImagenes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class PanelDibujo extends JPanel {
	
	  
	String direccion = "imagenes/imgLena1.jpg";
	  
	
	private BufferedImage image;
	  
		
	 
	private int ancho, alto;
		
	   
	public PanelDibujo() {
       try {                
          image = ImageIO.read(new File(direccion));
       } catch (IOException ex) {
            // handle exception...
       }

    	ancho = image.getWidth();
    	alto= image.getHeight();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);  
        //g.drawLine(10, 10, 50, 50);
        g.drawImage(image, 0, 0, null); // see javadoc for more info on the parameters
        
        /*
        Graphics2D canvas =  image.createGraphics();
        
        Graphics gcanvas= image.getGraphics();
        
        image.getHeight();
        
        image.getWidth();
        */
        //image.getRGB(x, y)
        /*
        for(int i = 0 ; i< 100;i++)
        	image.setRGB(10 +i , 10+i, 0);
        */
        //System.out.println("color: "+ ( image.getRGB(294, 12) % 256 + 256) );
        //System.out.println("color: "+ (Integer.toString(image.getRGB(372, 216),16) ));
        
        
        //gcanvas.setColor(Color.red);
        //gcanvas.fillRect(10, 10, 50, 50);
       
        
        
    }
    
    public int [][] getIntensidades(){
    	int [][] matriz = new int[ancho][alto];
    	int a = 0;
    	for( int j = 0; j<alto ; j++)
    		for( int i = 0; i<ancho ; i++){
    			matriz[i][j] = (int) (image.getRGB(i, j)  % 256 + 255);
    			a++;
    		}
    	System.out.println("a ::::::::::::::::::.."+ a);
    	
    	return matriz;
    }
    
    public int getAltoImg(){
    	return alto;
    }
    public int getAnchoImg(){
    	return ancho;
    }
	    

}
