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
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import co.edu.uptc.logica.modelo.Producto;

public class GUIFactura extends JFrame {
	
	
	private ArrayList<String> data;
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
	
	private JPanel pCliente;
		private JLabel lCliente;
		private JComboBox tCliente;
			//solo para testeo borrar cuando antes
		
			private String[] NOMBRESPRUEBA = {"NOMBRE 1","NOMBRE 2","NOMBRE 3"};
			
	private JPanel pNumPedido;
		private JLabel lNumPedido;
		private JTextField tNumPedido;
		
	private JPanel pFechaEntrega;
		private JLabel lFechaEntrega;
		private JTextField tFechaEntrega;
	
	private JPanel pTabla;
		private JTable jtTabla;
		private DefaultTableModel tableModel;
		private JScrollPane scrollpanel;
		 //solo para testear
	
	private GUIProducto frProducto;
	
	public GUIFactura() {
		
		
		//INICIALIZANCO FRAME
		
		//COMPONENTES DEL MENU PEDIDOS
		Header = new JPanel();
		Backbutton = new JLabel();
		Backtext = new JLabel();
		Logo = new JLabel();
		pButtonProducto = new JPanel();
			AddProducto = new JButton();
		AddFactura = new JButton();
		pCliente = new JPanel();
			lCliente = new JLabel();
			tCliente = new JComboBox(NOMBRESPRUEBA);
		pNumPedido= new JPanel();
			lNumPedido = new JLabel();
			tNumPedido = new JTextField();
			
		pFechaEntrega = new JPanel();
			lFechaEntrega = new JLabel();
			tFechaEntrega = new JTextField();
		
		pTabla = new JPanel();
			tableModel = new DefaultTableModel();
			tableModel.addColumn("Codigo");
			tableModel.addColumn("Producto");
			tableModel.addColumn("Tamaño");
			tableModel.addColumn("Cantidad");
			jtTabla = new JTable(tableModel);
			scrollpanel = new JScrollPane(jtTabla);
			
			
		
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
			Backtext.setText("Pedidos");
			Backtext.setFont(getCustomFont(18));
			Backtext.setSize((int) Backtext.getPreferredSize().getWidth(),50);
		
			Backtext.setLocation(180-(Backtext.getWidth()/2), 0);
			Backtext.setForeground(Color.white);
		//SETEO DE PANEL CLIENTES
		pCliente.setSize(360, 50);
		pCliente.setLayout(null);
		pCliente.setBackground(Color.white);
		pCliente.setLocation(0, 50);
			//SETEO TEXTO CLIENTE
			lCliente.setForeground(Color.decode("#35424A"));
			lCliente.setFont(getCustomFont(14));
			lCliente.setText("Cliente");
			lCliente.setSize(lCliente.getPreferredSize());
			lCliente.setLocation(10, 25-(lCliente.getHeight()/2));
			//SETEO COMBO BOX CLIENTES
			tCliente.setFont(getCustomFont(14));
			tCliente.setForeground(Color.decode("#35424A"));
			tCliente.setBackground(Color.decode("#dee2e6"));
			tCliente.setSize(180, 40);
			tCliente.setLocation(170, 25-(tCliente.getHeight()/2));
			tCliente.setToolTipText("test");
		pCliente.add(lCliente);
		pCliente.add(tCliente);
		//SETEO DE PANEL NUMERO PEDIDO
		pNumPedido.setSize(360, 50);
		pNumPedido.setLayout(null);
		pNumPedido.setBackground(Color.white);
		pNumPedido.setLocation(0, 102);
			//SETEO TEXTO NUMERO PEDIDO
			lNumPedido.setForeground(Color.decode("#35424A"));
			lNumPedido.setFont(getCustomFont(14));
			lNumPedido.setText("Numero de pedido");
			lNumPedido.setSize(lNumPedido.getPreferredSize());
			lNumPedido.setLocation(10, 25-(lCliente.getHeight()/2));
			//SETEO NUMERO PEDIDO
			tNumPedido.setFont(getCustomFont(14));
			tNumPedido.setForeground(Color.decode("#35424A"));
			tNumPedido.setBackground(Color.decode("#dee2e6"));
			tNumPedido.setSize(120, 40);
			tNumPedido.setLocation(230,  25-(tCliente.getHeight()/2));
			tNumPedido.setToolTipText("test2");
			tNumPedido.setEditable(false);
			tNumPedido.setText("1");
		pNumPedido.add(lNumPedido);
		pNumPedido.add(tNumPedido);
		//SETEO DE PANEL FECHA ENTREGA
		pFechaEntrega.setSize(360, 50);
		pFechaEntrega.setLayout(null);
		pFechaEntrega.setBackground(Color.white);
		pFechaEntrega.setLocation(0, 154);
			//SETEO TEXTO FECHA ENTREGA
			lFechaEntrega.setForeground(Color.decode("#35424A"));
			lFechaEntrega.setFont(getCustomFont(14));
			lFechaEntrega.setText("Fecha de entrega");
			lFechaEntrega.setSize(lFechaEntrega.getPreferredSize());
			lFechaEntrega.setLocation(10, 25-(lCliente.getHeight()/2));
			//SETEO FECHA ENTREGA
			tFechaEntrega.setFont(getCustomFont(14));
			tFechaEntrega.setForeground(Color.decode("#35424A"));
			tFechaEntrega.setBackground(Color.decode("#dee2e6"));
			tFechaEntrega.setSize(120, 40);
			tFechaEntrega.setLocation(230, 25-(tCliente.getHeight()/2));
			tFechaEntrega.setToolTipText("test2");
			tFechaEntrega.setEditable(false);
			tFechaEntrega.setText(java.time.LocalDate.now().toString());
		
		pFechaEntrega.add(lFechaEntrega);
		pFechaEntrega.add(tFechaEntrega);
		//SETEO PANEL BOTON 
		pButtonProducto.setBackground(Color.white);
		pButtonProducto.setSize(360, 50);
		pButtonProducto.setLayout(null);
		pButtonProducto.setLocation(0, 486);
			//SETEO BOTON AGREGAR PRODUCTO
		
			
			AddProducto.setBackground(Color.decode("#ff6d24"));
			AddProducto.setFont(getCustomFont(16));	
			AddProducto.setForeground(Color.white);
			AddProducto.setText("Producto");
			AddProducto.setSize((int) AddProducto.getPreferredSize().getWidth(),40);			
			AddProducto.setLocation(180-(AddProducto.getWidth()/2), 25-(AddProducto.getHeight()/2));
			AddProducto.setFocusable(false);
			
			
		pButtonProducto.add(AddProducto);
		//SETEO PANEL JTTABLA
		pTabla.setBackground(Color.white);
		pTabla.setSize(360, 500);

		pTabla.setLocation(0, 50);
			//SETEO JTTABLA
			jtTabla.setPreferredScrollableViewportSize(new Dimension(340,180));
			jtTabla.setFillsViewportHeight(true);
			
			
			pTabla.add(scrollpanel);
			
				
		
		//ANADIR COSAS AL PANEL
		
		
		MENUINDEX.add(Backbutton);
		MENUINDEX.add(Backtext);
		MENUINDEX.add(Header);
		//MENUINDEX.add(pCliente);
		//MENUINDEX.add(pNumPedido);
		//MENUINDEX.add(pFechaEntrega);
		//MENUINDEX.add(pButtonProducto);
		MENUINDEX.add(pTabla);
		
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
					new GUIindex().show();
					
					dispose();
					break;
				
				case 1:
					//METODO PARA ENTRAR A PESTANA DE GENERAR PEDIDOS
					
					
					
					break;
					
				case 2:
					//METODO PARA ENTRAR A PESTANA DE BUSCAR PEDIDOS
					
					
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
			
			break;
			
		case 2:
			
			break;
		
			
		}
	}
}