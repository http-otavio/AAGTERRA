package repository;

import model.tms.socios.Lucro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LucroRepository extends JpaRepository<Lucro, Long> {
}
