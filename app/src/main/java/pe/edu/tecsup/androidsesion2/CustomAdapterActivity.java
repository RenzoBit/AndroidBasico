package pe.edu.tecsup.androidsesion2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.SparseArray;
import android.widget.ExpandableListView;

import pe.edu.tecsup.androidsesion1.R;

public class CustomAdapterActivity extends AppCompatActivity {

    private ExpandableListView lstCustomAdapter;
    private SparseArray<AmpliableGroup> groups = new SparseArray<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_adapter);

        loadData();

        lstCustomAdapter = (ExpandableListView) findViewById(R.id.lstCustomAdapter);

        AmpliableAdapter adapter = new AmpliableAdapter(CustomAdapterActivity.this, groups);

        lstCustomAdapter.setAdapter(adapter);
    }

    public void loadData() {
        for (int i=0 ; i<5 ; i++) {
            AmpliableGroup group = new AmpliableGroup("Categoria " + (i+1));
            for (int j=0 ; j<3 ; j++) {
                group.children.add("Sub Categoría " + (j+1));
            }
            groups.append(i, group);
        }
    }
}
