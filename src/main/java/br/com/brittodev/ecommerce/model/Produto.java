package br.com.brittodev.ecommerce.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_produto")
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_produto")
	private Integer id;
	
	@Column(name = "nome_produto", length = 45, nullable = false)
	private String nomeProduto;
	
	@Column(name = "descricao_produto", columnDefinition = "TEXT")
	private String descricaoProduto;
	
	@Column(name = "preco_produto")
	private Double precoProduto;
	
	@Column(name = "destaque")
	private Integer destaque;
	
	@Column(name = "disponivel")
	private Integer disponivel;
	
	@ManyToMany
	@JoinTable(name = "tb_categoria_produto",
    joinColumns = @JoinColumn(name = "id_produto"),
    inverseJoinColumns = @JoinColumn( name = "id_categoria"))
	private List<Categoria> categorias;
	
	@OneToMany(mappedBy = "produto", cascade = CascadeType.ALL)
	private List<VarianteProduto> variantes;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public String getDescricaoProduto() {
		return descricaoProduto;
	}

	public void setDescricaoProduto(String descricaoProduto) {
		this.descricaoProduto = descricaoProduto;
	}

	public Double getPrecoProduto() {
		return precoProduto;
	}

	public void setPrecoProduto(Double precoProduto) {
		this.precoProduto = precoProduto;
	}

	public Integer getDestaque() {
		return destaque;
	}

	public void setDestaque(Integer destaque) {
		this.destaque = destaque;
	}

	public Integer getDisponivel() {
		return disponivel;
	}
	
	public void setDisponivel(Integer disponivel) {
		this.disponivel = disponivel;
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}

	public List<VarianteProduto> getVariantes() {
		return variantes;
	}

	public void setVariantes(List<VarianteProduto> variantes) {
		this.variantes = variantes;
	}
	
	
	
}
