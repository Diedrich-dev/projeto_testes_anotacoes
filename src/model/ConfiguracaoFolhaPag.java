/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Objects;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

/**
 *
 * @author pedro
 */
public class ConfiguracaoFolhaPag {
    
    private Integer id;
    @NotNull
    private Integer anoVigencia;
    private boolean ativo;
    @PositiveOrZero
    private Double valorDiaValeAlimentacao;
    @PositiveOrZero
    private Double valorDiaValeTransporte;
    @PositiveOrZero
    private Double percentualDescontoValeTransporte;
    @PositiveOrZero
    private Double percentualDescontoValeAlimentacao;

    public ConfiguracaoFolhaPag() {
    }

    public ConfiguracaoFolhaPag(Integer id, Integer anoVigencia, boolean ativo, Double valorDiaValeAlimentacao, Double valorDiaValeTransporte, Double percentualDescontoValeTransporte, Double percentualDescontoValeAlimentacao) {
        this.id = id;
        this.anoVigencia = anoVigencia;
        this.ativo = ativo;
        this.valorDiaValeAlimentacao = valorDiaValeAlimentacao;
        this.valorDiaValeTransporte = valorDiaValeTransporte;
        this.percentualDescontoValeTransporte = percentualDescontoValeTransporte;
        this.percentualDescontoValeAlimentacao = percentualDescontoValeAlimentacao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAnoVigencia() {
        return anoVigencia;
    }

    public void setAnoVigencia(Integer anoVigencia) {
        this.anoVigencia = anoVigencia;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public Double getValorDiaValeAlimentacao() {
        return valorDiaValeAlimentacao;
    }

    public void setValorDiaValeAlimentacao(Double valorDiaValeAlimentacao) {
        this.valorDiaValeAlimentacao = valorDiaValeAlimentacao;
    }

    public Double getValorDiaValeTransporte() {
        return valorDiaValeTransporte;
    }

    public void setValorDiaValeTransporte(Double valorDiaValeTransporte) {
        this.valorDiaValeTransporte = valorDiaValeTransporte;
    }

    public Double getPercentualDescontoValeTransporte() {
        return percentualDescontoValeTransporte;
    }

    public void setPercentualDescontoValeTransporte(Double percentualDescontoValeTransporte) {
        this.percentualDescontoValeTransporte = percentualDescontoValeTransporte;
    }

    public Double getPercentualDescontoValeAlimentacao() {
        return percentualDescontoValeAlimentacao;
    }

    public void setPercentualDescontoValeAlimentacao(Double percentualDescontoValeAlimentacao) {
        this.percentualDescontoValeAlimentacao = percentualDescontoValeAlimentacao;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.id);
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
        final ConfiguracaoFolhaPag other = (ConfiguracaoFolhaPag) obj;
        return Objects.equals(this.id, other.id);
    }
    
}
