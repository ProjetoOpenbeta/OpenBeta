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
@Table(name = "funcao")

public class Funcao implements Serializable{
    
    private Integer     id_funcao;
    private Cargo       cargo;
    private Setor       setor;
    private SubSetor    subSetor;
    private Turno       turno;
    
    private Set<FuncaoPessoa> funcao_pessoas = new HashSet<FuncaoPessoa>(0);
    
    public Funcao() {
        
    }
    
    @Id
    @GeneratedValue
    @Column(name = "id_pessoa", unique = true, nullable = false)
    public Integer getId_funcao() {
        return this.id_funcao;
    }

    public void setId_funcao(Integer id_funcao) {
        this.id_funcao = id_funcao;
    }
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cargo", nullable = false)
    public Cargo getCargo() {
        return this.cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_setor", nullable = false)
    public Setor getSetor() {
        return this.setor;
    }

    public void setSetor(Setor setor) {
        this.setor = setor;
    }
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_sub_setor", nullable = false) 
    public SubSetor getSubSetor() {
        return this.subSetor;
    }

    public void setSubSetor(SubSetor subSetor) {
        this.subSetor = subSetor;
    }
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_turno", nullable = false)
    public Turno getTurno() {
        return this.turno;
    }

    public void setTurno(Turno turno) {
        this.turno = turno;
    }
        
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "funcao")
    public Set<FuncaoPessoa> getFuncao_pessoas() {
        return this.funcao_pessoas;
    }

    public void setFuncao_pessoas(Set<FuncaoPessoa> funcao_pessoas) {
        this.funcao_pessoas = funcao_pessoas;
    }
    
}
