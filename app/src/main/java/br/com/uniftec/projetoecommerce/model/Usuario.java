package br.com.uniftec.projetoecommerce.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by daniel on 26/10/17.
 */

public class Usuario implements Serializable {

    public Usuario() {
        this.listEnderecos = new ArrayList<>();
        this.listProdutos = new ArrayList<>();
    }

    private Integer id;
    private String nome;
    private String email;
    private String senha;
    private String cpf;
    private String telefone;
    private List<Endereco> listEnderecos;
    private List<Produto> listProdutos;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public List<Endereco> getListEnderecos() {
        return listEnderecos;
    }

    public void setListEnderecos(List<Endereco> listEnderecos) {
        this.listEnderecos = listEnderecos;
    }

    public List<Produto> getListProdutos() {
        return listProdutos;
    }

    public void setListProdutos(List<Produto> listProdutos) {
        this.listProdutos = listProdutos;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
