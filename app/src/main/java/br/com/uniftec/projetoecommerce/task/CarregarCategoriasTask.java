package br.com.uniftec.projetoecommerce.task;

import android.os.AsyncTask;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import br.com.uniftec.projetoecommerce.response.CategoriaResponse;
import br.com.uniftec.projetoecommerce.response.ProdutosResponse;
import br.com.uniftec.projetoecommerce.service.ProdutoService;
import br.com.uniftec.projetoecommerce.util.ServerCommunicationUtil;
import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by Daniel Ribeiro on 26/10/17.
 */

public class CarregarCategoriasTask extends AsyncTask<String, Void, CategoriaResponse> implements Serializable {

    private ProdutoService produtoService;
    private CarregarCategoriaDelegate delegate;

    public CarregarCategoriasTask(CarregarCategoriaDelegate delegate) {
        this.produtoService = ServerCommunicationUtil.getInstance()
                .getRetrofit()
                .create(ProdutoService.class);

        this.delegate = delegate;
    }

    @Override
    protected CategoriaResponse doInBackground(String... parameters) {

        Call<CategoriaResponse> call = produtoService.buscarCategorias();

        try {
            Response<CategoriaResponse> response = call.execute();
            CategoriaResponse popularResponse = response.body();
            return popularResponse;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(CategoriaResponse popularResponse) {

        if (popularResponse != null) {
            delegate.sucesso(popularResponse);
        } else {
            delegate.falha("Não foi possível carregar as categorias.");
        }

    }

    public interface CarregarCategoriaDelegate {

        void sucesso(CategoriaResponse popularResponse);

        void falha(String mensagem);

    }
}
