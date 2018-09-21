import java.awt.BorderLayout;

import javax.swing.JFrame;

public class Ventana extends JFrame {
	private PanelBotonesInicial pbi;
	
	public Ventana() {
		super("Calculadora de ISR");//se inicializa la ventana
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//para que se acabe el programa al cerrar la ventana
		this.setSize(1000, 800);
		
		this.pbi= new PanelBotonesInicial();//inicializa panel inicial
		this.add(pbi,BorderLayout.CENTER);
		
		this.pack();
		this.setVisible(true);
	}
	
	/*public void setVisibleA (Boolean b) {//función para hacer visible un panel
		this.pr.setVisible(b);
	}*/
	
	public static void main(String[] args) {
		Ventana miVentana = new Ventana();//inicializa la ventana para que se pueda ver
		
	}
}
