package com.aagterra.transportes.repository;

import com.aagterra.transportes.model.socios.Lucro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LucroRepository extends JpaRepository<Lucro, Long> {
}
