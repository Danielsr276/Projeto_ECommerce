package br.com.uniftec.projetoecommerce.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by daniel on 26/10/17.
 */

public class Produto implements Serializable {

    public Produto() {
        this.listUrlsImagens = new ArrayList<>();
        this.categoria = new Categoria();
    }

    private Integer id;
    private String titulo;
    private String descricao;
    private String urlImagemPrincipal;
    private List<String> listUrlsImagens;
    private BigDecimal preco;
    private BigDecimal precoComDesconto;
    private Categoria categoria;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getUrlImagemPrincipal() {
        return urlImagemPrincipal;
    }

    public void setUrlImagemPrincipal(String urlImagemPrincipal) {
        this.urlImagemPrincipal = urlImagemPrincipal;
    }

    public List<String> getListUrlsImagens() {
        return listUrlsImagens;
    }

    public void setListUrlsImagens(List<String> listUrlsImagens) {
        this.listUrlsImagens = listUrlsImagens;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public BigDecimal getPrecoComDesconto() {
        return precoComDesconto;
    }

    public void setPrecoComDesconto(BigDecimal precoComDesconto) {
        this.precoComDesconto = precoComDesconto;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
