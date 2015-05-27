import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class GraboPeroNoTodos {
	public static void main(String[] args) {
		// Criterio de borrado
		String nombre = "kevin";
		// Usamos la clase File para poder manipular los objetos del
		// sistema de ficheros y renombrarlos o borrarlos
		File origen = new File("clientedos.dat");
		File destino = new File("backup.dat");
		// Estoy grabanado el primer elemento o no
		boolean primerElemento = true;
		// Porque luego haremos downcast
		ObjectOutputStream escrituraReemplazo = null;
		ObjectInputStream adaptadorLectura = null;
		try {
			// Preparamos la escritura (primer elemento)
			destino.createNewFile();
			escrituraReemplazo = new ObjectOutputStream(new FileOutputStream(destino));
			// preparamos la lectura
			adaptadorLectura = new ObjectInputStream(new FileInputStream(origen));
			// Este bucle se encarga de copiar los objetos de uno en uno
			do {
				ClienteUno cli = (ClienteUno) adaptadorLectura.readObject();
				// criterio de borrado o no
				if (!cli.nombre.equals(nombre)) {
					escrituraReemplazo.writeObject(cli);
					// Pero a partir del segundo elemento debemos cambiar el
					// flujo
					// En realidad no hace falta esta es la version ilustrada
//					if (primerElemento) {
//						primerElemento = false;
//						escrituraReemplazo.close();
//						escrituraReemplazo = new MiObjectOutputStream(new FileOutputStream(destino, true));
//					}
				}
			} while (true);

		} catch (IOException e) {
			// cerrando flujos
			try {
				adaptadorLectura.close();
				escrituraReemplazo.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// primero borramos el archivo origen
		origen.delete();
		// renombramos el archivo destino para que sea el nuevo origen
		destino.renameTo(origen);
	}
}
