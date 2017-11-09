package br.com.uniftec.projetoecommerce.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.List;

import br.com.uniftec.projetoecommerce.R;
import br.com.uniftec.projetoecommerce.adapter.PedidosAdapter;
import br.com.uniftec.projetoecommerce.adapter.ProductAdapter;
import br.com.uniftec.projetoecommerce.database.DataSource;
import br.com.uniftec.projetoecommerce.model.Pedido;

public class ListPedidosFragment extends Fragment {

    private RecyclerView recyclerViewListaPedidos;
    private List<Pedido> pedidos;
    private Button btnFecharPedidos;

    public ListPedidosFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_list_pedidos, container, false);

        recyclerViewListaPedidos = rootView.findViewById(R.id.recycler_view_list_pedidos);

        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        pedidos = DataSource.carregarJsonTestesPedidos(getActivity());

        PedidosAdapter pedidosAdapter = new PedidosAdapter(pedidos);
        recyclerViewListaPedidos.setAdapter(pedidosAdapter);

        RecyclerView.LayoutManager layout = new LinearLayoutManager(getActivity(),
                LinearLayoutManager.VERTICAL, false);

        recyclerViewListaPedidos.setLayoutManager(layout);


        super.onActivityCreated(savedInstanceState);
    }

}
