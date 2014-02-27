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

import br.com.openbeta.modelo.Funcao;
import br.com.openbeta.modelo.Cargo;
import br.com.openbeta.modelo.Graduacao;
import br.com.openbeta.modelo.Setor;
import br.com.openbeta.modelo.SubSetor;
import br.com.openbeta.modelo.TipoGraduacao;
import br.com.openbeta.modelo.Turno;

public class FuncoesTableModel extends AbstractTableModel{
	private static final long serialVersionUID = 1L;
	private static final int COL_ID         = 0;
	private static final int COL_CARGO      = 1;
	private static final int COL_SETOR      = 2;
        private static final int COL_SUBSETOR   = 3;
        private static final int COL_TURNO      = 4;

	private List<Funcao>    lista;
        private List<Cargo>     lista2;
        private List<Setor>     lista3;
        private List<SubSetor>  lista4;
        private List<Turno>     lista5;
        
	public FuncoesTableModel(List<Funcao> lista) {
		this.lista = new ArrayList<Funcao>(lista);
	}
        
       public FuncoesTableModel() {
		this.lista = new ArrayList<Funcao>();
	}
        
   	@Override
	public Class<?> getColumnClass(int columnIndex) {
		return getValueAt(0, columnIndex).getClass();
	}
	
//	@Override
//	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
//		Funcao      funcao      = lista.get(rowIndex); 
//                Cargo       cargo       = lista2.get(rowIndex);
//                Setor       setor       = lista3.get(rowIndex);
//                SubSetor    sub_setor   = lista4.get(rowIndex);
//                Turno       turno       = lista5.get(rowIndex);
//                
//		if(columnIndex == COL_ID){
//                    funcao.setId_funcao((Integer) aValue);			 
//		}
//		
//                if(columnIndex == COL_CARGO){
//                    cargo.setid_cargo((Integer) aValue);
//                    funcao.setCargo(cargo);
//                }    
//                
//                if(columnIndex == COL_SETOR){
//                    setor.setId_setor((Integer) aValue);
//                    funcao.setSetor(setor);
//                }
//                
//		if(columnIndex == COL_SUBSETOR){
//                    sub_setor.setId_sub_setor((Integer) aValue);
//                    funcao.setSubSetor(sub_setor); 
//		 }
//
//                if(columnIndex == COL_TURNO){
//                    turno.setId_turno((Integer) aValue);
//                    funcao.setTurno(turno);
//		 }
//                
//		fireTableDataChanged();
//	}
	
//	@Override
//	public boolean isCellEditable(int rowIndex, int columnIndex) {
//		 if((columnIndex == COL_CARGO) || (columnIndex == COL_SETOR) || (columnIndex == COL_SUBSETOR) || (columnIndex == COL_TURNO)){
//                    return false;
//		 }else{
//                    return false;
//		 }
//	}
	
	@Override
        public String getColumnName(int columnIndex){
            switch(columnIndex) {
                case COL_ID:
                    return "Código";
            }
            if(columnIndex == COL_ID){
                    return "Código";
            }else if(columnIndex == COL_CARGO){
                    return "Função";

            }else if (columnIndex == COL_SETOR){
                    return "Setor ou Curso";

            }else if (columnIndex == COL_SUBSETOR){
                    return "Sub-setor ou Disciplina";

            } else if (columnIndex == COL_TURNO){
                    return "Turno";
            }

            return "Indice de coluna inválido"; 
    }
	@Override
	public int getColumnCount() {
            return 5;
	}

	@Override
	public int getRowCount() {	
            return lista.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Funcao funcao = lista.get(rowIndex); 
                
		 if(columnIndex == COL_ID){
			 return funcao.getId_funcao();
			 
		 } else if(columnIndex == COL_CARGO){
                         EAO eao = new EAO(Cargo.class);  
			 Cargo c = (Cargo)eao.consulta(funcao.getCargo().getid_cargo());
                         return c.getnome_cargo();
                         
		 } else if (columnIndex == COL_SETOR){
			 EAO eao = new EAO(Setor.class);  
			 Setor s = (Setor)eao.consulta(funcao.getSetor().getId_setor());
                         return s.getNome_setor();
                         
		 } else if (columnIndex == COL_SUBSETOR){
			 EAO eao = new EAO(SubSetor.class);  
			 SubSetor ss = (SubSetor)eao.consulta(funcao.getSubSetor().getId_sub_setor());
                         return ss.getNome_sub_setor();
                 
                 } else if (columnIndex == COL_TURNO){
                         EAO eao = new EAO(Turno.class);  
			 Turno t = (Turno)eao.consulta(funcao.getTurno().getId_turno());
                         return t.getTurno();
                 }
                         
		 return "Não encontrou a coluna";
	}
        
        public List<Funcao> getFuncaoLista() {
            return this.lista;
        }

        public List<Cargo> getCargoLista() {
            return this.lista2;
        }

        public List<Setor> lista3() {
            return this.lista3;
        }
        
        public List<SubSetor> lista4() {
            return this.lista4;
        }

        public List<Turno> lista5() {
            return this.lista5;
        }

}			