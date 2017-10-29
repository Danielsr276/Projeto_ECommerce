package br.com.uniftec.projetoecommerce.viewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import br.com.uniftec.projetoecommerce.R;

/**
 * Created by daniel on 29/10/17.
 */

public class EnderecoViewHolder extends RecyclerView.ViewHolder {

    public TextView id;
    public TextView cidade;
    public TextView estado;

    public EnderecoViewHolder(View itemView) {
        super(itemView);
        id = itemView.findViewById(R.id.item_endereco_id);
        cidade = itemView.findViewById(R.id.item_endereco_cidade);
        estado = itemView.findViewById(R.id.item_endereco_estado);
    }
}
