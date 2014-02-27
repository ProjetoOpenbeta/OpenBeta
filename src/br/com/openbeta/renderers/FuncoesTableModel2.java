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

import br.com.openbeta.modelo.Funcao;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Vinicius_Pedron
 */
public class FuncoesTableModel2 extends AbstractTableModel{

    private List<Funcao> list = new ArrayList<Funcao>();

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return 4; 
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0:
                return list.get(rowIndex).getCargo().getnome_cargo();
            case 1:
                return list.get(rowIndex).getSetor().getNome_setor();
            case 2:
                return list.get(rowIndex).getSubSetor().getNome_sub_setor();
            case 3:
                return list.get(rowIndex).getTurno().getTurno();
            default:
                return "";
        }
    }

    @Override
    public String getColumnName(int column) {
        switch(column){
            case 0:
                return "Cargo";
            case 1:
                return "Setor";
            case 2:
                return "Sub-setor";
            case 3:
                return "Turno";
            default:
                return "";
         }
    }
    
    public void addFuncao(Funcao funcao){
        list.add(funcao);
        fireTableDataChanged();
    }
    
    public void addAllFuncao(List<Funcao> funcoes){
        list.addAll(funcoes);
        fireTableDataChanged();
    }
    
    public void limparTabela() {
        list.clear();
        fireTableDataChanged();
    }
    
    public List<Funcao> getFuncoes() {
        return list;
    }
}
