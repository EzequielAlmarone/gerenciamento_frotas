package com.frotas.web.repository;

import java.util.List;

import com.frotas.web.domain.Fipe;

public interface FipeDAO{ //
	void save(Fipe fipe);
	void update(Fipe fipe);
	void delete(Long id);
	Fipe findById(Long id);
	List<Fipe> findAll();
}
