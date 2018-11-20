import java.util.ArrayList;

public class Libro {
	

	private String titulo;
	private int anyo;
	private String nombre;
	private ArrayList<String> autor;
	private String editor;
	private int paginas;
	
	public Libro(String titulo, int anyo, String nombre, ArrayList<String> autor, String editor, int paginas) {
		super();
		this.titulo = titulo;
		this.anyo = anyo;
		this.nombre = nombre;
		this.autor = autor;
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

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<String> getAutor() {
		return autor;
	}

	public void setAutor(ArrayList<String> autor) {
		this.autor = autor;
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
	public void muestra() {
		System.out.println("Editor: " + editor + "\n"+"Titulo: " + titulo +"\n"+"Año :"+anyo+"\n"+"con el autor :"+autor+"\n"+"páginas :"+paginas);
	}
	
	

}


