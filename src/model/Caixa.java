package model;

public class Caixa {

	private int id;
	private String nome;
	
	public Caixa(int id, String nome) {
		this.id=id;
		this.nome=nome;
	}
	
	public Caixa(String nome) {
		this.nome =nome;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
