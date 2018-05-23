package com.portalnfsolution.repository;

import com.portalnfsolution.model.Nota;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.time.LocalDate;
import java.util.List;

public interface NotaRepository extends PagingAndSortingRepository<Nota, Long> {

    List<Nota> findNotaByCnpjEmitente(String cnpj, Pageable pageable);

    List<Nota> findNotaByCnpjEmitenteAndDataEmissao(String cnpj, LocalDate dataEmissao, Pageable pageable);

    List<Nota> findNotaByDataEmissao(LocalDate dataEmissao, Pageable pageable);

    List<Nota> findNotaBySituacao(String situacao, Pageable pageable);

    List<Nota> findNotaByDestinatarioIgnoringCaseContaining(String destinatario, Pageable pageable);

    Nota findNotaByChave(String chave);

    Nota findNotaByCnpjEmitenteAndNumeroAndSerie(String cnpj, String numero,Integer serie);

    Nota findNotaById(Long id);


}
