package pe.edu.tecsup.androidsesion4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

import pe.edu.tecsup.androidsesion1.R;

public class LecturaDOMActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_lectura_dom);

		CursoParserDOM parser = new CursoParserDOM(R.raw.cursos, getResources());
		ArrayList<Curso> cursos = parser.procesar();
		ArrayList<HashMap<String, String>> cursosAdapter = new ArrayList<HashMap<String, String>>();
		for (Curso curso : cursos) {
			HashMap<String, String> datosEvento = new HashMap<String, String>();
			datosEvento.put("Id", String.valueOf(curso.getId()));
			datosEvento.put("Curso", curso.getNombre());
			datosEvento.put("Desc", curso.getDescripcion());
			cursosAdapter.add(datosEvento);
		}
		String[] from = new String[] { "Id", "Curso", "Desc" };
		int[] to = new int[] { R.id.id, R.id.curso, R.id.descripcion };
		SimpleAdapter listadoAdapter = new SimpleAdapter(this, cursosAdapter, R.layout.fragment_lectura_dom_fila, from, to);
		ListView lv = (ListView) findViewById(R.id.lista1);
		lv.setAdapter(listadoAdapter);
	}

}
