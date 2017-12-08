package br.com.uniftec.projetoecommerce.service;

import br.com.uniftec.projetoecommerce.model.Endereco;
import br.com.uniftec.projetoecommerce.model.Usuario;
import br.com.uniftec.projetoecommerce.response.Resposta;
import br.com.uniftec.projetoecommerce.response.UsuarioResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;

/**
 * Created by Willi on 16/11/17.
 */

public interface UsuarioService {

    @PUT("/usuario")
    public Call<Resposta<String>> salvarUsuario(@Body Usuario usuario);

    @POST
    public Call<Resposta<UsuarioResponse>> atualizarUsuario(@Body Usuario usuario, @Header("X-Token") String token);

    @POST("/usuario/login")
    public Call<Resposta<String>> loginUsuario(@Body Usuario usuario);

    @PUT("/usuario/endereco")
    public Call<UsuarioResponse> salvarEndereco(@Body Endereco endereco, @Header("X-Token") String token);
}
