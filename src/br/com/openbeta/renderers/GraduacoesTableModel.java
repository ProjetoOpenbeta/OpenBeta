/*
 Copyright 2013 Vinicius Vasco Pedron, Luiz Gustavo Royer, Gelson Lemes,
    João Ricardo Oliveira, Hélio Campos, Maycon Willian Nunes Prestes
*/

/*
   Este arquivo é parte do programa OpenBeta

    OpenBeta é um software livre; você pode redistribuí-lo e/ou 
    modificá-lo dentro dos termos da Licença Pública Geral GNU como 
    publicada pela Fundação do Software Livre (FSF); na versão 2 da 
    Licença, ou (na sua opinião) qualquer versão.

    Este programa é distribuído na esperança de que possa ser  útil, 
    mas SEM NENHUMA GARANTIA; sem uma garantia implícita de ADEQUAÇÃO a qualquer
    MERCADO ou APLICAÇÃO EM PARTICULAR. Veja a
    Licença Pública Geral GNU para maiores detalhes.

    Você deve ter recebido uma cópia da Licença Pública Geral GNU
    junto com este programa, se não, escreva para a Fundação do Software
    Livre(FSF) Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
*/

package br.com.openbeta.renderers;

import br.com.openbeta.controle.EAO;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import br.com.openbeta.modelo.Graduacao;
import br.com.openbeta.modelo.TipoGraduacao;
import java.text.DateFormat;
import java.util.Date;

public class GraduacoesTableModel extends AbstractTableModel{
	private static final long serialVersionUID = 1L;
	private static final int COL_ID = 0;
	private static final int COL_GRADUACAO = 1;
	private static final int COL_CURSO    = 2;
        private static final int COL_DATA   = 3;

	private List<Graduacao>     lista;
        private List<TipoGraduacao> lista2;
        
	public GraduacoesTableModel(List<Graduacao> lista) {
            this.lista = new ArrayList<Graduacao>(lista);
	}
        
       public GraduacoesTableModel() {
            this.lista = new ArrayList<Graduacao>();
	}
        
   	@Override
	public Class<?> getColumnClass(int columnIndex) {
		return getValueAt(0, columnIndex).getClass();
	}
	
	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		Graduacao graduacao = lista.get(rowIndex); 
                TipoGraduacao tipo_graduacao = lista2.get(rowIndex);
                
		if(columnIndex == COL_ID){
                    graduacao.setid_graduacao((Integer) aValue);			 
		}
		
                if(columnIndex == COL_GRADUACAO){
                    tipo_graduacao.setId_tipo_graduacao((Integer) aValue);
                    graduacao.setTipo_graduacao(tipo_graduacao);
                }    
                
                if(columnIndex == COL_CURSO){
                    graduacao.setInstituicao(aValue.toString());	 
                }
                
		if(columnIndex == COL_DATA){
                    graduacao.setData_conclusao((Date)aValue);	 
		 }
		
		fireTableDataChanged();
	}
	
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		 if((columnIndex == COL_GRADUACAO) || (columnIndex == COL_CURSO) || (columnIndex == COL_DATA)){
                    return false;
		 }else{
                    return false;
		 }
	}
	
	@Override
        public String getColumnName(int columnIndex){
		 if(columnIndex == COL_ID){
			 return "Código";
			 
		 }else if(columnIndex == COL_GRADUACAO){
			 return "Graduação";
			 
		 }else if (columnIndex == COL_CURSO){
			 return "Instituição / Curso";
                         
		 }else if (columnIndex == COL_DATA){
			 return "Data de Conclusão";
		 }
                 
                 return "Indice de coluna inválido"; 
    }
	@Override
	public int getColumnCount() {
            return 4;
	}

	@Override
	public int getRowCount() {	
            return lista.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
            Graduacao graduacao = lista.get(rowIndex); 

            if(columnIndex == COL_ID){
                    return graduacao.getid_graduacao();

            } else if(columnIndex == COL_GRADUACAO){
                   EAO eao = new EAO(TipoGraduacao.class);    
                   TipoGraduacao g = (TipoGraduacao)eao.consulta(graduacao.getTipo_graduacao().getId_tipo_graduacao());
                   return g.getTipo_graduacao();

            } else if (columnIndex == COL_CURSO){
                    return graduacao.getInstituicao();

            } else if (columnIndex == COL_DATA){
                   Date data = graduacao.getData_conclusao();
                   DateFormat formata = DateFormat.getDateInstance();
                   String resultado = formata.format(data);

                  return resultado;
            }

            return "Não encontrou a coluna";
	}
        
        public List<Graduacao> getGraduacaoLista() {
            return this.lista;
        }

        public List<TipoGraduacao> getTipoGraduacaoLista() {
            return this.lista2;
        }
}
