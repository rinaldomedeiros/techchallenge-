ALTER TABLE public.pedido ADD status_pagamento int2 NULL;

ALTER TABLE public.pedido ADD CONSTRAINT pedido_status_pagamento_check CHECK (((status_pagamento >= 0) AND (status_pagamento <= 3)));