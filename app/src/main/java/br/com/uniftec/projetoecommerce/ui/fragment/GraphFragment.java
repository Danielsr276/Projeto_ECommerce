package br.com.uniftec.projetoecommerce.ui.fragment;

import android.annotation.TargetApi;
import android.app.ProgressDialog;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.com.uniftec.projetoecommerce.R;
import br.com.uniftec.projetoecommerce.model.Produto;
import br.com.uniftec.projetoecommerce.response.ProdutosResponse;
import br.com.uniftec.projetoecommerce.task.CarregarCategoriasTask;
import br.com.uniftec.projetoecommerce.task.CarregarProdutosTask;
import br.com.uniftec.projetoecommerce.ui.ListProdutosActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class GraphFragment extends Fragment implements CarregarProdutosTask.CarregarProdutosDelegate, View.OnClickListener, Serializable {

    public static final String PRODUCT_PARAMETER = "PRODUCT_PARAMETER";

    private View barRange_1;
    private View barRange_2;
    private View barRange_3;
    private View barRange_4;
    private View barRange_5;
    private ViewPager mViewPager;

    private TextView textView_1;
    private TextView textView_2;
    private TextView textView_3;
    private TextView textView_4;
    private TextView textView_5;
    List<Produto> produtos;

    private ProgressDialog progressDialog;
    private UpdateProductsFragment updateProductsFragment;

    public interface UpdateProductsFragment {
        void update(List<Produto> produtos);
    }

    public GraphFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_graph, container, false);

        barRange_1 = rootView.findViewById(R.id.bar_range_1);
        barRange_2 = rootView.findViewById(R.id.bar_range_2);
        barRange_3 = rootView.findViewById(R.id.bar_range_3);
        barRange_4 = rootView.findViewById(R.id.bar_range_4);
        barRange_5 = rootView.findViewById(R.id.bar_range_5);

        barRange_1.setOnClickListener(this);
        barRange_2.setOnClickListener(this);
        barRange_3.setOnClickListener(this);
        barRange_4.setOnClickListener(this);
        barRange_5.setOnClickListener(this);

        textView_1 = rootView.findViewById(R.id.txt_0_100);
        textView_2 = rootView.findViewById(R.id.txt_100_250);
        textView_3 = rootView.findViewById(R.id.txt_250_500);
        textView_4 = rootView.findViewById(R.id.txt_500_1500);
        textView_5 = rootView.findViewById(R.id.txt_mais_1500);

        mViewPager = (ViewPager) getActivity().findViewById(R.id.container);

        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {

        CarregarProdutosTask task = new CarregarProdutosTask(this);
        task.execute(null, null);

        progressDialog = ProgressDialog.show(getActivity(), "Aguarde", "Carregando ", true, false);

        Bundle bundle = this.getArguments();
        if (bundle != null) {
            updateProductsFragment = (UpdateProductsFragment) bundle.getSerializable(PRODUCT_PARAMETER);
        }
        super.onActivityCreated(savedInstanceState);
    }

    private void changeHeight(View barRange, int i) {
        ViewGroup.LayoutParams params = barRange.getLayoutParams();
        params.height = i;
        barRange.setLayoutParams(params);
    }

    @Override
    public void sucesso(ProdutosResponse popularResponse) {
        produtos = popularResponse.getProdutos();

        processQtdProdutos();

        progressDialog.dismiss();
        progressDialog = null;
    }

    /**
     * Responsável por setar as qtds dos produtos com o range de preços e os tamanhos das barras do gráfico
     */
    private void processQtdProdutos() {

        Integer valor1 = getSizeListProducts(0, 100);
        Integer valor2 = getSizeListProducts(100, 250);
        Integer valor3 = getSizeListProducts(250, 500);
        Integer valor4 = getSizeListProducts(500, 1500);
        Integer valor5 = getSizeListProducts(1500, 10000000);

        textView_1.setText(textView_1.getText().toString().replace("#$#", valor1.toString()));
        textView_2.setText(textView_2.getText().toString().replace("#$#", valor2.toString()));
        textView_3.setText(textView_3.getText().toString().replace("#$#", valor3.toString()));
        textView_4.setText(textView_4.getText().toString().replace("#$#", valor4.toString()));
        textView_5.setText(textView_5.getText().toString().replace("#$#", valor5.toString()));


        changeHeight(barRange_1, valor1 * 3);
        changeHeight(barRange_2, valor2 * 3);
        changeHeight(barRange_3, valor3 * 3);
        changeHeight(barRange_4, valor4 * 3);
        changeHeight(barRange_5, valor5 * 3);

    }

    @TargetApi(Build.VERSION_CODES.N)
    private Integer getSizeListProducts(int valorIni, int valorFinal) {

        Integer valueReturn = 0;
        for (Produto e :
                produtos) {
            if (e.getPreco().
                    compareTo(new BigDecimal(valorIni)) > 0 &&
                    e.getPreco().
                            compareTo(new BigDecimal(valorFinal)) < 0) {

                valueReturn++;
            }
        }
        return valueReturn;
    }

    @Override
    public void falha(String mensagem) {
        progressDialog.dismiss();
        progressDialog = null;

        Toast.makeText(getActivity(), mensagem, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onClick(View view) {
        Integer valorInicial = 0;
        Integer valorFinal = 0;
        if (view == barRange_1) {

            // atualizar a lista no fragment de produtos
            valorInicial = 0;
            valorFinal = 100;
        }
        if (view == barRange_2) {
            valorInicial = 100;
            valorFinal = 250;
        }

        if (view == barRange_3) {
            valorInicial = 250;
            valorFinal = 500;

        }
        if (view == barRange_4) {
            valorInicial = 500;
            valorFinal = 1500;

        }
        if (view == barRange_5) {

            valorInicial = 1500;
            valorFinal = 10000000;
        }

        updateProductsFragment.update(getListProducts(valorInicial, valorFinal));

        mViewPager.setCurrentItem(0);
    }

    private List<Produto> getListProducts(Integer valorIni, Integer valorFinal) {
        List<Produto> produtoList = new ArrayList<>();
        for (Produto e :
                produtos) {
            if (e.getPreco().
                    compareTo(new BigDecimal(valorIni)) > 0 &&
                    e.getPreco().
                            compareTo(new BigDecimal(valorFinal)) < 0) {

                produtoList.add(e);
            }
        }
        return produtoList;
    }
}