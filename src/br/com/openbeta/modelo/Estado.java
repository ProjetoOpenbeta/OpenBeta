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
@Table(name = "estado")
        
public class Estado implements Serializable {
    
    private Integer id_estado;
    private String  nome_estado;
    private String  nome_estado_inteiro;
    private Set<Pessoa> pessoas = new HashSet<Pessoa>(0);
    private Set<Endereco> enderecos = new HashSet<Endereco>(0);
    
    public Estado() {
    }
    
    @Id
    @GeneratedValue
    @Column(name = "id_estado", unique = true, nullable = false)
    public Integer getId_estado() {
        return this.id_estado;
    }

    public void setId_estado(Integer id_estado) {
        this.id_estado = id_estado;
    }
    
    @Column(name = "nome_estado")
    public String getNome_estado() {
        return this.nome_estado;
    }

    public void setNome_estado(String nome_estado) {
        this.nome_estado = nome_estado;
    }
    
    @Column(name = "nome_estado_inteiro")
    public String getNome_estado_inteiro() {
        return this.nome_estado_inteiro;
    }

    public void setNome_estado_inteiro(String nome_estado_inteiro) {
        this.nome_estado_inteiro = nome_estado_inteiro;
    }
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "estado")
    public Set<Pessoa> getPessoas() {
        return this.pessoas;
    }

    public void setPessoas(Set<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "estado")
    public Set<Endereco> getEnderecos() {
        return this.enderecos;
    }

    public void setEnderecos(Set<Endereco> enderecos) {
        this.enderecos = enderecos;
    }
}
