package br.com.uniftec.projetoecommerce.task;

import android.os.AsyncTask;

import java.io.IOException;

import br.com.uniftec.projetoecommerce.model.Usuario;
import br.com.uniftec.projetoecommerce.response.ResponseStatus;
import br.com.uniftec.projetoecommerce.response.Resposta;
import br.com.uniftec.projetoecommerce.service.UsuarioService;
import br.com.uniftec.projetoecommerce.util.ServerCommunicationUtil;
import retrofit2.Call;
import retrofit2.Response;

public class LoginUsuarioTask extends AsyncTask<Usuario, Void, Resposta<String>> {

    private LoginUsuarioDelegate delegate;
    private UsuarioService usuarioService;

    public LoginUsuarioTask(LoginUsuarioDelegate delegate){
        this.usuarioService = ServerCommunicationUtil.getInstance()
                .getRetrofit()
                .create(UsuarioService.class);

        this.delegate = delegate;
    }

    @Override
    protected Resposta<String> doInBackground(Usuario... parameters) {

        Call<Resposta<String>> call = usuarioService.loginUsuario(parameters[0]);
        try {
            Response<Resposta<String>> response = call.execute();
            return response.body();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(Resposta<String> resposta) {
        if(resposta.getStatus() == ResponseStatus.SUCCESS){
            delegate.loginUsarioSucesso(resposta.getData());
        } else {
            delegate.loginUsuarioFalha(resposta.getMessage());
        }
    }

    public interface LoginUsuarioDelegate {
        public void loginUsarioSucesso(String token);
        public void loginUsuarioFalha(String mensagem);
    }
}

