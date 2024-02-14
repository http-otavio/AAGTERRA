package model.tms.despesas;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Motorista {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    @OneToOne(mappedBy = "motorista")
    private Despesa despesa;
    private double valorDoPagamento;

    public void receberPagamento(double valor) {
        this.valorDoPagamento += valor;
    }
}
