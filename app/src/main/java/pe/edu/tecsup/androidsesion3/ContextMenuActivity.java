package pe.edu.tecsup.androidsesion3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import pe.edu.tecsup.androidsesion1.R;

public class ContextMenuActivity extends AppCompatActivity {

    private TextView txtMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_context_menu);

        txtMenu = (TextView) findViewById(R.id.txtMenu);

        registerForContextMenu(txtMenu);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_context, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.itemOpcion1:
                Toast.makeText(ContextMenuActivity.this, "Click en el Item 1", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.itemOpcion2:
                Toast.makeText(ContextMenuActivity.this, "Click en el Item 2", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.itemOpcion3:
                Toast.makeText(ContextMenuActivity.this, "Click en el Item 3", Toast.LENGTH_SHORT).show();
                return true;
            default:
                super.onContextItemSelected(item);
        }
        return false;
    }
}
