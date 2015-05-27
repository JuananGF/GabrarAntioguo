import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;


public class LeoProblemas {
public static void main(String[] args) {
	try(ObjectInputStream adaptadorLectura=
			new ObjectInputStream(
					new FileInputStream("clientedos.dat"))){
		do{
			ClienteUno cli=(ClienteUno) adaptadorLectura.readObject();
			muestraCliente(cli);
		}while(true);	
		
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
//		System.out.println("fin del archivo");
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

private static void muestraCliente(ClienteUno cli) {
	System.out.println("Datos del cliente");
	System.out.println("Nombre: "+cli.getNombre());
	System.out.println("Edad: "+cli.getEdad());
	if(cli.isAsociado())
		System.out.print("Si ");
	else
		System.out.print("No ");
	System.out.println("es asociado");
}
}
