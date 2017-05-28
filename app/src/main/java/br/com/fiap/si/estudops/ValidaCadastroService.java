package br.com.fiap.si.estudops;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.Vibrator;
import android.support.v7.app.NotificationCompat;
import android.util.Log;

public class ValidaCadastroService extends Service {

    public ValidaCadastroService() {}

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId){

        String usuario = intent.getExtras().getString("usuario");
        String senha = intent.getExtras().getString("senha");

        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this);
        notificationBuilder.setContentTitle("Validacao de login");

        if(usuario.trim().equalsIgnoreCase("ps") && senha.trim().equalsIgnoreCase("nota10")){
            notificationBuilder.setContentText("Cadastro realizado com sucesso");
            notificationBuilder.setSmallIcon(android.R.drawable.ic_dialog_alert);
        }else{
            notificationBuilder.setContentText("Cadastro inválido");
            notificationBuilder.setSmallIcon(android.R.drawable.ic_dialog_alert);
        }

        notificationBuilder.setContentIntent(PendingIntent.getActivity(this, 0, new Intent(this, MainActivity.class), PendingIntent.FLAG_UPDATE_CURRENT));
        notificationManager.notify(100,notificationBuilder.build());

        return START_STICKY;
    }
}
