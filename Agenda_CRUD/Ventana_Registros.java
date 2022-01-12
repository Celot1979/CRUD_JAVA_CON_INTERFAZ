package Agenda_CRUD;

mport java.sql.SQLException;

import javax.swing.*;

public class Venta_Registros {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
class marco_Registro extends JFrame{
	public  marco_Registro() {
		setTitle("Registros");
		setBounds(1250,400,800,400);
		add(new lamiana_Registro());
		setVisible(true);
	}
}

class lamiana_Registro extends JPanel{
	public lamiana_Registro() {
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
