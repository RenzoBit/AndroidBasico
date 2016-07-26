package pe.edu.tecsup.androidsesion4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import pe.edu.tecsup.androidsesion1.R;

public class SesionCuatroActivity extends AppCompatActivity implements View.OnClickListener {

	private Button btnSQLite, btnShared, btnContentLlamadas, btnContentContactos, btnContentSMS, btnXMLLectura;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sesion_cuatro);

		btnSQLite = (Button) findViewById(R.id.btnSQLite);
		btnShared = (Button) findViewById(R.id.btnShared);
		btnContentLlamadas = (Button) findViewById(R.id.btnContentLlamadas);
		btnContentContactos = (Button) findViewById(R.id.btnContentContactos);
		btnContentSMS = (Button) findViewById(R.id.btnContentSMS);
		btnXMLLectura = (Button) findViewById(R.id.btnXMLLectura);

		btnSQLite.setOnClickListener(this);
		btnShared.setOnClickListener(this);
		btnContentLlamadas.setOnClickListener(this);
		btnContentContactos.setOnClickListener(this);
		btnContentSMS.setOnClickListener(this);
		btnXMLLectura.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		Intent intent = new Intent();
		switch (v.getId()) {
			case R.id.btnSQLite:
				intent = new Intent(SesionCuatroActivity.this, EscrituraBDActivity.class);
				startActivity(intent);
				break;
			case R.id.btnShared:
				intent = new Intent(SesionCuatroActivity.this, EscribirPreferenciaActivity.class);
				startActivity(intent);
				break;
			case R.id.btnContentLlamadas:
				intent = new Intent(SesionCuatroActivity.this, ListarLlamadasActivity.class);
				startActivity(intent);
				break;
			case R.id.btnContentContactos:
				intent = new Intent(SesionCuatroActivity.this, ListarContactosActivity.class);
				startActivity(intent);
				break;
			case R.id.btnContentSMS:
				intent = new Intent(SesionCuatroActivity.this, ListarSMSActivity.class);
				startActivity(intent);
				break;
			case R.id.btnXMLLectura:
				intent = new Intent(SesionCuatroActivity.this, LecturaDOMActivity.class);
				startActivity(intent);
				break;
		}
	}

}
