package com.appgate.pruebaTecnica.calculo.infrastructure;

import com.appgate.pruebaTecnica.calculo.domain.Calculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HibernateCalculoRepository extends JpaRepository<Calculo, Integer> {
}
