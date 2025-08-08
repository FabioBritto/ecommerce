package br.com.brittodev.ecommerce.service.variante;

import java.util.List;

import br.com.brittodev.ecommerce.model.Produto;
import br.com.brittodev.ecommerce.model.VarianteProduto;

public interface IVarianteProdutoService {

	public VarianteProduto create(VarianteProduto variante);
	public VarianteProduto update(VarianteProduto variante);
	public List<VarianteProduto> findByProduto(Produto produto);
	public VarianteProduto findById(Integer id);
}
