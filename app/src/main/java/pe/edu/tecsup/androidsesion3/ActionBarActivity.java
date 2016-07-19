package pe.edu.tecsup.androidsesion3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import pe.edu.tecsup.androidsesion1.R;

public class ActionBarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action_bar);

        //this.getActionBar().setHomeButtonEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_principal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Toast.makeText(ActionBarActivity.this, "Click en el Home", Toast.LENGTH_SHORT).show();
                break;
            case R.id.item1:
                Toast.makeText(ActionBarActivity.this, "Click en el Item 1", Toast.LENGTH_SHORT).show();
                break;
            case R.id.item2:
                Toast.makeText(ActionBarActivity.this, "Click en el Item 2", Toast.LENGTH_SHORT).show();
                break;
            case R.id.item3:
                Toast.makeText(ActionBarActivity.this, "Click en el Item 3", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
