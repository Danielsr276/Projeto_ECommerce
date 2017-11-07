package br.com.uniftec.projetoecommerce.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import br.com.uniftec.projetoecommerce.R;
import br.com.uniftec.projetoecommerce.viewHolder.ProdutoImagensViewHolder;

/**
 * Created by daniel on 07/11/17.
 */

public class ProdutosImagensAdapter extends RecyclerView.Adapter {

    private List<String> listUrlsImagens;
    private OnActionCompleted callbackProdutoImagem;


    public ProdutosImagensAdapter(List<String> listUrlsImagens, OnActionCompleted callbackProdutoImagem) {
        this.listUrlsImagens = listUrlsImagens;
        this.callbackProdutoImagem = callbackProdutoImagem;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_imagem_produto, parent, false);

        ProdutoImagensViewHolder holder = new ProdutoImagensViewHolder(view, callbackProdutoImagem);

        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {

        ProdutoImagensViewHolder holder = (ProdutoImagensViewHolder) viewHolder;

        String urlImage = listUrlsImagens.get(position);

        int idImagem = holder.itemView.getResources().getIdentifier(
                urlImage, "drawable",
                holder.itemView.getContext().getPackageName());

        holder.imgProdutoList.setImageDrawable(holder.itemView.getContext().getDrawable(idImagem));
    }

    @Override
    public int getItemCount() {
        return listUrlsImagens.size();
    }

    public interface OnActionCompleted {
        void OnClick(int position, boolean isDelete);
    }
}
