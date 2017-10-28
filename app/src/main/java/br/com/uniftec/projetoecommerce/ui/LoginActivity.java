package br.com.uniftec.projetoecommerce.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

import br.com.uniftec.projetoecommerce.R;
import br.com.uniftec.projetoecommerce.database.DataSource;
import br.com.uniftec.projetoecommerce.model.Usuario;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {


    private EditText usuarioEdiText;
    private EditText senhaEditText;
    private Button enterButton;
    private Button newUserButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        List<Usuario> usuarios = DataSource.carregarJsonTestes(this);

        usuarioEdiText = (EditText) findViewById(R.id.usuario);
        senhaEditText = (EditText) findViewById(R.id.password);

        usuarioEdiText.setText(usuarios.get(1).getEmail());
        senhaEditText.setText(usuarios.get(1).getSenha());

        newUserButton = (Button) findViewById(R.id.botao_criar_conta);
        newUserButton.setOnClickListener(this);

        enterButton = (Button) findViewById(R.id.botao_entrar);
        enterButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.botao_criar_conta:
                startActivity(new Intent(this, UserActivity.class));
                break;
            case R.id.botao_entrar:
                startActivity(new Intent(this, HomeActivity.class));
        }
    }
}
