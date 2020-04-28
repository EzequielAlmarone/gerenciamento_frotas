package com.frotas.web.domain.enums;

public enum Combustivel {
	GASOLINACOMUM (1, "Gasolina comum"),
	GASOLINAADITIVADA (2, "Gasolina Aditivada"),
	ETANOL (3, "Etanol"),
	DIESEL (4, "Diesel"),
	GASNATURALVEICULAR (5, "Gás Natural Veicular");
	
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
		if(cod == null) {
			return null;
		}
		for(Combustivel x : Combustivel.values()) {
			if(cod.equals(x.getCod())) {
				return x;
			}	
		}
		throw new IllegalArgumentException("Id invalido: " + cod );
	}


	
	
	
	
	
	

}
