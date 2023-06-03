/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import java.time.LocalTime;
import java.util.Objects;


/**
 *
 * @author pedro
 */
public class Cargo {
    
    private Integer id;

    @NotBlank(message = "A descricao não pode estar em branco")
    @Size(min = 10, max = 200, message = "a descricao deve conter de 10 a 200 caracteres")
    @Pattern(regexp = "[A-zÀ-ü ]{3,200}", message = "descrição inválido")
    private String descricao;

    @Pattern(regexp = "^([01]?[0-9]|2[0-3]):[0-5][0-9]$", message = "Formato de hora inválido")
    private LocalTime cargaHorariaMensal;

    public Cargo() {
    }

    public Cargo(String descricao, LocalTime cargaHorariaMensal) {
        this.descricao = descricao;
        this.cargaHorariaMensal = cargaHorariaMensal;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalTime getCargaHorariaMensal() {
        return cargaHorariaMensal;
    }

    public void setCargaHorariaMensal(LocalTime cargaHorariaMensal) {
        this.cargaHorariaMensal = cargaHorariaMensal;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.id);
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
        final Cargo other = (Cargo) obj;
        return Objects.equals(this.id, other.id);
    }
    
    
}
