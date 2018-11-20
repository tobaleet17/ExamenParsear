
public class Parser_libro {

	public static void main(String[] args) {

		//Para el ejercico simple
		//Parser p1 = new Parser();
		//p1.parseFicheroXml("biblioteca.xml");
		//p1.parseDocument();
		//p1.muestra();
		
		//PAra el ampliado
		Parser2 p2 = new Parser2();
		
		p2.parseFicheroXml("acciones.xml");
		p2.parseDocument();
		p2.print();
		
		
		
		
		
		
	}

}
