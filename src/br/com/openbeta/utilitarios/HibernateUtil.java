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

package br.com.openbeta.utilitarios;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static SessionFactory factory;

 /**
 * escopo estático. É a primeira coisa executa em uma classe e só executada apenas uma vez. Objetivo é carregar nossas configurações do 
 * hibernate  para que sessões possam ser criadas.
 * O hibernate possui uma classe responsavel por funciona como uma fábrica  de sessões: classe SessionFactory
 **/
    
    static {
        //AnnotationConfiguration configuration = new AnnotationConfiguration();
        Configuration configuration = new Configuration().configure("/hibernate.cfg.xml");
        factory = configuration.buildSessionFactory();
    }
    
/**
 * sempre que quisermos uma session do hibernate apenas chamamos  * HibernateUtils.getSession();
**/
    
    public static Session getSession(){
        return factory.openSession();
    }

}