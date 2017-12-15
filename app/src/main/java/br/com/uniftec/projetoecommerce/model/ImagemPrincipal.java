package br.com.uniftec.projetoecommerce.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

/**
 * Created by daniel on 14/12/17.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class ImagemPrincipal implements Serializable{

    private Integer id;
    private String url;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
