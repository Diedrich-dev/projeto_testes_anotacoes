/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Objects;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import util.validacao.CPF;
import util.validacao.Email;
import util.validacao.Telefone;
import util.validacao.ValidEndereco;

/**
 *
 * @author pedro
 */
public class Pessoa {
    
    private Integer id;

    @NotBlank(message = "O nome não pode estar em branco")
    @Size(min = 3, max = 90, message = "o nome deve conter de 3 a 90 caracteres")
    @Pattern(regexp = "[A-zÀ-ü ]{3,90}", message = "nome inválido")
    private String nome;
    
    @CPF
    @NotNull
    private String cpf;
    
    @Email
    @NotNull
    private String email;
    
    @Telefone
    @NotNull
    private String telefone;
    
    @ValidEndereco
    private Endereco endereco;

    public Pessoa() {
        endereco = new Endereco();
    }

    public Pessoa(String nome, String cpf, String email, String telefone, Endereco endereco) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
        this.endereco = endereco;
    }

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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pessoa other = (Pessoa) obj;
        if (!Objects.equals(this.cpf, other.cpf)) {
            return false;
        }
        return Objects.equals(this.id, other.id);
    }
    
    
    
    
}
