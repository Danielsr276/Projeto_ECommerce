package br.com.uniftec.projetoecommerce.ui;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.wang.avi.AVLoadingIndicatorView;

import br.com.uniftec.projetoecommerce.R;

public class FinalizarCompraActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnFinalizar;
    private AVLoadingIndicatorView avi;
    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finalizar_compra);

        btnFinalizar = (Button) findViewById(R.id.btn_finalizar);
        btnFinalizar.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        setContentView(R.layout.loading);
        avi = (AVLoadingIndicatorView) findViewById(R.id.loading_custom);
        handler = new Handler();

        avi.show();

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                avi.hide();
                startActivity(new Intent(getApplicationContext(), ListProdutosActivity.class));
            }
        };

        handler.postDelayed(runnable, 3000);
    }
}
