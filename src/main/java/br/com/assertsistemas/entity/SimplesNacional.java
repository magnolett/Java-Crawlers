package br.com.assertsistemas.entity;

import java.math.BigDecimal;

public class SimplesNacional {

	private Long id;

	private Double receitaMinima;
	
	private Double receitaMaxima;

	private BigDecimal aliquota;

	private BigDecimal irpj;

	private BigDecimal csll;

	private BigDecimal cofins;

	private BigDecimal pasep;

	private BigDecimal cpp;

	private BigDecimal icms;

	private BigDecimal ipi;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getReceitaMinima() {
		return receitaMinima;
	}

	public void setReceitaMinima(Double receitaMinima) {
		this.receitaMinima = receitaMinima;
	}

	public Double getReceitaMaxima() {
		return receitaMaxima;
	}

	public void setReceitaMaxima(Double receitaMaxima) {
		this.receitaMaxima = receitaMaxima;
	}

	public BigDecimal getAliquota() {
		return aliquota;
	}

	public void setAliquota(BigDecimal aliquota) {
		this.aliquota = aliquota;
	}

	public BigDecimal getIrpj() {
		return irpj;
	}

	public void setIrpj(BigDecimal irpj) {
		this.irpj = irpj;
	}

	public BigDecimal getCsll() {
		return csll;
	}

	public void setCsll(BigDecimal csll) {
		this.csll = csll;
	}

	public BigDecimal getCofins() {
		return cofins;
	}

	public void setCofins(BigDecimal cofins) {
		this.cofins = cofins;
	}

	public BigDecimal getPasep() {
		return pasep;
	}

	public void setPasep(BigDecimal pasep) {
		this.pasep = pasep;
	}

	public BigDecimal getCpp() {
		return cpp;
	}

	public void setCpp(BigDecimal cpp) {
		this.cpp = cpp;
	}

	public BigDecimal getIcms() {
		return icms;
	}

	public void setIcms(BigDecimal icms) {
		this.icms = icms;
	}

	public BigDecimal getIpi() {
		return ipi;
	}

	public void setIpi(BigDecimal ipi) {
		this.ipi = ipi;
	}
	
	@Override
	public String toString() {
		return "SimplesNacional [id=" + id + ", receitaMinima=" + receitaMinima + ", receitaMaxima=" + receitaMaxima
				+ ", aliquota=" + aliquota + ", irpj=" + irpj + ", csll=" + csll + ", cofins=" + cofins + ", pasep="
				+ pasep + ", cpp=" + cpp + ", icms=" + icms + ", ipi=" + ipi + "]";
	}

}
