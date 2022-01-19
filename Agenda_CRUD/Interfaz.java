package Agenda_CRUD;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.SQLException;
import java.util.Scanner;

import javax.swing.*;






public class Interfaz {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		marco m = new marco();
//		Hace que el objeto principal quede a la escucha del evento del ratón. Que será el encargado de al presionar el botón derecho, apareza una nueva ventana con el menú
		//m.addMouseListener(new EventosDeRaton());
		
		m.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
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
//		Se llama a la función de conectar con la BBDD
		BBDD.initConnection();
		JPanel Inferior= new JPanel ();
		id = new JLabel("ID");
		cid= new JTextField(3);
		nombre = new JLabel("Nombre");
		cnombre = new JTextField(8);
		apellido = new JLabel("Apellido");
		capellido = new JTextField(8);
		movil = new JLabel("Movil");
		cmovil = new JTextField(8);
		fijo = new JLabel("Fijo");
		cfijo = new JTextField(8);
		anotacion = new JLabel("\t Anotacion");
		anotacionextra = new JLabel("");
		canotacion = new JTextArea(15,60);
		JScrollPane laminaScrollCliente = new JScrollPane(canotacion);
		canotacion.setLineWrap(true);
		
//		Menú emergente
		JPopupMenu emergente =new JPopupMenu();
		
		
		JMenuItem Registrar_Raton = new JMenuItem("REGISTRAR");
		 Registrar_Raton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// Inicializamos el hilo que nos abre la ventana de registros. En este caso vía ratón botón derecho.

				
				Ventana_Registros VR = new Ventana_Registros();
				Thread V = new Thread(VR);
				V.start();
				
			}
			
		});
		emergente.add( Registrar_Raton);
		
		
		JMenuItem  Mostrar_Raton = new JMenuItem("MOSTRAR REGISTROS");
		Mostrar_Raton .addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// Mediante la acción del botón se despliega un nuevo JFrame que está vinculado al hilo. En ese nuevo JFRame se realizará los registros en la BBDD
				Ventana_Leer_Registros r = new Ventana_Leer_Registros();
				Thread t = new Thread(r);
				t.start();
				
			}
			
		});
		emergente.add(Mostrar_Raton );
		
		
		JMenuItem Modificar_Raton = new JMenuItem("MODIFICAR REGISTROS");
		Modificar_Raton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//setBackground(Color.yellow);
				/*String ids = JOptionPane.showInputDialog("Ingresa el Id que queires mdificar");
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
					//Crea una nueva ventana creando un nuevo de el Jframe de la clase Ventana_Registros.
					marco_Registro Lerr_modificacion= new marco_Registro();
					Thread.sleep(2000);
					cid.setText("");
					cnombre.setText("");
					capellido.setText("");
					cmovil.setText("");
					cfijo.setText("");
					canotacion.setText("");
//					Cuando se modifica un registro, automaticamente se despliega una ventana con la info actualizada
					Lerr_modificacion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					
				} catch (SQLException | InterruptedException e1) {
					// TODO Auto-generated catch block
					System.out.println("No se ha podido modificar");
				}*/
				Leer_Registros ModificarRegistro = new Leer_Registros();
				Thread Modificar_Rarto= new Thread(ModificarRegistro);
				 Modificar_Rarto.start();
				
			}
			
			
			
		});
		emergente.add(Modificar_Raton);
		
		JMenuItem Borrar_Raton = new JMenuItem(" BORRAR  REGISTROS");
		Borrar_Raton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//setBackground(Color.yellow);
				try {
					BBDD.EliminarRegistros(cid);
					System.out.println("Se ha podido borrar el registro");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					System.out.println("No se ha podido borrar el registro");
				}
			}
			
			
			
		});
		
		emergente.add(Borrar_Raton);
		
		
		
		JMenuItem Salir_re = new JMenuItem("SALIR PROGRAMA");
		Salir_re.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//setBackground(Color.yellow);
				System.exit(1);
			}
			
			
			
		});
		
		emergente.add(Salir_re);
		
		
		
		
		
		
		
		
		
		
		setComponentPopupMenu(emergente);
		
//		Creación de botones y sus funciones dentro de la interfaz
		Crear = new JButton (" REGISTRAR ");
		Crear.addActionListener(new ActionListener() {
			// Cramos los registros al presionar el botón.
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Ventana_Registros VR = new Ventana_Registros();
				Thread V = new Thread(VR);
				V.start();
			}
			
		});
//		Botón y método ActionListener  para ejecutar el hilo que realiza la lectura de hilos. 
		Leer = new JButton (" MOSTRAR REGISTROS ");
		Leer.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Ventana_Leer_Registros r = new Ventana_Leer_Registros();
				Thread t = new Thread(r);
				t.start();
				
			}
			
		});
		Modificar = new JButton (" MODIFICAR REGISTROS ");
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
					//Crea una nueva ventana creando un nuevo de el Jframe de la clase Ventana_Registros.
					marco_Registro Lerr_modificacion= new marco_Registro();
					Thread.sleep(2000);
					cid.setText("");
					cnombre.setText("");
					capellido.setText("");
					cmovil.setText("");
					cfijo.setText("");
					canotacion.setText("");
//					Cuando se modifica un registro, automaticamente se despliega una ventana con la info actualizada
					Lerr_modificacion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					
				} catch (SQLException | InterruptedException e1) {
					// TODO Auto-generated catch block
					System.out.println("No se ha podido modificar");
				}
			}
			
		});
		Borrar= new JButton ("BORRAR REGISTRO ");
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
		
		Salir = new JButton (" SALIR ");
		Salir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				System.exit(1);
			}
			
		});
		
		Documentacion= new JButton ("DOCUMENTACIÓN");
		Licencia= new JButton ("LICENCIA");
		Licencia.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(null, "Programa registrado por Daniel Gil " + "\n" + "Solo uso formativo", "LEER ATENTAMENTE", JOptionPane.ERROR_MESSAGE);
			}
			
		});
		
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
		
		
		
		add(Crear);
        add(Leer);
        add(Modificar);
        add(Borrar);
        add(Salir);

        Inferior.add(Documentacion);
        Inferior.add(Licencia);

		
		
		add(Inferior, BorderLayout.SOUTH);
		
		
		
	}

//	Clase planificada para gestionar la ventana emergente de lectura de registros
	class Ventana_Leer_Registros implements Runnable{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			
			marco_Registro  mr = new marco_Registro();
		
			
		}
		
	}
	
	
	
	
	private JLabel id,nombre,apellido,movil,fijo,anotacion,anotacionextra;
	private JTextField cid,cnombre,capellido,cmovil,cfijo;
	private JTextArea canotacion;
	private JButton Crear,Leer,Modificar,Borrar,Salir,Documentacion,Licencia;;
	private static final Scanner  scanner= new Scanner(System.in);
}



