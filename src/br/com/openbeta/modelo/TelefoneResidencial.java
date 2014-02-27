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
@Table(name = "telefone_residencial")

public class TelefoneResidencial implements Serializable {
    
    private Integer id_telefone;
    private String  telefone_res;
    private Set<TelefoneResidencialPessoa> telefone_residencial_pessoas = new HashSet<>();
    
    public TelefoneResidencial() {
    }
    
    @Id
    @GeneratedValue
    @Column(name = "id_telefone", unique = true, nullable = false)
    public Integer getId_telefone() {
        return this.id_telefone;
    }

    public void setId_telefone(Integer id_telefone) {
        this.id_telefone = id_telefone;
    }
    
    @Column(name = "telefone_res")
    public String getTelefone_res() {
        return this.telefone_res;
    }

    public void setTelefone_res(String telefone_res) {
        this.telefone_res = telefone_res;
    }
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "telefone_residencial")
    public Set<TelefoneResidencialPessoa> getTelefone_residencial_pessoas() {
        return this.telefone_residencial_pessoas;
    }

    public void setTelefone_residencial_pessoas(Set<TelefoneResidencialPessoa> telefone_residencial_pessoas) {
        this.telefone_residencial_pessoas = telefone_residencial_pessoas;
    }
    
}
