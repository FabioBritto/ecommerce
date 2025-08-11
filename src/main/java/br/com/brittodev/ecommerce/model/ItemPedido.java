package br.com.brittodev.ecommerce.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_item_pedido")
public class ItemPedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "num_sequencial")
	private Integer numSequencial;
	
	@Column(name = "valor_unitario")
	private Double valorUnitario;
	
	@Column(name = "quantidade")
	private Integer quantidade;
	
	@Column(name = "valor_total")
	private Double valorTotal;

	@JsonIgnoreProperties("itens")
	@ManyToOne
	@JoinColumn(name = "tb_pedido_num_pedido")
	private Pedido pedido;
	
	@ManyToOne
	@JoinColumn(name = "tb_variante_produto_id_variante")
	private VarianteProduto variante;

	public Integer getNumSequencial() {
		return numSequencial;
	}

	public void setNumSequencial(Integer numSequencial) {
		this.numSequencial = numSequencial;
	}

	public Double getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(Double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public VarianteProduto getVariante() {
		return variante;
	}

	public void setVariante(VarianteProduto variante) {
		this.variante = variante;
	}
	
	
}
