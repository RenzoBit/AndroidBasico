package pe.edu.tecsup.androidsesion2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import pe.edu.tecsup.androidsesion1.R;

public class ArrayAdapterActivity extends AppCompatActivity {

    private Spinner spnFrutas;
    private Button btnEnviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_array_adapter);

        spnFrutas = (Spinner) findViewById(R.id.spnFrutas);
        btnEnviar = (Button) findViewById(R.id.btnEnviar);

        final String frutas[] = {"Mango", "Manzana", "Platano", "Pera", "Durazno", "Uva", "Piña"};

        ArrayAdapter<String> frutasAdapter =
                new ArrayAdapter<String>(
                        ArrayAdapterActivity.this, android.R.layout.simple_spinner_item, frutas);

        frutasAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spnFrutas.setAdapter(frutasAdapter);
        spnFrutas.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String fruta = frutas[position];
                Toast.makeText(ArrayAdapterActivity.this, String.format("%s %s", "Te gusta", fruta), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(ArrayAdapterActivity.this, "No seleccionaste nada.", Toast.LENGTH_SHORT).show();
            }
        });

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = spnFrutas.getSelectedItemPosition();
                String fruta = frutas[position];
                Toast.makeText(ArrayAdapterActivity.this, String.format("%s %s", "Te gusta", fruta), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
