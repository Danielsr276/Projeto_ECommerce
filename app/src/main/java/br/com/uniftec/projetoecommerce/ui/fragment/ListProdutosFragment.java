package br.com.uniftec.projetoecommerce.ui.fragment;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import br.com.uniftec.projetoecommerce.R;
import br.com.uniftec.projetoecommerce.adapter.ProductAdapter;
import br.com.uniftec.projetoecommerce.database.DataSource;
import br.com.uniftec.projetoecommerce.model.Categoria;
import br.com.uniftec.projetoecommerce.model.Produto;
import br.com.uniftec.projetoecommerce.response.CategoriaResponse;
import br.com.uniftec.projetoecommerce.response.ProdutosResponse;
import br.com.uniftec.projetoecommerce.task.CarregarCategoriasTask;
import br.com.uniftec.projetoecommerce.task.CarregarProdutosTask;
import br.com.uniftec.projetoecommerce.ui.DetalheProdutoActivity;

public class ListProdutosFragment extends Fragment
        implements ProductAdapter.OnActionProductCompleted,
        CarregarProdutosTask.CarregarProdutosDelegate,
        CarregarCategoriasTask.CarregarCategoriaDelegate,
        AdapterView.OnItemSelectedListener,
        GraphFragment.UpdateProductsFragment, Serializable {

    public static final String PRODUCTS_PARAMETER = "PRODUCTS_PARAMETER";

    private List<Produto> produtos;
    private ProgressDialog progressDialog;
    private transient RecyclerView recyclerViewListaProdutos;
    private HashMap<String, Integer> spinnerMap;
    private transient Spinner spinnerCategoria;
    private transient Spinner spinnerDestaque;

    public ListProdutosFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_list_produtos, container, false);

        recyclerViewListaProdutos = rootView.findViewById(R.id.recycler_view_list_produtos);
        spinnerCategoria = rootView.findViewById(R.id.spinner_categoria_destaque);
        spinnerCategoria.setOnItemSelectedListener(this);

        spinnerDestaque = rootView.findViewById(R.id.spinner_alfabeto_preco);
        spinnerDestaque.setOnItemSelectedListener(this);

        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            produtos = (List<Produto>) bundle.getSerializable(PRODUCTS_PARAMETER);
        } else {
            produtos = new ArrayList<>();
        }

        ProductAdapter productAdapter = new ProductAdapter(produtos, this);
        recyclerViewListaProdutos.setAdapter(productAdapter);

        RecyclerView.LayoutManager layout = new StaggeredGridLayoutManager(2,
                StaggeredGridLayoutManager.VERTICAL);

        recyclerViewListaProdutos.setLayoutManager(layout);

        progressDialog = ProgressDialog.show(getActivity(), "Aguarde", "Carregando ", true, false);

        CarregarProdutosTask task = new CarregarProdutosTask(this);

        CarregarCategoriasTask taskCategorias = new CarregarCategoriasTask(this);
        taskCategorias.execute(null, null);

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
    public void sucesso(CategoriaResponse popularResponse) {
        List<String> spinnerArray = new ArrayList<>();
        spinnerMap = new HashMap<>();
        for (Categoria cat :
                popularResponse.getCategorias()) {

            spinnerMap.put(cat.getNome(), cat.getId());
            spinnerArray.add(cat.getNome());
        }
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getContext(), R.layout.support_simple_spinner_dropdown_item, spinnerArray);

        spinnerCategoria.setAdapter(dataAdapter);
        dataAdapter.notifyDataSetChanged();

        progressDialog.dismiss();
        progressDialog = null;

    }

    @Override
    public void falha(String mensagem) {
        progressDialog.dismiss();
        progressDialog = null;

        Toast.makeText(getActivity(), mensagem, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        if (adapterView == spinnerCategoria) {
            progressDialog = ProgressDialog.show(getActivity(), "Aguarde", "Filtrando categorias", true, false);
            CarregarProdutosTask task = new CarregarProdutosTask(this);
            Integer id = spinnerMap.get(spinnerCategoria.getSelectedItem());
            task.execute(id.toString(), null);
        }
        if (adapterView == spinnerDestaque) {

            if (spinnerDestaque.getSelectedItemId() != 0) {
                progressDialog = ProgressDialog.show(getActivity(), "Aguarde", "Filtrando destaques", true, false);
                CarregarProdutosTask task = new CarregarProdutosTask(this);
                Integer id = spinnerMap.get(spinnerCategoria.getSelectedItem());
                Boolean detalhes = (spinnerDestaque.getSelectedItemId() == 1);
                task.execute(id.toString(), detalhes.toString());
            }
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @Override
    public void update(List<Produto> produtos) {
        this.produtos.clear();
        this.produtos.addAll(produtos);

        recyclerViewListaProdutos.getAdapter().notifyDataSetChanged();
    }
}