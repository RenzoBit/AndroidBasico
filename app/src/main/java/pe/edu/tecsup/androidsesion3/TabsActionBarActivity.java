package pe.edu.tecsup.androidsesion3;

import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import pe.edu.tecsup.androidsesion1.R;

public class TabsActionBarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabs_action_bar);

        ActionBar actionBar = getSupportActionBar();

        // Se configura la navegación a través de Tabs
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        // Ocultar el título del Activity
        actionBar.setDisplayShowTitleEnabled(false);


        // Creación de tabs
        ActionBar.Tab tab1 = actionBar.newTab().setText("Pestaña 1");
        ActionBar.Tab tab2 = actionBar.newTab().setText("Pestaña 2");

        //Creamos los fragmentos de cada tab
        Fragment tab1frag = new Tab1Fragment();
        Fragment tab2frag = new Tab2Fragment();

        //Asociamos los listener a los tabs
        tab1.setTabListener((ActionBar.TabListener) new MyTabListener(tab1frag));
        tab2.setTabListener((ActionBar.TabListener) new MyTabListener(tab2frag));

        // Agregar los tabs al ActionBar
        actionBar.addTab(tab1);
        actionBar.addTab(tab2);

    }
}
