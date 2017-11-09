package br.com.uniftec.projetoecommerce.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.List;

import br.com.uniftec.projetoecommerce.R;
import br.com.uniftec.projetoecommerce.adapter.CarrinhoComprasAdapter;
import br.com.uniftec.projetoecommerce.database.DataSource;
import br.com.uniftec.projetoecommerce.model.Produto;

public class CarrinhoComprasActivity extends AppCompatActivity implements View.OnClickListener {

    private RecyclerView recyclerViewListaCarrinhoCompras;
    private List<Produto> produtos;
    private Button btnFinalizarCompras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrinho_compras);

        produtos = DataSource.carregarJsonTestesProducts(this);

        recyclerViewListaCarrinhoCompras = (RecyclerView) findViewById(R.id.recyclerViewlistaCarrinhoCompras);

        recyclerViewListaCarrinhoCompras.setAdapter(new CarrinhoComprasAdapter(produtos));

        RecyclerView.LayoutManager layout = new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false);

        recyclerViewListaCarrinhoCompras.setLayoutManager(layout);

        btnFinalizarCompras = (Button) findViewById(R.id.btn_finalizar_compras);

        btnFinalizarCompras.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == btnFinalizarCompras) {
            Intent intent = new Intent(this, FinalizarCompraActivity.class);
            startActivity(intent);
        }
    }
}
