create unique index uk_clientes_cpf on clientes (cpf);

create index idx_locacao_imovel on locacao (id_imovel);
create index idx_locacao_inquilino on locacao (id_inquilino);
create index idx_aluguel_locacao on alugueis (id_locacao);
