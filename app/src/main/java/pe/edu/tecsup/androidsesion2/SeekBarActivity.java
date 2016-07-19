package pe.edu.tecsup.androidsesion2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.SeekBar;

import pe.edu.tecsup.androidsesion1.R;

public class SeekBarActivity extends AppCompatActivity {

    private SeekBar skbEntradas;
    private EditText edtNumero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seek_bar);

        skbEntradas = (SeekBar) findViewById(R.id.skbEntradas);
        edtNumero = (EditText) findViewById(R.id.edtNumero);

        skbEntradas.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int valor = progress;
                edtNumero.setText(String.valueOf(valor));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
