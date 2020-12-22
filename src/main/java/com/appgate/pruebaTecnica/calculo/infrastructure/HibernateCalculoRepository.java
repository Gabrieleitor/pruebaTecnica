package com.appgate.pruebaTecnica.calculo.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class HibernateCalculoRepository extends JpaRepository<Calculo, Integer> {
}
