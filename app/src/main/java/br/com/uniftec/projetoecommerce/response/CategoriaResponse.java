package br.com.uniftec.projetoecommerce.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

import br.com.uniftec.projetoecommerce.model.Categoria;
import br.com.uniftec.projetoecommerce.model.Produto;

/**
 * Created by daniel on 26/10/17.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CategoriaResponse implements Serializable {
    @JsonProperty("data")
    private List<Categoria> categorias;


    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }
}
