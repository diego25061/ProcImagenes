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
import javax.swing.BoxLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Component;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.FlowLayout;
import java.awt.Insets;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;

public class Ventana1 {
	
	private static final int anchoPanelHistograma= 300;
	private static final int alturaPanelHistograma= 150;

	private JFrame frmProcesadorDeImagenes;
	PanelDibujo panelImgOriginal;
	PanelHistograma panelHistogramaInicial ;
	private JPanel panelImagenes;
	private JPanel panelDerecho;
	private JMenuBar menuBar;
	private JMenu mnArchivo;
	private JMenuItem mntmImportarImagen;
	private JMenuItem mntmSalir;
	private PanelDibujo panelImgByN;
	private JPanel panel;
	private JPanel panel_1;
	private PanelDibujo panelImgByNSinRuido;
	private PanelDibujo panelImgFinal;
	private JPanel panelOpciones;
	private JPanel panel_2;
	private JLabel lblNewLabel;
	private JRadioButton rdbtnNewRadioButton;
	private JRadioButton rdbtnNewRadioButton_1;
	private JLabel lblContraste;
	private JSlider slider;
	private JPanel panel_3;
	private JPanel panel_4;
	private JPanel panel_5;
	private JPanel panel_6;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana1 window = new Ventana1();
					window.frmProcesadorDeImagenes.setVisible(true);
					
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
		frmProcesadorDeImagenes = new JFrame(); 
		frmProcesadorDeImagenes.setTitle("Procesador de imagenes");
		frmProcesadorDeImagenes.setBounds(100, 100, 698, 549);
		frmProcesadorDeImagenes.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmProcesadorDeImagenes.getContentPane().setLayout(new BorderLayout(0, 0));
		
		panelImagenes = new JPanel();
		frmProcesadorDeImagenes.getContentPane().add(panelImagenes);
		panelImagenes.setLayout(new BoxLayout(panelImagenes, BoxLayout.X_AXIS));
		
		panel = new JPanel();
		panelImagenes.add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Imagen original", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.add(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		panelImgOriginal = new PanelDibujo();
		panel_3.add(panelImgOriginal);
		panelImgOriginal.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		panel_5 = new JPanel();
		panel_5.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Blanco y negro sin ruido", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.add(panel_5);
		panel_5.setLayout(new BorderLayout(0, 0));
		
		panelImgByNSinRuido = new PanelDibujo();
		panel_5.add(panelImgByNSinRuido);
		panelImgByNSinRuido.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		panel_1 = new JPanel();
		panelImagenes.add(panel_1);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.Y_AXIS));
		
		panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Blanco y Negro", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.add(panel_4);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		panelImgByN = new PanelDibujo();
		panel_4.add(panelImgByN);
		panelImgByN.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		panel_6 = new JPanel();
		panel_6.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Imagen final: contraste arreglado", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.add(panel_6);
		panel_6.setLayout(new BorderLayout(0, 0));
		
		panelImgFinal = new PanelDibujo();
		panel_6.add(panelImgFinal);
		panelImgFinal.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		panelDerecho = new JPanel();
		panelDerecho.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		frmProcesadorDeImagenes.getContentPane().add(panelDerecho, BorderLayout.EAST);
		panelDerecho.setLayout(new BorderLayout(0, 0));
		
		panel_2 = new JPanel();
		panelDerecho.add(panel_2, BorderLayout.NORTH);
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.Y_AXIS));
 
		
		panelHistogramaInicial = new PanelHistograma();
		panel_2.add(panelHistogramaInicial);
		panelHistogramaInicial.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panelHistogramaInicial.setPreferredSize(new Dimension(anchoPanelHistograma,alturaPanelHistograma));
		
		JPanel panelHistogramaFinal = new JPanel();
		panel_2.add(panelHistogramaFinal);
		panelHistogramaFinal.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panelHistogramaFinal.setPreferredSize(new Dimension(anchoPanelHistograma,alturaPanelHistograma));
		
		panelOpciones = new JPanel();
		panelDerecho.add(panelOpciones, BorderLayout.CENTER);
		GridBagLayout gbl_panelOpciones = new GridBagLayout();
		gbl_panelOpciones.columnWidths = new int[]{89, 0};
		gbl_panelOpciones.rowHeights = new int[]{0, 23, 0, 0, 0, 0, 23, 0};
		gbl_panelOpciones.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panelOpciones.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		panelOpciones.setLayout(gbl_panelOpciones);
		
		lblNewLabel = new JLabel("Eliminacion de ruido");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.insets = new Insets(0, 5, 5, 0);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panelOpciones.add(lblNewLabel, gbc_lblNewLabel);
		
		rdbtnNewRadioButton = new JRadioButton("Media");
		GridBagConstraints gbc_rdbtnNewRadioButton = new GridBagConstraints();
		gbc_rdbtnNewRadioButton.anchor = GridBagConstraints.WEST;
		gbc_rdbtnNewRadioButton.insets = new Insets(0, 5, 5, 0);
		gbc_rdbtnNewRadioButton.gridx = 0;
		gbc_rdbtnNewRadioButton.gridy = 1;
		panelOpciones.add(rdbtnNewRadioButton, gbc_rdbtnNewRadioButton);
		
		rdbtnNewRadioButton_1 = new JRadioButton("Mediana");
		GridBagConstraints gbc_rdbtnNewRadioButton_1 = new GridBagConstraints();
		gbc_rdbtnNewRadioButton_1.anchor = GridBagConstraints.WEST;
		gbc_rdbtnNewRadioButton_1.insets = new Insets(0, 5, 5, 0);
		gbc_rdbtnNewRadioButton_1.gridx = 0;
		gbc_rdbtnNewRadioButton_1.gridy = 2;
		panelOpciones.add(rdbtnNewRadioButton_1, gbc_rdbtnNewRadioButton_1);
		
		lblContraste = new JLabel("Contraste");
		GridBagConstraints gbc_lblContraste = new GridBagConstraints();
		gbc_lblContraste.anchor = GridBagConstraints.WEST;
		gbc_lblContraste.insets = new Insets(0, 5, 5, 0);
		gbc_lblContraste.gridx = 0;
		gbc_lblContraste.gridy = 3;
		panelOpciones.add(lblContraste, gbc_lblContraste);
		
		slider = new JSlider();
		GridBagConstraints gbc_slider = new GridBagConstraints();
		gbc_slider.fill = GridBagConstraints.HORIZONTAL;
		gbc_slider.anchor = GridBagConstraints.WEST;
		gbc_slider.insets = new Insets(0, 5, 5, 0);
		gbc_slider.gridx = 0;
		gbc_slider.gridy = 4;
		panelOpciones.add(slider, gbc_slider);
		
		JButton btnEcualizar = new JButton("Histograma");
		GridBagConstraints gbc_btnEcualizar = new GridBagConstraints();
		gbc_btnEcualizar.anchor = GridBagConstraints.SOUTH;
		gbc_btnEcualizar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnEcualizar.gridx = 0;
		gbc_btnEcualizar.gridy = 6;
		panelOpciones.add(btnEcualizar, gbc_btnEcualizar);
		btnEcualizar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				panelHistogramaInicial.declararIntensidades(panelImgOriginal.getIntensidades(), panelImgOriginal.getAnchoImg(), panelImgOriginal.getAltoImg());
			}
		});
		
		menuBar = new JMenuBar();
		frmProcesadorDeImagenes.setJMenuBar(menuBar);
		
		mnArchivo = new JMenu("Archivo");
		menuBar.add(mnArchivo);
		
		mntmImportarImagen = new JMenuItem("Importar imagen");
		mnArchivo.add(mntmImportarImagen);
		
		mntmSalir = new JMenuItem("Salir");
		mntmSalir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
			}
		});
		mnArchivo.add(mntmSalir);
	}
}
