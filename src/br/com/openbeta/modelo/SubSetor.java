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

package br.com.openbeta.modelo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name = "sub_setor")

public class SubSetor implements Serializable{
    
    private Integer id_sub_setor;
    private String  nome_sub_setor;
    private Set<Funcao> funcoes = new HashSet<Funcao>(0);
    
    public SubSetor() {
        
    }
    
    @Id
    @GeneratedValue
    @Column(name = "id_sub_setor")

    public Integer getId_sub_setor() {
        return this.id_sub_setor;
    }

    public void setId_sub_setor(Integer id_sub_setor) {
        this.id_sub_setor = id_sub_setor;
    }
    
    @Column(name = "nome_sub_setor")
    public String getNome_sub_setor() {
        return this.nome_sub_setor;
    }

    public void setNome_sub_setor(String nome_sub_setor) {
        this.nome_sub_setor = nome_sub_setor;
    }
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "sub_setor")
    public Set<Funcao> getFuncoes() {
        return this.funcoes;
    }

    public void setFuncoes(Set<Funcao> funcoes) {
        this.funcoes = funcoes;
    }
     
}
