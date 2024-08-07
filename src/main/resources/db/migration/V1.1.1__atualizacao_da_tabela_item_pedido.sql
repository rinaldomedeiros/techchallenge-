-- Inclusão da coluna produto_id e da a chave estrangeira

ALTER TABLE public.item_pedido ADD produto_id int8 NOT NULL;

ALTER TABLE public.item_pedido ADD CONSTRAINT fk_item_pedido_produto FOREIGN KEY (produto_id) REFERENCES public.produto(id)