package Agenda_CRUD;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

import javax.swing.*;

/*
 * En está clase está viinculado todo el código que hace referencia a la ventana emergente de lectura de contacto.
 * 
 * Posteriormente la clase del JFrame será llamada en un hilo para que ejecute independientemente la consulta a la BBDD mediante SQL
 */

class marco_Registro extends JFrame{
	public  marco_Registro() {
		setTitle("Registros");
		setBounds(1250,400,800,400);
		add(new lamiana_Lectura_Registro());
		//Estado_Ventana objeto_escucha = new Estado_Ventana();
		//addWindowListener(objeto_escucha);
		setVisible(true);
		
	}
}

class lamiana_Lectura_Registro extends JPanel{
	public lamiana_Lectura_Registro() {
		 contenido = new JTextArea(15,50);
		 JScrollPane laminaScrollCliente = new JScrollPane(contenido);
		 contenido.setLineWrap(true);
		 try {
			BBDD.leerRegistros(contenido);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("No se pudo leer");
		}
		 add(laminaScrollCliente);
		 
	}
	private JTextArea contenido;
	
}

