-- Criando as sequences
CREATE SEQUENCE seq_produto;
CREATE SEQUENCE seq_pedido;
CREATE SEQUENCE seq_item_pedido;
CREATE SEQUENCE seq_chef;

ALTER SEQUENCE seq_produto OWNER TO techchallenge_usr;
ALTER SEQUENCE seq_pedido OWNER TO techchallenge_usr;
ALTER SEQUENCE seq_item_pedido OWNER TO techchallenge_usr;
ALTER SEQUENCE seq_chef OWNER TO techchallenge_usr;

-- Criando a tabela chef
CREATE TABLE public.chef (
     id int8 DEFAULT nextval('seq_chef'::regclass) NOT NULL,
     nome varchar(255) NOT NULL,
     CONSTRAINT pk_chef PRIMARY KEY (id)
);

ALTER TABLE public.chef OWNER TO techchallenge_usr;

-- Criando a tabela produto
CREATE TABLE public.produto (
	id int8 DEFAULT nextval('seq_produto'::regclass) NOT NULL,
	categoria int2 NOT NULL,
	valor float8 NOT NULL,
	descricao varchar(255) NOT NULL,
	nome varchar(255) NOT NULL,
	CONSTRAINT produto_categoria_check CHECK (((categoria >= 0) AND (categoria <= 3))),
	CONSTRAINT pk_produto PRIMARY KEY (id)
);

ALTER TABLE public.produto OWNER TO techchallenge_usr;

-- Criando a tabela pedido
CREATE TABLE public.pedido (
    id int8 DEFAULT nextval('seq_pedido'::regclass) NOT NULL,
	status int2 NOT NULL,
	valor_total float8 NOT NULL,
	cliente_id int8 NULL,
	numero varchar(255) NOT NULL,
	CONSTRAINT pk_pedido PRIMARY KEY (id),
	CONSTRAINT pedido_status_check CHECK (((status >= 0) AND (status <= 3))),
	CONSTRAINT fk_pedido_cliente FOREIGN KEY (cliente_id) REFERENCES public.cliente(id)
);

ALTER TABLE public.pedido OWNER TO techchallenge_usr;

-- Criando a tabela item_pedido
CREATE TABLE public.item_pedido (
    id int8 DEFAULT nextval('seq_item_pedido'::regclass) NOT NULL,
	quantidade int4 NOT NULL,
	valor float8 NOT NULL,
	pedido_id int8 NOT NULL,
	CONSTRAINT item_pedido_pkey PRIMARY KEY (id),
	CONSTRAINT fk_item_pedido_pedido FOREIGN KEY (pedido_id) REFERENCES public.pedido(id)
);

ALTER TABLE public.item_pedido OWNER TO techchallenge_usr;