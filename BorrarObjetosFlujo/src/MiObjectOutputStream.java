
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class MiObjectOutputStream extends ObjectOutputStream {
	public boolean primerObjeto = false;

	protected MiObjectOutputStream(OutputStream out) throws IOException, SecurityException {
		super(out);
		
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void writeStreamHeader() throws IOException {
		System.out.println("soy el mio");
	}
}
