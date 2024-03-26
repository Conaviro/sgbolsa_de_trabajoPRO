package com.ug.ec.dao;

import com.ug.ec.domain.Oferta;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OfertaDao extends JpaRepository<Oferta, Long> {

    List<Oferta> findByEstatus(String estatus);

   // List<Oferta> findByDestacadoAndEstatusOrderByIdDesc(Integer destacado, String estatus);
//
    List<Oferta> findBySalarioBetweenOrderBySalarioDesc(double s1, double s2);
//
    List<Oferta> findByEstatusIn(String[] estatus);
    
    List<Oferta> findByDestacadoAndEstatus(Integer destacado, String estatus);

}
