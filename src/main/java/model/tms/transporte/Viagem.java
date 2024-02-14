package model.tms.transporte;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Viagem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    public void associarCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
