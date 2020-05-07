package com.frotas.web.domain.enums;

import java.util.ArrayList;
import java.util.List;

public enum Combustivel {
	ETANOL(1, "Etanol"), DIESEL(2, "Diesel"), GASNATURALVEICULAR(3, "Gás Natural Veicular"),
	GASOLINAADITIVADA(4, "Gasolina Aditivada"), GASOLINACOMUM(5, "Gasolina comum");

	private int cod;
	private String descricao;

	private Combustivel(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public int getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}

	public static Combustivel toEnum(Integer cod) {
		if (cod == null) {
			return null;
		}
		for (Combustivel x : Combustivel.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}
		throw new IllegalArgumentException("Id invalido: " + cod);
	}

	public static List<Combustivel> getEnum() {
		List<Combustivel> lista = new ArrayList<>();
		for (Combustivel x : Combustivel.values()) {
			lista.add(x);
		}
		return lista;
	}
}
