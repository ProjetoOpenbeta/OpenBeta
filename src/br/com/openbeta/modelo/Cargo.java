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
@Table(name = "cargo")

public class Cargo implements Serializable {
    
    private Integer id_cargo;
    private String  nome_cargo;
    private Set<Funcao> funcao = new HashSet<Funcao>(0);
    
    public Cargo() {
        
    }
    
    @Id
    @GeneratedValue
    @Column(name = "id_cargo", unique = true, nullable = false)
    public Integer getid_cargo() {
        return this.id_cargo;
    }

    public void setid_cargo(Integer id_cargo) {
        this.id_cargo = id_cargo;
    }
    
    @Column(name = "nome_cargo")
    public String getnome_cargo() {
        return this.nome_cargo;
    }

    public void setnome_cargo(String nome_cargo) {
        this.nome_cargo = nome_cargo;
    }
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "cargo")
    public Set<Funcao> getfuncao() {
        return this.funcao;
    }

    public void setFuncao(Set<Funcao> funcao) {
        this.funcao = funcao;
    }
    
}
