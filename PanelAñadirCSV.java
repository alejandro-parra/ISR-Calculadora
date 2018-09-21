import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;

public class PanelAñadirCSV extends JPanel implements ActionListener{
	
	private JButton jbVerificar, jbCalcular;
	private JLabel jlTitulo;
	private JTextField jtRuta;
	
	
	public PanelAñadirCSV() {
		super();//se inicializa el panel
		this.setPreferredSize(new Dimension(500,500));
		
		
		
		this.jbVerificar=new JButton("Elegir Archivo");
		this.jtRuta=new JTextField();
		this.jtRuta.setPreferredSize(new Dimension(100,24));
		
		this.jbCalcular= new JButton("Calcular");
		this.jlTitulo=new JLabel();
		
		this.jlTitulo.setPreferredSize(new Dimension(500,300));
		this.jlTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		
		String paragraph="IMPORTAR UN CSV: Elige un archivo que quieras importar y después presiona el botón de Calcular.";
		this.jlTitulo.setText("<html><p style=\"width:300px\">"+paragraph+"</p></html>");
		
		this.add(jlTitulo);
		this.add(jtRuta);
		this.add(jbVerificar);
		this.add(jbCalcular);
		
		this.jbVerificar.addActionListener(this);
		this.jbCalcular.addActionListener(this);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		File file;
		if(e.getSource()==jbVerificar) {
			JFileChooser fc = new JFileChooser();
			
			int line= fc.showDialog(this, "Examinar");
			file=fc.getSelectedFile();
			this.jtRuta.setText(""+file);
		}
		else if(e.getSource()==jbCalcular){
			Persona multiple= new Persona(jtRuta.getText());
			
		}
		
		
	}
	
}
