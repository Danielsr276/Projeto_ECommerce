package br.com.uniftec.projetoecommerce.ui;

import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;

import java.util.List;

import br.com.uniftec.projetoecommerce.R;
import br.com.uniftec.projetoecommerce.adapter.EnderecoAdapter;
import br.com.uniftec.projetoecommerce.model.Endereco;
import br.com.uniftec.projetoecommerce.model.Usuario;

public class UserActivity extends AppCompatActivity implements EnderecoAdapter.OnActionCompleted{

    public static final String USER_PARAMETER = "USER_PARAMETER";
    private Usuario usuario;
    private RecyclerView recyclerViewListaEnderecos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        usuario = (Usuario) getIntent().getSerializableExtra(USER_PARAMETER);

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
}
