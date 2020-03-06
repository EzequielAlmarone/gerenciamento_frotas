package com.frotas.web.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Entity
public class Veiculo extends AbstractEntity<Long> {
	
	@Column(nullable = false, length = 20)
	private String ano;
	@Column(nullable = false, length = 20)
	private String placa;
	@Column(nullable = false, length = 30)
	private String renavam;
	@Column(nullable = false, length = 20)
	private String patrimonio;
	@Column(nullable = false, unique = true, length = 120)
	private String chassi;
	@Column(name = "capacidade_tanque", nullable = false, length = 10)
	private Integer capacidadeTanque;
	@Column(name = "tipo_combustivel", nullable = false, length = 70)
	private String tipoCombustivivel;
	@ManyToOne
	@JoinColumn(name = "id_fipe_pk")
	private Fipe fipe;
	@ManyToOne
	@JoinColumn(name = "id_categoria_pk")
	private Categoria categoria;

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getRenavam() {
		return renavam;
	}

	public void setRenavam(String renavam) {
		this.renavam = renavam;
	}

	public String getPatrimonio() {
		return patrimonio;
	}

	public void setPatrimonio(String patrimonio) {
		this.patrimonio = patrimonio;
	}

	public String getChassi() {
		return chassi;
	}

	public void setChassi(String chassi) {
		this.chassi = chassi;
	}

	public Integer getCapacidadeTanque() {
		return capacidadeTanque;
	}

	public void setCapacidadeTanque(Integer capacidadeTanque) {
		this.capacidadeTanque = capacidadeTanque;
	}

	public String getTipoCombustivivel() {
		return tipoCombustivivel;
	}

	public void setTipoCombustivivel(String tipoCombustivivel) {
		this.tipoCombustivivel = tipoCombustivivel;
	}

	public Fipe getFipe() {
		return fipe;
	}

	public void setFipe(Fipe fipe) {
		this.fipe = fipe;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

}
