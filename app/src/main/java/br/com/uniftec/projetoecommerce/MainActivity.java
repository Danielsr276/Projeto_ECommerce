package br.com.uniftec.projetoecommerce;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements Runnable {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        findViewById(R.id.activity_splash).postDelayed(this, 3500);
    }

    @Override
    public void run() {
        this.setContentView(R.layout.activity_login);
    }
}
