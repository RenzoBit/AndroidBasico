package pe.edu.tecsup.androidsesion4;

import android.content.res.Resources;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.InputStream;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

/**
 * Created by Renzo on 26/07/2016.
 */
public class CursoParserDOM {

	private int identificador;
	private Resources recursos;

	public CursoParserDOM(int identificador, Resources recursos) {
		this.identificador = identificador;
		this.recursos = recursos;
	}

	public ArrayList<Curso> procesar() {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		ArrayList<Curso> cursos = new ArrayList<Curso>();
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document dom = builder.parse(this.getInputStream());
			Element root = dom.getDocumentElement();
			NodeList items = root.getElementsByTagName("curso");
			for (int i = 0; i < items.getLength(); i++) {
				Curso curso = new Curso();
				Node item = items.item(i);
				NodeList datosNoticia = item.getChildNodes();
				for (int j = 0; j < datosNoticia.getLength(); j++) {
					Node dato = datosNoticia.item(j);
					String etiqueta = dato.getNodeName();
					if (etiqueta.equals("id")) {
						String texto = obtenerTexto(dato);
						curso.setId(Integer.parseInt(texto));
					} else if (etiqueta.equals("nombre")) {
						curso.setNombre(dato.getFirstChild().getNodeValue());
					} else if (etiqueta.equals("descripcion")) {
						curso.setDescripcion(dato.getFirstChild().getNodeValue());
					}
				}
				cursos.add(curso);
			}
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
		return cursos;
	}

	private String obtenerTexto(Node dato) {
		StringBuilder texto = new StringBuilder();
		NodeList fragmentos = dato.getChildNodes();
		for (int k = 0; k < fragmentos.getLength(); k++) {
			texto.append(fragmentos.item(k).getNodeValue());
		}
		return texto.toString();
	}

	private InputStream getInputStream() {
		try {
			return recursos.openRawResource(identificador);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
