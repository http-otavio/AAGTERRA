package com.aagterra.transportes.model.transporte;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull(message = "Nome não pode ser nulo")
    @Size(min = 2, max = 100, message = "Nome deve ter entre 2 e 100 caracteres")
    private String nome;

    @ManyToOne
    @JoinColumn(name = "transporte_id")
    private Transporte transporte;

    @OneToMany(mappedBy = "cliente")
    private List<Viagem> viagens; // Adicionado aqui

    public void adicionarViagem(Viagem viagem) {
        this.viagens.add(viagem);
    }
}
