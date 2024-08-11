-- Altera a coluna 'numero' de varchar para int4 e adiciona a coluna data_pedido

ALTER TABLE public.pedido
ALTER COLUMN numero TYPE int4 USING numero::integer,
ALTER COLUMN numero SET NOT NULL,
ADD COLUMN data_pedido timestamp;