package pe.edu.tecsup.androidsesion4;

import android.Manifest;
import android.content.ContentResolver;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.provider.CallLog;
import android.provider.CallLog.Calls;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import pe.edu.tecsup.androidsesion1.R;

public class ListarLlamadasActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_listar_llamadas);
	}

	public void listarLlamadas(View view) {
		String[] campos = new String[]{Calls.TYPE, Calls.NUMBER};
		Uri llamadasUri = Calls.CONTENT_URI; // content://call_log/calls
		ContentResolver cr = getContentResolver();
		if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_CALL_LOG) != PackageManager.PERMISSION_GRANTED) {
			return;
		}
		Cursor cur = cr.query(llamadasUri, campos, // Columnas a devolver
				null, // Condición de la query
				null, // Argumentos variables de la query
				null); // Orden de los resultados
		String[] llamadas = new String[cur.getCount()];
		int contador = 0;

		if (cur.moveToFirst()) {
			int tipo;
			String tipoLlamada = "";
			String telefono;
			int colTipo = cur.getColumnIndex(Calls.TYPE);
			int colTelefono = cur.getColumnIndex(Calls.NUMBER);
			do {
				tipo = cur.getInt(colTipo);
				telefono = cur.getString(colTelefono);
				if (tipo == Calls.INCOMING_TYPE) {
					tipoLlamada = "ENTRADA";
				} else if (tipo == Calls.OUTGOING_TYPE) {
					tipoLlamada = "SALIDA";
				} else if (tipo == Calls.MISSED_TYPE) {
					tipoLlamada = "PERDIDA";
				}
				llamadas[contador++] = tipoLlamada + " - " + telefono;
			} while (cur.moveToNext());
		}

		ListView LstJugadores = (ListView) findViewById(R.id.LstLlamadas);
		ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, llamadas);
		LstJugadores.setAdapter(adaptador);
	}

}
