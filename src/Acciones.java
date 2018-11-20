import java.util.ArrayList;

public class Acciones {
	
	private String nombre;
	private int cantidad;
	private float precio;
	private ArrayList<compras> compra;
	private ArrayList<ventas> venta;


	public Acciones(String nombre, int cantidad, float precio, ArrayList<compras> compra, ArrayList<ventas> venta) {
	
		
		super();
		this.nombre = nombre;
		this.cantidad = cantidad;
		this.precio = precio;
		this.compra = compra;
		this.venta = venta;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCompras() {
		return cantidad;
	}

	public void setCompras(int cantidad) {
		this.cantidad = cantidad;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public ArrayList<compras> getCompra() {
		return compra;
	}

	public void setCompra(ArrayList<compras> compra) {
		this.compra = compra;
	}

	public ArrayList<ventas> getVenta() {
		return venta;
	}

	public void setVenta(ArrayList<ventas> venta) {
		this.venta = venta;
	}

	@Override
	public String toString() {
		
		String res = null;
		res = "Nombre: " + nombre;
		res += "Compras: ";
		
		for (compras aux: compra){
			
			res+= aux.getCantidad() + ", ";
			res += "\n Precio: ";
			res += aux.getPrecio() + ",";
			
		}
		
		res += "Compras: ";
		for (ventas aux: venta){
			
			res+= aux.getCantidad() + ", ";
			res += "\n Precio: ";
			res += aux.getPrecio() + ",";
			
		}
		
		
		res += "\n---------------------------------";
		
		return res;
	}
	
	
	
	
	
}
