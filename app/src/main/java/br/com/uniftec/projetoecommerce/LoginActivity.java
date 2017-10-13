package br.com.uniftec.projetoecommerce;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {


    private EditText usuarioEdiText;
    private EditText senhaEditText;
    private Button enterButton;
    private Button newUserButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //findViewById()

        newUserButton = (Button) findViewById(R.id.botao_criar_conta);
        newUserButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(this, UserActivity.class);
        startActivity(intent);
    }
}
