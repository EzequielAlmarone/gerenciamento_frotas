package com.frotas.web.services;

import java.util.List;

import com.frotas.web.domain.Categoria;

public interface CategoriaService {
	void save(Categoria categoria);
	void update(Categoria categoria);
	void delete(Long id);
	Categoria findById(Long id);
	List<Categoria> findAll();
}
