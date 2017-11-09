package br.com.uniftec.projetoecommerce.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import br.com.uniftec.projetoecommerce.R;
import br.com.uniftec.projetoecommerce.model.Produto;
import br.com.uniftec.projetoecommerce.ui.CarrinhoComprasActivity;
import br.com.uniftec.projetoecommerce.viewHolder.CarrinhoComprasViewHolder;
import br.com.uniftec.projetoecommerce.viewHolder.ProdutoViewHolder;

/**
 * Created by daniel on 08/11/17.
 */

public class CarrinhoComprasAdapter extends RecyclerView.Adapter {

    private List<Produto> listProdutos;

    public CarrinhoComprasAdapter(List<Produto> produtos) {
        this.listProdutos = produtos;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_carrinho_compras, parent, false);

        CarrinhoComprasViewHolder holder = new CarrinhoComprasViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        CarrinhoComprasViewHolder holder = (CarrinhoComprasViewHolder) viewHolder;

        Produto produto = listProdutos.get(position);

        holder.descricaoProdutoCarrinho.setText(String.valueOf(produto.getTitulo()));
        holder.precoProdutoCarrinho.setText(String.valueOf(produto.getPrecoComDesconto()));

        int idImagem = holder.itemView.getResources().getIdentifier(
                produto.getUrlImagemPrincipal(), "drawable",
                holder.itemView.getContext().getPackageName());

        holder.imagemProdutoCarrinho.setImageDrawable(holder.itemView.getContext().getDrawable(idImagem));
    }

    @Override
    public int getItemCount() {
        return listProdutos.size();
    }
}

