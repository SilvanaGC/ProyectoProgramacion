package co.edu.uptc.presentacion.GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GUIProducto extends JFrame {
	
	private JLabel Logo;
	private JPanel MENUINDEX;
	private JPanel Header;
	private JLabel Backbutton;
	private JLabel Backtext;
	private JPanel pButtonProducto;
		private JButton AddProducto;
		
	private JButton AddFactura;
	private Font pixelMplus;
	private ImageIcon SILAUICON;
	private ImageIcon IconoPequeno;
	
	private JPanel pCodigo;
		private JLabel lCodigo;
		private JComboBox tCodigo;
			//solo para testeo borrar cuando antes
			private String[] NOMBRESPRUEBA = {"NOMBRE 1","NOMBRE 2","NOMBRE 3"};
			
	private JPanel pNameProducto;
		private JLabel lNameProducto;
		private JTextField tNameProducto;
		
	private JPanel pTamano;
		private JLabel lTamano;
		private JTextField tTamano;
		
	private JPanel pCantidad;
		private JLabel lCantidad;
		private JTextField tCantidad;
	
	public GUIProducto() {
		
		//COMPONENTES DEL MENU PEDIDOS
		Header = new JPanel();
		Backbutton = new JLabel();
		Backtext = new JLabel();
		Logo = new JLabel();
		pButtonProducto = new JPanel();
			AddProducto = new JButton();
		AddFactura = new JButton();
		pCodigo = new JPanel();
			lCodigo = new JLabel();
			tCodigo = new JComboBox(NOMBRESPRUEBA);
		pNameProducto= new JPanel();
			lNameProducto = new JLabel();
			tNameProducto = new JTextField();
			
		pTamano = new JPanel();
			lTamano = new JLabel();
			tTamano = new JTextField();
		
		pCantidad = new JPanel();
			lCantidad = new JLabel();
			tCantidad = new JTextField();
			
		
		SILAUICON = new ImageIcon("Recursos/textures/SILAUICON.png");
		IconoPequeno = new ImageIcon("Recursos/textures/SILAUICONminijpg.jpg");
		//setSize(370,540);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setLayout(null);
		setTitle("SILAU S.A.S");
		setIconImage(IconoPequeno.getImage());
		getContentPane().setBackground(Color.BLACK);
		add(getMenuIndex());
		pack();
		setLocationRelativeTo(null);
		setResizable(false);
		
		//setSize(this.getPreferredSize());
		
		
	}
	private JPanel getMenuIndex() {
		
		MENUINDEX = new JPanel();
		
		MENUINDEX.setPreferredSize(new Dimension(360,540));
		MENUINDEX.setLayout(null);
		MENUINDEX.setBackground(Color.decode("#dee2e6"));
		
		
		//SETEO HEADEAR
		Header.setSize(360,50);
		Header.setBackground(Color.decode("#ff6d24"));
		Header.setLocation(0, 0);
		
		
		
			//SETEO BOTON HEADER
			
			Backbutton.setText("<");
			Backbutton.setFont(getCustomFont(18));
			
			Backbutton.setSize(50,50);
			Backbutton.setLocation(10, 0);
			Backbutton.setForeground(Color.white);
			clicked(0);
			//SETEO TEXTO HEADER
			Backtext.setText("Agregar producto");
			Backtext.setFont(getCustomFont(18));
			Backtext.setSize((int) Backtext.getPreferredSize().getWidth(),50);
		
			Backtext.setLocation(180-(Backtext.getWidth()/2), 0);
			Backtext.setForeground(Color.white);
		//SETEO DE PANEL CODIGO
		pCodigo.setSize(360, 50);
		pCodigo.setLayout(null);
		pCodigo.setBackground(Color.white);
		pCodigo.setLocation(0, 50);
			//SETEO TEXTO CODIGO
			lCodigo.setForeground(Color.decode("#35424A"));
			lCodigo.setFont(getCustomFont(14));
			lCodigo.setText("Codigo");
			lCodigo.setSize(lCodigo.getPreferredSize());
			lCodigo.setLocation(10, 25-(lCodigo.getHeight()/2));
			//SETEO COMBO BOX CODIGO
			tCodigo.setFont(getCustomFont(14));
			tCodigo.setForeground(Color.decode("#35424A"));
			tCodigo.setBackground(Color.decode("#dee2e6"));
			tCodigo.setSize(180, 40);
			tCodigo.setLocation(170, 25-(tCodigo.getHeight()/2));
			tCodigo.setToolTipText("test");
		pCodigo.add(lCodigo);
		pCodigo.add(tCodigo);
		//SETEO DE PANEL NUMERO NOMBRE PRODUCTO
		pNameProducto.setSize(360, 50);
		pNameProducto.setLayout(null);
		pNameProducto.setBackground(Color.white);
		pNameProducto.setLocation(0, 102);
			//SETEO TEXTO NOMBRE PRODUCTO
			lNameProducto.setForeground(Color.decode("#35424A"));
			lNameProducto.setFont(getCustomFont(14));
			lNameProducto.setText("Nombre producto");
			lNameProducto.setSize(lNameProducto.getPreferredSize());
			lNameProducto.setLocation(10, 25-(lCodigo.getHeight()/2));
			//SETEO NOMBRE PRODUCTO
			tNameProducto.setFont(getCustomFont(14));
			tNameProducto.setForeground(Color.decode("#35424A"));
			tNameProducto.setBackground(Color.decode("#dee2e6"));
			tNameProducto.setSize(120, 40);
			tNameProducto.setLocation(230,  25-(tNameProducto.getHeight()/2));
			tNameProducto.setToolTipText("test2");
			tNameProducto.setEditable(false);
			tNameProducto.setText("1");
		pNameProducto.add(lNameProducto);
		pNameProducto.add(tNameProducto);
		//SETEO DE PANEL TAMANO
		pTamano.setSize(360, 50);
		pTamano.setLayout(null);
		pTamano.setBackground(Color.white);
		pTamano.setLocation(0, 154);
			//SETEO TEXTO TAMANO
			lTamano.setForeground(Color.decode("#35424A"));
			lTamano.setFont(getCustomFont(14));
			lTamano.setText("Tamaño");
			lTamano.setSize(lTamano.getPreferredSize());
			lTamano.setLocation(10, 25-(lCodigo.getHeight()/2));
			//SETEO TAMANO
			tTamano.setFont(getCustomFont(14));
			tTamano.setForeground(Color.decode("#35424A"));
			tTamano.setBackground(Color.decode("#dee2e6"));
			tTamano.setSize(120, 40);
			tTamano.setLocation(230, 25-(tTamano.getHeight()/2));
			tTamano.setToolTipText("test2");
			tTamano.setEditable(false);
			tTamano.setText(java.time.LocalDate.now().toString());
		
		pTamano.add(lTamano);
		pTamano.add(tTamano);
		//SETEO DE PANEL CANTIDAD
		pCantidad.setSize(360, 50);
		pCantidad.setLayout(null);
		pCantidad.setBackground(Color.white);
		pCantidad.setLocation(0, 206);
			//SETEO TEXTO CANTIDAD
			lCantidad.setForeground(Color.decode("#35424A"));
			lCantidad.setFont(getCustomFont(14));
			lCantidad.setText("Cantidad");
			lCantidad.setSize(lCantidad.getPreferredSize());
			lCantidad.setLocation(10, 25-(lCodigo.getHeight()/2));
			//SETEO CANTIDAD
			tCantidad.setFont(getCustomFont(14));
			tCantidad.setForeground(Color.decode("#35424A"));
			tCantidad.setBackground(Color.decode("#dee2e6"));
			tCantidad.setSize(120, 40);
			tCantidad.setLocation(230,  25-(tCantidad.getHeight()/2));
			tCantidad.setToolTipText("test2");
			tCantidad.setEditable(false);
			tCantidad.setText("1");
		pCantidad.add(lCantidad);
		pCantidad.add(tCantidad);
		//SETEO PANEL BOTON 
		pButtonProducto.setBackground(Color.white);
		pButtonProducto.setSize(360, 266);
		pButtonProducto.setLayout(null);
		pButtonProducto.setLocation(0, 274);
		
			
			//SETEO BOTON GUARDAR
		
			
			AddProducto.setBackground(Color.decode("#ff6d24"));
			AddProducto.setFont(getCustomFont(16));	
			AddProducto.setForeground(Color.white);
			AddProducto.setText("Agregar");
			
			AddProducto.setSize((int) AddProducto.getPreferredSize().getWidth(),40);
			
			
			
			AddProducto.setLocation(180-(AddProducto.getWidth()/2), 20);
			clicked(1);
			//AddProducto.setFocusable(false);
		
		pButtonProducto.add(AddProducto);
		
		//ANADIR COSAS AL PANEL
		MENUINDEX.add(Backbutton);
		MENUINDEX.add(Backtext);
		MENUINDEX.add(Header);
		MENUINDEX.add(pCodigo);
		MENUINDEX.add(pNameProducto);
		MENUINDEX.add(pTamano);
		MENUINDEX.add(pCantidad);
		MENUINDEX.add(pButtonProducto);
		
		return MENUINDEX;
	}
	
	private Font getCustomFont(int i) {
		
		
		try{
            // load a custom font in your project folder
			pixelMplus = Font.createFont(Font.TRUETYPE_FONT, new File("Recursos/Fonts/Quicksand-Bold.ttf")).deriveFont(Float.parseFloat(i+"f"));	
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("Recursos/Fonts/Quicksand-Bold.ttf")));			
		}
		catch(IOException | FontFormatException e){
			System.err.print("ERROR DE FUENTE");
		}
		
		
		return pixelMplus;
	}
	
	private void clicked(int code) {
		
		MouseListener ms = new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent e) {
				// ABRE NUEVA VENTANA
			
				
				switch(code) {
				case 0:
					//METODO PARA VOLVER A PESTANA ANTERIOR
					new GUINuevoPedido().show();
					
					dispose();
					break;
				
				case 1:
					GUINuevoPedido np = new GUINuevoPedido();
					np.addProducto(Integer.toString(tCodigo.getSelectedIndex()),tNameProducto.getText(),tTamano.getText(),tCantidad.getText());
					np.show();
					setVisible(false);
					break;
					
				case 2:
					
					break;
				
					
				
					
				}
				
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// NO HACE NADA
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// NO HACE NADA
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// NO HACE NADA
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// NO HACE NADA
				
			}
			
		};
		
		
		switch(code) {
		case 0 :
			Backbutton.addMouseListener(ms);
			break;
		case 1:
			AddProducto.addMouseListener(ms);
			break;
			
		case 2:
			
			break;
		
			
		}
	}
}