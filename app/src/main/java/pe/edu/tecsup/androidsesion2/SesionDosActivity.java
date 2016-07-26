package pe.edu.tecsup.androidsesion2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import pe.edu.tecsup.androidsesion1.R;

public class SesionDosActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnTextView;
    private Button btnButton;
    private Button btnImageView;
    private Button btnScrollView;
    private Button btnEditText;
    private Button btnAutoCompleteTextView;
    private Button btnCheckBox;
    private Button btnRadioButton;
    private Button btnProgressBar;
    private Button btnSeekBar;
    private Button btnArrayAdapter;
    private Button btnSimpleAdapter;
    private Button btnSimpleCursorAdapter;
    private Button btnCustomAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sesion_dos);

        btnTextView = (Button) findViewById(R.id.btnTextView);
        btnButton = (Button) findViewById(R.id.btnButton);
        btnImageView = (Button) findViewById(R.id.btnImageView);
        btnScrollView = (Button) findViewById(R.id.btnScrollView);
        btnEditText = (Button) findViewById(R.id.btnEditText);
        btnAutoCompleteTextView = (Button) findViewById(R.id.btnAutoCompleteTextView);
        btnCheckBox = (Button) findViewById(R.id.btnCheckBox);
        btnRadioButton = (Button) findViewById(R.id.btnRadioButton);
        btnProgressBar = (Button) findViewById(R.id.btnProgressBar);
        btnSeekBar = (Button) findViewById(R.id.btnSeekBar);
        btnArrayAdapter = (Button) findViewById(R.id.btnArrayAdapter);
        btnSimpleAdapter = (Button) findViewById(R.id.btnSimpleAdapter);
        btnSimpleCursorAdapter = (Button) findViewById(R.id.btnSimpleCursorAdapter);
        btnCustomAdapter = (Button) findViewById(R.id.btnCustomAdapter);

        btnTextView.setOnClickListener(this);
        btnButton.setOnClickListener(this);
        btnImageView.setOnClickListener(this);
        btnScrollView.setOnClickListener(this);
        btnEditText.setOnClickListener(this);
        btnAutoCompleteTextView.setOnClickListener(this);
        btnCheckBox.setOnClickListener(this);
        btnRadioButton.setOnClickListener(this);
        btnProgressBar.setOnClickListener(this);
        btnSeekBar.setOnClickListener(this);
        btnArrayAdapter.setOnClickListener(this);
        btnSimpleAdapter.setOnClickListener(this);
        btnSimpleCursorAdapter.setOnClickListener(this);
        btnCustomAdapter.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        switch (v.getId()) {
            case R.id.btnTextView:
                break;
            case R.id.btnButton:
                break;
            case R.id.btnImageView:
                break;
            case R.id.btnScrollView:
                intent = new Intent(SesionDosActivity.this, ScrollViewActivity.class);
                startActivity(intent);
                break;
            case R.id.btnEditText:
                break;
            case R.id.btnAutoCompleteTextView:
                intent = new Intent(SesionDosActivity.this, AutoCompleteActivity.class);
                startActivity(intent);
                break;
            case R.id.btnCheckBox:
                intent = new Intent(SesionDosActivity.this, CheckBoxActivity.class);
                startActivity(intent);
                break;
            case R.id.btnRadioButton:
                intent = new Intent(SesionDosActivity.this, RadioButtonActivity.class);
                startActivity(intent);
                break;
            case R.id.btnProgressBar:
                intent = new Intent(SesionDosActivity.this, ProgressBarActivity.class);
                startActivity(intent);
                break;
            case R.id.btnSeekBar:
                intent = new Intent(SesionDosActivity.this, SeekBarActivity.class);
                startActivity(intent);
                break;
            case R.id.btnArrayAdapter:
                intent = new Intent(SesionDosActivity.this, ArrayAdapterActivity.class);
                startActivity(intent);
                break;
            case R.id.btnSimpleAdapter:
                intent = new Intent(SesionDosActivity.this, SimpleAdapterActivity.class);
                startActivity(intent);
                break;
            case R.id.btnSimpleCursorAdapter:
                intent = new Intent(SesionDosActivity.this, SimpleCursorAdapterActivity.class);
                startActivity(intent);
                break;
            case R.id.btnCustomAdapter:
                intent = new Intent(SesionDosActivity.this, CustomAdapterActivity.class);
                startActivity(intent);
                break;
        }
    }
}

