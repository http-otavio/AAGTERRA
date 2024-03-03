package com.aagterra.transportes.model.transporte;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;
import java.util.List;
@Data
@Entity
public class Transporte {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date data;
    @OneToMany(mappedBy = "transporte")
    private List<Cliente> clientes;
    private int numeroDeViagens;
    private double valorDoFrete;

    public void adicionarCliente(Cliente cliente) {
        this.clientes.add(cliente);
    }

    public double calcularValorTotalDoFrete() {
        return this.numeroDeViagens * this.valorDoFrete;
    }
}
