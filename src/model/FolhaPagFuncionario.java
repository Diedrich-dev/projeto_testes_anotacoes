/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.PositiveOrZero;

/**
 *
 * @author pedro
 */
public class FolhaPagFuncionario {
    
    private Integer id;
    @NotNull
    private Integer anoReferencia;
    @NotNull
    private Integer mesReferencia;

    @Pattern(regexp = "^([01]?[0-9]|2[0-3]):[0-5][0-9]$", message = "Formato de hora inválido")
    private LocalDate dataPagamento;

    @Pattern(regexp = "^([01]?[0-9]|2[0-3]):[0-5][0-9]$", message = "Formato de hora inválido")
    private LocalTime horasTrabalhadas;
    
    @Min(value = 0, message = "As faltas se, justificativa não pode, ser negativas")
    private int faltasSemJustificativa;
    
    @PositiveOrZero
    private Double salarioBase;
    
    @PositiveOrZero
    private Double valorHorasExtras;
    
    @PositiveOrZero
    private Double totalProventos;
    
    @PositiveOrZero
    private Double valorValeTransporte;
    
    @PositiveOrZero
    private Double valorValeAlimentacao;
    
    @PositiveOrZero
    private Double descontoINSS;
    
    @PositiveOrZero
    private Double descontoIR;
    
    @PositiveOrZero
    private Double descontoValeTransporte;

    @PositiveOrZero
    private Double descontoValeAlimentacao;

    @PositiveOrZero
    private Double valorFGTS;

    @PositiveOrZero
    private Double totalDescontos;

    @PositiveOrZero
    private Double salarioLiquido;

    public FolhaPagFuncionario() {
    }

    public FolhaPagFuncionario(Integer anoReferencia, Integer mesReferencia, LocalDate dataPagamento, LocalTime horasTrabalhadas, int faltasSemJustificativa, Double salarioBase, Double valorHorasExtras, Double totalProventos, Double valorValeTransporte, Double valorValeAlimentacao, Double descontoINSS, Double descontoIR, Double descontoValeTransporte, Double descontoValeAlimentacao, Double valorFGTS, Double totalDescontos, Double salarioLiquido) {
        this.anoReferencia = anoReferencia;
        this.mesReferencia = mesReferencia;
        this.dataPagamento = dataPagamento;
        this.horasTrabalhadas = horasTrabalhadas;
        this.faltasSemJustificativa = faltasSemJustificativa;
        this.salarioBase = salarioBase;
        this.valorHorasExtras = valorHorasExtras;
        this.totalProventos = totalProventos;
        this.valorValeTransporte = valorValeTransporte;
        this.valorValeAlimentacao = valorValeAlimentacao;
        this.descontoINSS = descontoINSS;
        this.descontoIR = descontoIR;
        this.descontoValeTransporte = descontoValeTransporte;
        this.descontoValeAlimentacao = descontoValeAlimentacao;
        this.valorFGTS = valorFGTS;
        this.totalDescontos = totalDescontos;
        this.salarioLiquido = salarioLiquido;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAnoReferencia() {
        return anoReferencia;
    }

    public void setAnoReferencia(Integer anoReferencia) {
        this.anoReferencia = anoReferencia;
    }

    public Integer getMesReferencia() {
        return mesReferencia;
    }

    public void setMesReferencia(Integer mesReferencia) {
        this.mesReferencia = mesReferencia;
    }

    public LocalDate getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(LocalDate dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public LocalTime getHorasTrabalhadas() {
        return horasTrabalhadas;
    }

    public void setHorasTrabalhadas(LocalTime horasTrabalhadas) {
        this.horasTrabalhadas = horasTrabalhadas;
    }

    public int getFaltasSemJustificativa() {
        return faltasSemJustificativa;
    }

    public void setFaltasSemJustificativa(int faltasSemJustificativa) {
        this.faltasSemJustificativa = faltasSemJustificativa;
    }

    public Double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(Double salarioBase) {
        this.salarioBase = salarioBase;
    }

    public Double getValorHorasExtras() {
        return valorHorasExtras;
    }

    public void setValorHorasExtras(Double valorHorasExtras) {
        this.valorHorasExtras = valorHorasExtras;
    }

    public Double getTotalProventos() {
        return totalProventos;
    }

    public void setTotalProventos(Double totalProventos) {
        this.totalProventos = totalProventos;
    }

    public Double getValorValeTransporte() {
        return valorValeTransporte;
    }

    public void setValorValeTransporte(Double valorValeTransporte) {
        this.valorValeTransporte = valorValeTransporte;
    }

    public Double getValorValeAlimentacao() {
        return valorValeAlimentacao;
    }

    public void setValorValeAlimentacao(Double valorValeAlimentacao) {
        this.valorValeAlimentacao = valorValeAlimentacao;
    }

    public Double getDescontoINSS() {
        return descontoINSS;
    }

    public void setDescontoINSS(Double descontoINSS) {
        this.descontoINSS = descontoINSS;
    }

    public Double getDescontoIR() {
        return descontoIR;
    }

    public void setDescontoIR(Double descontoIR) {
        this.descontoIR = descontoIR;
    }

    public Double getDescontoValeTransporte() {
        return descontoValeTransporte;
    }

    public void setDescontoValeTransporte(Double descontoValeTransporte) {
        this.descontoValeTransporte = descontoValeTransporte;
    }

    public Double getDescontoValeAlimentacao() {
        return descontoValeAlimentacao;
    }

    public void setDescontoValeAlimentacao(Double descontoValeAlimentacao) {
        this.descontoValeAlimentacao = descontoValeAlimentacao;
    }

    public Double getValorFGTS() {
        return valorFGTS;
    }

    public void setValorFGTS(Double valorFGTS) {
        this.valorFGTS = valorFGTS;
    }

    public Double getTotalDescontos() {
        return totalDescontos;
    }

    public void setTotalDescontos(Double totalDescontos) {
        this.totalDescontos = totalDescontos;
    }

    public Double getSalarioLiquido() {
        return salarioLiquido;
    }

    public void setSalarioLiquido(Double salarioLiquido) {
        this.salarioLiquido = salarioLiquido;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.id);
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
        final FolhaPagFuncionario other = (FolhaPagFuncionario) obj;
        return Objects.equals(this.id, other.id);
    }
    
}
