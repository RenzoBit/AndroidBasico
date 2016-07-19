package pe.edu.tecsup.androidsesion1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Hernan Pareja on 03/06/2016.
 */
public class LayoutActivity extends AppCompatActivity {

    private int layoutId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            layoutId = extras.getInt("layout");
        }

        setContentView(layoutId);
    }
}
