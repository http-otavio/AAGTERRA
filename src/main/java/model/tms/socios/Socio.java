package model.tms.socios;

import jakarta.persistence.*;
import lombok.Data;
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
    private List<Lucro> lucros;
    private double valorRecebido;

    public void receberLucro(double valorTotal) {
        this.valorRecebido = valorTotal * (this.percentualDeLucro / 100.0);
    }
}
