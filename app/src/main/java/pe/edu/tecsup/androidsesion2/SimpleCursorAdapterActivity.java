package pe.edu.tecsup.androidsesion2;

import android.database.Cursor;
import android.database.MatrixCursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import pe.edu.tecsup.androidsesion1.R;

public class SimpleCursorAdapterActivity extends AppCompatActivity {

    private ListView lstSimpleCursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_cursor_adapter);

        lstSimpleCursor = (ListView) findViewById(R.id.lstSimpleCursor);

        String[] from = new String[]{"Codigo", "Nombre", "Continente", "Region"};
        int[] to = new int[]{R.id.codigo, R.id.nombre, R.id.continente, R.id.region};

        Cursor cursor = obtenerPaises();

        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this, R.layout.item_simple_cursor, cursor, from, to, 0);

        lstSimpleCursor.setAdapter(adapter);

    }

    private Cursor obtenerPaises() {

        MatrixCursor cursorOrigen = new MatrixCursor(new String[] {"_id", "Codigo", "Nombre", "Continente", "Region"});
        cursorOrigen.addRow(new String[] {"1", "51", "Perú", "América", "Sur"});
        cursorOrigen.addRow(new String[] {"2", "01", "Estados Unidos", "América", "Norte"});
        cursorOrigen.addRow(new String[] {"3", "48", "México", "América", "Centro"});

        if (cursorOrigen != null) {
            cursorOrigen.moveToFirst();
        }
        return cursorOrigen;

    }

}
