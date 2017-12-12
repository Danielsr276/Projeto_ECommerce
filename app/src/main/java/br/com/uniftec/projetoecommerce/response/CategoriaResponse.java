package br.com.uniftec.projetoecommerce.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

/**
 * Created by daniel on 26/10/17.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CategoriaResponse implements Serializable {
    private Integer id;
    private String nome;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
