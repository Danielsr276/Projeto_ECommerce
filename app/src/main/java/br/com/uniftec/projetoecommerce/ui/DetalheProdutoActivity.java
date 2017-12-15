package br.com.uniftec.projetoecommerce.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.io.Serializable;

import br.com.uniftec.projetoecommerce.R;
import br.com.uniftec.projetoecommerce.adapter.ProdutosImagensAdapter;
import br.com.uniftec.projetoecommerce.model.Produto;

public class DetalheProdutoActivity extends AppCompatActivity implements View.OnClickListener, ProdutosImagensAdapter.OnActionCompleted, Serializable {

    public static final String PRODUTO_PARAMETER = "PRODUTO_PARAMETER";

    private Produto produto;
    private ImageView imageProduto;
    private TextView textViewId;
    private TextView textViewTitulo;
    private TextView textViewPreco;
    private TextView textViewDesconto;
    private TextView textViewDescricao;
    private TextView textViewDescricaoCategoria;
    private Button btnFecharDetalhe;
    private RecyclerView recyclerViewImagens;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_produto);

        produto = (Produto) getIntent().getSerializableExtra(PRODUTO_PARAMETER);

        imageProduto = (ImageView) findViewById(R.id.imagem_detalhe_produto);


        try {
            String imagemUrl = produto.getImagemPrincipal().getUrl();
            Picasso.with(getApplicationContext()).load(imagemUrl).into(imageProduto);
        } catch (Exception e) {

            imageProduto.setImageDrawable(null);
        }

//        int idImagem = getResources().getIdentifier(produto.getUrlImagemPrincipal(),
//                "drawable", getPackageName());
//        imageProduto.setImageDrawable(getDrawable(idImagem));

        textViewId = (TextView) findViewById(R.id.id_detalhe_produto);
        textViewId.setText(String.valueOf(produto.getId()));

        textViewTitulo = (TextView) findViewById(R.id.detalhe_titulo_produto);
        textViewTitulo.setText(produto.getTitulo());

        textViewPreco = (TextView) findViewById(R.id.preco_detalhe_produto);
        textViewPreco.setText(String.valueOf(produto.getPreco()));

        textViewDesconto = (TextView) findViewById(R.id.preco_desconto_detalhe_produto);
        textViewDesconto.setText(String.valueOf(produto.getPrecoComDesconto()));

        textViewDescricao = (TextView) findViewById(R.id.descricao_detalhe_produto);
        textViewDescricao.setText(produto.getDescricao());

        textViewDescricaoCategoria = (TextView) findViewById(R.id.descricao_categoria_produto);
        textViewDescricaoCategoria.setText(produto.getCategoria().getNome());

        btnFecharDetalhe = (Button) findViewById(R.id.btn_detalhe_produto_fechar);
        btnFecharDetalhe.setOnClickListener(this);

        recyclerViewImagens = (RecyclerView) findViewById(R.id.recycler_horizontal_imagens_produto);
        recyclerViewImagens.setAdapter(new ProdutosImagensAdapter(produto.getListImagens(), this));

        RecyclerView.LayoutManager layout = new LinearLayoutManager(this,
                LinearLayoutManager.HORIZONTAL, false);

        recyclerViewImagens.setLayoutManager(layout);
    }

    @Override
    public void onClick(View view) {
        if (view == btnFecharDetalhe) {
            finish();
        }
    }

    @Override
    public void OnClick(int position, boolean isDelete) {

        String itemAtPosition = (String) produto.getListImagens().get(position).getUrl();

        try {
            String urlImage = produto.getListImagens().get(position).getUrl();
            Picasso.with(this).load(urlImage).into(imageProduto);
        } catch (Exception e) {
            imageProduto.setImageDrawable(null);
        }


//        int idImagem = getResources().getIdentifier(itemAtPosition,
//                "drawable", getPackageName());
//
//        imageProduto.setImageDrawable(getDrawable(idImagem));
    }
}
