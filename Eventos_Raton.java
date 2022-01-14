package Agenda_CRUD;
import java.sql.SQLException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;

class EventosDeRaton extends MouseAdapter{

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		if (e.getModifiersEx() == 4096) {
			System.out.println("He presionado el boton derecho");
			marco_raton marc = new marco_raton();
			
			
			 
		}
		
		
	}

}

class marco_raton extends JFrame{
	public marco_raton() {
		//this.setResizable(false);
		setTitle("Menu");
		setBounds(400,400,150,200);
		//add(new lamina());
		setVisible(true);
		
	}

	
	}
