package ru.mirea.tereshkin.socketconnection;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private final String HOST = "time-a.nist.gov";
    private final int PORT = 13;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.textView);
    }

    public void onClickTime(View view){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Socket socket = new Socket(HOST, PORT);
                    BufferedReader reader = new BufferedReader(
                            new InputStreamReader(socket.getInputStream()));
                    reader.readLine();
                    String result = reader.readLine();
                    socket.close();
                    textView.post(() -> textView.setText(result));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
    }
}