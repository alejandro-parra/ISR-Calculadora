import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Persona {
	private String valoresDouble;
	private String[] entradaString;
	
	 /* 
	   Valores tipo String:
		   entradaString[0]- nombre 
		   entradaString[1]- rfc 
		   entradaString[2]- nivel educativo
		
		   Valores tipo double: 
		   
		   extra: días de aguinaldo exento 
		   
		    valoresDouble[0] - sueldoMensual 
			valoresDouble[1] - sueldoAnual 
			valoresDouble[2] - aguinaldo 
			valoresDouble[3] - aguinaldoExento 
			valoresDouble[4] - aguinaldoGrava 
			valoresDouble[5] - primaVaca 
			valoresDouble[6] - primaVacaExenta
			valoresDouble[7] - primaVacaGrava
			valoresDouble[8] - totalGrava
			valoresDouble[9]- servMedico 
			valoresDouble[10] - servFunerario 
			valoresDouble[11]- servSGMM 
			valoresDouble[12] - servHipoteca 
			valoresDouble[13] - donativos 
			valoresDouble[14] - subcuenta retiro
			valoresDouble[15] - transporte escolar
			valoresDouble[16] - colegiaturaMax permitida a deducir 
			valoresDouble[17] - colegiaturaPagada 
			valoresDouble[18] - deduccionesSinRetiro 
			valoresDouble[19] - deducciónPermitida 
			valoresDouble[20] - montoISR
			valoresDouble[21] - cuotaFija
			valoresDouble[22] - porcentajeExcedente
			valoresDouble[23] - pagoExcedente
			valoresDouble[24] - totalFinal
			 */
	
	
	
	
	public Persona(String[] entradaString,double[]entradaDouble) { // constructor que recibe un array con los datos de entrada
		Calculos c= new Calculos(entradaDouble,entradaString);//se crea una nueva instancia que nos hace los calculos
		this.valoresDouble=c.getCalculos();
		this.entradaString=entradaString;
		
	}
	
	public Persona(String archivo) {
		this.entradaString=entradaString;
		
		try {
			Calculos c;
			c = new Calculos(archivo);
			this.valoresDouble=c.getCalculos();
		} catch (IOException e) {
			System.out.println("Error en el nombre del archivo");
		}
		
	}
	
	public void añadirPersona(String archivo) throws IOException {
		String linea1="";
		String linea2="";
		StringTokenizer str=new StringTokenizer(valoresDouble,",");
		
		for(int i=0;i<16;i++) {
			linea1+=str.nextToken()+",";
		}
		
		for(int i=16;i<25;i++) {
			linea2+=str.nextToken()+",";
		}
		
		BufferedReader br = new BufferedReader(new FileReader(archivo));
		FileWriter fw = new FileWriter (archivo,true);
		PrintWriter pr = new PrintWriter(fw);
		
		br.read();
		pr.println(this.entradaString[0]+","+this.entradaString[1]+","+linea1+this.entradaString[2]+","+linea2);
		
		
		fw.close();
		pr.close();
		
	}
}


