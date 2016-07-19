package pe.edu.tecsup.androidsesion2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import pe.edu.tecsup.androidsesion1.R;

public class CheckBoxActivity extends AppCompatActivity {

    private CheckBox chkFutbol;
    private CheckBox chkBasket;
    private CheckBox chkTennis;
    private CheckBox chkUFC;
    private Button btnEnviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_box);

        chkFutbol = (CheckBox) findViewById(R.id.chkFutbol);
        chkBasket = (CheckBox) findViewById(R.id.chkBasket);
        chkTennis = (CheckBox) findViewById(R.id.chkTennis);
        chkUFC = (CheckBox) findViewById(R.id.chkUFC);
        btnEnviar = (Button) findViewById(R.id.btnEnviar);

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mensaje = "Te gusta: ";
                if (chkFutbol.isChecked()) {
                    mensaje = mensaje + "Futbol,";
                }
                if (chkBasket.isChecked()) {
                    mensaje = mensaje + "Basket,";
                }
                if (chkTennis.isChecked()) {
                    mensaje = mensaje + "Tennis,";
                }
                if (chkUFC.isChecked()) {
                    mensaje = mensaje + "UFC";
                }
                Toast.makeText(CheckBoxActivity.this, mensaje, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
