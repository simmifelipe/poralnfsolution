package com.portalnfsolution.repository;

import com.portalnfsolution.model.Nota;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.time.LocalDate;
import java.util.List;

public interface NotaRepository extends PagingAndSortingRepository<Nota, Long> {

    List<Nota> findAll();

    List<Nota> findNotaByCnpjEmitente(String cnpj);

    List<Nota> findNotaByCnpjEmitenteAndDataEmissao(String cnpj, LocalDate dataEmissao);

    List<Nota> findNotaByDataEmissao(LocalDate dataEmissao);

    List<Nota> findNotaBySituacao(String situacao);

    List<Nota> findNotaByChave(String chave);

    List<Nota> findNotaByDestinatarioIgnoringCaseContaining(String destinatario);

    List<Nota> findNotaByCnpjEmitenteAndNumeroAndSerie(String cnpj, String numero,Integer serie);


}
