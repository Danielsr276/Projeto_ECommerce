package br.com.uniftec.projetoecommerce.adapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.io.Serializable;
import java.util.List;

import br.com.uniftec.projetoecommerce.R;
import br.com.uniftec.projetoecommerce.model.Endereco;
import br.com.uniftec.projetoecommerce.model.Produto;
import br.com.uniftec.projetoecommerce.viewHolder.EnderecoViewHolder;
import br.com.uniftec.projetoecommerce.viewHolder.ProdutoViewHolder;

/**
 * Created by daniel on 04/11/17.
 */

public class ProductAdapter extends RecyclerView.Adapter implements View.OnClickListener, Serializable {

    private List<Produto> listProdutos;
    private OnActionProductCompleted callbackProduto;

    public ProductAdapter(List<Produto> listProdutos, OnActionProductCompleted callbackProduto) {
        this.listProdutos = listProdutos;
        this.callbackProduto = callbackProduto;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_produto, parent, false);

        ProdutoViewHolder holder = new ProdutoViewHolder(view, callbackProduto);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {

        ProdutoViewHolder holder = (ProdutoViewHolder) viewHolder;

        Produto produto = listProdutos.get(position);

        holder.descricaoProduto.setText(String.valueOf(produto.getTitulo()));


        try {
            //"http://image.tmdb.org/t/p/w780" +
            String imagemUrl = produto.getImagemPrincipal().getUrl();
            Picasso.with(holder.itemView.getContext()).load(imagemUrl).into(holder.imagemProduto);
        } catch (Exception e) {

            holder.imagemProduto.setImageDrawable(null);
        }

//        int idImagem = holder.itemView.getResources().getIdentifier(
//                produto.getUrlImagemPrincipal(), "drawable",
//                holder.itemView.getContext().getPackageName());
//
//        holder.imagemProduto.setImageDrawable(holder.itemView.getContext().getDrawable(idImagem));
    }

    @Override
    public int getItemCount() {
        return listProdutos.size();
    }

    public interface OnActionProductCompleted {
        void OnClick(int position, boolean isDelete);
    }

    @Override
    public void onClick(View view) {

    }
}
