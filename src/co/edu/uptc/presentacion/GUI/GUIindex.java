package co.edu.uptc.presentacion.GUI;


import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

import javax.swing.*;

public class GUIindex extends JFrame {

	private JLabel Logo;
	private JPanel MENUINDEX;
	private JLabel Nombre;
	private JLabel Correo;
	private JButton Factura;
	private JButton Pedido;
	private JButton Inventario;
	private JButton Fabricacion;
	private ImageIcon SILAUICON;
	private ImageIcon IconoPequeno;
	private Font pixelMplus;
	
	
	public GUIindex() {
		
		//COMPONENTES DEL INDEX
		Logo = new JLabel();
		Nombre = new JLabel();
		Correo = new JLabel();
		Factura = new JButton();
		Pedido = new JButton();
		Inventario = new JButton();
		Fabricacion = new JButton();
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
		
		//SETEO DE LOGO
		Logo.setSize(140, 97);
		Logo.setIcon(new ImageIcon(SILAUICON.getImage().getScaledInstance(140, 97, Image.SCALE_DEFAULT)));
		Logo.setLocation(180-(Logo.getWidth()/2),50);
		Logo.setBackground(Color.orange);
		//SETEO DE NOMBRE 
		Nombre.setFont(getCustomFont(18));
		Nombre.setText("SILAU S.A.S");
		Nombre.setSize(Nombre.getPreferredSize());
		Nombre.setLocation(180-(Nombre.getWidth()/2), 160);
		Correo.setForeground(Color.decode("#35424A"));
		//SETEO NOMBRE DE CORREO
		Correo.setFont(getCustomFont(14));
		Correo.setText("SILAU S.A.S@company.com");
		Correo.setSize(Correo.getPreferredSize());
		Correo.setLocation(180-(Correo.getWidth()/2), 185);
		Correo.setForeground(Color.decode("#B3B3BA"));
		
		//SETEO DE BOTNO PEDIDO
		Pedido.setFont(getCustomFont(14));
		Pedido.setFocusable(false);
		Pedido.setText("Pedido");
		Pedido.setSize(Pedido.getPreferredSize());
		Pedido.setSize(360,55);
		Pedido.setLocation(0,240);
		Pedido.setAlignmentX(CENTER_ALIGNMENT);
		Pedido.setBackground(Color.white);
		//Pedido.setForeground(Color.decode("#35424A"));
		Pedido.setBorder(BorderFactory.createEmptyBorder());
		clicked(1);
		
		//SETEO DE BOTON FACTURA
		Factura.setFont(getCustomFont(14));
		Factura.setFocusable(false);
		Factura.setText("Factura");
		Factura.setSize(Factura.getPreferredSize());
		Factura.setSize(360,55);
		Factura.setLocation(0,295);
		Factura.setAlignmentX(CENTER_ALIGNMENT);
		Factura.setBackground(Color.white);
		//Factura.setForeground(Color.decode("#35424A"));
		Factura.setBorder(BorderFactory.createEmptyBorder());
		
		//SETEO DE BOTON INVENTARIO
		Inventario.setFont(getCustomFont(14));
		Inventario.setFocusable(false);
		Inventario.setText("Inventario");
		Inventario.setSize(Inventario.getPreferredSize());
		Inventario.setSize(360,55);
		Inventario.setLocation(0,350);
		Inventario.setAlignmentX(CENTER_ALIGNMENT);
		Inventario.setBackground(Color.white);
		//Inventario.setForeground(Color.decode("#35424A"));
		Inventario.setBorder(BorderFactory.createEmptyBorder());
		//SETEO DE BOTON FABRICACION
		Fabricacion.setFont(getCustomFont(14));
		Fabricacion.setFocusable(false);
		Fabricacion.setText("Fabricación");
		Fabricacion.setSize(Fabricacion.getPreferredSize());
		Fabricacion.setSize(360,55);
		Fabricacion.setLocation(0,405);
		Fabricacion.setAlignmentX(CENTER_ALIGNMENT);
		Fabricacion.setBackground(Color.white);
		//Fabricacion.setForeground(Color.decode("#35424A"));
		Fabricacion.setBorder(BorderFactory.createEmptyBorder());
		
		
		MENUINDEX.add(Logo);
		MENUINDEX.add(Nombre);
		MENUINDEX.add(Correo);
		MENUINDEX.add(Pedido);
		MENUINDEX.add(Factura);
		MENUINDEX.add(Inventario);
		MENUINDEX.add(Fabricacion);
		return MENUINDEX;
	}

	//PARA EXPORTAR FUENTES CUSTOM, COPIAR EL CODIGO Y PONER EL ARCHIVO DE LA FUENTE.TFF EN LA CARPETA Fonts
	//CAMBIAR LAS VARIABLES OBVIO
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
					break;
				
				case 1:
					new GUIPedidos().show();
					dispose();
					break;
					
				case 2:
					break;
				case 3:
					break;
					
				case 4:
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
		case 1:
			Pedido.addMouseListener(ms);
			break;
			
		case 2:
			Factura.addMouseListener(ms);
			break;
		case 3:
			Inventario.addMouseListener(ms);
			break;
			
		case 4:
			Fabricacion.addMouseListener(ms);
			break;
			
		}
		
		
		
	}
}
