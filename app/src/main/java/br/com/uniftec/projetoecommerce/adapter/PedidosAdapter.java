package br.com.uniftec.projetoecommerce.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.List;

import br.com.uniftec.projetoecommerce.model.Pedido;
import br.com.uniftec.projetoecommerce.model.Produto;

/**
 * Created by willi on 09/11/2017.
 */

public class PedidosAdapter extends RecyclerView.Adapter {

    private List<Pedido> listPedidos;

    public PedidosAdapter(List<Pedido> pedidos) {
        this.listPedidos = pedidos;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return listPedidos.size();
    }
}
