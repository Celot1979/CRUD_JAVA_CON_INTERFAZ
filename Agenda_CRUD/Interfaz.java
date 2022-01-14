package Agenda_CRUD;

public class Interfaz {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		marco m = new marco();
		//m.addWindowListener(new Ventana_adp());
		m.addMouseListener(new EventosDeRaton());
		
		m.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}

}
class marco extends JFrame{
	public marco() {
		//this.setResizable(false);
		setTitle("AGENDA");
		setBounds(400,400,800,400);
		add(new lamina());
		setVisible(true);
		
	}

	
	}


class lamina extends JPanel{
	public lamina() {
		BBDD.initConnection();
//		Lámina inferior para todo lso componentes de la interfaz - menos el menú-
		JPanel Inferior= new JPanel ();
//		Lámina Superior para el menú
		JPanel Superior = new JPanel();
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
		
//		Creación de botones y sus funciones dentro de la interfaz
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
		
		Salir = new JButton ("Salir");
		Salir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				System.exit(1);
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
		
		
		
		Inferior.add(Crear);
		Inferior.add(Leer);
		Inferior.add(Modificar);
		Inferior.add(Borrar);
		Inferior.add(Salir);
		
		
		add(Inferior, BorderLayout.SOUTH);
		
		
		
	}

	
	
	
	private JLabel id,nombre,apellido,movil,fijo,anotacion,anotacionextra;
	private JTextField cid,cnombre,capellido,cmovil,cfijo;
	private JTextArea canotacion;
	private JButton Crear,Leer,Modificar,Borrar,Salir;
	private static final Scanner  scanner= new Scanner(System.in);
}



public class Interfaz {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		marco m = new marco();
		//m.addWindowListener(new Ventana_adp());
		m.addMouseListener(new EventosDeRaton());
		
		m.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}

}
class marco extends JFrame{
	public marco() {
		//this.setResizable(false);
		setTitle("AGENDA");
		setBounds(400,400,800,400);
		add(new lamina());
		setVisible(true);
		
	}

	
	}


class lamina extends JPanel{
	public lamina() {
		BBDD.initConnection();
//		Lámina inferior para todo lso componentes de la interfaz - menos el menú-
		JPanel Inferior= new JPanel ();
//		Lámina Superior para el menú
		JPanel Superior = new JPanel();
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
		
//		Creación de botones y sus funciones dentro de la interfaz
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
		
		Salir = new JButton ("Salir");
		Salir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				System.exit(1);
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
		
		
		
		Inferior.add(Crear);
		Inferior.add(Leer);
		Inferior.add(Modificar);
		Inferior.add(Borrar);
		Inferior.add(Salir);
		
		
		add(Inferior, BorderLayout.SOUTH);
		
		
		
	}

	
	
	
	private JLabel id,nombre,apellido,movil,fijo,anotacion,anotacionextra;
	private JTextField cid,cnombre,capellido,cmovil,cfijo;
	private JTextArea canotacion;
	private JButton Crear,Leer,Modificar,Borrar,Salir;
	private static final Scanner  scanner= new Scanner(System.in);
}



