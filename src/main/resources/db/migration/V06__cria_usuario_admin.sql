insert into usuarios (login, senha, ativo)
values ('admin', '$2b$10$AKr4fPfdtpslSIrUuA4Ft./KVBD2MLae/yoAyUTrXs6XKoXUjem6u', true);

insert into usuario_perfis (usuario_id, perfil_id)
select u.id, p.id
from usuarios u
         cross join perfis p
where u.login = 'admin'
  and p.nome = 'ADMIN';
