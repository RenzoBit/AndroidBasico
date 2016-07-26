package pe.edu.tecsup.androidsesion4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import pe.edu.tecsup.androidsesion1.R;

public class LecturaBDActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_lectura_bd);

		CuentaDAO dao = new CuentaDAO(this);
		Cuenta cuenta;
		try {
			cuenta = dao.obtener();
			TextView correo = (TextView) findViewById(R.id.tvCorreo);
			correo.setText("Bienvenido " + cuenta.getCorreo());
		} catch (DAOExcepcion e) {
			Log.i("LecturaBDActivity", "====> " + e.getMessage());
		}
	}
}
