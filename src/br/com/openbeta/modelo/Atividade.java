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
@Table(name = "atividade")

public class Atividade implements Serializable {
    
    private     Integer         id_atividade;
    private     String          tipo_atividade;
    private     Set<Pessoa>     pessoa = new HashSet<Pessoa>(0);

    public Atividade() {
    }
            
    //getters e setters
    @Id
    @GeneratedValue
    @Column(name = "id_atividade", unique = true, nullable = false)
    public Integer getid_atividade() {
        return this.id_atividade;
    }

    public void setid_atividade(Integer id_atividade) {
        this.id_atividade = id_atividade;
    }
    
    @Column(name = "tipo_atividade", unique = true, nullable = false)
    public String gettipo_atividade() {
        return this.tipo_atividade;
    }

    public void settipo_atividade(String tipo_atividade) {
        this.tipo_atividade = tipo_atividade;
    }
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "atividade")
    public Set<Pessoa> getPessoa() {
        return this.pessoa;
    }
    
    public void setPessoa(Set<Pessoa> pessoa) {
        this.pessoa = pessoa;
    }
   
}
