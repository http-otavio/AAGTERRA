package com.aagterra.transportes.model.socios;
import jakarta.persistence.*;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Data
@Entity
public class Lucro {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "socio_id")
    @JsonBackReference
    private Socio socio;

    private double valorRecebido;

    public void distribuirLucro(double valorTotal) {
        this.socio.receberLucro(valorTotal);
    }
}
