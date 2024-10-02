package model;

import javax.swing.table.AbstractTableModel;

import java.util.List;

//cria um modelo para a tabela de valor total.  (ja esta explicando como funciona em "ModeloTabelaProduto").

public class ModeloTabelaValorTotal extends AbstractTableModel{

	private List<Double> valores;
	
	public ModeloTabelaValorTotal(List<Double> valores) {
		super();
		this.valores = valores;
	}
	

	private static final String[] colunas = {
			"VALOR TOTAL:"
	};
	
	
	public int getRowCount() {
		return valores.size();
	}

	@Override
	public int getColumnCount() {
		return colunas.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		
		if(columnIndex == 0)
			return valores.get(0);
		else
			return null;
	}

	public String getColumnName(int column) { 
		return colunas[column];
	}
}
