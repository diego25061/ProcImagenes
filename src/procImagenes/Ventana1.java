package procImagenes;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import procImagenes.PanelImagen.TipoEscala;
import procImagenes.filtros.FiltroEcualizacion;
import procImagenes.filtros.FiltroNoRuidoMedia;
import procImagenes.filtros.FiltroNoRuidoMediana;

public class Ventana1 {

	PanelImagen imagen1;
	PanelImagen imagen2;
	PanelImagen imagen3;
	PanelImagen imagen4;
	
	PanelImagen imagenHistogramaInicial;
	PanelImagen imagenHistogramaFinal;
	
	String direccion = "imagenes/imgLenaDanho.jpg";
	String direccionTD2 = "imagenes/td1.jpg";
	
	private CargadorImagen cargadorImagen;
	FiltroEcualizacion filtroEcualizacion;
	
	private static final int anchoPanelHistograma= 300;
	private static final int alturaPanelHistograma= 150;

	private JFrame frmProcesadorDeImagenes;
	private PanelImagen panelImgOriginal;
	private PanelImagen panelHistogramaInicial ;
	private JPanel panelImagenes;
	private JPanel panelDerecho;
	private JMenuBar menuBar;
	private JMenu mnArchivo;
	private JMenuItem mntmImportarImagen;
	private JMenuItem mntmSalir;
	private PanelImagen panelImgByN;
	private JPanel panel;
	private JPanel panel_1;
	private PanelImagen panelImgByNSinRuido;
	private PanelImagen panelImgFinal;
	private JPanel panelOpciones;
	private JPanel panel_2;
	private JLabel lblNewLabel;
	private JLabel lblContraste;
	private JPanel panel_3;
	private JPanel panel_4;
	private JPanel panel_5;
	private JPanel panel_6;
	private JComboBox cbxVista;
	private JComboBox cbxRuido;
	
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
		cargadorImagen = new CargadorImagen();

		imagen1 = new PanelImagen();
		imagen2 = new PanelImagen();
		imagen3 = new PanelImagen();
		imagen4 = new PanelImagen();

		imagenHistogramaInicial = new PanelImagen();
		imagenHistogramaFinal = new PanelImagen();
		
		PanelImagen.cambiarTipoEscala(TipoEscala.CENTRADO);
		
		crearImagenes();
		//creando ventana
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
		
		panelImgOriginal = imagen1;
		panel_3.add(panelImgOriginal);
		panelImgOriginal.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		panel_5 = new JPanel();
		panel_5.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Blanco y negro sin ruido", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.add(panel_5);
		panel_5.setLayout(new BorderLayout(0, 0));
		
		panelImgByNSinRuido = imagen3;
		panel_5.add(panelImgByNSinRuido);
		panelImgByNSinRuido.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		panel_1 = new JPanel();
		panelImagenes.add(panel_1);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.Y_AXIS));
		
		panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Blanco y Negro", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.add(panel_4);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		panelImgByN = imagen2;
		panel_4.add(panelImgByN);
		panelImgByN.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		panel_6 = new JPanel();
		panel_6.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Imagen final: histograma ecualizado", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.add(panel_6);
		panel_6.setLayout(new BorderLayout(0, 0));
		
		panelImgFinal = imagen4;
		panel_6.add(panelImgFinal);
		panelImgFinal.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		panelDerecho = new JPanel();
		panelDerecho.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		frmProcesadorDeImagenes.getContentPane().add(panelDerecho, BorderLayout.EAST);
		panelDerecho.setLayout(new BorderLayout(0, 0));
		
		panel_2 = new JPanel();
		panelDerecho.add(panel_2, BorderLayout.NORTH);
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.Y_AXIS));
 
		
		panelHistogramaInicial = imagenHistogramaInicial;
		panel_2.add(panelHistogramaInicial);
		panelHistogramaInicial.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panelHistogramaInicial.setPreferredSize(new Dimension(anchoPanelHistograma,alturaPanelHistograma));
		
		JPanel panelHistogramaFinal = imagenHistogramaFinal;
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
		
		cbxRuido = new JComboBox();
		cbxRuido.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				JComboBox cbx =((JComboBox)arg0.getSource());
				cambiarTipoFiltro(cbx.getSelectedIndex());
			}
		});
		cbxRuido.setModel(new DefaultComboBoxModel(new String[] {"MEDIANA", "MEDIA"}));
		cbxRuido.setSelectedIndex(0);
		GridBagConstraints gbc_cbxRuido = new GridBagConstraints();
		gbc_cbxRuido.insets = new Insets(0, 0, 5, 0);
		gbc_cbxRuido.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbxRuido.gridx = 0;
		gbc_cbxRuido.gridy = 1;
		panelOpciones.add(cbxRuido, gbc_cbxRuido);
		
		lblContraste = new JLabel("Vista imagen");
		GridBagConstraints gbc_lblContraste = new GridBagConstraints();
		gbc_lblContraste.anchor = GridBagConstraints.WEST;
		gbc_lblContraste.insets = new Insets(0, 5, 5, 0);
		gbc_lblContraste.gridx = 0;
		gbc_lblContraste.gridy = 2;
		panelOpciones.add(lblContraste, gbc_lblContraste);
		
		cbxVista = new JComboBox();
		cbxVista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cambiarVisionEscala(((JComboBox)e.getSource()).getSelectedIndex());
			}
		});
		cbxVista.setModel(new DefaultComboBoxModel(new String[] {"CENTRADO", "ESTIRADO", "SIMPLE"}));
		cbxVista.setSelectedIndex(0);
		GridBagConstraints gbc_cbxVista = new GridBagConstraints();
		gbc_cbxVista.insets = new Insets(0, 0, 5, 0);
		gbc_cbxVista.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbxVista.gridx = 0;
		gbc_cbxVista.gridy = 3;
		panelOpciones.add(cbxVista, gbc_cbxVista);
		
		menuBar = new JMenuBar();
		frmProcesadorDeImagenes.setJMenuBar(menuBar);
		
		mnArchivo = new JMenu("Archivo");
		menuBar.add(mnArchivo);
		
		mntmImportarImagen = new JMenuItem("Importar imagen");
		mntmImportarImagen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
	            System.out.println("asdasd");

				JFileChooser fc= new JFileChooser();
				
				FileNameExtensionFilter filter = new FileNameExtensionFilter("Imagenes JPG", "jpg");
				fc.setFileFilter(filter);
				
				fc.setCurrentDirectory(new File("C:\\EclipseLuna workspace\\ProcImagenes\\imagenes"));

		        int returnVal = fc.showOpenDialog(frmProcesadorDeImagenes );

		        if (returnVal == JFileChooser.APPROVE_OPTION) {
		            File file = fc.getSelectedFile();
		            
		            System.out.println("Opening: " + file.getPath() + ".");
		            direccion = file.getPath();
		            crearImagenes();
		        } else 
		        	System.out.println("Open command cancelled by user.");
		        
			}
		});
		mntmImportarImagen.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			}
		});
		mnArchivo.add(mntmImportarImagen);
		
		mntmSalir = new JMenuItem("Salir");
		mntmSalir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
			}
		});
		mnArchivo.add(mntmSalir);
	}
	
	private void cambiarVisionEscala(int index){

		
		switch (index){
		//mediana
		case 0:
			PanelImagen.cambiarTipoEscala(TipoEscala.CENTRADO);			
			break;
		case 1:
			PanelImagen.cambiarTipoEscala(TipoEscala.ESTIRADO);
			break;
		case 2:
			PanelImagen.cambiarTipoEscala(TipoEscala.SIMPLE);
			break;
		}
		
		imagen1.repaint();
		imagen2.repaint();
		imagen3.repaint();
		imagen4.repaint();
		
	 
	}
	
	private void cambiarTipoFiltro(int index){

		//PanelImagen.cambiarTipoEscala(TipoEscala.CENTRADO);
		BufferedImage img3 = null;
		switch (index){
		//mediana
		case 0:
			FiltroNoRuidoMediana filtro  = new FiltroNoRuidoMediana();	
			img3 = PanelImagen.procesarImagenGrises( filtro.aplicarFiltro(InfoImagen.getMatrizIntensidadesGris(imagen2.getImagen())));
			break;

		//media
		case 1:
			FiltroNoRuidoMedia filtro2  = new FiltroNoRuidoMedia();	
			img3 = PanelImagen.procesarImagenGrises( filtro2.aplicarFiltro(InfoImagen.getMatrizIntensidadesGris(imagen2.getImagen())));
			break;
		}
		BufferedImage img4 = PanelImagen.procesarImagenGrises( filtroEcualizacion.aplicarFiltro(InfoImagen.getMatrizIntensidadesGris(img3)));

		imagen3.setImagen(img3);
		imagen4.setImagen(img4);
		
		imagen3.repaint();
		imagen4.repaint();
		imagenHistogramaFinal.setImagen(CreadorHistograma.componerImagen(300, 150, img4));
		imagenHistogramaFinal.repaint();
	}
	
	private void recargarImagen(){
		BufferedImage imgOrig = cargadorImagen.cargarImagen(direccion);
	}
	
	private void crearImagenes(){
		
		BufferedImage imgOrig = cargadorImagen.cargarImagen(direccion);
		
		FiltroNoRuidoMedia filtro2 = new FiltroNoRuidoMedia();	
		FiltroNoRuidoMediana filtro  = new FiltroNoRuidoMediana();	
		filtroEcualizacion  = new FiltroEcualizacion(0,255);	
		
		//InfoImagen infoImgOriginal = new InfoImagen(imgOrig);		
		BufferedImage imgOrigbn = PanelImagen.procesarImagenGrises( InfoImagen.getMatrizIntensidadesGris(imgOrig));
		
		//InfoImagen infoImgOrigBN = new InfoImagen(imgOrigbn);		
		BufferedImage imgOrigFiltro = PanelImagen.procesarImagenGrises( filtro.aplicarFiltro(InfoImagen.getMatrizIntensidadesGris(imgOrigbn)));
		
		BufferedImage imgEcualizada = PanelImagen.procesarImagenGrises( filtroEcualizacion.aplicarFiltro(InfoImagen.getMatrizIntensidadesGris(imgOrigFiltro)));
		 	
		imagen1.setImagen(imgOrig);
		imagen2.setImagen(imgOrigbn);
		imagen3.setImagen(imgOrigFiltro);
		imagen4.setImagen(imgEcualizada);
		
		imagen1.repaint();
		imagen2.repaint();
		imagen3.repaint();
		imagen4.repaint();
		
		imagenHistogramaInicial.setImagen(CreadorHistograma.componerImagen(300, 150, imgOrig));
		imagenHistogramaFinal.setImagen(CreadorHistograma.componerImagen(300, 150, imgEcualizada));		
	}
}

