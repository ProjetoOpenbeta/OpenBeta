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
@Table(name = "situacao")

public class Situacao implements Serializable {
    
    private Integer id_situacao;
    private String  tipo_situacao;
    private Set<Pessoa> pessoas = new HashSet<Pessoa>(0);

    public Situacao() {
    }
    
    @Id
    @GeneratedValue
    @Column(name = "id_situacao", unique = true, nullable = false)
    public Integer getId_situacao() {
        return this.id_situacao;
    }

    public void setId_situacao(Integer id_situacao) {
        this.id_situacao = id_situacao;
    }
    
    @Column(name = "tipo_situacao", unique = true, nullable = false)
    public String getTipo_situacao() {
        return this.tipo_situacao;
    }

    public void setTipo_situacao(String tipo_situacao) {
        this.tipo_situacao = tipo_situacao;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "situacao")
    public Set<Pessoa> getPessoas() {
        return this.pessoas;
    }

    public void setPessoas(Set<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }


}
