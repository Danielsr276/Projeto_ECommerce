package br.com.uniftec.projetoecommerce.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import br.com.uniftec.projetoecommerce.R;
import br.com.uniftec.projetoecommerce.model.Endereco;

public class EnderecoActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String ENDERECO_TO_EDIT = "ENDERECO_EDIT";
    private Endereco endereco;
    private EditText idEndereco;
    private EditText ruaEndereco;
    private EditText numeroEndereco;
    private EditText complementoEndereco;
    private EditText bairroEndereco;
    private EditText cidadeEndereco;
    private EditText estadoEndereco;
    private Button btnCadastrarEndereco;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_endereco);

        idEndereco = (EditText) findViewById(R.id.id_endereco);
        ruaEndereco = (EditText) findViewById(R.id.rua_endereco);
        numeroEndereco = (EditText) findViewById(R.id.numero_endereco);
        complementoEndereco = (EditText) findViewById(R.id.complemento_endereco);
        bairroEndereco = (EditText) findViewById(R.id.bairro_endereco);
        cidadeEndereco = (EditText) findViewById(R.id.cidade_endereco);
        estadoEndereco = (EditText) findViewById(R.id.estado_endereco);
        btnCadastrarEndereco = (Button) findViewById(R.id.btn_cadastrar_endereco);

        btnCadastrarEndereco.setOnClickListener(this);

        endereco = (Endereco) getIntent().getSerializableExtra(ENDERECO_TO_EDIT);
        if (endereco != null) {
            populateEndereco(endereco);
        }
    }

    private void populateEndereco(Endereco endereco) {
        idEndereco.setText(String.valueOf(endereco.getId() != null ? endereco.getId() : ""));
        ruaEndereco.setText(endereco.getRua());
        numeroEndereco.setText(String.valueOf(endereco.getNumero() != null ? endereco.getNumero() : ""));
        complementoEndereco.setText(endereco.getComplemento());
        bairroEndereco.setText(endereco.getBairro());
        cidadeEndereco.setText(endereco.getCidade());
        estadoEndereco.setText(endereco.getEstado());
    }

    @Override
    public void onClick(View view) {
        if (view == btnCadastrarEndereco) {
            finish();
        }
    }
}
