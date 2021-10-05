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

public class GUINuevoPedido extends JFrame {
	
	private JLabel Logo;
	private JPanel MENUINDEX;
	private JPanel Header;
	private JLabel Backbutton;
	private JLabel Backtext;
	private JButton AddProducto;
	private JButton AddFactura;
	private Font pixelMplus;
	private ImageIcon SILAUICON;
	private ImageIcon IconoPequeno;
	
	public GUINuevoPedido() {
		
		//COMPONENTES DEL MENU PEDIDOS
		Header = new JPanel();
		Backbutton = new JLabel();
		Backtext = new JLabel();
		Logo = new JLabel();
		AddProducto = new JButton();
		AddFactura = new JButton();
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
			Backtext.setText("Nuevo Pedido");
			Backtext.setFont(getCustomFont(18));
			Backtext.setSize((int) Backtext.getPreferredSize().getWidth(),50);
		
			Backtext.setLocation(180-(Backtext.getWidth()/2), 0);
			Backtext.setForeground(Color.white);
		//SETEO DE LOGO
		Logo.setSize(140, 97);
		Logo.setIcon(new ImageIcon(SILAUICON.getImage().getScaledInstance(140, 97, Image.SCALE_DEFAULT)));
		Logo.setLocation(180-(Logo.getWidth()/2),50+50);
		Logo.setBackground(Color.orange);
		
		
		
		
		//ANADIR COSAS AL PANEL
		MENUINDEX.add(Backbutton);
		MENUINDEX.add(Backtext);
		MENUINDEX.add(Header);
		

		
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
					new GUIPedidos().show();
					
					dispose();
					break;
				
				case 1:
					
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
			
			break;
			
		case 2:
			
			break;
		
			
		}
	}
}