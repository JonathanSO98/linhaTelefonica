package br.com.projeto.linhaTelefonica.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.stereotype.Component;
import java.io.Serializable;

/*
 * 
 */

@Entity
@Component
@Table(name = "Plano")
public class Plano implements Serializable {

		private static final long serialVersionUID = -6888542263201514002L;

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long idPlano;

		@Column(name = "nome_plano", nullable = false)
		private String nomePlano;

		@Column(name = "valor_plano", nullable = false)
		private double valorPlano;

		@Column(name = "quant_gb_plano", nullable = false)
		private int quantGbPlano;

		public Plano() {

		}

		public Plano(Long idPlano, String nomePlano, double valorPlano, int quantGbPlano) {
			this.idPlano = idPlano;
			this.nomePlano = nomePlano;
			this.valorPlano = valorPlano;
			this.quantGbPlano = quantGbPlano;
		}

		public Long getIdPlano() {
			return idPlano;
		}

		public void setIdPlano(Long idPlano) {
			this.idPlano = idPlano;
		}

		public String getNomePlano() {
			return nomePlano;
		}

		public void setNomePlano(String nomePlano) {
			this.nomePlano = nomePlano;
		}

		public double getValorPlano() {
			return valorPlano;
		}

		public void setValorPlano(double valorPlano) {
			this.valorPlano = valorPlano;
		}

		public int getQuantGbPlano() {
			return quantGbPlano;
		}

		public void setQuantGbPlano(int quantGbPlano) {
			this.quantGbPlano = quantGbPlano;
		}

		@Override
		public String toString() {
			return "Plano [idPlano= " + idPlano + ", nomePlano= " + nomePlano + ", valorPlano= " + valorPlano
					+ ", quantGbPlano= " + quantGbPlano + "]";
		}
	
}
