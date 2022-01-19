package Agenda_CRUD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTextArea;
import javax.swing.JTextField;
// Crear la conexión con la BBDD
public class BBDD {
	public static void initConnection() {
		try {
			connection= DriverManager.getConnection(url, user, pass);
			System.out.println("Conexion con éxito");
		}catch(Exception e) {
			System.out.println("REVISAR: Conexión sin exito");
		}
	}
	//Crear registro con BBDD
	public static void Crear(String nombre, String apellido, String movil, String fijo,String anotacion) {
		PreparedStatement stml;
		try {
			stml = connection.prepareStatement("INSERT INTO agenda2(nombre, apellido,movil,fijo,anotacion) VALUES(?,?,?,?,?)");
			stml.setString(1, nombre);
			stml.setString(2, apellido);
			stml.setString(3, movil);
			stml.setString(4, fijo);
			stml.setString(5, anotacion);
			stml.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	// Leer los registro
	
		public static  void leerRegistros(JTextArea contenido) throws SQLException {
			PreparedStatement stml = connection.prepareStatement("SELECT * FROM agenda2 order by id");
			ResultSet resultados = stml.executeQuery();
			//System.out.println("id| nombre | apellido | movil | fijo | anotacion ");
			while(resultados.next()) {
				long id = resultados.getLong("id");
				String nombre = resultados.getString("nombre");
				String apellido = resultados.getString("apellido");
				String movil = resultados.getString("movil");
				String fijo = resultados.getString("fijo");
				String anotacion = resultados.getString("anotacion");
				
				//System.out.println(id + " | " + nombre + " | " + apellido + " | " + movil + " | " + fijo + " | " + anotacion);
				contenido.append("\n" + id + " | " + nombre + " | " + apellido + " | " + movil + " | " + fijo + " | " + anotacion);
				
			}
		}
//		------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------	
//		------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------	
//		Leer registros especificos
		public static void leerRegistroEspecifico( long id, String NuevoNom, String NuevoApe, String movilB,String fijo,String anotacion) throws SQLException {
			//Long resultado = Long.parseLong(cid.getText());
			PreparedStatement stml = connection.prepareStatement("SELECT * FROM agenda2 WHERE ID = ?");
			stml.setLong(1, id);
			ResultSet resultados = stml.executeQuery();
			
			
			NuevoNom = resultados.getString("nombre");
			NuevoApe = resultados.getString("apellido");
			movilB = resultados.getString("movil");
			fijo = resultados.getString("fijo");
			anotacion = resultados.getString("anotacion");
			
			/*if(resultados.next()) {
				cnombre.setText(NuevoNom);
				capellido.setText(NuevoApe);
				cmovil.setText(movilB);
				cfijo.setText(fijo);
				canotacion.setText(nombre);
			}*/
			
		}
//		----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
//		------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
		// Eliminar Registros
		
		public static void EliminarRegistros(JTextField cid) throws SQLException {
			Long resultado = Long.parseLong(cid.getText());
			PreparedStatement stml = connection.prepareStatement("DELETE FROM agenda2 WHERE ID = ?");
			stml.setLong(1, resultado);
			int row = stml.executeUpdate();
			if(row == 0) {
				System.out.println("No se borró el registro con id  " + resultado);
			}else if( row != 0) {
				System.out.println("Se borró correctamente el registro con id: " + resultado);
			}
		}
		
		
		// Modificar los registros
		public static void ModificarDatos(long id, String NuevoNom, String NuevoApe, String movil,String fijo,String anotacion) throws SQLException {
			PreparedStatement stml = connection.prepareStatement("UPDATE agenda2 SET nombre = ?, apellido= ?, movil = ?, fijo =?, anotacion = ? WHERE id =?");
			stml.setString(1,NuevoNom);
			stml.setString(2, NuevoApe);
			stml.setString(3, movil);
			stml.setString(4, fijo);
			stml.setString(5, anotacion);
			
			
			
			stml.setLong(6, id);
			int row = stml.executeUpdate();
			if(row == 0) {
				System.out.println("No se modificó nada");
			}else {
				System.out.println("Se modificó el registro");
			}
			
		}
		
		
	private static final String user = "postgres";
	private static final String pass = "1234";
	private static String url = "jdbc:postgresql://localhost:5433/agenda2";
    private  static Connection connection;
    private JTextArea contenido;

    private JTextField cid,cnombre,capellido,cmovil,cfijo;

}



