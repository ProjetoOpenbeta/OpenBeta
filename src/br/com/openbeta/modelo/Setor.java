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
@Table(name = "setor")

public class Setor implements Serializable{
    
    private Integer id_setor;
    private String  nome_setor;
    private Set<Funcao> funcoes = new HashSet<Funcao>(0);
    
    public Setor() {
        
    }
    
    @Id
    @GeneratedValue
    @Column(name = "id_setor", unique = true, nullable = false)
    public Integer getId_setor() {
        return this.id_setor;
    }

    public void setId_setor(Integer id_setor) {
        this.id_setor = id_setor;
    }
    
    @Column(name = "nome_setor")
    public String getNome_setor() {
        return this.nome_setor;
    }

    public void setNome_setor(String nome_setor) {
        this.nome_setor = nome_setor;
    }
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "setor")
    public Set<Funcao> getFuncoes() {
        return this.funcoes;
    }

    public void setFuncoes(Set<Funcao> funcoes) {
        this.funcoes = funcoes;
    }
    
}
