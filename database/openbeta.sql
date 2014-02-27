-- phpMyAdmin SQL Dump
-- version 4.0.4.1
-- http://www.phpmyadmin.net
--
-- Máquina: 127.0.0.1
-- Data de Criação: 27-Fev-2014 às 00:51
-- Versão do servidor: 5.5.32
-- versão do PHP: 5.4.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de Dados: `openbeta`
--
CREATE DATABASE IF NOT EXISTS `openbeta` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `openbeta`;

-- --------------------------------------------------------

--
-- Estrutura da tabela `atividade`
--

CREATE TABLE IF NOT EXISTS `atividade` (
  `id_atividade` int(11) NOT NULL AUTO_INCREMENT,
  `tipo_atividade` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_atividade`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Extraindo dados da tabela `atividade`
--

INSERT INTO `atividade` (`id_atividade`, `tipo_atividade`) VALUES
(1, 'ATIVO'),
(2, 'INATIVO');

-- --------------------------------------------------------

--
-- Estrutura da tabela `cargo`
--

CREATE TABLE IF NOT EXISTS `cargo` (
  `id_cargo` int(11) NOT NULL AUTO_INCREMENT,
  `nome_cargo` varchar(45) NOT NULL,
  PRIMARY KEY (`id_cargo`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Extraindo dados da tabela `cargo`
--

INSERT INTO `cargo` (`id_cargo`, `nome_cargo`) VALUES
(1, 'PROFESSOR'),
(2, 'FUNCIONÁRIO'),
(3, 'PEDAGOGIA');

-- --------------------------------------------------------

--
-- Estrutura da tabela `contratacao`
--

CREATE TABLE IF NOT EXISTS `contratacao` (
  `id_contratacao` int(11) NOT NULL AUTO_INCREMENT,
  `tipo_contratacao` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_contratacao`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Extraindo dados da tabela `contratacao`
--

INSERT INTO `contratacao` (`id_contratacao`, `tipo_contratacao`) VALUES
(1, 'ESTADO'),
(2, 'PSS');

-- --------------------------------------------------------

--
-- Estrutura da tabela `endereco`
--

CREATE TABLE IF NOT EXISTS `endereco` (
  `id_endereco` int(11) NOT NULL AUTO_INCREMENT,
  `logradouro` varchar(45) NOT NULL,
  `rua` varchar(90) NOT NULL,
  `numero` varchar(10) NOT NULL,
  `bairro` varchar(45) NOT NULL,
  `cep` decimal(8,0) NOT NULL,
  `cidade` varchar(75) NOT NULL,
  `id_estado` int(11) NOT NULL,
  PRIMARY KEY (`id_endereco`),
  KEY `fk_estado_endereco` (`id_estado`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=11 ;

--
-- Extraindo dados da tabela `endereco`
--

INSERT INTO `endereco` (`id_endereco`, `logradouro`, `rua`, `numero`, `bairro`, `cep`, `cidade`, `id_estado`) VALUES
(1, 'RUA', 'HIEDA BAGGIO MAYER', '2868', 'VILA TOLENTINO', '85802250', 'CASCAVEL', 14);

-- --------------------------------------------------------

--
-- Estrutura da tabela `estado`
--

CREATE TABLE IF NOT EXISTS `estado` (
  `id_estado` int(11) NOT NULL AUTO_INCREMENT,
  `nome_estado` varchar(2) NOT NULL,
  `nome_estado_inteiro` varchar(30) NOT NULL,
  PRIMARY KEY (`id_estado`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=28 ;

--
-- Extraindo dados da tabela `estado`
--

INSERT INTO `estado` (`id_estado`, `nome_estado`, `nome_estado_inteiro`) VALUES
(1, 'AC', 'ACRE'),
(2, 'AL', 'ALAGOAS'),
(3, 'AP', 'AMAPÁ'),
(4, 'AM', 'AMAZONAS'),
(5, 'BA', 'BAHIA'),
(6, 'CE', 'CEARÁ'),
(7, 'DF', 'DISTRITO FEDERAL'),
(8, 'ES', 'ESPÍRITO SANTO'),
(9, 'GO', 'GOIÁS'),
(10, 'MA', 'MARANHÃO'),
(11, 'MT', 'MATO GROSSO'),
(12, 'MS', 'MATO GROSSO DO SUL'),
(13, 'MG', 'MINAS GERAIS'),
(14, 'PR', 'PARANÁ'),
(15, 'PB', 'PARAÍBA'),
(16, 'PA', 'PARÁ'),
(17, 'PE', 'PERNAMBUCO'),
(18, 'PI', 'PIAUÍ'),
(19, 'RJ', 'RIO DE JANEIRO'),
(20, 'RN', 'RIO GRANDE DO NORTE'),
(21, 'RS', 'RIO GRANDE DO SUL'),
(22, 'RO', 'RONDÔNIA'),
(23, 'RR', 'RORAIMA'),
(24, 'SC', 'SANTA CATARINA'),
(25, 'SE', 'SERGIPE'),
(26, 'SP', 'SÃO PAULO'),
(27, 'TO', 'TOCANTINS');

-- --------------------------------------------------------

--
-- Estrutura da tabela `estado_civil`
--

CREATE TABLE IF NOT EXISTS `estado_civil` (
  `id_estado_civil` int(11) NOT NULL AUTO_INCREMENT,
  `estado_civil` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_estado_civil`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Extraindo dados da tabela `estado_civil`
--

INSERT INTO `estado_civil` (`id_estado_civil`, `estado_civil`) VALUES
(1, 'SOLTEIRO'),
(2, 'CASADO'),
(3, 'DIVORCIADO'),
(4, 'VIÚVO');

-- --------------------------------------------------------

--
-- Estrutura da tabela `funcao`
--

CREATE TABLE IF NOT EXISTS `funcao` (
  `id_funcao` int(11) NOT NULL AUTO_INCREMENT,
  `id_cargo` int(11) NOT NULL,
  `id_setor` int(11) NOT NULL,
  `id_sub_setor` int(11) NOT NULL,
  `id_turno` int(11) NOT NULL,
  PRIMARY KEY (`id_funcao`),
  KEY `fk_setor` (`id_setor`),
  KEY `fk_turno` (`id_turno`),
  KEY `fk_sub_setor` (`id_sub_setor`),
  KEY `fk_cargo` (`id_cargo`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=12 ;

--
-- Extraindo dados da tabela `funcao`
--

INSERT INTO `funcao` (`id_funcao`, `id_cargo`, `id_setor`, `id_sub_setor`, `id_turno`) VALUES
(1, 2, 3, 4, 2);

-- --------------------------------------------------------

--
-- Estrutura da tabela `funcao_pessoa`
--

CREATE TABLE IF NOT EXISTS `funcao_pessoa` (
  `id_funcao_pessoa` int(11) NOT NULL AUTO_INCREMENT,
  `id_funcao` int(11) NOT NULL,
  `id_pessoa` int(11) NOT NULL,
  PRIMARY KEY (`id_funcao_pessoa`),
  KEY `fk_funcao` (`id_funcao`),
  KEY `fk_pessoa_funcao` (`id_pessoa`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=12 ;

--
-- Extraindo dados da tabela `funcao_pessoa`
--

INSERT INTO `funcao_pessoa` (`id_funcao_pessoa`, `id_funcao`, `id_pessoa`) VALUES
(1, 1, 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `graduacao`
--

CREATE TABLE IF NOT EXISTS `graduacao` (
  `id_graduacao` int(11) NOT NULL AUTO_INCREMENT,
  `data_conclusao` date DEFAULT NULL,
  `instituicao` varchar(90) DEFAULT NULL,
  `id_tipo_graduacao` int(11) NOT NULL,
  PRIMARY KEY (`id_graduacao`),
  KEY `fk_tipo_graduacao` (`id_tipo_graduacao`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=12 ;

--
-- Extraindo dados da tabela `graduacao`
--

INSERT INTO `graduacao` (`id_graduacao`, `data_conclusao`, `instituicao`, `id_tipo_graduacao`) VALUES
(1, '2012-11-10', 'UNIVEL - SISTEMAS INFORMAÇÃO', 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `graduacao_pessoa`
--

CREATE TABLE IF NOT EXISTS `graduacao_pessoa` (
  `id_graduacao_pessoa` int(11) NOT NULL AUTO_INCREMENT,
  `id_graduacao` int(11) NOT NULL,
  `id_pessoa` int(11) NOT NULL,
  PRIMARY KEY (`id_graduacao_pessoa`),
  KEY `fk_graduacao` (`id_graduacao`),
  KEY `fk_pessoa_graduacao` (`id_pessoa`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=12 ;

--
-- Extraindo dados da tabela `graduacao_pessoa`
--

INSERT INTO `graduacao_pessoa` (`id_graduacao_pessoa`, `id_graduacao`, `id_pessoa`) VALUES
(1, 1, 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `pessoa`
--

CREATE TABLE IF NOT EXISTS `pessoa` (
  `id_pessoa` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(90) NOT NULL,
  `registro` int(11) NOT NULL,
  `rg` int(12) NOT NULL,
  `cpf` varchar(11) NOT NULL,
  `data_nascto` date NOT NULL,
  `nome_mae` varchar(90) NOT NULL,
  `senha` varchar(45) NOT NULL,
  `email_principal` varchar(100) DEFAULT NULL,
  `email_adicional` varchar(100) DEFAULT NULL,
  `telefone_celular` varchar(45) DEFAULT NULL,
  `telefone_celular_2` varchar(45) DEFAULT NULL,
  `cidade_natal` varchar(75) DEFAULT NULL,
  `outros` varchar(255) DEFAULT NULL,
  `id_endereco` int(11) NOT NULL,
  `id_estado_natal` int(11) NOT NULL,
  `id_atividade` int(11) NOT NULL,
  `id_contratacao` int(11) NOT NULL,
  `id_situacao` int(11) NOT NULL,
  `id_estado_civil` int(11) NOT NULL,
  `id_sexo` int(11) NOT NULL,
  PRIMARY KEY (`id_pessoa`),
  KEY `fk_endereco` (`id_endereco`),
  KEY `fk_estado_natal` (`id_estado_natal`),
  KEY `fk_atividade` (`id_atividade`),
  KEY `fk_contratacao` (`id_contratacao`),
  KEY `fk_situacao` (`id_situacao`),
  KEY `fk_estado_civil` (`id_estado_civil`),
  KEY `fk_sexo` (`id_sexo`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 COMMENT='<double-click to overwrite multiple objects>' AUTO_INCREMENT=10 ;

--
-- Extraindo dados da tabela `pessoa`
--

INSERT INTO `pessoa` (`id_pessoa`, `nome`, `registro`, `rg`, `cpf`, `data_nascto`, `nome_mae`, `senha`, `email_principal`, `email_adicional`, `telefone_celular`, `telefone_celular_2`, `cidade_natal`, `outros`, `id_endereco`, `id_estado_natal`, `id_atividade`, `id_contratacao`, `id_situacao`, `id_estado_civil`, `id_sexo`) VALUES
(1, 'VINICIUS VASCO PEDRON', 11199, 81155909, '03665648971', '1982-02-26', 'ELISABETE VASCO PEDRON', '202cb962ac59075b964b07152d234b70', 'viniciuspedron@hotmail.com', 'vvpedron@gmail.com', '4599363312', '', 'CURITIBA', 'ALUNO QUE FAZ PROGRAMA', 1, 14, 2, 1, 1, 1, 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `setor`
--

CREATE TABLE IF NOT EXISTS `setor` (
  `id_setor` int(11) NOT NULL,
  `nome_setor` varchar(45) NOT NULL,
  PRIMARY KEY (`id_setor`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `setor`
--

INSERT INTO `setor` (`id_setor`, `nome_setor`) VALUES
(1, 'ENSINO FUNDAMENTAL'),
(3, 'TÉC. SUBSEQUENTE - ADMINISTRAÇÃO'),
(4, 'TÉC. SUBSEQUENTE - SECRETARIADO'),
(5, 'TÉC. SUBSEQUENTE - INFORMÁTICA'),
(6, 'TÉC. INTEGRAL - ADMINISTRAÇÃO'),
(7, 'TÉC. INTEGRAL - INFORMÁTICA'),
(8, 'CELEM'),
(9, 'SALA DE RECURSOS'),
(10, 'SALA DE APOIO'),
(11, 'ESPORTE E LAZER'),
(12, 'AULAS ESPECIALIZADAS'),
(13, 'ARTE E CULTURA');

-- --------------------------------------------------------

--
-- Estrutura da tabela `sexo`
--

CREATE TABLE IF NOT EXISTS `sexo` (
  `id_sexo` int(11) NOT NULL AUTO_INCREMENT,
  `sexo` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_sexo`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Extraindo dados da tabela `sexo`
--

INSERT INTO `sexo` (`id_sexo`, `sexo`) VALUES
(1, 'MASCULINO'),
(2, 'FEMININO');

-- --------------------------------------------------------

--
-- Estrutura da tabela `situacao`
--

CREATE TABLE IF NOT EXISTS `situacao` (
  `id_situacao` int(11) NOT NULL AUTO_INCREMENT,
  `tipo_situacao` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_situacao`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Extraindo dados da tabela `situacao`
--

INSERT INTO `situacao` (`id_situacao`, `tipo_situacao`) VALUES
(1, 'EM EXERCÍCIO'),
(2, 'READAPTADO'),
(3, 'AFASTADO DA FUNÇÃO'),
(4, 'LICENÇA MÉDICA'),
(5, 'LICENÇA PRÊMIO');

-- --------------------------------------------------------

--
-- Estrutura da tabela `sub_setor`
--

CREATE TABLE IF NOT EXISTS `sub_setor` (
  `id_sub_setor` int(11) NOT NULL AUTO_INCREMENT,
  `nome_sub_setor` varchar(50) NOT NULL,
  PRIMARY KEY (`id_sub_setor`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=60 ;

--
-- Extraindo dados da tabela `sub_setor`
--

INSERT INTO `sub_setor` (`id_sub_setor`, `nome_sub_setor`) VALUES
(1, 'ARTE'),
(2, 'CIÊNCIAS'),
(3, 'EDUCAÇÃO FÍSICA'),
(4, 'GEOGRAFIA'),
(5, 'HISTÓRIA'),
(6, 'LÍNGUA PORTUGUESA'),
(7, 'MATEMÁTICA'),
(8, 'L.E.M - INGLÊS'),
(9, 'ENSINO RELIGIOSO'),
(10, 'BIOLOGIA'),
(11, 'FILOSOFIA'),
(12, 'FÍSICA'),
(13, 'QUÍMICA'),
(14, 'L.E.M - ESPANHOL'),
(15, 'ADMINISTRAÇÃO DE PROD. E MAT.'),
(16, 'ADM. FINANCEIRA E ORÇAMENTÁRIA'),
(17, 'COMPORTAMENTO ORGANIZACIONAL'),
(18, 'CONTABILIDADE'),
(19, 'ELABORAÇÃO E ANÁLISE PROJETOS'),
(20, 'ESTATÍSTICA APLICADA'),
(21, 'FUNDAMENTOS DO TRABALHO'),
(22, 'GESTÃO DE PESSOAS'),
(23, 'INFORMÁTICA'),
(24, 'INTRODUÇÃO À ECONOMIA'),
(25, 'MARKETING'),
(26, 'MATEMÁTICA FINANCEIRA'),
(27, 'NOÇÕES DE DIREITO - LEG. TRABALHO'),
(28, 'ORGANIZAÇÃO, SISTEMAS E MÉTODOS'),
(29, 'PRÁTICA DISCURSIVA E LINGUAGEM'),
(30, 'TEORIA GERAL DA ADMINISTRAÇÃO'),
(31, 'ADMINISTRAÇÃO'),
(32, 'CERIMONIAL E PROTOCOLO'),
(33, 'ESPANHOL TÉCNICO'),
(34, 'INGLÊS TÉCNICO'),
(35, 'INTRODUÇÃO AS FINANÇAS'),
(36, 'METODOLOGIA CIENTÍFICA'),
(37, 'NOÇÕES DE DIR. E LEG. SOC. TRAB.'),
(38, 'PSICOLOGIA ORGANIZACIONAL'),
(39, 'REDAÇÃO EMPRESARIAL'),
(40, 'TÉCNICAS DE SECRETARIADO'),
(41, 'ANÁLISE DE PROJETOS'),
(42, 'BANCO DE DADOS'),
(43, 'FUND. E ARQUITETURA DE COMPUT.'),
(44, 'INFORMÁTICA INSTRUMENTAL'),
(45, 'INTERNET E PROGRAMAÇÃO WEB'),
(46, 'LINGUAGEM DE PROGRAMAÇÃO'),
(47, 'MATEMÁTICA APLICADA'),
(48, 'REDES E SISTEMAS OPERACIONAIS'),
(49, 'SUPORTE TÉCNICO'),
(50, 'LÍNGUA PORT. E LITERATURA'),
(51, 'ITALIANO - CELEM'),
(52, 'ESPANHOL - CELEM'),
(53, 'FRANCÊS - CELEM'),
(54, 'SALA DE RECURSOS'),
(55, 'SALA DE APOIO'),
(56, 'HORA TREINAMENTO'),
(57, 'FUTSAL E ATLETISMO'),
(58, 'TREINAMENTO ESPORTIVO'),
(59, 'TEATRO');

-- --------------------------------------------------------

--
-- Estrutura da tabela `telefone_residencial`
--

CREATE TABLE IF NOT EXISTS `telefone_residencial` (
  `id_telefone` int(11) NOT NULL AUTO_INCREMENT,
  `telefone_res` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_telefone`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=10 ;

--
-- Extraindo dados da tabela `telefone_residencial`
--

INSERT INTO `telefone_residencial` (`id_telefone`, `telefone_res`) VALUES
(1, '4599363312');

-- --------------------------------------------------------

--
-- Estrutura da tabela `telefone_residencial_pessoa`
--

CREATE TABLE IF NOT EXISTS `telefone_residencial_pessoa` (
  `id_telefone_residencial_pessoa` int(11) NOT NULL AUTO_INCREMENT,
  `id_telefone_residencial` int(11) NOT NULL,
  `id_pessoa` int(11) NOT NULL,
  PRIMARY KEY (`id_telefone_residencial_pessoa`),
  KEY `fk_telefone` (`id_telefone_residencial`),
  KEY `fk_pessoa_telefone_residencial` (`id_pessoa`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=10 ;

--
-- Extraindo dados da tabela `telefone_residencial_pessoa`
--

INSERT INTO `telefone_residencial_pessoa` (`id_telefone_residencial_pessoa`, `id_telefone_residencial`, `id_pessoa`) VALUES
(1, 1, 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `tipo_graduacao`
--

CREATE TABLE IF NOT EXISTS `tipo_graduacao` (
  `id_tipo_graduacao` int(11) NOT NULL AUTO_INCREMENT,
  `tipo_graduacao` varchar(45) NOT NULL,
  PRIMARY KEY (`id_tipo_graduacao`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=7 ;

--
-- Extraindo dados da tabela `tipo_graduacao`
--

INSERT INTO `tipo_graduacao` (`id_tipo_graduacao`, `tipo_graduacao`) VALUES
(1, 'BACHARELADO'),
(2, 'LICENCIATURA'),
(3, 'TECNÓLOGO'),
(4, 'PÓS-GRADUAÇÃO'),
(5, 'MESTRADO'),
(6, 'DOUTORADO');

-- --------------------------------------------------------

--
-- Estrutura da tabela `turno`
--

CREATE TABLE IF NOT EXISTS `turno` (
  `id_turno` int(11) NOT NULL AUTO_INCREMENT,
  `turno` varchar(45) NOT NULL,
  PRIMARY KEY (`id_turno`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Extraindo dados da tabela `turno`
--

INSERT INTO `turno` (`id_turno`, `turno`) VALUES
(1, 'MATUTINO'),
(2, 'VESPERTINO'),
(3, 'NOTURNO');

--
-- Constraints for dumped tables
--

--
-- Limitadores para a tabela `endereco`
--
ALTER TABLE `endereco`
  ADD CONSTRAINT `fk_endereco_estado1` FOREIGN KEY (`id_estado`) REFERENCES `estado` (`id_estado`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `funcao`
--
ALTER TABLE `funcao`
  ADD CONSTRAINT `fk_funcao_cargo1` FOREIGN KEY (`id_sub_setor`) REFERENCES `sub_setor` (`id_sub_setor`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_funcao_cargo2` FOREIGN KEY (`id_cargo`) REFERENCES `cargo` (`id_cargo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_funcao_sub_funcao1` FOREIGN KEY (`id_setor`) REFERENCES `setor` (`id_setor`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_funcao_turno1` FOREIGN KEY (`id_turno`) REFERENCES `turno` (`id_turno`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `funcao_pessoa`
--
ALTER TABLE `funcao_pessoa`
  ADD CONSTRAINT `fk_id_funcao` FOREIGN KEY (`id_funcao`) REFERENCES `funcao` (`id_funcao`),
  ADD CONSTRAINT `fk_id_pessoa_funcao` FOREIGN KEY (`id_pessoa`) REFERENCES `pessoa` (`id_pessoa`);

--
-- Limitadores para a tabela `graduacao`
--
ALTER TABLE `graduacao`
  ADD CONSTRAINT `fk_graduacao_tipo_graduacao1` FOREIGN KEY (`id_tipo_graduacao`) REFERENCES `tipo_graduacao` (`id_tipo_graduacao`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `graduacao_pessoa`
--
ALTER TABLE `graduacao_pessoa`
  ADD CONSTRAINT `fk_id_graduacao` FOREIGN KEY (`id_graduacao`) REFERENCES `graduacao` (`id_graduacao`),
  ADD CONSTRAINT `fk_id_pessoa` FOREIGN KEY (`id_pessoa`) REFERENCES `pessoa` (`id_pessoa`);

--
-- Limitadores para a tabela `pessoa`
--
ALTER TABLE `pessoa`
  ADD CONSTRAINT `fk_pessoa_atividade1` FOREIGN KEY (`id_atividade`) REFERENCES `atividade` (`id_atividade`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_pessoa_contratacao1` FOREIGN KEY (`id_contratacao`) REFERENCES `contratacao` (`id_contratacao`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_pessoa_endereco` FOREIGN KEY (`id_endereco`) REFERENCES `endereco` (`id_endereco`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_pessoa_estado1` FOREIGN KEY (`id_estado_natal`) REFERENCES `estado` (`id_estado`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_pessoa_estado_civil1` FOREIGN KEY (`id_estado_civil`) REFERENCES `estado_civil` (`id_estado_civil`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_pessoa_sexo1` FOREIGN KEY (`id_sexo`) REFERENCES `sexo` (`id_sexo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_pessoa_situacao1` FOREIGN KEY (`id_situacao`) REFERENCES `situacao` (`id_situacao`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `telefone_residencial_pessoa`
--
ALTER TABLE `telefone_residencial_pessoa`
  ADD CONSTRAINT `fk_id_pessoa_tel_residencial` FOREIGN KEY (`id_pessoa`) REFERENCES `pessoa` (`id_pessoa`),
  ADD CONSTRAINT `fk_id_telefone` FOREIGN KEY (`id_telefone_residencial`) REFERENCES `telefone_residencial` (`id_telefone`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
