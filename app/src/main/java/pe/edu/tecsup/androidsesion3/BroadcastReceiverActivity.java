package pe.edu.tecsup.androidsesion3;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import pe.edu.tecsup.androidsesion1.R;

public class BroadcastReceiverActivity extends AppCompatActivity {

    private Button btnStartService;
    private Button btnStopService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast_receiver);

        btnStartService = (Button) findViewById(R.id.btnStartService);
        btnStartService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startService(new Intent(getBaseContext(), BroadcastService.class));
            }
        });

        btnStopService = (Button) findViewById(R.id.btnStopService);
        btnStopService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopService(new Intent(getBaseContext(), BroadcastService.class));
            }
        });
    }

    public static class BroadcastReceiver extends android.content.BroadcastReceiver {

        public BroadcastReceiver () {

        }

        @Override
        public void onReceive(Context context, Intent intent) {

            String hora = new String();

            Bundle extras = intent.getExtras();
            if (extras != null) {
                hora = extras.getString("hora");
            }
            Log.i("BroadCast Receiver", "Acabo de recibir la hora");
            Toast.makeText(context, hora, Toast.LENGTH_SHORT).show();
        }
    }
}
