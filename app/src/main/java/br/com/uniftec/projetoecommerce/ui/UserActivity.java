package br.com.uniftec.projetoecommerce.ui;

import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

import br.com.uniftec.projetoecommerce.R;
import br.com.uniftec.projetoecommerce.adapter.EnderecoAdapter;
import br.com.uniftec.projetoecommerce.model.Endereco;
import br.com.uniftec.projetoecommerce.model.Usuario;

public class UserActivity extends AppCompatActivity implements EnderecoAdapter.OnActionCompleted, View.OnClickListener {

    public static final String USER_PARAMETER = "USER_PARAMETER";
    private Usuario usuario;
    private RecyclerView recyclerViewListaEnderecos;
    private EditText nomeUsuario;
    private EditText emailUsuario;
    private EditText senhaUsuario;
    private EditText cpfUsuario;
    private EditText telefoneUsuario;
    private Button btnCadastrarUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        usuario = (Usuario) getIntent().getSerializableExtra(USER_PARAMETER);

        nomeUsuario = (EditText) findViewById(R.id.id_usuario);
        emailUsuario = (EditText) findViewById(R.id.id_email);
        senhaUsuario = (EditText) findViewById(R.id.id_senha);
        cpfUsuario = (EditText) findViewById(R.id.id_cpf);
        telefoneUsuario = (EditText) findViewById(R.id.id_telefone);
        btnCadastrarUsuario = (Button) findViewById(R.id.btn_cadastrar_usuario);

        btnCadastrarUsuario.setOnClickListener(this);

        nomeUsuario.setText(usuario.getNome());
        emailUsuario.setText(usuario.getEmail());
        senhaUsuario.setText(usuario.getSenha());
        cpfUsuario.setText(usuario.getCpf());
        telefoneUsuario.setText(usuario.getTelefone());

        recyclerViewListaEnderecos = (RecyclerView) findViewById(R.id.recyclerViewlistaEnderecos);

        List<Endereco> listEnderecos = usuario.getListEnderecos();

        recyclerViewListaEnderecos.setAdapter(new EnderecoAdapter(listEnderecos, this));

        RecyclerView.LayoutManager layout = new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false);

        recyclerViewListaEnderecos.setLayoutManager(layout);

    }

    @Override
    public void OnClick(int position) {
        Intent intent = new Intent(this, EnderecoActivity.class);
        intent.putExtra(EnderecoActivity.ENDERECO_TO_EDIT, usuario.getListEnderecos().get(position));
        startActivity(intent);
    }

    @Override
    public void onClick(View view) {
        if (view == btnCadastrarUsuario) {
            finish();
        }
    }
}
