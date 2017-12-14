package br.com.uniftec.projetoecommerce.service;

import java.util.Map;

import br.com.uniftec.projetoecommerce.response.CategoriaResponse;
import br.com.uniftec.projetoecommerce.response.ProdutosResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * Created by Daniel Ribeiro on 16/11/17.
 */

public interface ProdutoService {

    @GET("/produto")
    public Call<ProdutosResponse> buscarProdutos( @QueryMap Map<String, String> options);

    @GET("/produto/categorias")
    public Call<CategoriaResponse> buscarCategorias();

}
