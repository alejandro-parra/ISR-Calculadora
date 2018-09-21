import java.awt.BorderLayout;

import javax.swing.JFrame;

public class Ventana3 extends JFrame {
	public Ventana3() {
		super("Calculadora de ISR");//se inicializa la ventana
		
		this.setSize(1000, 800);
		
		PanelAñadirCSV pc = new PanelAñadirCSV();//inicializa el panel para añadir un csv
		this.add(pc,BorderLayout.CENTER);
		
		this.pack();
		this.setVisible(true);
	}
	
}
