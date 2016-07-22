package pe.edu.tecsup.androidmain;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import pe.edu.tecsup.androidsesion1.R;
import pe.edu.tecsup.androidsesion2.SesionDosActivity;
import pe.edu.tecsup.androidsesion1.SesionUnoActivity;
import pe.edu.tecsup.androidsesion3.SesionTresActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnSesionUno;
    private Button btnSesionDos;
    private Button btnSesionTres;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //comentado
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSesionUno = (Button) findViewById(R.id.btnSesionUno);
        btnSesionDos = (Button) findViewById(R.id.btnSesionDos);
        btnSesionTres = (Button) findViewById(R.id.btnSesionTres);

        btnSesionUno.setOnClickListener(this);
        btnSesionDos.setOnClickListener(this);
        btnSesionTres.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        switch (v.getId()) {
            case R.id.btnSesionUno:
                intent = new Intent(MainActivity.this, SesionUnoActivity.class);
                break;
            case R.id.btnSesionDos:
                intent = new Intent(MainActivity.this, SesionDosActivity.class);
                break;
            case R.id.btnSesionTres:
                intent = new Intent(MainActivity.this, SesionTresActivity.class);
                break;
        }
        startActivity(intent);
    }
}
