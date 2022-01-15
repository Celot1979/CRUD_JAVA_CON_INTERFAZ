package Agenda_CRUD;
import java.sql.SQLException;
import java.util.Scanner;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/*
 * En la 1a Clase se crea para tener un evento del ratón, que al ser presionado el botón derecho llame a JFRame y a el JPanel
 */
/*class EventosDeRaton extends MouseAdapter{

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		if (e.getModifiersEx() == 4096) {
			System.out.println("He presionado el boton derecho");
			marco_raton marc = new marco_raton();
			marc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			
			 
		}
		
		
	}

}*/
// Aquí empezaremos a crear lo que es el Marco que le dará unas proporciones a JFrame
/*class marco_raton extends JFrame{
	public marco_raton() {
		this.setResizable(false);
		setTitle("Menu");
		setBounds(400,400,120,200);
		add(new Lamina_Menu_Raton());
		setVisible(true);
		
	}

	
	}*/

//Aquí empezaremos crearemos la lámina que contendrá todo el código del menú en vertical

/*class Lamina_Menu_Raton extends JPanel{
	public Lamina_Menu_Raton() {
		BBDD.initConnection();
//		Barra del menú
		
		 menuBar = new JMenuBar();
		 menuBar.setLayout(new GridLayout(0,1));
		 
//		 Contenido de la barra del menú
		 
		 JMenu Acciones = new JMenu(" ACCIONES ");
		// Acciones.setMnemonic(KeyEvent.VK_F);
		 JMenuItem registro = new JMenuItem("REGISTRAR");
		 registro.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
			 
		 });
		 JMenuItem leer= new JMenuItem("LEER");
		 JMenuItem modificar= new JMenuItem("MODIFICAR");
		 JMenuItem borrar= new JMenuItem("BORRAR");
		 Acciones.add(registro);
		 Acciones.add(leer);
		 Acciones.add(modificar);
		 Acciones.add(borrar);
		 menuBar.add(Acciones);
		 
		 
		 JMenu Acciones2 = new JMenu(" AYUDA  ");
		 //fileMenu.setMnemonic(KeyEvent.VK_F);
		 menuBar.add(Acciones2);
		 
		 add(menuBar);
		 
		 
		 JMenu Acciones3 = new JMenu(" LICENCIA  ");
		 //fileMenu.setMnemonic(KeyEvent.VK_F);
		 menuBar.add(Acciones3);
		 
		 add(menuBar);
	}
	private  JMenuBar menuBar;
	private JLabel id,nombre,apellido,movil,fijo,anotacion,anotacionextra;
	private JTextField cid,cnombre,capellido,cmovil,cfijo;
	private JTextArea canotacion;
	private JButton Crear,Leer,Modificar,Borrar,Salir;
	private static final Scanner  scanner= new Scanner(System.in);
}*/