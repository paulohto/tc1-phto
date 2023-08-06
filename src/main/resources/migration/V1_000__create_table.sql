CREATE TABLE tb_pessoa (
  id                BIGINT          NOT NULL AUTO_INCREMENT PRIMARY KEY,
  nome              VARCHAR(100)    NOT NULL,
  data_nascimento   VARCHAR(25)     NULL,
  sexo              CHAR(01)        NOT NULL,
  parentesco        VARCHAR(50)     NULL
);

CREATE TABLE tb_endereco (
	id              INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	rua             VARCHAR(50) NOT NULL,
	numero          VARCHAR(25) NOT NULL,
	bairro          VARCHAR(35) NOT NULL,
	cidade          VARCHAR(35) NOT NULL,
	estado          CHAR(02) NOT NULL
);

CREATE TABLE tb_eletrodomestico (
	id              INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	nome            VARCHAR(50) NOT NULL,
	modelo          VARCHAR(50) NOT NULL,
	potencia        VARCHAR(35) NOT NULL,
	selo            CHAR(01) NOT NULL
);