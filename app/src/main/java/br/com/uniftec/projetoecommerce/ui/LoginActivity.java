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
    private List<Usuario> usuarios;
    private static int NUMERO_USUARIO = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usuarios = DataSource.carregarJsonTestes(this);

        usuarioEdiText = (EditText) findViewById(R.id.usuario);
        senhaEditText = (EditText) findViewById(R.id.password);

        usuarioEdiText.setText(usuarios.get(NUMERO_USUARIO).getEmail());
        senhaEditText.setText(usuarios.get(NUMERO_USUARIO).getSenha());

        newUserButton = (Button) findViewById(R.id.botao_criar_conta);
        newUserButton.setOnClickListener(this);

        enterButton = (Button) findViewById(R.id.botao_entrar);
        enterButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.botao_criar_conta:

                Intent intent = new Intent(this, UserActivity.class);
                intent.putExtra(UserActivity.USER_PARAMETER, usuarios.get(NUMERO_USUARIO));
                startActivity(intent);

                break;
            case R.id.botao_entrar:
                startActivity(new Intent(this, ListProdutosActivity.class));
        }
    }
}
