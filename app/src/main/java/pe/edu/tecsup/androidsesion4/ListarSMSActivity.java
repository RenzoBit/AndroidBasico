package pe.edu.tecsup.androidsesion4;

import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import pe.edu.tecsup.androidsesion1.R;

public class ListarSMSActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_listar_sms);
	}

	public void listarSMS(View v) {
		//Cursor cursor = getContentResolver().query(Uri.parse("content://sms/inbox"), null, null, null, null);
		Cursor cursor = getContentResolver().query(Uri.parse("content://sms/sent"), null, null, null, null);
		cursor.moveToFirst();
		int i = 0;
		String[] datos = new String[cursor.getCount()];
		if (cursor.getCount() > 0) {
			do {
				String mensaje = "";
				for (int idx = 0; idx < cursor.getColumnCount(); idx++) {
					mensaje += cursor.getColumnName(idx) + ":" + cursor.getString(idx);
				}
				Log.i("=========>", mensaje);
				datos[i++] = cursor.getString(2) + "===>" + cursor.getString(12);
			} while (cursor.moveToNext());
		} else {
			Log.i("==========>", "No hay registros");
		}
		ListView LstContactos = (ListView) findViewById(R.id.lvSms);
		ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, datos);
		LstContactos.setAdapter(adaptador);
	}

}
