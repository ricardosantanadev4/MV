CREATE TABLE OPCOES(    
    NOME VARCHAR2(100) NOT NULL,
    STATUS VARCHAR2(100)NOT NULL,
    CONSTRAINT OPCOES_PK PRIMARY KEY(NOME) ENABLE
);

CREATE TABLE PARTICIPANTES_E_OPCOES(
    CPF  VARCHAR2 (11) NOT NULL,
    NOME VARCHAR2(100) NOT NULL,    
    OPCAO1 VARCHAR2(100) NOT NULL,
    OPCAO2 VARCHAR2(100) NULL,
    CONSTRAINT PARTICIPANTES_E_OPCOES_PK PRIMARY KEY(CPF) ENABLE
);



