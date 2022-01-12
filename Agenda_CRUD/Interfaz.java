package Agenda_CRUD;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.SQLException;
import java.util.Scanner;

import javax.swing.*;


public class Interfaz {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		marco m = new marco();
		m.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		m.addKeyListener(new Eventos_teclado ());
	}

}
class marco extends JFrame{
	public marco() {
		this.setResizable(false);
		setTitle("AGENDA");
		setBounds(400,400,800,400);
		add(new lamina());
		setVisible(true);
		
	}

	
	}


class lamina extends JPanel{
	public lamina() {
		BBDD.initConnection();
		JPanel Inferior= new JPanel ();
		id = new JLabel("ID");
		cid= new JTextField(3);
		nombre = new JLabel("Nombre");
		cnombre = new JTextField(10);
		apellido = new JLabel("Apellido");
		capellido = new JTextField(10);
		movil = new JLabel("Movil");
		cmovil = new JTextField(10);
		fijo = new JLabel("Fijo");
		cfijo = new JTextField(10);
		anotacion = new JLabel("Anotacion");
		anotacionextra = new JLabel("");
		canotacion = new JTextArea(15,60);
		JScrollPane laminaScrollCliente = new JScrollPane(canotacion);
		canotacion.setLineWrap(true);
		
		Crear = new JButton ("Crear");
		Crear.addActionListener(new ActionListener() {
			// Cramos los registros al presionar el botón.
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String nom = cnombre.getText();
				String ape = capellido.getText();
				String mov = cmovil.getText();
				String fij = cfijo.getText();
				String cano = canotacion.getText();
				
				
				
				BBDD.Crear(nom, ape, mov, fij, cano);
				
				cnombre.setText("");
				capellido.setText("");
				cmovil.setText("");
				cfijo.setText("");
				canotacion.setText("");
				
				JOptionPane.showMessageDialog(null, "Registro realizado con éxito");
			}
			
		});
		Leer = new JButton ("Leer");
		Leer.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				marco_Registro mr = new marco_Registro();
				mr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
				
			}
			
		});
		Modificar = new JButton ("Modificar ");
		Modificar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				//System.out.println("Ingrese id de la persona que quiera modifiar los datos:");
				String ids = JOptionPane.showInputDialog("Ingresa el Id que queires mdificar");
				Long resultado_id = Long.parseLong(ids);
				cid.setText(ids);
				String nombre =JOptionPane.showInputDialog("Ingresa el nuevo nombre: ");
				cnombre.setText(nombre);
				String apellido = JOptionPane.showInputDialog("Ingresa los nuevos apellidos: ");
				capellido.setText(apellido);
				String movil = JOptionPane.showInputDialog("Ingresa el número de móvil nuevo: ");
				cmovil.setText(movil);
				String fijo =JOptionPane.showInputDialog("Ingresa el número de fijo nuevo: ");
				cfijo.setText(fijo);
				String anotacion =JOptionPane.showInputDialog("Ingresa la nueva anotación : ");
				canotacion.append(anotacion);

				try {
					BBDD.ModificarDatos(resultado_id , nombre, apellido, movil,fijo,anotacion);
					System.out.println("Se ha modificado correctamente");
					marco_Registro Lerr_modificacion= new marco_Registro();
					Thread.sleep(2000);
					cid.setText("");
					cnombre.setText("");
					capellido.setText("");
					cmovil.setText("");
					cfijo.setText("");
					canotacion.setText("");
					Lerr_modificacion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				} catch (SQLException | InterruptedException e1) {
					// TODO Auto-generated catch block
					System.out.println("No se ha podido modificar");
				}
			}
			
		});
		Borrar= new JButton ("Borrar");
		Borrar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					BBDD.EliminarRegistros(cid);
					System.out.println("Se ha podido borrar el registro");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					System.out.println("No se ha podido borrar el registro");
				}
			}
			
		});
		id.setLocation(27, 20);
		add(id);
		add(cid);
		add(nombre);
		add(cnombre);
		add(apellido);
		add(capellido);
		add(movil);
		add(cmovil);
		add(fijo);
		add(cfijo);
		
		
		add(anotacion);
		add(anotacionextra);
		add(laminaScrollCliente);
		
		
		
		Inferior.add(Crear);
		Inferior.add(Leer);
		Inferior.add(Modificar);
		Inferior.add(Borrar);
		
		add(Inferior, BorderLayout.SOUTH);
		
		
		
	}

	class Eventos_teclado implements  KeyListener{

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			if(e.getKeyCode() == KeyEvent.VK_C) {
				String nom = cnombre.getText();
				String ape = capellido.getText();
				String mov = cmovil.getText();
				String fij = cfijo.getText();
				String cano = canotacion.getText();
				
				BBDD.Crear(nom, ape, mov, fij, cano);
				cnombre.setText("");
				capellido.setText("");
				cmovil.setText("");
				cfijo.setText("");
				canotacion.setText("");
				
				JOptionPane.showMessageDialog(null, "Registro realizado con éxito");
			}
			
		}

		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	
	private JLabel id,nombre,apellido,movil,fijo,anotacion,anotacionextra;
	private JTextField cid,cnombre,capellido,cmovil,cfijo;
	private JTextArea canotacion;
	private JButton Crear,Leer,Modificar,Borrar;
	private static final Scanner  scanner= new Scanner(System.in);
}

class Eventos_teclado implements  KeyListener{

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode() ==  KeyEvent.VK_ALT + KeyEvent.VK_C) {
			String nom = cnombre.getText();
			String ape = capellido.getText();
			String mov = cmovil.getText();
			String fij = cfijo.getText();
			String cano = canotacion.getText();
			
			BBDD.Crear(nom, ape, mov, fij, cano);
			cnombre.setText("");
			capellido.setText("");
			cmovil.setText("");
			cfijo.setText("");
			canotacion.setText("");
			
			JOptionPane.showMessageDialog(null, "Registro realizado con éxito");
		}
		
	}
	private JLabel id,nombre,apellido,movil,fijo,anotacion,anotacionextra;
	private JTextField cid,cnombre,capellido,cmovil,cfijo;
	private JTextArea canotacion;
	private JButton Crear,Leer,Modificar,Borrar;
	private static final Scanner  scanner= new Scanner(System.in);
	
}


