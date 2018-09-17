package br.com.projeto.linhaTelefonica.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;

/*
 * Esta classe utiliza as anotações:
 * Entity informa que a classe é uma entidade
 * Component
 * Table define o nome da tabela
 * Id indentifica a chave primaria
 * GeneratedValue foi utilizado o IDENTITY para o proprio banco de dados gerar a chave primaria como auto incremeto 
 * Column permite definir caracteristicas da coluna no banco de dados 
 */

@Entity
@Component
@Table(name = "Cliente")
public class Cliente {

	private static final long serialVersionUID = -6888542263201514002L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCliente;

	@Column(name = "nome_cliente", nullable = false, unique = false)
	@NotNull(message = "Nome do Cliente é uma informação obrigatória")
	
	private String nomeCliente;

	@Column(name = "email_cliente", nullable = false, unique = false)
	@NotNull(message = "Email do Cliente é uma informação obrigatória")
	private String emailCliente;

	@JsonSerialize(using = DateSerializer.class)
	@Column(name = "data_cad_cliente", nullable = false)
	private Date dataCadCliente;

	@Column(name = "num_linha_cliente", nullable = false, unique = false)
	@NotNull(message = "Número do Cliente é uma informação obrigatória")
	private String numLinhaCliente;

	@Column(name = "plano_id", nullable = false)
	private Long planoCliente;

	public Cliente() {

	}

	public Cliente(Long idCliente, String nomeCliente, String emailCliente, Date dataCadCliente, String numLinhaCliente,
			Long planoCliente) {
		this.idCliente = idCliente;
		this.nomeCliente = nomeCliente;
		this.emailCliente = emailCliente;
		this.dataCadCliente = dataCadCliente;
		this.numLinhaCliente = numLinhaCliente;
		this.planoCliente = planoCliente;
	}

	public Long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public String getEmailCliente() {
		return emailCliente;
	}

	public void setEmailCliente(String emailCliente) {
		this.emailCliente = emailCliente;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	public Date getDataCadCliente() {
		return dataCadCliente;
	}

	public void setDataCadCliente(Date dataCadCliente) {
		this.dataCadCliente = dataCadCliente;
	}

	public String getNumLinhaCliente() {
		return numLinhaCliente;
	}

	public void setNumLinhaCliente(String numLinhaCliente) {
		this.numLinhaCliente = numLinhaCliente;
	}

	public Long getPlanoCliente() {
		return planoCliente;
	}

	public void setPlanoCliente(Long planoCliente) {
		this.planoCliente = planoCliente;
	}

	@Override
	public String toString() {
		return "Cliente [idCliente= " + idCliente + ", nomeCliente= " + nomeCliente + ", emailCliente= " + emailCliente
				+ ", dataCadCliente= " + dataCadCliente + ", numLinhaCiente= " + numLinhaCliente + ", planoCliente=  "
				+ planoCliente + "]";
	}

}
