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

package br.com.openbeta.controle;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaUpdate;

public class Sessao {
    private static SessionFactory fabricaSessao;
    private static Configuration hibernateConfig;
    // Estrutura static para garantir que a SessionFactory seja iniciada apenas uma vez
    static {
        try {
            hibernateConfig = new Configuration().configure("configuracao/hibernate.cfg.xml");
            fabricaSessao = hibernateConfig.buildSessionFactory();
            atualizarBD();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    // Retorna a sessão
    public static Session getSessao(){
        return fabricaSessao.openSession();
    }
 
    // Atualiza o Schema do Banco de Dados
    private static void atualizarBD(){
        SchemaUpdate se = new SchemaUpdate(hibernateConfig);
        se.execute(true, true);
    }
}
