package pe.edu.tecsup.androidsesion2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import pe.edu.tecsup.androidsesion1.R;

public class AutoCompleteActivity extends AppCompatActivity implements TextWatcher {

    private AutoCompleteTextView autCompletePrueba;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto_complete);

        String frutas[] = {"Mango", "Manzana", "Platano", "Pera", "Durazno", "Uva", "Piña"};

        autCompletePrueba = (AutoCompleteTextView) findViewById(R.id.autCompletePrueba);
        autCompletePrueba.addTextChangedListener(this);
        autCompletePrueba.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, frutas));

    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {

    }
}
