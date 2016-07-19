package pe.edu.tecsup.androidsesion3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import pe.edu.tecsup.androidsesion1.LayoutActivity;
import pe.edu.tecsup.androidsesion1.R;

public class SesionTresActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnTabs;
    private Button btnActionBar;
    private Button btnContextMenu;
    private Button btnTabsActionBar;
    private Button btnServices;
    private Button btnAsyncTask;
    private Button btnBroadcastReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sesion_tres);

        btnTabs = (Button) findViewById(R.id.btnTabs);
        btnActionBar = (Button) findViewById(R.id.btnActionBar);
        btnContextMenu = (Button) findViewById(R.id.btnContextMenu);
        btnTabsActionBar = (Button) findViewById(R.id.btnTabsActionBar);
        btnServices = (Button) findViewById(R.id.btnServices);
        btnAsyncTask = (Button) findViewById(R.id.btnAsyncTask);
        btnBroadcastReceiver = (Button) findViewById(R.id.btnBroadcastReceiver);

        btnTabs.setOnClickListener(this);
        btnActionBar.setOnClickListener(this);
        btnContextMenu.setOnClickListener(this);
        btnTabsActionBar.setOnClickListener(this);
        btnServices.setOnClickListener(this);
        btnAsyncTask.setOnClickListener(this);
        btnBroadcastReceiver.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        switch (v.getId()) {
            case R.id.btnTabs:
                intent = new Intent(SesionTresActivity.this, TabsActivity.class);
                startActivity(intent);
                break;
            case R.id.btnActionBar:
                intent = new Intent(SesionTresActivity.this, ActionBarActivity.class);
                startActivity(intent);
                break;
            case R.id.btnContextMenu:
                intent = new Intent(SesionTresActivity.this, ContextMenuActivity.class);
                startActivity(intent);
                break;
            case R.id.btnTabsActionBar:
                intent = new Intent(SesionTresActivity.this, TabsActionBarActivity.class);
                startActivity(intent);
                break;
            case R.id.btnServices:
                intent = new Intent(SesionTresActivity.this, ServicesActivity.class);
                startActivity(intent);
                break;
            case R.id.btnAsyncTask:
                intent = new Intent(SesionTresActivity.this, AsyncTaskActivity.class);
                startActivity(intent);
                break;
            case R.id.btnBroadcastReceiver:
                intent = new Intent(SesionTresActivity.this, BroadcastReceiverActivity.class);
                startActivity(intent);
                break;
        }
    }
}

