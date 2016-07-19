package pe.edu.tecsup.androidsesion3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TabHost;

import pe.edu.tecsup.androidsesion1.R;

public class TabsActivity extends AppCompatActivity {

    private TabHost tabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabs);

        tabHost = (TabHost) findViewById(R.id.tabHost);

        tabHost.setup();

        TabHost.TabSpec spec;

        // Tab 1
        spec = tabHost.newTabSpec("tab1");
        spec.setContent(R.id.lnlTab1);
        spec.setIndicator("Ventas");
        tabHost.addTab(spec);

        // Tab 2
        spec = tabHost.newTabSpec("tab2");
        spec.setContent(R.id.lnlTab2);
        spec.setIndicator("Servicios");
        tabHost.addTab(spec);

        // Tab 3
        spec = tabHost.newTabSpec("tab3");
        spec.setContent(R.id.lnlTab3);
        spec.setIndicator("Almacen");
        tabHost.addTab(spec);

        tabHost.setCurrentTab(0);
    }
}
