package br.com.uniftec.projetoecommerce.ui;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import br.com.uniftec.projetoecommerce.R;
import br.com.uniftec.projetoecommerce.database.DataSource;
import br.com.uniftec.projetoecommerce.model.Usuario;
import br.com.uniftec.projetoecommerce.task.IncluirUsuarioTask;
import br.com.uniftec.projetoecommerce.task.LoginUsuarioTask;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener, LoginUsuarioTask.LoginUsuarioDelegate {


    private EditText usuarioEdiText;
    private EditText senhaEditText;
    private Button enterButton;
    private Button newUserButton;
    private List<Usuario> usuarios;
    private static int NUMERO_USUARIO = 0;
    private ProgressDialog progressDialog;

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
                intent.putExtra(UserActivity.LOGADO, false);
                startActivity(intent);

                break;
            case R.id.botao_entrar:
                progressDialog = ProgressDialog.show(this, "Aguarde", "Fazendo Login", true, false);
                loginUsarioSucesso();
        }
    }

    private void loginUsarioSucesso() {
        Usuario usuario = new Usuario();
        usuario.setEmail(String.valueOf(usuarioEdiText.getText()));
        usuario.setSenha(String.valueOf(senhaEditText.getText()));

//            progressDialog.dismiss();
//            progressDialog = null;

        LoginUsuarioTask loginUsuarioTask = new LoginUsuarioTask(this);
        loginUsuarioTask.execute(usuario);
    }

    @Override
    public void loginUsarioSucesso(String token) {
        Toast.makeText(this, "Usuário logado com sucesso: " + token, Toast.LENGTH_LONG).show();

        progressDialog.dismiss();
        progressDialog = null;

        startActivity(new Intent(this, ListProdutosActivity.class));
    }

    @Override
    public void loginUsuarioFalha(String mensagem) {
        Toast.makeText(this, mensagem, Toast.LENGTH_LONG).show();

        progressDialog.dismiss();
        progressDialog = null;
    }
}
