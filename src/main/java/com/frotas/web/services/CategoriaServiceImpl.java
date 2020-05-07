package com.frotas.web.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.frotas.web.domain.Categoria;
import com.frotas.web.repository.CategoriaDAO;
@Service @Transactional(readOnly = false)
public class CategoriaServiceImpl implements CategoriaService {
	@Autowired
	private CategoriaDAO dao;

	@Override
	public void save(Categoria categoria) {
		dao.save(categoria);
		
	}

	@Override
	public void update(Categoria categoria) {
		dao.update(categoria);
		
	}

	@Override
	public void delete(Long id) {
		dao.delete(id);
		
	}

	@Override @Transactional(readOnly = true)
	public Categoria findById(Long id) {
		return dao.findById(id);
	}

	@Override @Transactional(readOnly = true)
	public List<Categoria> findAll() {
		return dao.findAll();
	}

	@Override
	public boolean categoriaTemVeiculo(Long id) {
		if(findById(id).getVeiculos().isEmpty()){
			return false; // não tem veiculo cadastrado na categoria pesquisada
		}
		return true; // tem veiculo cadastrado na categoria pesquisada
	}
}
