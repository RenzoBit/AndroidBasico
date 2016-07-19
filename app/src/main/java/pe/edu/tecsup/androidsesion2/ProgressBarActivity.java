package pe.edu.tecsup.androidsesion2;

import android.app.ProgressDialog;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import pe.edu.tecsup.androidsesion1.R;

public class ProgressBarActivity extends AppCompatActivity implements View.OnClickListener {

    private ProgressDialog progressBar;
    private int progressStatus;
    private Handler progressHandler = new Handler();

    private Button btnProgress1;
    private Button btnProgress2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_bar);

        btnProgress1 = (Button) findViewById(R.id.btnProgress1);
        btnProgress2 = (Button) findViewById(R.id.btnProgress2);

        btnProgress1.setOnClickListener(this);
        btnProgress2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnProgress1) {

            progressStatus = 0;

            progressBar = new ProgressDialog(ProgressBarActivity.this);
            progressBar.setCancelable(true);
            progressBar.setMessage("Tarea Larga...");
            progressBar.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            progressBar.setProgress(0);
            progressBar.setMax(100);
            progressBar.show();

            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (progressStatus < 100) {
                        progressStatus += 10;

                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        progressHandler.post(new Runnable() {
                            @Override
                            public void run() {
                                progressBar.setProgress(progressStatus);
                            }
                        });

                        if (progressStatus >= 100) {
                            progressBar.dismiss();
                        }
                    }
                }
            }).start();

        } else if (v.getId() == R.id.btnProgress2) {

            progressBar = ProgressDialog.show(ProgressBarActivity.this, "Espere", "Descargando archivo...", true);
            progressBar.setCancelable(true);
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(5000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    progressBar.dismiss();
                }
            }).start();

        }
    }
}
