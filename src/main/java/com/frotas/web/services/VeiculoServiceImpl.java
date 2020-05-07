package com.frotas.web.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.frotas.web.domain.Veiculo;
import com.frotas.web.repository.VeiculoDAO;
@Service @Transactional(readOnly = false)
public class VeiculoServiceImpl implements VeiculoService {
	@Autowired
	private VeiculoDAO dao;
	@Override
	public void save(Veiculo veiculo) {
		dao.save(veiculo);
	}

	@Override
	public void update(Veiculo veiculo) {
		dao.update(veiculo);	
	}

	@Override
	public void delete(Long id) {
		dao.delete(id);		
	}
	
	@Override @Transactional(readOnly = true)
	public Veiculo findById(Long id) {
		return dao.findById(id);
	}

	@Override @Transactional(readOnly = true)
	public List<Veiculo> findAll() {
		return dao.findAll();
	}

}
