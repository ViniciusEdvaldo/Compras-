package model;

import java.util.List;

import javax.swing.table.AbstractTableModel;

public class ModeloTabelaProduto extends AbstractTableModel{
	
	
	private List<Produto> produtos;

	public ModeloTabelaProduto(List<Produto> produtos) {  //construtor. 
		super();
		this.produtos = produtos;
	}
	
	
	private static final String[] colunas = {  //vetor para definir as colunas da tabela.
			"Codigo", "Nome", "Valor"
	};

	@Override
	public int getRowCount() {  //metodo que define a quantidade de linhas na tabela.
		return produtos.size();
	}

	@Override
	public int getColumnCount() {  //metodo que define a quantidade de colunas na tabela,
		return colunas.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Produto prod = produtos.get(rowIndex);  //instancia de produto para pegar o conteudo de cada registro do db.
		
		if(columnIndex == 0) {    
			return prod.getCodigo();
		}else if(columnIndex == 1) {
			return prod.getNome();
		}else if(columnIndex == 2) {
			return prod.getValor();
		}else {
			return null;
		}   //sequencia de if e else para pegar o valor de cada coluna do registro da tabela.
	
	}

	
	public String getColumnName(int column) {  //metodo para deixar os nomes das colunas corretos na tabela.
		return colunas[column];
	}
}
