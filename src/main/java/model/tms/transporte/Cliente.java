package model.tms.transporte;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
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
