package pe.edu.tecsup.androidsesion1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SesionUnoActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnGrid;
    private Button btnLinear;
    private Button btnRelative;
    private Button btnFrame;
    private Button btnTable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sesion_uno);

        btnGrid = (Button) findViewById(R.id.btnGrid);
        btnLinear = (Button) findViewById(R.id.btnLinear);
        btnRelative = (Button) findViewById(R.id.btnRelative);
        btnFrame = (Button) findViewById(R.id.btnFrame);
        btnTable = (Button) findViewById(R.id.btnTable);

        btnGrid.setOnClickListener(this);
        btnLinear.setOnClickListener(this);
        btnRelative.setOnClickListener(this);
        btnFrame.setOnClickListener(this);
        btnTable.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(SesionUnoActivity.this, LayoutActivity.class);
        switch (v.getId()) {
            case R.id.btnGrid:
                intent.putExtra("layout", R.layout.activity_layout_grid);
                break;
            case R.id.btnLinear:
                intent.putExtra("layout", R.layout.activity_layout_linear);
                break;
            case R.id.btnRelative:
                intent.putExtra("layout", R.layout.activity_layout_relative);
                break;
            case R.id.btnFrame:
                intent.putExtra("layout", R.layout.activity_layout_frame);
                break;
            case R.id.btnTable:
                intent.putExtra("layout", R.layout.activity_layout_table);
                break;
        }
        startActivity(intent);
    }
}
