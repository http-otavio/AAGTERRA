package com.aagterra.transportes.model.despesas;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Despesa {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private double valorGastoComDiesel;
    @OneToOne
    private Motorista motorista;
    private double valorDoPagamento;
    private double totalDasDespesas;

    public double calcularTotalDasDespesas() {
        return this.valorGastoComDiesel + this.valorDoPagamento;
    }
}
