package br.com.uniftec.projetoecommerce.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import br.com.uniftec.projetoecommerce.R;
import br.com.uniftec.projetoecommerce.database.DataSource;

public class MainActivity extends AppCompatActivity implements Runnable {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        findViewById(R.id.activity_splash).postDelayed(this, 3500);
    }

    @Override
    public void run() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
}
