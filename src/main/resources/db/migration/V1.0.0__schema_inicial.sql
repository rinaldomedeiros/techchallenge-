-- Criando a sequence seq_clientes
CREATE SEQUENCE seq_cliente;
ALTER SEQUENCE seq_cliente OWNER TO techchallenge_usr;

-- Criando a tabela clientes
CREATE TABLE public.cliente (
     id int8 DEFAULT nextval('seq_cliente'::regclass) NOT NULL,
     nome varchar(255) NOT NULL,
     email varchar(255) NOT NULL,
     cpf char(14) NOT NULL,
     CONSTRAINT pk_clientes PRIMARY KEY (id),
     CONSTRAINT uq_email UNIQUE (cpf)
);

ALTER TABLE public.cliente OWNER TO techchallenge_usr;

INSERT INTO cliente (nome, email, cpf) VALUES
('João Silva', 'joao.silva@example.com', '123.456.789-00'),
('Maria Souza', 'maria.souza@example.com', '234.567.890-11'),
('Pedro Oliveira', 'pedro.oliveira@example.com', '345.678.901-22'),
('Ana Santos', 'ana.santos@example.com', '456.789.012-33'),
('Carlos Pereira', 'carlos.pereira@example.com', '567.890.123-44'),
('Paula Lima', 'paula.lima@example.com', '678.901.234-55'),
('Ricardo Costa', 'ricardo.costa@example.com', '789.012.345-66'),
('Fernanda Almeida', 'fernanda.almeida@example.com', '890.123.456-77'),
('Roberto Martins', 'roberto.martins@example.com', '901.234.567-88'),
('Juliana Ferreira', 'juliana.ferreira@example.com', '012.345.678-99');

