package br.com.uniftec.projetoecommerce.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import br.com.uniftec.projetoecommerce.R;
import br.com.uniftec.projetoecommerce.model.Endereco;
import br.com.uniftec.projetoecommerce.viewHolder.EnderecoViewHolder;

/**
 * Created by daniel on 29/10/17.
 */

public class EnderecoAdapter extends RecyclerView.Adapter {

    private List<Endereco> listEnderecos;
    private Context context;

    public EnderecoAdapter(List<Endereco> listEnderecos, Context context) {
        this.listEnderecos = listEnderecos;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context)
                .inflate(R.layout.item_endereco, parent, false);

        EnderecoViewHolder holder = new EnderecoViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {

        EnderecoViewHolder holder = (EnderecoViewHolder) viewHolder;

        Endereco endereco = listEnderecos.get(position);

        holder.id.setText(String.valueOf(endereco.getId()));
        holder.cidade.setText(String.valueOf(endereco.getCidade()));
        holder.estado.setText(String.valueOf(endereco.getEstado()));

    }

    @Override
    public int getItemCount() {
        return listEnderecos.size();
    }
}
