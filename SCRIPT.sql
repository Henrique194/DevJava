CREATE TABLE public.primeira_tabela (
	id serial NOT NULL,
	nome varchar NOT NULL,
	telefone numeric NOT NULL,
	CONSTRAINT primeira_tabela_pk PRIMARY KEY (id)
);


-- Auto-generated SQL script #202106242301 ***ADD***
INSERT INTO public.primeira_tabela (id,nome,telefone)
	VALUES (NULL,NULL,NULL);


-- Auto-generated SQL script #202106251846 ***DELETE***
DELETE FROM public.segunda_tabela
	WHERE id=4;


-- Auto-generated SQL script #202106252035 ***Edit Nome***
UPDATE public.segunda_tabela
	SET nome='Felipe'
	WHERE id=6;


-- Auto-generated SQL script #202106252036 ***Edit Telefone***
UPDATE public.segunda_tabela
	SET telefone=11940399456
	WHERE id=6;


CREATE TABLE public.tab_cliente (
	id char NOT NULL,
	nome varchar NOT NULL,
	telefone char NOT NULL,
	email varchar NOT NULL,
	CONSTRAINT tab_cliente_pk PRIMARY KEY (id)
);


SELECT * FROM public.tab_cliente ***SELECT***

ALTER TABLE public.tab_cliente DROP COLUMN telefone;
