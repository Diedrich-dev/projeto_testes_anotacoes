/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDate;
import java.util.Objects;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.PositiveOrZero;
import util.validacao.CTPS;
import util.validacao.ValidCargo;

/**
 *
 * @author pedro
 */
public class Funcionario {
    
    private Integer id;
    
    @CTPS
    private String ctps;

    @Pattern(regexp = "^([01]?[0-9]|2[0-3]):[0-5][0-9]$", message = "Formato de hora inválido")
    private LocalDate dataAdmissao;

    @Pattern(regexp = "^([01]?[0-9]|2[0-3]):[0-5][0-9]$", message = "Formato de hora inválido")
    private LocalDate dataDemissao;
    
    @ValidCargo
    private Cargo cargo;

    @PositiveOrZero
    private Double salario;
    
    
    private boolean recebeValeTransporte;
    private boolean recebeValeAlimentacao;
    private int numeroDependentes;

    public Funcionario() {
    }

    public Funcionario(String ctps, LocalDate dataAdmissao, LocalDate dataDemissao, Cargo cargo, Double salario, boolean recebeValeTransporte, boolean recebeValeAlimentacao, int numeroDependentes) {
        this.ctps = ctps;
        this.dataAdmissao = dataAdmissao;
        this.dataDemissao = dataDemissao;
        this.cargo = cargo;
        this.salario = salario;
        this.recebeValeTransporte = recebeValeTransporte;
        this.recebeValeAlimentacao = recebeValeAlimentacao;
        this.numeroDependentes = numeroDependentes;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCtps() {
        return ctps;
    }

    public void setCtps(String ctps) {
        this.ctps = ctps;
    }

    public LocalDate getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(LocalDate dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

    public LocalDate getDataDemissao() {
        return dataDemissao;
    }

    public void setDataDemissao(LocalDate dataDemissao) {
        this.dataDemissao = dataDemissao;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public boolean isRecebeValeTransporte() {
        return recebeValeTransporte;
    }

    public void setRecebeValeTransporte(boolean recebeValeTransporte) {
        this.recebeValeTransporte = recebeValeTransporte;
    }

    public boolean isRecebeValeAlimentacao() {
        return recebeValeAlimentacao;
    }

    public void setRecebeValeAlimentacao(boolean recebeValeAlimentacao) {
        this.recebeValeAlimentacao = recebeValeAlimentacao;
    }

    public int getNumeroDependentes() {
        return numeroDependentes;
    }

    public void setNumeroDependentes(int numeroDependentes) {
        this.numeroDependentes = numeroDependentes;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + Objects.hashCode(this.id);
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
        final Funcionario other = (Funcionario) obj;
        return Objects.equals(this.id, other.id);
    }
    
    
}
