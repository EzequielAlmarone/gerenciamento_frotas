package com.frotas.web.services;

import java.util.List;
import com.frotas.web.domain.Fipe;

public interface FipeService {
	void save(Fipe fipe);
	void update(Fipe fipe);
	void delete(Long id);
	Fipe findById(Long id);
	List<Fipe> findAll();
}
