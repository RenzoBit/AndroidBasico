package pe.edu.tecsup.androidsesion2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

import pe.edu.tecsup.androidsesion1.R;

public class RadioButtonActivity extends AppCompatActivity {

    private RadioButton radSoltero;
    private RadioButton radCasado;
    private RadioButton radDivorciado;
    private Button btnEnviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio_button);

        radSoltero = (RadioButton) findViewById(R.id.radSoltero);
        radCasado = (RadioButton) findViewById(R.id.radCasado);
        radDivorciado = (RadioButton) findViewById(R.id.radDivorciado);
        btnEnviar = (Button) findViewById(R.id.btnEnviar);

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mensaje = new String();
                if (radSoltero.isChecked()) {
                    mensaje = "Tu estas SOLTERO! Aprovecha";
                } else if (radCasado.isChecked()) {
                    mensaje = "Tu estas CASADO! :(";
                } else if (radDivorciado.isChecked()) {
                    mensaje = "Tu estas DIVORCIADO! ...";
                }
                Toast.makeText(RadioButtonActivity.this, mensaje, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
