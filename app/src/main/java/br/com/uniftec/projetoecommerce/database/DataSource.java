package br.com.uniftec.projetoecommerce.database;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import br.com.uniftec.projetoecommerce.R;
import br.com.uniftec.projetoecommerce.model.Endereco;
import br.com.uniftec.projetoecommerce.model.Pedido;
import br.com.uniftec.projetoecommerce.model.Produto;
import br.com.uniftec.projetoecommerce.model.Usuario;

/**
 * Created by daniel on 27/10/17.
 */

public class DataSource {

    public static List<Usuario> carregarJsonTestes(Context context) {

        List<Usuario> usuarios = new ArrayList<>();

        try {
            JSONArray results = new JSONArray(loadJSONFromAsset(context));

            for (int i = 0; i < results.length(); i++) {
                Usuario usuario = new Usuario();
                JSONObject jsonResult = results.getJSONObject(i);

                usuario.setId(jsonResult.getInt("id"));
                usuario.setNome(jsonResult.getString("nome"));
                usuario.setEmail(jsonResult.getString("email"));
                usuario.setSenha(jsonResult.getString("senha"));
                usuario.setCpf(jsonResult.getString("cpf"));
                usuario.setTelefone(jsonResult.getString("telefone"));

                popularEnderecos(usuario, jsonResult.getJSONArray("listEnderecos"));
                popularProdutos(usuario, jsonResult.getJSONArray("listProdutos"));

                usuarios.add(usuario);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return usuarios;
    }

    public static void popularProdutos(Usuario usuario, JSONArray listProdutos) throws JSONException {
        for (int i = 0; i < listProdutos.length(); i++) {
            JSONObject jsonResult = listProdutos.getJSONObject(i);

            Produto produto = new Produto();
            produto.setId(jsonResult.getInt("id"));
            produto.setTitulo(jsonResult.getString("titulo"));
            produto.setUrlImagemPrincipal(jsonResult.getString("urlImagemPrincipal"));

            popularListaUrls(produto, jsonResult.getJSONArray("listUrlsImagens"));

            produto.setPreco(BigDecimal.valueOf(jsonResult.getDouble("preco")));
            produto.setPrecoComDesconto(BigDecimal.valueOf(jsonResult.getDouble("precoComDesconto")));

            JSONObject categoria = jsonResult.getJSONObject("categoria");
            produto.getCategoria().setId(categoria.getInt("id"));
            produto.getCategoria().setNome(categoria.getString("nome"));
            usuario.getListProdutos().add(produto);

        }
    }

    private static void popularListaUrls(Produto produto, JSONArray listUrlsImagens) throws JSONException {
        for (int i = 0; i < listUrlsImagens.length(); i++) {
            String urlImage = listUrlsImagens.getString(i);
            produto.getListUrlsImagens().add(urlImage);
        }
    }

    private static void popularEnderecos(Usuario usuario, JSONArray listEnderecos) throws JSONException {
        for (int i = 0; i < listEnderecos.length(); i++) {
            JSONObject jsonResult = listEnderecos.getJSONObject(i);

            Endereco endereco = new Endereco();
            endereco.setId(jsonResult.getInt("id"));
            endereco.setRua(jsonResult.getString("rua"));
            endereco.setNumero(jsonResult.getInt("numero"));
            endereco.setComplemento(jsonResult.getString("complemento"));
            endereco.setBairro(jsonResult.getString("bairro"));
            endereco.setCidade(jsonResult.getString("cidade"));
            endereco.setEstado(jsonResult.getString("estado"));
            usuario.getListEnderecos().add(endereco);
        }
    }

    public static String loadJSONFromAsset(Context context) throws IOException {
        String json = null;
        try {
            InputStream is = context.getResources().openRawResource(R.raw.users);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

    public static String loadJSONProductsFromAsset(Context context) throws IOException {
        String json = null;
        try {
            InputStream is = context.getResources().openRawResource(R.raw.products);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

    public static String loadJSONPedidosFromAsset(Context context) throws IOException {
        String json = null;
        try {
            InputStream is = context.getResources().openRawResource(R.raw.pedidos);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }


    public static List<Produto> carregarJsonTestesProducts(Context context) {

        List<Produto> produtos = new ArrayList<>();

        try {
            JSONArray results = new JSONArray(loadJSONProductsFromAsset(context));

            for (int i = 0; i < results.length(); i++) {
                JSONObject jsonResult = results.getJSONObject(i);

                Produto produto = new Produto();
                produto.setId(jsonResult.getInt("id"));
                produto.setTitulo(jsonResult.getString("titulo"));
                produto.setUrlImagemPrincipal(jsonResult.getString("urlImagemPrincipal"));

                popularListaUrls(produto, jsonResult.getJSONArray("listUrlsImagens"));

                produto.setPreco(BigDecimal.valueOf(jsonResult.getDouble("preco")));
                produto.setPrecoComDesconto(BigDecimal.valueOf(jsonResult.getDouble("precoComDesconto")));
                produto.setDestaque(jsonResult.getInt("destaque"));
                produto.setDescricao(jsonResult.getString("descricao"));

                JSONObject categoria = jsonResult.getJSONObject("categoria");
                produto.getCategoria().setId(categoria.getInt("id"));
                produto.getCategoria().setNome(categoria.getString("nome"));

                produtos.add(produto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return produtos;
    }

    public static List<Pedido> carregarJsonTestesPedidos(Context context) {

        List<Pedido> pedidos = new ArrayList<>();

        try {
            JSONArray results = new JSONArray(loadJSONPedidosFromAsset(context));

            for (int i = 0; i < results.length(); i++) {
                JSONObject jsonResult = results.getJSONObject(i);

                Pedido pedido = new Pedido();
                pedido.setId(jsonResult.getInt("id"));
                pedido.setIdUsuario(jsonResult.getInt("idUsuario"));
                pedido.setProdutos(jsonResult.getJSONArray("produtos"));
                pedido.setTotal(BigDecimal.valueOf(jsonResult.getDouble("total")));
                pedido.setData(jsonResult.getString("data"));
                pedido.setStatus(jsonResult.getInt("status"));

                pedidos.add(pedido);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return pedidos;
    }

}
