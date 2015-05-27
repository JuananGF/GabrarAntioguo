import java.io.Serializable;


public class ClienteUno implements Serializable{
	public String nombre;
	public int edad;
	public boolean asociado;
	public ClienteUno(String nombre, int edad, boolean asociado) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.asociado = asociado;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public boolean isAsociado() {
		return asociado;
	}
	public void setAsociado(boolean asociado) {
		this.asociado = asociado;
	}
	public ClienteUno() {
		// TODO Auto-generated constructor stub
	}
}
