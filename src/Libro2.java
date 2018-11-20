import java.util.ArrayList;
import java.util.Iterator;

public class Libro2 {
	
	private String titulo;
	private int anyo;
	private String nombre;
	private int compras;
	private int precio;
	private ArrayList<autor> autores;
	private ArrayList<compras> compra;
	private ArrayList<ventas> venta;
	private String editor;
	private int paginas;
	
	
	public Libro2(String titulo, int anyo, ArrayList<autor> autores, String editor, int paginas) {
		super();
		this.titulo = titulo;
		this.anyo = anyo;
		this.autores = autores;
		this.editor = editor;
		this.paginas = paginas;
	}


	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public int getAnyo() {
		return anyo;
	}


	public void setAnyo(int anyo) {
		this.anyo = anyo;
	}

	public ArrayList<autor> getAutores() {
		return autores;
	}


	public void setAutores(ArrayList<autor> autores) {
		this.autores = autores;
	}


	public String getEditor() {
		return editor;
	}


	public void setEditor(String editor) {
		this.editor = editor;
	}


	public int getPaginas() {
		return paginas;
	}


	public void setPaginas(int paginas) {
		this.paginas = paginas;
	}
	@Override
	public String toString() {
		
		String res = null;
		res = "Titulo: " + titulo + "\nAño: " + anyo+ "\n";
		res += "Autores: ";
		
		for (autor aux: autores){
			
			res+= aux.getNombre() + ", ";
			res += "\n Apellido: ";
			res += aux.getApellidos() + ",";
			
		}
		
		res += "\nEditor: " + editor + "\nPáginas:" + paginas;
		res += "\n---------------------------------";
		
		return res;
	}
	
	

}
