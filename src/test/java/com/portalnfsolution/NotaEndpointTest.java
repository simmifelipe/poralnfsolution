package com.portalnfsolution;

import com.portalnfsolution.model.Nota;
import com.portalnfsolution.repository.NotaRepository;
import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class NotaEndpointTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @MockBean
    private NotaRepository repository;

    @Autowired
    private MockMvc mockMvc;


    @Before
    public void setup(){
        Nota nota = new Nota(1L, "43180491362590003505650000003520269077533044", "000000001",
                "91362590003505", 0, LocalDate.now(), LocalDate.now(), "143180004030449",
                "55", BigDecimal.ONE, "Autorizada");
        BDDMockito.when(repository.findById(nota.getId())).thenReturn(Optional.of(nota));
    }

    @Test
    public void pesquisarNotasPorCnpjEmitenteDeveRetornarStatus200(){
        ResponseEntity<String> response = restTemplate.getForEntity("/v1/protegido/notas/{cnpj}", String.class, "91362590003505");
        Assertions.assertThat(response.getStatusCodeValue()).isEqualTo(200);
    }

    @Test
    public void pesquisarNotasPorCnpjEDataEmissaoDeveRetornarStatus200(){
        ResponseEntity<String> response = restTemplate.getForEntity("/v1/protegido/notas/{cnpj}/{dataEmissao}", String.class, "91362590003505", "2018-04-22");
        Assertions.assertThat(response.getStatusCodeValue()).isEqualTo(200);
        System.out.println(repository.findNotaByCnpjEmitenteAndDataEmissao("91362590003505", LocalDate.parse("2018-04-22"), null));

    }

    @Test
    public void pesquisarNotasPorDataEmissaoDeveRetornarStatus200(){
        ResponseEntity<String> response = restTemplate.getForEntity("/v1/protegido/notas/data/{dataEmissao}", String.class, "2018-04-18");
        Assertions.assertThat(response.getStatusCodeValue()).isEqualTo(200);
    }

    @Test
    public void pesquisarNotasPorSituacaoDeveRetornarStatus200(){
        ResponseEntity<String> response = restTemplate.getForEntity("/v1/protegido/notas/situacao/{situacao}", String.class, "Autorizada");
        Assertions.assertThat(response.getStatusCodeValue()).isEqualTo(200);
    }

    @Test
    public void pesquisarNotasPorChaveDeveRetornarStatus200ENaoSerNulo(){
        Nota nota = new Nota(1L, "43180491362590003505650000003520269077533045", "000000001",
                "91362590003505", 0, LocalDate.now(), LocalDate.now(), "143180004030449",
                "55", BigDecimal.ONE, "Autorizada");
        repository.save(nota);
        ResponseEntity<String> response = restTemplate.getForEntity("/v1/protegido/notas/chave/{chave}", String.class, "431804913625900035056500000035202690775330445");
        Assertions.assertThat(response.getStatusCodeValue()).isEqualTo(200);
        Assertions.assertThat(response.getBody()).isNotNull();
    }



}
