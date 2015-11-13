package procImagenes;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Panel;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.SystemColor;
import javax.swing.border.BevelBorder;

public class Ventana1 {

	private JFrame frame;
	PanelDibujo panelImagen;
	PanelHistograma panelHistograma ;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana1 window = new Ventana1();
					window.frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

	
	/**
	 * Create the application.
	 */
	public Ventana1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setMinimumSize(new Dimension(800, 560));
		frame.setBounds(100, 100, 844, 560);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		panelImagen = new PanelDibujo();
		panelImagen.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panelImagen.setBounds(10, 10, 502, 502);
		frame.getContentPane().add(panelImagen);
		
		panelHistograma = new PanelHistograma();
		panelHistograma.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panelHistograma.setBounds(518, 10, 300, 184);
		frame.getContentPane().add(panelHistograma);
		
		JButton btnEcualizar = new JButton("Histograma");
		btnEcualizar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				panelHistograma.declararIntensidades(panelImagen.getIntensidades(), panelImagen.getAnchoImg(), panelImagen.getAltoImg());
			}
		});
		btnEcualizar.setBounds(518, 400, 300, 23);
		frame.getContentPane().add(btnEcualizar);
		
		JPanel panelHistogramaAcum = new JPanel();
		panelHistogramaAcum.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panelHistogramaAcum.setBounds(518, 205, 300, 184);
		frame.getContentPane().add(panelHistogramaAcum);
	}
}
