package com.portalnfsolution.model;


import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "tb_nota")
public class Nota implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private Long id;

    @Column
    private String chave;

    @Column(length = 9, nullable = false)
    private String numero;

    @Column(name = "cnpj_emitente")
    private String cnpjEmitente;

    @Column(length = 3)
    private Integer serie;

    @Column
    private LocalDate dataEmissao;

    @Column
    private LocalDate dataAutorizacao;

    @Column
    private String protocolo;

    @Column
    private String modelo;

    @Column(name = "valor_total")
    private BigDecimal valotTotal;

    @Column
    private String situacao;

    @Column(name = "status_retorno")
    private String statusRetorno;

    @Column(name = "mensagem_retorno")
    private String mensagemRetorno;

    @Column
    private String destinatario;

    @Column(name = "seq_carta_correcao")
    private String sequenciaCartaCorrecao;

    @Column(name = "xml_copiado")
    private boolean xmlCopiado;

    @Column
    private boolean sincronizada;

    public Nota() {
    }

    public Nota(Long id, String chave, String numero, String cnpjEmitente, Integer serie, LocalDate dataEmissao,
                LocalDate dataAutorizacao, String protocolo, String modelo, BigDecimal valotTotal, String situacao) {
        this.id = id;
        this.chave = chave;
        this.numero = numero;
        this.cnpjEmitente = cnpjEmitente;
        this.serie = serie;
        this.dataEmissao = dataEmissao;
        this.dataAutorizacao = dataAutorizacao;
        this.protocolo = protocolo;
        this.modelo = modelo;
        this.valotTotal = valotTotal;
        this.situacao = situacao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getChave() {
        return chave;
    }

    public void setChave(String chave) {
        this.chave = chave;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCnpjEmitente() {
        return cnpjEmitente;
    }

    public void setCnpjEmitente(String cnpjEmitente) {
        this.cnpjEmitente = cnpjEmitente;
    }

    public Integer getSerie() {
        return serie;
    }

    public void setSerie(Integer serie) {
        this.serie = serie;
    }

    public LocalDate getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(LocalDate dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public LocalDate getDataAutorizacao() {
        return dataAutorizacao;
    }

    public void setDataAutorizacao(LocalDate dataAutorizacao) {
        this.dataAutorizacao = dataAutorizacao;
    }

    public String getProtocolo() {
        return protocolo;
    }

    public void setProtocolo(String protocolo) {
        this.protocolo = protocolo;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public BigDecimal getValotTotal() {
        return valotTotal;
    }

    public void setValotTotal(BigDecimal valotTotal) {
        this.valotTotal = valotTotal;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public String getStatusRetorno() {
        return statusRetorno;
    }

    public void setStatusRetorno(String statusRetorno) {
        this.statusRetorno = statusRetorno;
    }

    public String getMensagemRetorno() {
        return mensagemRetorno;
    }

    public void setMensagemRetorno(String mensagemRetorno) {
        this.mensagemRetorno = mensagemRetorno;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public String getSequenciaCartaCorrecao() {
        return sequenciaCartaCorrecao;
    }

    public void setSequenciaCartaCorrecao(String sequenciaCartaCorrecao) {
        this.sequenciaCartaCorrecao = sequenciaCartaCorrecao;
    }

    public boolean isXmlCopiado() {
        return xmlCopiado;
    }

    public void setXmlCopiado(boolean xmlCopiado) {
        this.xmlCopiado = xmlCopiado;
    }

    public boolean isSincronizada() {
        return sincronizada;
    }

    public void setSincronizada(boolean sincronizada) {
        this.sincronizada = sincronizada;
    }

    @Override
    public String toString() {
        return "Nota{" +
                "id=" + id +
                ", chave='" + chave + '\'' +
                ", numero='" + numero + '\'' +
                ", cnpjEmitente='" + cnpjEmitente + '\'' +
                ", serie=" + serie +
                ", dataEmissao=" + dataEmissao +
                ", dataAutorizacao=" + dataAutorizacao +
                ", protocolo='" + protocolo + '\'' +
                ", modelo='" + modelo + '\'' +
                ", valotTotal=" + valotTotal +
                ", situacao='" + situacao + '\'' +
                ", statusRetorno='" + statusRetorno + '\'' +
                ", mensagemRetorno='" + mensagemRetorno + '\'' +
                ", destinatario='" + destinatario + '\'' +
                ", sequenciaCartaCorrecao='" + sequenciaCartaCorrecao + '\'' +
                ", xmlCopiado=" + xmlCopiado +
                ", sincronizada=" + sincronizada +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Nota nota = (Nota) o;

        if (!numero.equals(nota.numero)) return false;
        if (!cnpjEmitente.equals(nota.cnpjEmitente)) return false;
        return serie.equals(nota.serie);
    }

    @Override
    public int hashCode() {
        int result = numero.hashCode();
        result = 31 * result + cnpjEmitente.hashCode();
        result = 31 * result + serie.hashCode();
        return result;
    }
}
