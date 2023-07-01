CREATE TABLE IF NOT EXISTS public.book
(
    id bigint NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1 ),
    title character varying(150) COLLATE pg_catalog."default" NOT NULL,
    author character varying(150) COLLATE pg_catalog."default" NOT NULL,
    description character varying(150) COLLATE pg_catalog."default",
    CONSTRAINT book_pkey PRIMARY KEY (id)
    )

INSERT INTO public.book (title,author,description) VALUES
	 ('Crime and Punishment','F. Dostoevsky',NULL),
	 ('Anna Karenina','L. Tolstoy',NULL),
	 ('The Brothers Karamazov','F. Dostoevsky',NULL),
	 ('War and Peace','L. Tolstoy',NULL),
	 ('Dead Souls','N. Gogol',NULL);
