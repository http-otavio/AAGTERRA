package com.aagterra.transportes.repository;

import com.aagterra.transportes.model.faturamento.Faturamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FaturamentoRepository extends JpaRepository<Faturamento, Long> {
}

