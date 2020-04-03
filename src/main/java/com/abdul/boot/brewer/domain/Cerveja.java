package com.abdul.boot.brewer.domain;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

@Entity
@Table(name = "cerveja")
public class Cerveja {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;

	@Pattern(regexp = "([a-zA-Z]{2}\\d{4})?", message = "SKU deve seguir o padrao XX9999")
	@NotBlank (message = "SKU é obrigatório")
	private String sku;

	@NotBlank (message = "Nome é obrigatório")
	private String nome;

	@NotBlank (message = "A descrição é obrigatória")
	@Size(min = 1, max = 50, message = "O tamanho da descrição deve estar entre {min} e {max}")
	private String descricao;

	@NotNull (message = "O valor é obrigatório")
	@DecimalMin("0.50")
	@DecimalMax(value = "9999999.99", message = "O valor da cerveja deve ser no máximo 999.999.99 MZN")
	@NumberFormat(style = Style.CURRENCY, pattern = "#,##0.00")
	private BigDecimal valor;

	@NotNull (message = "O teor alcóolico é obrigatório")
	@DecimalMax(value = "100.00", message = "O valor do teor alcóolico deve ser no máximo de 100")
	@NumberFormat(style = Style.CURRENCY, pattern = "#,##0.00")
	@Column(name = "teor_alcoolico")
	private BigDecimal teorAlcoolico;

	@NotNull (message = "A comissão é obrigatória")	
	@DecimalMax(value = "100.00", message = "O valor da comissão deve ser no máximo de 100")
	@NumberFormat(style = Style.CURRENCY, pattern = "#,##0.00")
	private BigDecimal comissao;

	@NotNull (message = "A quantidade em estoque é obrigatória")		
	@Max(value = 9999, message = "O valor maximo de estoque deve ser 9.999")
	@NumberFormat(style = Style.NUMBER, pattern = "#,##0")
	@Column(name = "quantidade_estoque")
	private Integer quantidadeEstoque;
	
	@NotNull (message = "A origem é obrigatória")
	@Enumerated(EnumType.STRING)
	private Origem origem;
	
	@NotNull (message = "O sabor é obrigatório")
	@Enumerated(EnumType.STRING)
	private Sabor sabor;
	
	@NotNull (message = "O estilo é obrigatório")
	@ManyToOne
	@JoinColumn(name = "codigo_estilo")
	private Estilo estilo;
	
	
	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public BigDecimal getTeorAlcoolico() {
		return teorAlcoolico;
	}

	public void setTeorAlcoolico(BigDecimal teorAlcoolico) {
		this.teorAlcoolico = teorAlcoolico;
	}

	public BigDecimal getComissao() {
		return comissao;
	}

	public void setComissao(BigDecimal comissao) {
		this.comissao = comissao;
	}

	public Integer getQuantidadeEstoque() {
		return quantidadeEstoque;
	}

	public void setQuantidadeEstoque(Integer quantidadeEstoque) {
		this.quantidadeEstoque = quantidadeEstoque;
	}
	
	public boolean isNova() {
		return codigo == null;
	}
	
	
	


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cerveja other = (Cerveja) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

	public Origem getOrigem() {
		return origem;
	}

	public void setOrigem(Origem origem) {
		this.origem = origem;
	}

	public Sabor getSabor() {
		return sabor;
	}

	public void setSabor(Sabor sabor) {
		this.sabor = sabor;
	}

	public Estilo getEstilo() {
		return estilo;
	}

	public void setEstilo(Estilo estilo) {
		this.estilo = estilo;
	}

}