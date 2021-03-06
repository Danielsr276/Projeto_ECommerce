package br.com.uniftec.projetoecommerce.viewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import br.com.uniftec.projetoecommerce.R;
import br.com.uniftec.projetoecommerce.adapter.EnderecoAdapter;

/**
 * Created by daniel on 29/10/17.
 */

public class EnderecoViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public TextView id;
    public TextView cidade;
    public TextView estado;
    public ImageView deleteButton;
    public EnderecoAdapter.OnActionCompleted callbackEndereco;

    public EnderecoViewHolder(View itemView, EnderecoAdapter.OnActionCompleted callbackEndereco) {
        super(itemView);

        this.callbackEndereco = callbackEndereco;
        id = itemView.findViewById(R.id.item_endereco_id);
        cidade = itemView.findViewById(R.id.item_endereco_cidade);
        estado = itemView.findViewById(R.id.item_endereco_estado);
        deleteButton = itemView.findViewById(R.id.task_delete);
        deleteButton.setOnClickListener(this);
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view == this.itemView){
            callbackEndereco.OnClick(getAdapterPosition(), false);
        }else if (view == deleteButton){
            callbackEndereco.OnClick(getAdapterPosition(), true);
        }
    }

}
