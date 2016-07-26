package pe.edu.tecsup.androidsesion4;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import pe.edu.tecsup.androidsesion1.R;

public class ListarContactosActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_listar_contactos);
	}

	public void mostrarContactos(View V) {
		// http://androidexample.com/Get_Contact_Emails_By_Content_Provider_-_Android_Example/index.php?view=article_discription&aid=121&aaid=141
		try {
			ContentResolver cr = this.getContentResolver();
			Cursor cur = cr.query(ContactsContract.Contacts.CONTENT_URI, null, null, null, null);
			if (cur.getCount() > 0) {
				while (cur.moveToNext()) {
					String[] contactos = new String[cur.getCount()];
					Uri uri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
					String[] listaCampos = new String[]{ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME, ContactsContract.CommonDataKinds.Phone.NUMBER};
					Cursor datos = getContentResolver().query(uri, listaCampos, null, null, null);
					int indexName = datos.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME);
					int indexNumber = datos.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER);
					int i = 0;
					datos.moveToFirst();
					do {
						String name = datos.getString(indexName);
						String number = datos.getString(indexNumber);
						contactos[i++] = name + " ===> " + number;
					} while (datos.moveToNext());
					ListView LstContactos = (ListView) findViewById(R.id.LstContactos);
					ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, contactos);
					LstContactos.setAdapter(adaptador);
				}
			} else {
				Log.i("==========>", "No hay registros");
			}
			cur.close();
		} catch (Exception e) {
			Log.i("=======>", e.toString());
		}
	}

}
