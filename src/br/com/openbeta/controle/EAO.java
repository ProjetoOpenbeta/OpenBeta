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

import br.com.openbeta.modelo.Pessoa;
import br.com.openbeta.utilitarios.HibernateUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
//import javax.persistence.criteria.Expression;
import javax.swing.JOptionPane;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

public class EAO<T, PK extends Serializable> {
    Session session ;//= HibernateUtil.getSession();
    private Query query; 
    private Class<T> classe;
   
    public EAO(Class<T> classe){
        this.classe = classe;
        this.session = HibernateUtil.getSession();
    }
  
      public List<Pessoa> getLogin(String cpf){
	Criteria criteria = session.createCriteria(Pessoa.class);
	if(cpf!=null){
            criteria.add(Expression.ge("cpf",cpf));
	}
	criteria.addOrder(Order.asc("cpf"));
 
	return criteria.list();
     }
  
    public void bulkInsert(List<T> list){
        try {
            session.beginTransaction();
            for (T t : list) {
                session.saveOrUpdate(t);
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        }
    }
   
    public void insertUpdate(T entity){
        session.beginTransaction();
        session.saveOrUpdate(entity);
        session.getTransaction().commit();
    }
    
    public void fecharSessao() {
        session.close();
    }
    
    
    public T consulta(PK pk) {
        session.beginTransaction();
        T objeto = (T)session.load(classe, pk);
        session.getTransaction().commit();
        return objeto;
    }
    
    public void delete(T entity){
        try{
            session.beginTransaction();
            session.delete(entity);
            session.getTransaction().commit();
            //session.close();
            JOptionPane.showMessageDialog(null, "Registro deletado com sucesso!", null, JOptionPane.INFORMATION_MESSAGE);
        } catch (HibernateException e) { 
            JOptionPane.showMessageDialog(null, "Erro ao deletar registro.\n"+e.getMessage(), null, JOptionPane.ERROR_MESSAGE);
        }
    }

    
    public List selectLogin(String usuario){
        List<T> lista = new ArrayList();
        try {
            session.getTransaction().begin();
            query = session.createQuery("from Pessoa");
            
            lista = query.list();
            session.getTransaction().commit();
            //session.close();
        } catch (HibernateException e) {  
            JOptionPane.showMessageDialog(null, "Erro ao realizar Select.\n"+e.getMessage(), null, JOptionPane.ERROR_MESSAGE);
        }
        return lista;
   }
}
