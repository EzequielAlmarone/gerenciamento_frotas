package com.frotas.web.services;

import java.util.List;

import com.frotas.web.domain.Veiculo;


public interface VeiculoService {
	void save(Veiculo veiculo);
	void update(Veiculo veiculo);
	void delete(Long id);
	Veiculo findById(Long id);
	List<Veiculo> findAll();
}
