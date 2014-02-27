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

import br.com.openbeta.modelo.Graduacao;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Vinicius_Pedron
 */
public class GraduacoesTableModel2 extends AbstractTableModel{

    private List<Graduacao> list = new ArrayList<Graduacao>();

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return 3; 
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0:
                return list.get(rowIndex).getTipo_graduacao().getTipo_graduacao();
            case 1:
                return list.get(rowIndex).getInstituicao();
            case 2:
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                return dateFormat.format(list.get(rowIndex).getData_conclusao());
            default:
                return "";
        }
    }

    @Override
    public String getColumnName(int column) {
        switch(column){
            case 0:
                return "Tipo de graduação";
            case 1:
                return "Instituição";
            case 2:
                return "Data de conclusão";
            default:
                return "";
         }
    }
    
    public void addGraduacao(Graduacao graduacao){
        list.add(graduacao);
        fireTableDataChanged();
    }
    
    public void addAllGraduacao(List<Graduacao> graduacoes){
        list.addAll(graduacoes);
        fireTableDataChanged();
    }
    
    public void limparTabela() {
        list.clear();
        fireTableDataChanged();
    }
    
    public List<Graduacao> getGradoacoes() {
        return list;
    }
}
