package fr.acos.androkado.views.activities;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import fr.acos.androkado.R;

public class Main5Activity extends AppCompatActivity{

    private ProgressBar progressBar = null;
    private Button btn1 = null;
    private Button btn2 = null;
    private Button btn3 = null;
    private Button btn4 = null;
    private ProgressBarHandler handler = new ProgressBarHandler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        /* ProgressBar */
        this.progressBar = this.findViewById(R.id.progressBar);
        this.btn1 = this.findViewById(R.id.btnProgressBar1);
        this.btn2 = this.findViewById(R.id.btnProgressBar2);
        this.btn3 = this.findViewById(R.id.btnProgressBar3);
        this.btn4 = this.findViewById(R.id.btnProgressBar4);

    }

    public void onBtnProgressBar1clicked(View view) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                progressBarLooper();
            }
        }).start();
    }

    public void onBtnProgressBar2clicked(View view) {
        progressBarLooper();
    }

    private void progressBarLooper() {
        for (int i = 0; i <= 10000; i++) {
            Main5Activity.this.progressBar.setProgress(i);
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Main5Activity.this.progressBar.setProgress(0);
    }

    public void onBtnProgressBar3clicked(View view) {
        new Worker().execute();
    }

    public void onBtnProgressBar4clicked(final View view) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Message msgGo = new Message();
                msgGo.what = 1;
                handler.sendMessage(msgGo);
                
                for (int i = 0; i <= 10000; i++) {
                    Message msgEnCours = new Message();
                    msgEnCours.what = 2;
                    msgEnCours.arg1 = i;
                    handler.sendMessage(msgEnCours);

                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                Message msgEnd = new Message();
                msgEnd.what = 3;
                handler.sendMessage(msgEnd);
                Main5Activity.this.progressBar.setProgress(0);
            }
        }).start();
    }

    class Worker extends AsyncTask<Void,Integer,String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(Void... voids) {
            progressBarLooper();

            return "J'ai fini";
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
        }
    }

    class ProgressBarHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            switch (msg.what){
                case 1: btn4.setEnabled(false);
                    break;
                case 2: Main5Activity.this.progressBar.setProgress(msg.arg1);
                    break;
                case 3: btn4.setEnabled(true);
                    break;
            }
        }
    }
}
