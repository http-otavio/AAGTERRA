package com.aagterra.transportes.model.socios;

import jakarta.persistence.*;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.List;

@Data
@Entity
public class Socio {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private double percentualDeLucro;

    @OneToMany(mappedBy = "socio")
    @JsonManagedReference
    private List<Lucro> lucros;

    private double valorRecebido;

    public void receberLucro(double valorTotal) {
        this.valorRecebido = valorTotal * (this.percentualDeLucro / 100.0);
    }
}
