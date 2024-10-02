package model;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class ModeloTabelaNotaFiscal extends AbstractTableModel{
	
	private List<NotaFiscal> notas;
	
	public ModeloTabelaNotaFiscal(List<NotaFiscal> notas) {
		super();
		this.notas = notas;
		
	}

	private static final String[] colunas = {
			"codigo", "valorTotal", "hora", "dia", "cnpj", "idCompra", "formaDePagamento"
	};
	
	@Override
	public int getRowCount() {
		return notas.size();
	}

	@Override
	public int getColumnCount() {
		return colunas.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		NotaFiscal notaFiscal = notas.get(rowIndex);
		
		if(columnIndex == 0) {
			return notaFiscal.getCodigo();
		}else if(columnIndex == 1) {
			return notaFiscal.getValorTotal();
		}else if(columnIndex == 2) {
			return notaFiscal.getHora();
		}else if(columnIndex == 3) {
			return notaFiscal.getDia();
		}else if(columnIndex == 4) {
			return notaFiscal.getCnpj();
		}else if(columnIndex == 5) {
			return notaFiscal.getIdCompra();
		}else if(columnIndex == 6) {
			return notaFiscal.getFormaDePagamento();
		}else {
			return null;

		}
	}
	
	public String getColumnName(int column) {
		return colunas[column];
	}

}
