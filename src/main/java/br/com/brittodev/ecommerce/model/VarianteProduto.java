package br.com.brittodev.ecommerce.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_variante_produto")
public class VarianteProduto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_variante")
	private Integer id;
	
	@Column(name = "nome_variante", length = 45, nullable = false)
	private String nomeVariante;
	
	@Column(name = "descricao_variante", columnDefinition = "TEXT")
	private String descricaoVariante;
	
	@Column(name = "link_foto", length = 255)
	private String linkFoto;
	
	@JsonIgnoreProperties("variantes")
	@ManyToOne
	@JoinColumn(name = "tb_produto_id_produto")
	private Produto produto;
	
	@OneToMany
	@JoinColumn(name = "")
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomeVariante() {
		return nomeVariante;
	}

	public void setNomeVariante(String nomeVariante) {
		this.nomeVariante = nomeVariante;
	}

	public String getDescricaoVariante() {
		return descricaoVariante;
	}

	public void setDescricaoVariante(String descricaoVariante) {
		this.descricaoVariante = descricaoVariante;
	}

	public String getLinkFoto() {
		return linkFoto;
	}

	public void setLinkFoto(String linkFoto) {
		this.linkFoto = linkFoto;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	

	@Override
	public String toString() {
		return "VarianteProduto [id=" + id + ", nomeVariante=" + nomeVariante + ", descricaoVariante="
				+ descricaoVariante + ", linkFoto=" + linkFoto + ", produto=" + produto + "]";
	}
	
	
}
