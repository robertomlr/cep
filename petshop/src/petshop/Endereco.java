package petshop;

import com.google.gson.annotations.SerializedName;

public class Endereco {
	@SerializedName("cep")
	private static String cep;
	@SerializedName("logradouro")
	private static String logradouro;
	@SerializedName("complemento")
	private static String complemento;
	@SerializedName("bairro")
	private static String bairro;
	@SerializedName("localidade")
	private static String localidade;
	@SerializedName("uf")
	private static String uf;
	@SerializedName("unidade")
	private static String unidade;
	@SerializedName("ibge")
	private static String ibge;
	@SerializedName("guia")
	private static String guia;

	public static String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public static String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public static String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public static String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public static String getLocalidade() {
		return localidade;
	}

	public void setLocalidade(String localidade) {
		this.localidade = localidade;
	}

	public static String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public static String getUnidade() {
		return unidade;
	}

	public void setUnidade(String unidade) {
		this.unidade = unidade;
	}

	public static String getIbge() {
		return ibge;
	}

	public void setIbge(String ibge) {
		this.ibge = ibge;
	}

	public static String getGuia() {
		return guia;
	}

	public void setGuia(String guia) {
		this.guia = guia;
	}

	@Override
	public String toString() {
		return "Endereco{" + "cep='" + cep + '\'' + ", logradouro='" + logradouro + ", complemento='" + complemento
				+ '\'' + ", bairro='" + bairro + '\'' + ", localidade='" + localidade + '\'' + ", uf='" + uf + '\''
				+ ", unidade='" + unidade + '\'' + ", ibge'=" + ibge + '\'' + ", guia'" + guia + '\'' + '}';
	}

}
