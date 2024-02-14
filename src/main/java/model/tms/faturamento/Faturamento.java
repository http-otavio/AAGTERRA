package model.tms.faturamento;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;



@Data
@Entity
public class Faturamento {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private double totalDoFrete;
    private double valorDaDiaria;
    private double totalDoFaturamento;

    public double calcularTotalDoFaturamento() {
        return this.totalDoFrete + this.valorDaDiaria;
    }
}
