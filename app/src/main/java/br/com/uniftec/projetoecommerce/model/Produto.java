package br.com.uniftec.projetoecommerce.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by daniel on 26/10/17.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Produto implements Serializable {

    public Produto() {
        this.listUrlsImagens = new ArrayList<>();
        this.categoria = new Categoria();
    }

    private Integer id;

    @JsonProperty("nome")
    private String titulo;
    private String descricao;
    private String urlImagemPrincipal;
    private ImagemPrincipal imagemPrincipal;

    @JsonProperty("imagens")
    private List<ImagemPrincipal> listImagens;
    private List<String> listUrlsImagens;
    private BigDecimal preco;
    private BigDecimal precoComDesconto;
    private Integer destaque;
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

    public Integer getDestaque() {
        return destaque;
    }

    public void setDestaque(Integer destaque) {
        this.destaque = destaque;
    }

    public ImagemPrincipal getImagemPrincipal() {
        return imagemPrincipal;
    }

    public void setImagemPrincipal(ImagemPrincipal imagemPrincipal) {
        this.imagemPrincipal = imagemPrincipal;
    }

    public List<ImagemPrincipal> getListImagens() {
        return listImagens;
    }

    public void setListImagens(List<ImagemPrincipal> listImagens) {
        this.listImagens = listImagens;
    }
}
