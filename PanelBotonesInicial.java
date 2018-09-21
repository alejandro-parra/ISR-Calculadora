import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class PanelBotonesInicial extends JPanel implements MouseListener,ActionListener {

	private JLabel mensajeIntro;
	private JButton btConsulta, btRegistro;
	
	
	public PanelBotonesInicial() {
		super();
		this.setPreferredSize(new Dimension(800,800));
		
		
		this.mensajeIntro= new JLabel();
		this.mensajeIntro.setHorizontalAlignment(SwingConstants.CENTER);
		String paragraph="Bienvenido a la calculadora del ISR. Para consultar información del pago de ISR de uno o más empleados, haz click en Consulta. Para registrar información nueva haz click en Registro";
		this.mensajeIntro.setText("<html><p style=\"width:500px\">"+paragraph+"</p></html>");
	
		this.mensajeIntro.setBackground(null);
		this.mensajeIntro.setFont(new Font("Arial",Font.PLAIN,20));
		
		this.btConsulta=new JButton("Consulta");
		this.btRegistro=new JButton("Registro");
		
		this.btConsulta.setFont(new Font("Arial",Font.PLAIN,50));
		this.btRegistro.setFont(new Font("Arial",Font.PLAIN,50));
		
		this.btConsulta.setPreferredSize(new Dimension(300,300));
		this.btRegistro.setPreferredSize(new Dimension(300,300));
		
		this.btConsulta.addActionListener(this);
		this.btRegistro.addActionListener(this);
		
		this.add(mensajeIntro,BorderLayout.NORTH);
		this.add(btConsulta,BorderLayout.CENTER);
		this.add(btRegistro,BorderLayout.CENTER);
		
		
	}
	
	
	
	
	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		
		
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}






	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btRegistro) {
			Ventana2 miVentana = new Ventana2();
		}
		else{
			Ventana3 miVentana = new Ventana3();
		}
		
	}

}
