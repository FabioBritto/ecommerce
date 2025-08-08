package br.com.brittodev.ecommerce.service.variante;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.brittodev.ecommerce.dao.VarianteProdutoDAO;
import br.com.brittodev.ecommerce.model.Produto;
import br.com.brittodev.ecommerce.model.VarianteProduto;

@Component
public class VarianteProdutoServiceImpl implements IVarianteProdutoService {

	@Autowired
	private VarianteProdutoDAO varianteDAO;	
	
	@Override
	public VarianteProduto create(VarianteProduto variante) {
		return varianteDAO.save(variante);
	}

	@Override
	public VarianteProduto update(VarianteProduto variante) {
		return varianteDAO.save(variante);
	}

	@Override
	public List<VarianteProduto> findByProduto(Produto produto) {
		return varianteDAO.findByProduto(produto);
	}

	@Override
	public VarianteProduto findById(Integer id) {
		return varianteDAO.findById(id).orElse(null);
	}

}
