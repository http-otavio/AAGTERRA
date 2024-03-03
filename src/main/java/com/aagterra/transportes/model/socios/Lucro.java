package com.aagterra.transportes.model.socios;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Lucro {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "socio_id")
    private Socio socio;
    private double valorRecebido;

    public void distribuirLucro(double valorTotal) {
        this.socio.receberLucro(valorTotal);
    }
}
