package pe.edu.tecsup.androidsesion3;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Timer;

/**
 * Created by hrodp on 11/06/2016.
 */
public class ShowTimeService extends Service {

    private Timer timer = new Timer();
    public static final long INTERVALO_SEGUNDOS = 4 * 1000;

    private Handler handler;

    public ShowTimeService() {
        handler = new Handler();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        timer.scheduleAtFixedRate(new TimerTask(), 0, INTERVALO_SEGUNDOS);
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        timer.cancel();
        Toast.makeText(getBaseContext(), "Servicio Detenido", Toast.LENGTH_SHORT).show();
    }

    class TimerTask extends java.util.TimerTask {

        @Override
        public void run() {
            handler.post(new Runnable() {
                @Override
                public void run() {
                    GregorianCalendar gc = new GregorianCalendar();
                    String hora;

                    hora = gc.get(Calendar.HOUR) + ":" + gc.get(Calendar.MINUTE) + ":" + gc.get(Calendar.SECOND);

                    Toast.makeText(getBaseContext(), hora, Toast.LENGTH_SHORT).show();
                    Log.i("Time", hora);
                }
            });
        }
    }
}
