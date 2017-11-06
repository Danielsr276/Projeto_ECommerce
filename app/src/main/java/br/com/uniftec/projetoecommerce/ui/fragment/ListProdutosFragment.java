package br.com.uniftec.projetoecommerce.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import br.com.uniftec.projetoecommerce.R;
import br.com.uniftec.projetoecommerce.adapter.ProductAdapter;
import br.com.uniftec.projetoecommerce.database.DataSource;
import br.com.uniftec.projetoecommerce.model.Produto;

public class ListProdutosFragment extends Fragment implements View.OnClickListener, ProductAdapter.OnActionProductCompleted {

    private List<Produto> produtos;
    private RecyclerView recyclerViewListaProdutos;

    public ListProdutosFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_list_produtos, container, false);

        recyclerViewListaProdutos = (RecyclerView) rootView.findViewById(R.id.recycler_view_list_produtos);

        recyclerViewListaProdutos.setOnClickListener(this);

        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        produtos = DataSource.carregarJsonTestesProducts(getActivity());

        ProductAdapter productAdapter = new ProductAdapter(produtos, this);
        recyclerViewListaProdutos.setAdapter(productAdapter);

        RecyclerView.LayoutManager layout = new LinearLayoutManager(getActivity(),
                LinearLayoutManager.VERTICAL, false);

        recyclerViewListaProdutos.setLayoutManager(layout);


        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onClick(View view) {

    }

    @Override
    public void OnClick(int position, boolean isDelete) {

    }
}
