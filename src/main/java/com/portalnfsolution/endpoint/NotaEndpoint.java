package com.portalnfsolution.endpoint;

import com.portalnfsolution.model.Nota;
import com.portalnfsolution.repository.NotaRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;

/**
 * Created by felipe.simmi on 21/05/2018.
 */

@RestController
@RequestMapping("v1")
public class NotaEndpoint {

    private final NotaRepository repository;

    @Autowired
    public NotaEndpoint(NotaRepository repository){
        this.repository = repository;
    }

    @GetMapping("/protegido/notas")
    public ResponseEntity<?> listarTodos(){
        return new ResponseEntity<>(repository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/protegido/notas/{cnpj}")
    public ResponseEntity<?> porCnpj(@PathVariable("cnpj") String cnpj){
        return new ResponseEntity<>(repository.findNotaByCnpjEmitente(cnpj), HttpStatus.OK);
    }

    @GetMapping("/protegido/notas/{cnpj}/{dataEmissao}")
    public ResponseEntity<?> porCnpjEDataEmissao(
            @PathVariable("cnpj") String cnpj, @PathVariable("dataEmissao") String dataEmissao){
        LocalDate data = LocalDate.parse(dataEmissao);
        return new ResponseEntity<>(repository.findNotaByCnpjEmitenteAndDataEmissao(cnpj, data), HttpStatus.OK);
    }

    @GetMapping("/protegido/notas/data/{dataEmissao}")
    public ResponseEntity<?> porDataEmissao(@PathVariable("dataEmissao") String dataEmissao){
        LocalDate data = LocalDate.parse(dataEmissao);
        return new ResponseEntity<>(repository.findNotaByDataEmissao(data), HttpStatus.OK);
    }

    @GetMapping("/protegido/notas/situacao/{situacao}")
    public ResponseEntity<?> porSituacao(@PathVariable("situacao") String situacao){
        return new ResponseEntity<>(repository.findNotaBySituacao(situacao), HttpStatus.OK);
    }

    @GetMapping("/protegido/notas/chave/{chave}")
    public ResponseEntity<?> porChave(@PathVariable("chave") String chave){
        return new ResponseEntity<>(repository.findNotaByChave(chave), HttpStatus.OK);
    }

    @GetMapping("/protegido/notas/destinatario/{destinatario}")
    public ResponseEntity<?> porDestinatario(@PathVariable("destinatario") String destinatario){
        return new ResponseEntity<>(repository.findNotaByDestinatarioIgnoringCaseContaining(destinatario), HttpStatus.OK);
    }

    @GetMapping("/protegido/notas/{cnpj}/{numero}/{serie}")
    public ResponseEntity<?> porCnpjENumeroESerie(
            @PathVariable("cnpj") String cnpj, @PathVariable("numero") String numero, @PathVariable("serie") String serie){
        Integer sr = Integer.valueOf(serie);
        numero = StringUtils.leftPad(numero, 9, "0");
        return new ResponseEntity<>(repository.findNotaByCnpjEmitenteAndNumeroAndSerie(cnpj, numero, sr), HttpStatus.OK);
    }

    @RequestMapping(value = "/protegido/notas", method = RequestMethod.POST)
    public ResponseEntity<?> salvar(@RequestBody Nota nota) {
        return new ResponseEntity<>(repository.save(nota), HttpStatus.CREATED);
    }

















}
