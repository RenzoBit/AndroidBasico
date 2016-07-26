package pe.edu.tecsup.androidsesion4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import pe.edu.tecsup.androidsesion1.R;

public class EscrituraBDActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_escritura_bd);
	}

	public void guardar(View view) {
		EditText correo = (EditText) findViewById(R.id.txtCorreo);
		EditText clave = (EditText) findViewById(R.id.txtClave);
		CuentaDAO dao = new CuentaDAO(getBaseContext());
		try {
			dao.eliminarTodos();
			dao.insertar(correo.getText().toString(), clave.getText().toString());
			Toast.makeText(EscrituraBDActivity.this, "Se insertó correctamente", Toast.LENGTH_SHORT).show();
		} catch (DAOExcepcion e) {
			Log.i("EscrituraBDActivity", "====> " + e.getMessage());
		}
	}

	public void continuar(View view) {
		startActivity(new Intent(this, LecturaBDActivity.class));
	}

}
