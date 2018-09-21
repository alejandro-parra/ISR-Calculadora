import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.StringTokenizer;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JOptionPane;

public class PanelAñadirInfo extends JPanel implements MouseListener{
	private String[] s;//array de strings que será el producto final a pasarle al objeto Persona
	private double[] i; //array con las entradas de tipo numérico que se pasan al objeto Persona
	private JTextField jtNombre,
						jtRFC,
						jtSueldoMensual,
						jtAguinaldo,
						jtPrimaVaca,
						jtServMedicos,
						jtServFunerarios,
						jtServSGMM,
						jtHipotecarios,
						jtDonativos,
						jtRetiro,
						jtTransporte,
						jtColegiatura,
						jtDiasAguinaldo;
	
	private JRadioButton rbKinder,
						rbPrimaria,
						rbSecundaria,
						rbPrepa,
						rbNull;
	
	private JButton registrar;
	
	
	public PanelAñadirInfo() {
		super();//se inicializa el panel
		this.setPreferredSize(new Dimension(500,800));
		this.setBackground(Color.CYAN);
		this.setForeground(Color.WHITE);
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));//un layout para que se acomode el texto en lineas bien distribuidas
		
		
		this.jtNombre=new JTextField(20);//declarar todas las variables de texto
		this.jtRFC=new JTextField(13);
		this.jtSueldoMensual=new JTextField(15);
		this.jtDiasAguinaldo=new JTextField(2);
		this.jtAguinaldo=new JTextField(15);
		this.jtPrimaVaca=new JTextField(15);
		this.jtServMedicos=new JTextField(15);
		this.jtServFunerarios=new JTextField(15);
		this.jtServSGMM=new JTextField(15);
		this.jtHipotecarios=new JTextField(15);
		this.jtDonativos=new JTextField(15);
		this.jtRetiro=new JTextField(15);
		this.jtTransporte=new JTextField(15);
		this.jtColegiatura=new JTextField(15);
		
		this.rbKinder=new JRadioButton("Kinder");//declarar los botones de radio
		this.rbPrimaria=new JRadioButton("Primaria");
		this.rbSecundaria=new JRadioButton("Secundaria");
		this.rbPrepa=new JRadioButton("Prepa");
		this.rbNull=new JRadioButton("No tengo hijo");
		
		this.registrar=new JButton("Registrar");//declarar el boton para subir la informacion
		this.registrar.addMouseListener(this);
		
		//SECCION DONDE AÑADIMOS TOODO AL PANEL
		
		this.add(new JLabel("Nombre"));
		this.add(jtNombre);
		
		this.add(new JLabel("RFC"));
		this.add(jtRFC);
		
		this.add(new JLabel("Sueldo Mensual"));
		this.add(jtSueldoMensual);
		
		this.add(new JLabel("Dias que se le da al empleado de aguinaldo exento"));
		this.add(jtDiasAguinaldo);
		
		this.add(new JLabel("Aguinaldo total"));
		this.add(jtAguinaldo);
		
		this.add(new JLabel("Prima Vacional"));
		this.add(jtPrimaVaca);
		
		this.add(new JLabel("Gastos de servicios médicos"));
		this.add(jtServMedicos);
		
		this.add(new JLabel("Gastos funerarios"));
		this.add(jtServFunerarios);
		
		this.add(new JLabel("Gastos del seguro medico de gastos mayores"));
		this.add(jtServSGMM);
		
		this.add(new JLabel("Gastos hipotecarios"));
		this.add(jtHipotecarios);
		
		this.add(new JLabel("Donativos hechos"));
		this.add(jtDonativos);
		
		this.add(new JLabel("Dinero para el fondo de retiro"));
		this.add(jtRetiro);
		
		this.add(new JLabel("Gastos de transporte escolar"));
		this.add(jtTransporte);
		
		this.add(new JLabel("Nivel de estudios del hijo"));
	
		ButtonGroup bg= new ButtonGroup();//Se agrupa en un ButtonGroup para poder seleccionar solo una a la vez
		bg.add(rbNull);
		bg.add(rbKinder);
		bg.add(rbPrimaria);
		bg.add(rbSecundaria);
		bg.add(rbPrepa);
		
		this.add(rbNull);
		this.add(rbKinder);
		this.add(rbPrimaria);
		this.add(rbSecundaria);
		this.add(rbPrepa);
		
		this.add(new JLabel("Colegiatura Pagada"));
		this.add(jtColegiatura);
		
		this.add(registrar);
	}
	


	//LO QUE VA A HACER EL PROGRAMA EN CASO DE QUE EL USUARIO LE DE CLICK AL BOTON FINAL
	
	public void mouseClicked(MouseEvent e){
		
		//Se guarda todo en dos arrays para transportar los datos de manera más fácil
		
		
		this.s= new String[3];
		this.i=new double[12];
		
		this.s[0]=jtNombre.getText();
		this.s[1]=jtRFC.getText();
		
		//se inserta un try por si los valores que insertó el usuario no son del tipo Int
		try { 
			
			this.i[0]=Double.parseDouble(jtSueldoMensual.getText());
			this.i[1]=Double.parseDouble(jtAguinaldo.getText());
			this.i[2]=Double.parseDouble(jtPrimaVaca.getText());
			this.i[3]=Double.parseDouble(jtServMedicos.getText());
			this.i[4]=Double.parseDouble(jtServFunerarios.getText());
			this.i[5]=Double.parseDouble(jtServSGMM.getText());
			this.i[6]=Double.parseDouble(jtHipotecarios.getText());
			this.i[7]=Double.parseDouble(jtDonativos.getText());
			this.i[8]=Double.parseDouble(jtRetiro.getText());
			this.i[9]=Double.parseDouble(jtTransporte.getText());
			this.i[10]=Double.parseDouble(jtColegiatura.getText());
			this.i[11]=Double.parseDouble(jtDiasAguinaldo.getText());
			
			if(rbNull.isSelected()) {
				this.s[2]="No tiene hijos";
			}
			else if(rbKinder.isSelected()) {
				this.s[2]="Preescolar";
			}
			else if (rbPrimaria.isSelected()) {
				this.s[2]="Primaria";
			}
			else if (rbSecundaria.isSelected()) {
				this.s[2]="Secundaria";
			}
			else {
				this.s[2]="Preparatoria";
			}
			
			JOptionPane.showMessageDialog(null, "Registro Exitoso");
			
			
			
			
			Persona tmp= new Persona(this.s,this.i);//Se inicializa una variable persona que le pasan los datos de entrada como parámetro
			tmp.añadirPersona("/Users/alejandroparra/Documents/directory-Workspace/ISR/src/resultados.csv");
			
		}catch(NumberFormatException r) {
			JOptionPane.showMessageDialog(null, "Introduce numeros reales positivos en las secciones correspondientes");
			
			
		} catch (IOException e1) {
			JOptionPane.showMessageDialog(null, "No se encontró el archivo");
		}
		
		
		
		
		
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
}
