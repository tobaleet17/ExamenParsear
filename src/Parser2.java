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

public class Parser2 {
	
	private Document dom = null;
	private ArrayList<Libro2> libros = null;
	private ArrayList<Acciones> compra = null;
	private ArrayList<Acciones> venta = null;
	
	
	public Parser2() {
		
		//libros = new ArrayList<Libro2>();
		compra = new ArrayList<Acciones>();
		venta = new ArrayList<Acciones>();
		
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
	NodeList nl = docEle.getElementsByTagName("accion");
	if (nl != null && nl.getLength() > 0) {
		for (int i = 0; i < nl.getLength(); i++) {

			// obtenemos un elemento de la lista (persona)
			Element el = (Element) nl.item(i);

			// obtenemos una persona
			Acciones p = recuperarLibro(el);
			Acciones m = recuperarLibro(el);

			// lo añadimos al array
			compra.add(p);
			venta.add(m);
		}
	}
	
	

}
private Acciones recuperarLibro(Element personaEle) {
	
	//para cada elemento persona, obtenemos su nombre y su edad
		//int anyo = getIntAtribute(personaEle, "titulo");
		
	
		String nombre = getTextValue(personaEle, "titulo");
		float precio = getIntValue(personaEle, "precio");
		int cantidad = getIntValue(personaEle,"cantidad");
		ArrayList<compras> compra = getArray(personaEle, "operaciones");
		ArrayList<ventas> venta = getArray2(personaEle, "operaciones");
		
		//String editor = getTextValue(personaEle, "editor");
		//int paginas = getIntValue(personaEle, "paginas");
			
			//Libro2 l1=new Libro2(titulo, anyo, autores, editor, paginas);
			
		
			Acciones a2 = new Acciones(nombre, cantidad, precio, compra, venta);
			return a2;
	
}

	private String getTextValue(Element ele, String tagName) {

		String textValue = null;
		NodeList n1 = ele.getElementsByTagName(tagName);

		if (n1 != null && n1.getLength() > 0) {

			Element el = (Element) n1.item(0);
			textValue = el.getFirstChild().getTextContent();
		}

		return textValue;
	}
	
	private int getIntAtribute(Element ele, String tagName) {

		int anyo = 0;
		NodeList n1 = ele.getElementsByTagName(tagName);
		if (n1 != null && n1.getLength() > 0) {
			Element el = (Element) n1.item(0);
			anyo = Integer.parseInt(el.getAttribute("anyo"));
		}
		return anyo;
	}
	
	
	private ArrayList<compras> getArray (Element ele, String tagName) {
		
		ArrayList <compras> compra = new ArrayList<compras>();
		NodeList n1 = ele.getElementsByTagName(tagName);
		
		if (n1 != null && n1.getLength() > 0) {
			
			Element el = (Element) n1.item(0);
			NodeList nlCompras = el.getElementsByTagName("compras");
			
			if (nlCompras != null && nlCompras.getLength() > 0) {
				
				Element el2 = (Element) n1.item(1);
				NodeList nlCompra = el.getElementsByTagName("compra");
				
				if (nlCompra != null && nlCompra.getLength() > 0) {
				
				for (int i = 0; i < nlCompra.getLength() ; i++) {
					
					Element e12 = (Element) nlCompra.item(i);
					int cantidad = getIntValue(e12, "cantidad");
					int precio = getIntValue(e12,"precio");
					
					
					compras c1 = new compras(cantidad, precio);
					compra.add(c1);
					
					}
				}
				
			}
			
		}
	
		return compra;

	}
	
	private ArrayList<ventas> getArray2 (Element ele, String tagName) {
		
		ArrayList <ventas> venta = new ArrayList<ventas>();
		NodeList n1 = ele.getElementsByTagName(tagName);
		
		if (n1 != null && n1.getLength() > 0) {
			
			Element el = (Element) n1.item(0);
			NodeList nlVentas = el.getElementsByTagName("ventas");
			
			if (nlVentas != null && nlVentas.getLength() > 0) {
				
				Element el2 = (Element) n1.item(1);
				NodeList nlVenta = el.getElementsByTagName("venta");
				
				if (nlVenta != null && nlVenta.getLength() > 0) {
				
				for (int i = 0; i < nlVenta.getLength() ; i++) {
					
					Element e12 = (Element) nlVenta.item(i);
					int cantidad = getIntValue(e12, "cantidad");
					int precio = getIntValue(e12,"precio");
					
					ventas v1 = new ventas(cantidad, precio);
					
					
					venta.add(v1);
					
					}
				}
			}
			
		}
	
		return venta;

	}

	private int getIntValue(Element ele, String tagName) {

		return Integer.parseInt( getTextValue(ele, tagName));
		
	}
	
	public void print () {
		
			
		
		for (Acciones aux: compra ) {
			
			aux.toString();
			System.out.println(aux.toString());
			
		}
				
		}

}
