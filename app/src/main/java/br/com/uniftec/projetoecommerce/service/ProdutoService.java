package br.com.uniftec.projetoecommerce.service;

import br.com.uniftec.projetoecommerce.response.ProdutosResponse;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Daniel Ribeiro on 16/11/17.
 */

public interface ProdutoService {

    @GET("/produto?categoria-id=18")
    public Call<ProdutosResponse> buscarProdutos();
}
