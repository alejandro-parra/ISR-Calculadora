import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import javax.swing.JOptionPane;

public class Calculos {
	double[] ed,sd;
	String[] entradaString;
	/*   Valores del array de salida (numero al final indica si pertenece a algun lugar del array de entrada)
	  
	   Valores tipo String:
	   0- nombre 0
	   1- rfc 1
	   2- nivel de escuela 2
	   
	   
	   Valores tipo double: 
	   
	   extra: días de aguinaldo exento 11
	   
	   0- sueldoMensual 0
		1- sueldoAnual e0*12
		2- aguinaldo 1
		3- aguinaldoExento e0/30*extra
		4- aguinaldoGrava e0-s3
		5- primaVaca 2
		6- primaVacaExenta
		7- primaVacaGrava
		8- totalGrava
		9- servMedico 3
		10- servSGMM 5
		11- servFunerario 4
		12- servHipoteca 6
		13- donativos 7
		14- afore 8
		15- transport 9
		16- colegiaturaMax 
		17- colegiaturaPagada 10
		18- deduccionesSinRetiro 9+10+11+12+13+15+16
		19- deducciónPermitida 1+2+5
		20- montoISR
		21- cuotaFija
		22- porcentajeExcedente
		23- pagoExcedente
		24- totalFinal
		 */
	
	
	public Calculos(double[] entradaDouble,String[] entradaString) {
		this.ed=entradaDouble;
		this.sd=new double[25];
		this.entradaString=entradaString;
		
		this.calcular(this.ed, this.entradaString);
		
	}
	
	public Calculos(String archivo) throws IOException {
		String linea,linea1,linea2;
		linea1="";
		linea2="";
		this.ed= new double[12];
		this.entradaString= new String[3];
		this.sd=new double[25];
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(archivo));
			FileWriter fw = new FileWriter ("Resultado.csv");
			PrintWriter pr = new PrintWriter(fw);
			pr.println("Nombre,RFC,Sueldo mensual,Ingreso anual,Aguinaldo,Aguinaldo exento,Aguinaldo gravado,Prima vacacional,Prima vacacional excenta,Prima vacacional gravada,Total ingresos gravan,Medicos y hospitales,Gastos funerarios,SGMM,Hipotecarios,Donativos,Subcuenta retiro,Transporte escolar,Nivel educativo,Maximo a deducir colegiatura,Colegiatura pagada,Total deducciones (sin retiro),Deduccion permitida 10%,Monto ISR,Cuota fija,Porcentaje excedente,Pago excedente,Total a pagar");
			while((linea= br.readLine()) != null) {
				StringTokenizer st= new StringTokenizer(linea,",");
				
				this.entradaString[0]=st.nextToken();
				this.entradaString[1]=st.nextToken();
				
				for(int i=0;i<10;i++) {
					this.ed[i]=Double.parseDouble(st.nextToken());
				}
				
				this.entradaString[2]=st.nextToken();
				this.ed[11]=Double.parseDouble(st.nextToken());
				
				this.calcular(this.ed, this.entradaString);
				
				
				for(int i=0;i<16;i++) {
					
					linea1+=sd[i]+",";
				}
				
				for(int i=16;i<23;i++) {
					linea2+=sd[i]+",";
				}
				linea2+=sd[24];
				
				pr.println(this.entradaString[0]+","+this.entradaString[1]+","+linea1+this.entradaString[2]+","+linea2);
			}
			
			fw.close();
			pr.close();
		}
		catch(FileNotFoundException e) {
			System.out.println("El archivo no existe");
		}
		
		
		
	}
	
	public void calcular(double[] entradaDouble,String[] entradaString) {
		this.sd[0]=this.ed[0];
		this.sd[1]=this.ed[0]*12;
		this.sd[2]=this.ed[1];
		this.sd[3]=this.ed[0]/2;
		this.sd[4]=this.ed[1]-this.sd[3];
		this.sd[5]=this.ed[2];
		
		if(this.sd[5]<1209) {
			this.sd[6]=this.sd[5];
		}else {
			this.sd[6]=1209;
		}
		
		this.sd[7]=this.sd[5]-this.sd[6];
		this.sd[8]=this.sd[7]+this.sd[4]+this.sd[1];
		this.sd[9]=this.ed[3];
		this.sd[10]=this.ed[4];
		this.sd[11]=this.ed[5];
		this.sd[12]=this.ed[6];
		this.sd[13]=this.ed[7];
		this.sd[14]=this.ed[8];
		this.sd[15]=this.ed[9];
		
		if(entradaString[2]=="Preescolar") {
			this.sd[16]=14200;
		}
		else if(entradaString[2]=="Primaria"){
			this.sd[16]=12900;
		}
		else if(entradaString[2]=="Secundaria"){
			this.sd[16]=19900;
		}
		else if(entradaString[2]=="Preparatoria"){
			this.sd[16]=24500;
		}
		else {
			this.sd[16]=0;
		}
		
		this.sd[17]=this.ed[10];
		this.sd[18]=this.sd[9]+this.sd[10]+this.sd[11]+this.sd[12]+this.sd[13]+this.sd[15]+this.sd[16];
		this.sd[19]=(this.sd[1]+this.sd[2]+this.sd[5])/10+this.sd[14];
		
		if (this.sd[18]<this.sd[19]) {
			this.sd[20]=this.sd[8]-this.sd[18];
		}else {
			this.sd[20]=this.sd[8]-this.sd[19];
		}
		
		if(this.sd[20]>=0 && this.sd[20]<=5952.84) {
			this.sd[21]=0;
			this.sd[22]=1.92;
			this.sd[23]=(this.sd[20])/100*this.sd[22];
		}
		else if(this.sd[20]>5952.84 && this.sd[20]<=50524.92) {
			this.sd[21]=114.29;
			this.sd[22]=6.4;
			this.sd[23]=(this.sd[20]-5952.84)/100*this.sd[22];
		}
		else if(this.sd[20]>50524.92 && this.sd[20]<=88793.04) {
			this.sd[21]=2966.91;
			this.sd[22]=10.88;
			this.sd[23]=(this.sd[20]-50524.92)/100*this.sd[22];
		}
		else if(this.sd[20]>88793.04 && this.sd[20]<=103218) {
			this.sd[21]=7130.48;
			this.sd[22]=16;
			this.sd[23]=(this.sd[20]-88793.04)/100*this.sd[22];
		}
		else if(this.sd[20]>103218 && this.sd[20]<=123580.2) {
			this.sd[21]=9438.47;
			this.sd[22]=17.92;
			this.sd[23]=(this.sd[20]-103218)/100*this.sd[22];
		}
		else if(this.sd[20]>123580.2 && this.sd[20]<=249243.48) {
			this.sd[21]=13087.37;
			this.sd[22]=21.36;
			this.sd[23]=(this.sd[20]-123580.2)/100*this.sd[22];
		}
		else if(this.sd[20]>249243.48 && this.sd[20]<=392841.96) {
			this.sd[21]=39929.05;
			this.sd[22]=23.52;
			this.sd[23]=(this.sd[20]-249243.48)/100*this.sd[22];
		}
		else if(this.sd[20]>392841.96 && this.sd[20]<=750000) {
			this.sd[21]=73703.41;
			this.sd[22]=30;
			this.sd[23]=(this.sd[20]-392841.96)/100*this.sd[22];
		}
		else if(this.sd[20]>750000 && this.sd[20]<=1000000) {
			this.sd[21]=180850.82;
			this.sd[22]=32;
			this.sd[23]=(this.sd[20]-750000)/100*this.sd[22];
		}
		else if(this.sd[20]>1000000 && this.sd[20]<=3000000) {
			this.sd[21]=260850.81;
			this.sd[22]=34;
			this.sd[23]=(this.sd[20]-1000000)/100*this.sd[22];
		}
		else if(this.sd[20]>3000000) {
			this.sd[21]=940850.81;
			this.sd[22]=35;
			this.sd[23]=(this.sd[20]-3000000)/100*this.sd[22];
		}
		else {
			this.sd[21]=0;
			this.sd[22]=0;
			this.sd[23]=this.sd[20];
		}
		
		this.sd[24]=this.sd[21]+this.sd[23];
		
	}
	public String getCalculos() {
		String resultados="";
		for(int i=0;i<this.sd.length;i++) {
			resultados+=this.sd[i]+",";
		}
		return resultados;
	}
	
}
