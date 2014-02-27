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
@Table(name = "estado_civil")

public class EstadoCivil implements Serializable{
    
    private Integer id_estado_civil;
    private String  estado_civil;
    private Set<Pessoa> pessoas = new HashSet<Pessoa>(0);
    
    public EstadoCivil() {
        
    }
    
    @Id
    @GeneratedValue
    @Column(name = "id_estado_civil", unique = true, nullable = false)
    public Integer getId_estado_civil() {
        return this.id_estado_civil;
    }

    public void setId_estado_civil(Integer id_estado_civil) {
        this.id_estado_civil = id_estado_civil;
    }
    
    @Column(name = "estado_civil")
    public String getEstado_civil() {
        return this.estado_civil;
    }

    public void setEstado_civil(String estado_civil) {
        this.estado_civil = estado_civil;
    }
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "estado_civil")
    public Set<Pessoa> getPessoas() {
        return this.pessoas;
    }

    public void setPessoas(Set<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }
    
}
