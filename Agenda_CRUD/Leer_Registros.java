package Agenda_CRUD;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Leer_Registros extends JFrame implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		setTitle("MODIFICAR REGISTROS");
		setBounds(1250,400,400,600);
		try {
			add(new lamina_Modificar());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Estado_Ventana objeto_escucha = new Estado_Ventana();
		//addWindowListener(objeto_escucha);
		setVisible(true);
	}

}
class lamina_Modificar extends JPanel{
	public  lamina_Modificar() throws SQLException {
		 BBDD.initConnection();
		 id = new JLabel("ID:                                          ");
		 id.setFont(new Font("Arial",Font.BOLD, 16));
		 add(id);
		 cid = new  JTextField (10);
		 add(cid);
		 nombre = new JLabel ("Nombre nuevo registro: ");
		 nombre.setFont(new Font("Arial",Font.BOLD, 16));
		 add(nombre);
		 cnombre = new  JTextField (10);
		 add(cnombre);
		 System.out.println("\n");
		 apellido= new JLabel ("Apellido nuevo registro: ");
		 apellido.setFont(new Font("Arial",Font.BOLD, 16));
		 add(apellido);
		 capellido = new  JTextField (10);
		 add(capellido);
		 
		 
		 movil= new JLabel ("Número móvil:                   ");
		 movil.setFont(new Font("Arial",Font.BOLD, 16));
		 add(movil);
		 cmovil = new  JTextField (10);
		 add(cmovil);
		 
		 fijo= new JLabel ("Número fijo:                        ");
		 fijo.setFont(new Font("Arial",Font.BOLD, 16));
		 add(fijo);
		 cfijo = new  JTextField (10);
		 add(cfijo);
		 
		 
		 anotacion = new JLabel("Anotacion");
		 anotacion.setFont(new Font("Arial",Font.BOLD, 16));
		 add(anotacion);
		 canotacion = new JTextArea(15,32);
		 JScrollPane laminaScrollCliente = new JScrollPane(canotacion);
		 canotacion.setLineWrap(true);
		 
		 add(laminaScrollCliente);
		 BBDD.leerRegistros(canotacion);
		 
			/*int res = JOptionPane.showConfirmDialog( null, "¿Quieres Modificar alguno de los registros?", "Confirm",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			if ( res == JOptionPane.NO_OPTION )  JOptionPane.showInputDialog("Hasta pronto: ");
			if (res == JOptionPane.YES_OPTION) {
				JOptionPane.showMessageDialog(null, "Debe de introduccir el ID del contacto que desea mofidicar");
				Long resultado_id = Long.parseLong(cid.getText());
				cid.setText(cid.getText());
				String nombre =cnombre.getText();
				cnombre.setText(nombre);
				String apellido = capellido.getText();
				capellido.setText(apellido);
				String movil = cmovil.getText();
				cmovil.setText(movil);
				String fijo =cfijo.getText();
				cfijo.setText(fijo);
				String anotacion =JOptionPane.showInputDialog("Ingresa la nueva anotación : ");
				canotacion.append(anotacion);
				Modificar_clase = new JButton ("MODIFICAR");
				BBDD.ModificarDatos(resultado_id , nombre, apellido, movil,fijo,anotacion);
				JOptionPane.showMessageDialog(null, "Se ha efectuado la modificación con existo");
			}*/
		 		
	
		 System.out.println("HAsta aquí bien");
		 
	}
	private JTextArea contenido;
	private JLabel id,nombre,apellido,movil,fijo,anotacion,anotacionextra;
	private JTextField cid,cnombre,capellido,cmovil,cfijo,cid_busqueda;
	private JTextArea canotacion;
	private JButton Registro,Leer,Modificar_clase,Borrar,Salir,Documentacion,Licencia,ver_dato;
	private static final Scanner  scanner= new Scanner(System.in);
}