package pe.edu.tecsup.androidsesion2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

import pe.edu.tecsup.androidsesion1.R;

public class SimpleAdapterActivity extends AppCompatActivity {

    private ListView lstAgenda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_adapter);

        lstAgenda = (ListView) findViewById(R.id.lstAgenda);

        String[] from = new String[]{"Time", "Name", "Desc"};
        int[] to = new int[]{R.id.hora, R.id.nombre, R.id.desc};

        ArrayList<String[]> lista = new ArrayList<String[]>();
        String[] evento1 = {"09:00", "Campeonato Promoción", "Canchita del Barrio"};
        String[] evento2 = {"11:00", "Visitar Amigos", "Bar El Tufo"};
        String[] evento3 = {"13:00", "Almuerzo Familiar", "Casa de Tia Lucha"};
        String[] evento4 = {"09:00", "Campeonato Promoción", "Canchita del Barrio"};
        String[] evento5 = {"11:00", "Visitar Amigos", "Bar El Tufo"};
        String[] evento6 = {"13:00", "Almuerzo Familiar", "Casa de Tia Lucha"};
        String[] evento7 = {"09:00", "Campeonato Promoción", "Canchita del Barrio"};
        String[] evento8 = {"11:00", "Visitar Amigos", "Bar El Tufo"};
        String[] evento9 = {"13:00", "Almuerzo Familiar", "Casa de Tia Lucha"};
        String[] evento10 = {"09:00", "Campeonato Promoción", "Canchita del Barrio"};
        String[] evento11 = {"11:00", "Visitar Amigos", "Bar El Tufo"};
        String[] evento12 = {"13:00", "Almuerzo Familiar", "Casa de Tia Lucha"};
        String[] evento13 = {"09:00", "Campeonato Promoción", "Canchita del Barrio"};
        String[] evento14 = {"11:00", "Visitar Amigos", "Bar El Tufo"};
        String[] evento15 = {"13:00", "Almuerzo Familiar", "Casa de Tia Lucha"};

        lista.add(evento1);
        lista.add(evento2);
        lista.add(evento3);
        lista.add(evento4);
        lista.add(evento5);
        lista.add(evento6);
        lista.add(evento7);
        lista.add(evento8);
        lista.add(evento9);
        lista.add(evento10);
        lista.add(evento11);
        lista.add(evento12);
        lista.add(evento13);
        lista.add(evento14);
        lista.add(evento15);

        ArrayList<HashMap<String, String>> eventos = new ArrayList<HashMap<String, String>>();
        for (String[] evento : lista) {
            HashMap<String, String> datosEvento = new HashMap<String, String>();

            datosEvento.put("Time", evento[0]);
            datosEvento.put("Name", evento[1]);
            datosEvento.put("Desc", evento[2]);

            eventos.add(datosEvento);
        }

        SimpleAdapter listaAdapter = new SimpleAdapter(SimpleAdapterActivity.this, eventos, R.layout.item_agenda, from, to);

        lstAgenda.setAdapter(listaAdapter);
        lstAgenda.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(SimpleAdapterActivity.this, "Pulsaste el elemento " + position, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
