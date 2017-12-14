package br.com.uniftec.projetoecommerce.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

import br.com.uniftec.projetoecommerce.model.Produto;

/**
 * Created by marioklein on 26/10/17.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProdutosResponse implements Serializable{

    @JsonProperty("data")
    private List<Produto> produtos;

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }
}
