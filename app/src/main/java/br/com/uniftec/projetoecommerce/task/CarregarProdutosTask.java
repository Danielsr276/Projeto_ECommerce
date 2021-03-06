package br.com.uniftec.projetoecommerce.task;

import android.os.AsyncTask;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import br.com.uniftec.projetoecommerce.response.ProdutosResponse;
import br.com.uniftec.projetoecommerce.service.ProdutoService;
import br.com.uniftec.projetoecommerce.util.ServerCommunicationUtil;
import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by Daniel Ribeiro on 26/10/17.
 */

public class CarregarProdutosTask extends AsyncTask<String, Void, ProdutosResponse> implements Serializable {

    private ProdutoService produtoService;
    private CarregarProdutosDelegate delegate;

    public CarregarProdutosTask(CarregarProdutosDelegate delegate) {
        this.produtoService = ServerCommunicationUtil.getInstance()
                .getRetrofit()
                .create(ProdutoService.class);

        this.delegate = delegate;
    }

    @Override
    protected ProdutosResponse doInBackground(String... parameters) {

        Map<String, String> data = new HashMap<>();
        if (parameters[1] != null) {
            data.put("destaques", parameters[1]);
        }
        if (parameters[0] != null) {
            data.put("categoria-id", parameters[0]);
        }

        //        ?categoria-id=18
        Call<ProdutosResponse> call = produtoService.buscarProdutos(data);

        try {
            Response<ProdutosResponse> response = call.execute();
            ProdutosResponse popularResponse = response.body();
            return popularResponse;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(ProdutosResponse popularResponse) {

        if (popularResponse != null) {
            delegate.sucesso(popularResponse);
        } else {
            delegate.falha("Não foi possível carregar.");
        }

    }

    public interface CarregarProdutosDelegate {

        void sucesso(ProdutosResponse popularResponse);

        void falha(String mensagem);

    }
}
