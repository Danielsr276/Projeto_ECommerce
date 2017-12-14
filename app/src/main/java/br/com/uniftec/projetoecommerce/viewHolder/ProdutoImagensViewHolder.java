package br.com.uniftec.projetoecommerce.viewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import java.io.Serializable;

import br.com.uniftec.projetoecommerce.R;
import br.com.uniftec.projetoecommerce.adapter.ProdutosImagensAdapter;

/**
 * Created by daniel on 07/11/17.
 */

public class ProdutoImagensViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, Serializable {

    public ImageView imgProdutoList;
    public ProdutosImagensAdapter.OnActionCompleted callbackProdutoImagem;

    public ProdutoImagensViewHolder(View itemView, ProdutosImagensAdapter.OnActionCompleted callbackProdutoImagem) {
        super(itemView);

        this.callbackProdutoImagem = callbackProdutoImagem;

        imgProdutoList = itemView.findViewById(R.id.imagem_produto_list);
        imgProdutoList.setOnClickListener(this);

        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == this.itemView) {
            callbackProdutoImagem.OnClick(getAdapterPosition(), false);
        } else if (view == imgProdutoList) {
            callbackProdutoImagem.OnClick(getAdapterPosition(), true);
        }
    }
}
