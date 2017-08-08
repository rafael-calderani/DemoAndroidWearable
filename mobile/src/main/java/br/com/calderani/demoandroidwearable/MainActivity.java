package br.com.calderani.demoandroidwearable;

import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public PendingIntent getPendingIntent() {
        Intent urlIntent = new Intent(Intent.ACTION_VIEW);
        Uri uri = Uri.parse("http://www.google.com");
        urlIntent.setData(uri);
        PendingIntent urlPengingIntent = PendingIntent.getActivity(this, 0, urlIntent, 0);

        return urlPengingIntent;
    }

    public void enviarNotificacao(View v) {
        int notificationId = 101;
        Intent viewIntent = new Intent(this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, viewIntent, 0);

        NotificationCompat.Builder nBuilder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("Android Wear")
                .setContentText("Teste de Notificação")
                .addAction(R.mipmap.ic_launcher, "Open Google", getPendingIntent())
                .setContentIntent(pendingIntent);

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
        notificationManager.notify(notificationId, nBuilder.build());
    }
}
