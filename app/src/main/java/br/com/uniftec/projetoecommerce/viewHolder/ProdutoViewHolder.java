package br.com.uniftec.projetoecommerce.viewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.Serializable;

import br.com.uniftec.projetoecommerce.R;
import br.com.uniftec.projetoecommerce.adapter.ProductAdapter;

/**
 * Created by daniel on 29/10/17.
 */

public class ProdutoViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, Serializable {

    public TextView descricaoProduto;
    public ImageView imagemProduto;
    public ProductAdapter.OnActionProductCompleted callbackProduto;

    public ProdutoViewHolder(View itemView, ProductAdapter.OnActionProductCompleted callbackProduto) {
        super(itemView);

        this.callbackProduto = callbackProduto;
        descricaoProduto = itemView.findViewById(R.id.descricao_produto);
        imagemProduto = itemView.findViewById(R.id.imagem_produto);
        imagemProduto.setOnClickListener(this);

        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == this.itemView) {
            callbackProduto.OnClick(getAdapterPosition(), false);
        } else if (view == imagemProduto) {
            callbackProduto.OnClick(getAdapterPosition(), true);
        }
    }

}
