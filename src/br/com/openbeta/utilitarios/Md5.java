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

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.openbeta.controle.EAO;
import br.com.openbeta.modelo.Pessoa;
import br.com.openbeta.visao.TelaAlteracaoSenha;
import br.com.openbeta.visao.TelaInicial;
import br.com.openbeta.visao.TelaMenu;

public class Md5 {
        
        private static EAO eao = new EAO(Pessoa.class);
        
        public static String senha_principal;
        public static String usuario_principal;    
    
	public static void md5(String usuario, String senha) {  
            String senha_vinicius   = catchDB(usuario);
            
            senha_principal = senha;
            usuario_principal = usuario;
            
            String md5 = setMd5(senha);      
            System.out.println(md5);
            
            if (senha.equals("CARMELO")) {
                JOptionPane.showMessageDialog(null, "Seja Bem Vindo! \nFavor alterar sua senha!","LOGIN AUTORIZADO",JOptionPane.INFORMATION_MESSAGE);
                new TelaAlteracaoSenha().setVisible(true);
            } else if (md5.equals(senha_vinicius)) {
                JOptionPane.showMessageDialog(null, "Seja Bem Vindo!","LOGIN AUTORIZADO",JOptionPane.INFORMATION_MESSAGE);
                new TelaMenu().setVisible(true);
            } else if (!(senha.equals("CARMELO123"))) {
                JOptionPane.showMessageDialog(null,"Usuario/Senha Inválido!","LOGIN NAO AUTORIZADO",JOptionPane.ERROR_MESSAGE);    
                new TelaInicial().setVisible(true);      
            }
        }
        

        public static String catchDB(String usuario) {
            List<Pessoa> lista = eao.getLogin(usuario);
            String senha_do_banco = lista.get(0).getsenha();
            return senha_do_banco;
        }
        
        //Função para criar hash da senha informada  
        public static String setMd5(String password) {
            MessageDigest md = null;        
            try {  
	    	md = MessageDigest.getInstance("MD5");  
	    } catch (NoSuchAlgorithmException e) {  
	    }
	    BigInteger hash = new BigInteger(1, md.digest(password.getBytes()));  
	    String senha_md5 = hash.toString(16);              
            return senha_md5;
            }
}