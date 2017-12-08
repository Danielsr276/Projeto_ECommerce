package br.com.uniftec.projetoecommerce.task;

import android.os.AsyncTask;

import java.io.IOException;

import br.com.uniftec.projetoecommerce.model.Endereco;
import br.com.uniftec.projetoecommerce.response.EnderecoResponse;
import br.com.uniftec.projetoecommerce.response.ResponseStatus;
import br.com.uniftec.projetoecommerce.response.Resposta;
import br.com.uniftec.projetoecommerce.response.UsuarioResponse;
import br.com.uniftec.projetoecommerce.service.UsuarioService;
import br.com.uniftec.projetoecommerce.util.ServerCommunicationUtil;
import retrofit2.Call;
import retrofit2.Response;

public class EnderecoUsuarioTask extends AsyncTask<Endereco, Void, UsuarioResponse> {

    private EnderecoUsuarioDelegate delegate;
    private UsuarioService usuarioService;

    public EnderecoUsuarioTask(EnderecoUsuarioDelegate delegate) {
        this.usuarioService = ServerCommunicationUtil.getInstance()
                .getRetrofit()
                .create(UsuarioService.class);

        this.delegate = delegate;
    }

    @Override
    protected UsuarioResponse doInBackground(Endereco... parameters) {

        Call<UsuarioResponse> call = usuarioService.salvarEndereco(parameters[0], parameters[0].getToken());
        try {
            Response<UsuarioResponse> response = call.execute();
            return response.body();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(UsuarioResponse resposta) {
        if (resposta != null) {
            delegate.enderecoUsarioSucesso(resposta);
        } else {
            delegate.enderecoUsuarioFalha("Não foi possível carregar.");
        }
    }

    public interface EnderecoUsuarioDelegate {
        public void enderecoUsarioSucesso(UsuarioResponse resposta);

        public void enderecoUsuarioFalha(String mensagem);
    }
}

