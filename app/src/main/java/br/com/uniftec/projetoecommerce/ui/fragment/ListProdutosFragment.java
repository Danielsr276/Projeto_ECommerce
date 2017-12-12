package br.com.uniftec.projetoecommerce.ui.fragment;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;

import br.com.uniftec.projetoecommerce.R;
import br.com.uniftec.projetoecommerce.adapter.ProductAdapter;
import br.com.uniftec.projetoecommerce.database.DataSource;
import br.com.uniftec.projetoecommerce.model.Produto;
import br.com.uniftec.projetoecommerce.response.ProdutoResponse;
import br.com.uniftec.projetoecommerce.response.ProdutosResponse;
import br.com.uniftec.projetoecommerce.task.CarregarProdutosTask;
import br.com.uniftec.projetoecommerce.ui.DetalheProdutoActivity;

public class ListProdutosFragment extends Fragment implements ProductAdapter.OnActionProductCompleted, CarregarProdutosTask.CarregarProdutosDelegate {

    private List<Produto> produtos;
    private ProgressDialog progressDialog;
    private RecyclerView recyclerViewListaProdutos;

    public ListProdutosFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_list_produtos, container, false);

        recyclerViewListaProdutos = rootView.findViewById(R.id.recycler_view_list_produtos);

        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        produtos = DataSource.carregarJsonTestesProducts(getActivity());

        ProductAdapter productAdapter = new ProductAdapter(produtos, this);
        recyclerViewListaProdutos.setAdapter(productAdapter);

        RecyclerView.LayoutManager layout = new StaggeredGridLayoutManager(2,
                StaggeredGridLayoutManager.VERTICAL);

        recyclerViewListaProdutos.setLayoutManager(layout);

        progressDialog = ProgressDialog.show(getActivity(), "Aguarde", "Carregando ", true, false);

        CarregarProdutosTask task = new CarregarProdutosTask(this);
        task.execute();


        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void OnClick(int position, boolean isDelete) {

        Produto itemAtPosition = (Produto) produtos.get(position);

        Intent intent = new Intent(getActivity(), DetalheProdutoActivity.class);
        intent.putExtra(DetalheProdutoActivity.PRODUTO_PARAMETER, itemAtPosition);
        startActivity(intent);
    }

    @Override
    public void sucesso(ProdutosResponse popularResponse) {
        produtos.clear();
        produtos.addAll(popularResponse.getProdutos());

        recyclerViewListaProdutos.getAdapter().notifyDataSetChanged();

        progressDialog.dismiss();
        progressDialog = null;

    }

    @Override
    public void falha(String mensagem) {
        progressDialog.dismiss();
        progressDialog = null;

        Toast.makeText(getActivity(), mensagem, Toast.LENGTH_LONG).show();
    }
}