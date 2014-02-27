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
@Table(name = "tipo_graduacao")

public class TipoGraduacao implements Serializable {
    
    private Integer id_tipo_graduacao;
    private String  tipo_graduacao;
    private Set<Graduacao> graduacoes = new HashSet<Graduacao>(0);
    
    public TipoGraduacao() {
        
    }
    
    @Id
    @GeneratedValue
    @Column(name = "id_tipo_graduacao", unique = true, nullable = false)
    public Integer getId_tipo_graduacao() {
        return this.id_tipo_graduacao;
    }

    public void setId_tipo_graduacao(Integer id_tipo_graduacao) {
        this.id_tipo_graduacao = id_tipo_graduacao;
    }
    
    @Column(name = "tipo_graduacao")
    public String getTipo_graduacao() {
        return this.tipo_graduacao;
    }

    public void setTipo_graduacao(String tipo_graduacao) {
        this.tipo_graduacao = tipo_graduacao;
    }
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "tipo_graduacao")
    public Set<Graduacao> getGraduacoes() {
        return this.graduacoes;
    }

    public void setGraduacoes(Set<Graduacao> graduacoes) {
        this.graduacoes = graduacoes;
    }  
}
