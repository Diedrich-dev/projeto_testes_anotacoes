/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Objects;

import jakarta.validation.constraints.*;

/**
 *
 * @author pedro
 */
public class Endereco {
    
    private Integer id;

    @NotBlank(message = "O nome da cidade não pode estar em branco")
    @Pattern(regexp = "[A-zÀ-ü ]", message = "cidade inválida")
    private String cidade;

    @NotBlank(message = "O nome do bairro não pode estar em branco")
    @Pattern(regexp = "[A-zÀ-ü ]", message = "bairro inválido")
    private String bairro;

    @NotBlank(message = "O nome da rua não pode estar em branco")
    @Pattern(regexp = "[A-zÀ-ü ]", message = "rua inválida")
    private String rua;

    @NotNull(message = "O número não pode ser nulo")
    @Min(value = 1, message = "O número mínimo é 1")
    @Positive(message = "O número deve ser positivo")
    @Digits(integer = 5, fraction = 0, message = "O número deve ter até 5 dígitos")
    private Integer numero;

    public Endereco() {
    }

    public Endereco(String cidade, String bairro, String rua, Integer numero) {
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
        this.numero = numero;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public Integer getNumero() {
        return numero;
    }
    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    @Override
    public int hashCode() {
        int hash = 5;
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
        final Endereco other = (Endereco) obj;
        return Objects.equals(this.id, other.id);
    }
    
    
}
