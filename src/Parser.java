import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class Parser {

		
	private Document dom = null;
	private ArrayList<Libro> libros = null;
	
	
	public Parser() {
		
		libros = new ArrayList<Libro>();
		
	}
	
	public void parseFicheroXml(String fichero) {
		
		// creamos una factory
				DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

				try {
					// creamos un documentbuilder
					DocumentBuilder db = dbf.newDocumentBuilder();

					// parseamos el XML y obtenemos una representación DOM
					dom = db.parse(fichero);
				} catch (ParserConfigurationException pce) {
					pce.printStackTrace();
				} catch (SAXException se) {
					se.printStackTrace();
				} catch (IOException ioe) {
					ioe.printStackTrace();
				}
		
		
	}
	
	
	public void parseDocument() {
		
		// obtenemos el elemento raíz
		Element docEle = dom.getDocumentElement();

		// obtenemos el nodelist de elementos
		NodeList nl = docEle.getElementsByTagName("libro");
		if (nl != null && nl.getLength() > 0) {
			for (int i = 0; i < nl.getLength(); i++) {

				// obtenemos un elemento de la lista (persona)
				Element el = (Element) nl.item(i);

				// obtenemos una persona
				Libro p = recuperarLibro(el);

				// lo añadimos al array
				libros.add(p);
			}
		}
		
		
	}
	
	private Libro recuperarLibro(Element personaEle) {
		
		//para cada elemento persona, obtenemos su nombre y su edad
				String titulo = getTextValue(personaEle,"titulo");
				int anyo = getAtributoInt(personaEle,"titulo","anyo");
				String nombre = getTextValue(personaEle,"nombre");
				ArrayList<String> autor = getAtributoAutor(personaEle,"autor");
				String editor = getTextValue(personaEle,"editor");
				int paginas = getIntValue(personaEle,"paginas");
				
				Libro l1 = new Libro(titulo, anyo, nombre, autor, editor, paginas);
				
				return l1;
		
	}
	
	private String getTextValue(Element ele, String tagName) {
		String textVal = null;
		NodeList nl = ele.getElementsByTagName(tagName);
		if (nl != null && nl.getLength() > 0) {
			Element el = (Element) nl.item(0);
			textVal = el.getFirstChild().getNodeValue();
		}
		return textVal;
	}

	private int getIntValue(Element ele, String tagName) {
		return Integer.parseInt(getTextValue(ele, tagName));
	}
	
	private String getAtributo(Element ele,String tagAtri, String atri) {
		
		String textVal = null;
		String aux = null;
		
		NodeList nl = ele.getElementsByTagName(tagAtri);
		
		
		if (nl != null && nl.getLength() > 0) {
			Element el = (Element) nl.item(0);
			aux  = el.getAttribute(atri);
			
		}
			
		return aux;
		}
	
	private int getAtributoInt(Element ele,String tag,String atri) {
		
		int aux;
		aux = Integer.parseInt(getAtributo(ele, tag, atri));
		
		
		return aux;
		
		
		
	}
	
	private ArrayList<String> getAtributoAutor(Element ele, String tagAutor) {

		String textVal = null;
		ArrayList<String> var = new ArrayList<String>();
		NodeList nl = ele.getElementsByTagName(tagAutor);

		if (nl != null && nl.getLength() > 0) {

			Element elemento = (Element) nl.item(0);
			NodeList nl2 = ele.getElementsByTagName("nombre");

			if (nl2 != null && nl.getLength() > 0) {

				for (int i = 0; i < nl2.getLength(); i++) {

					Element elemento2 = (Element) nl2.item(i);

					var.add(elemento2.getFirstChild().getNodeValue());

				}

			}

		}
		return var;

	}
		
	
	public void muestra(){

		Iterator it = libros.iterator();
		
		while(it.hasNext()) {
			
			Libro l2=(Libro) it.next();
			l2.muestra();
			
		}
	}
	
}
