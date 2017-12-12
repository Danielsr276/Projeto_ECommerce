package br.com.uniftec.projetoecommerce.service;

import java.util.List;

import br.com.uniftec.projetoecommerce.model.Endereco;
import br.com.uniftec.projetoecommerce.model.Pedido;
import br.com.uniftec.projetoecommerce.model.Usuario;
import br.com.uniftec.projetoecommerce.response.PedidoResponse;
import br.com.uniftec.projetoecommerce.response.Resposta;
import br.com.uniftec.projetoecommerce.response.UsuarioResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;

/**
 * Created by daniel ribeiro on 07/12/17.
 */

public interface PedidoService {

    @PUT("/pedido")
    public Call<Resposta<String>> salvarPedido(@Body Pedido pedido, @Header("X-Token") String token);

    @POST("/pedido")
    public Call<Resposta<PedidoResponse>> atualizarPedido(@Body Pedido pedido, @Header("X-Token") String token);

    @GET("/pedido")
    public Call<Resposta<List<PedidoResponse>>> buscarPedidos(@Header("X-Token") String token);

    @PUT("/usuario/endereco")
    public Call<Resposta<String>> salvarEndereco(@Body Endereco endereco);
}
