package co.edu.uptc.presentacion.GUI;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GUIInventario extends JFrame {
	
	private JLabel Logo;
	private JPanel MENUINDEX;
	private JPanel Header;
	private JLabel Backbutton;
	private JLabel Backtext;
	private JLabel Nombre;
	private JLabel Eslogan;
	private JButton Factura;
	private JButton Pedido;
	private ImageIcon SILAUICON;
	private Font pixelMplus;
	private ImageIcon IconoPequeno;

	public GUIInventario() {
		
		//COMPONENTES DEL MENU PEDIDOS
		Header = new JPanel();
		Backbutton = new JLabel();
		Backtext = new JLabel();
		Logo = new JLabel();
		Nombre = new JLabel();
		Eslogan = new JLabel();
		Factura = new JButton();
		Pedido = new JButton();
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
		MENUINDEX.setBackground(Color.white);
		
		
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
			Backtext.setText("Inventario");
			Backtext.setFont(getCustomFont(18));
			Backtext.setSize((int) Backtext.getPreferredSize().getWidth(),50);
		
			Backtext.setLocation(180-(Backtext.getWidth()/2), 0);
			Backtext.setForeground(Color.white);
		//SETEO DE LOGO
		Logo.setSize(140, 97);
		Logo.setIcon(new ImageIcon(SILAUICON.getImage().getScaledInstance(140, 97, Image.SCALE_DEFAULT)));
		Logo.setLocation(180-(Logo.getWidth()/2),50+50);
		Logo.setBackground(Color.orange);
		//SETEO DE NOMBRE 
		Nombre.setFont(getCustomFont(18));
		Nombre.setText("SILAU S.A.S");
		Nombre.setSize(Nombre.getPreferredSize());
		Nombre.setLocation(180-(Nombre.getWidth()/2), 160+50);
		Eslogan.setForeground(Color.decode("#35424A"));
		//SETEO ESLOGAN
		Eslogan.setFont(getCustomFont(14));
		Eslogan.setText("Arte hecho a mano");
		Eslogan.setSize(Eslogan.getPreferredSize());
		Eslogan.setLocation(180-(Eslogan.getWidth()/2), 185+50);
		Eslogan.setForeground(Color.decode("#B3B3BA"));
		
		//SETEO DE BOTON NUEVO PEDIDO
		Pedido.setFont(getCustomFont(14));
		Pedido.setFocusable(false);
		Pedido.setForeground(Color.decode("#35424A"));
		Pedido.setText("Agregar productos");
		Pedido.setSize(Pedido.getPreferredSize());
		Pedido.setSize(360,55);
		Pedido.setLocation(0,240+50);
		Pedido.setAlignmentX(CENTER_ALIGNMENT);
		Pedido.setBackground(Color.white);
		//Pedido.setForeground(Color.decode("#35424A"));
		Pedido.setBorder(BorderFactory.createEmptyBorder());
		clicked(1);

		
		//SETEO DE BOTON BUSCAR FACTURA
		Factura.setFont(getCustomFont(14));
		Factura.setFocusable(false);
		Factura.setForeground(Color.decode("#35424A"));
		Factura.setText("Mostra productos");
		Factura.setSize(Factura.getPreferredSize());
		Factura.setSize(360,55);
		Factura.setLocation(0,295+50);
		Factura.setAlignmentX(CENTER_ALIGNMENT);
		Factura.setBackground(Color.white);
		//Factura.setForeground(Color.decode("#35424A"));
		Factura.setBorder(BorderFactory.createEmptyBorder());
		
		
		
		
		MENUINDEX.add(Backbutton);
		MENUINDEX.add(Backtext);
		MENUINDEX.add(Header);
		MENUINDEX.add(Logo);
		MENUINDEX.add(Nombre);
		MENUINDEX.add(Eslogan);
		MENUINDEX.add(Pedido);
		MENUINDEX.add(Factura);
		
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
					new GUINuevoProducto().show();
					
					dispose();
					break;
					
				case 2:
					//METODO PARA ENTRAR A PESTANA DE BUSCAR PEDIDOS
					new GUIBuscarProducto().show();
					dispose();
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
			Pedido.addMouseListener(ms);
			break;
			
		case 2:
			Factura.addMouseListener(ms);
			break;
		
			
		}
	}
}


	