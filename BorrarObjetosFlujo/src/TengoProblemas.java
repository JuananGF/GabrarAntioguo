import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class TengoProblemas {
	public static void main(String[] args) {
		ClienteUno socio = new ClienteUno();
		File archivo = new File("clientedos.dat");
		ObjectOutputStream adaptador = null;
		if (!archivo.exists())
			try {
				archivo.createNewFile();
				adaptador = new ObjectOutputStream(new FileOutputStream(archivo, true));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		else
			try {
				adaptador = new MiObjectOutputStream(new FileOutputStream(archivo, true));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		try {
			adaptador.writeObject(socio);
			adaptador.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("programa finalizado");

	}
}
