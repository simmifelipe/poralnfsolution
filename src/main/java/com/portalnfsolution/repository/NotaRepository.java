package com.portalnfsolution.repository;

import com.portalnfsolution.model.Nota;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface NotaRepository extends PagingAndSortingRepository<Nota, Long> {

    List<Nota> findAll();

}
