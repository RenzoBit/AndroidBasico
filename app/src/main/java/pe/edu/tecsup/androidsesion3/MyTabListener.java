package pe.edu.tecsup.androidsesion3;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.util.Log;

import pe.edu.tecsup.androidsesion1.R;

/**
 * Created by hrodp on 11/06/2016.
 */
public class MyTabListener implements ActionBar.TabListener {

    private Fragment fragment;

    public MyTabListener(Fragment fragment) {
        this.fragment = fragment;
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
        Log.i("ActionBar", tab.getText() + " seleccionada.");
        ft.replace(R.id.lnlContenedor, fragment);
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {
        Log.i("ActionBar", tab.getText() + " deseleccionada.");
        ft.remove(fragment);
    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {
        Log.i("ActionBar", tab.getText() + " reseleccionada.");
    }
}
