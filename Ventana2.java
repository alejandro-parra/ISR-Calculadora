import java.awt.BorderLayout;

import javax.swing.JFrame;

public class Ventana2 extends JFrame {
	
	
	public Ventana2() {
		super("Calculadora de ISR");//se inicializa la ventana
		
		this.setSize(1000, 800);
		
		PanelAñadirInfo pr= new PanelAñadirInfo();//inicializa panel de registro
		this.add(pr,BorderLayout.WEST);
		
		this.pack();
		this.setVisible(true);
	}
	
	
	public static void main(String[] args) {
		
	}
}
