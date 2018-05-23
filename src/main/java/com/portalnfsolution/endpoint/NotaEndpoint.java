package com.portalnfsolution.endpoint;

import com.portalnfsolution.exception.ResourceNotFoundException;
import com.portalnfsolution.model.Nota;
import com.portalnfsolution.repository.NotaRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

/**
 * Created by felipe.simmi on 21/05/2018.
 */

@RestController
@RequestMapping("v1")
public class NotaEndpoint {

    private final NotaRepository repository;

    @Autowired
    public NotaEndpoint(NotaRepository repository) {
        this.repository = repository;
    }

    private void verificaSeNotaExiste(String cnpj, String numero, String serie) {
        Nota nota = repository.findNotaByCnpjEmitenteAndNumeroAndSerie(cnpj, numero, Integer.valueOf(serie));
        if (nota == null) {
            throw new ResourceNotFoundException("Nota não encontrada com estes parametros: " +
                    "Cnpj -> " + cnpj + " | " +
                    "Número -> " + numero + " | " +
                    "Série -> " + serie
            );
        }
    }

    @GetMapping(path = "/protegido/notas")
    public ResponseEntity<?> listarTodos(Pageable pageable) {
        return new ResponseEntity<>(repository.findAll(pageable), HttpStatus.OK);
    }

    @GetMapping(path = "/protegido/notas/{cnpj}")
    public ResponseEntity<?> porCnpj(@PathVariable("cnpj") String cnpj, Pageable pageable) {
        return new ResponseEntity<>(repository.findNotaByCnpjEmitente(cnpj, pageable), HttpStatus.OK);
    }

    @GetMapping(path = "/protegido/notas/{cnpj}/{dataEmissao}")
    public ResponseEntity<?> porCnpjEDataEmissao(
            @PathVariable("cnpj") String cnpj, @PathVariable("dataEmissao") String dataEmissao, Pageable pageable) {
        LocalDate data = LocalDate.parse(dataEmissao);
        return new ResponseEntity<>(repository.findNotaByCnpjEmitenteAndDataEmissao(cnpj, data, pageable), HttpStatus.OK);
    }

    @GetMapping(path = "/protegido/notas/data/{dataEmissao}")
    public ResponseEntity<?> porDataEmissao(@PathVariable("dataEmissao") String dataEmissao, Pageable pageable) {
        LocalDate data = LocalDate.parse(dataEmissao);
        return new ResponseEntity<>(repository.findNotaByDataEmissao(data, pageable), HttpStatus.OK);
    }

    @GetMapping(path = "/protegido/notas/situacao/{situacao}")
    public ResponseEntity<?> porSituacao(@PathVariable("situacao") String situacao, Pageable pageable) {
        return new ResponseEntity<>(repository.findNotaBySituacao(situacao, pageable), HttpStatus.OK);
    }

    @GetMapping(path = "/protegido/notas/chave/{chave}")
    public ResponseEntity<?> porChave(@PathVariable("chave") String chave) {
        return new ResponseEntity<>(repository.findNotaByChave(chave), HttpStatus.OK);
    }

    @GetMapping(path = "/protegido/notas/destinatario/{destinatario}")
    public ResponseEntity<?> porDestinatario(@PathVariable("destinatario") String destinatario, Pageable pageable) {
        return new ResponseEntity<>(repository.findNotaByDestinatarioIgnoringCaseContaining(destinatario, pageable), HttpStatus.OK);
    }

    @GetMapping(path = "/protegido/notas/{cnpj}/{numero}/{serie}")
    public ResponseEntity<?> porCnpjENumeroESerie(
            @PathVariable("cnpj") String cnpj, @PathVariable("numero") String numero, @PathVariable("serie") String serie) {
        Integer sr = Integer.valueOf(serie);
        numero = StringUtils.leftPad(numero, 9, "0");
        return new ResponseEntity<>(repository.findNotaByCnpjEmitenteAndNumeroAndSerie(cnpj, numero, sr), HttpStatus.OK);
    }

    @PostMapping(path = "/protegido/notas")
    public ResponseEntity<?> salvar(@RequestBody Nota nota) {
        return new ResponseEntity<>(repository.save(nota), HttpStatus.CREATED);
    }

    @PutMapping(path = "/protegido/notas")
    public ResponseEntity<?> atualizar(@RequestBody Nota nota) {
        verificaSeNotaExiste(nota.getCnpjEmitente(), nota.getNumero(), String.valueOf(nota.getSerie()));
        repository.save(nota);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(path = "/protegido/notas")
    public ResponseEntity<?> remover(@RequestBody Nota nota) {
        verificaSeNotaExiste(nota.getCnpjEmitente(), nota.getNumero(), String.valueOf(nota.getSerie()));
        repository.delete(nota);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
