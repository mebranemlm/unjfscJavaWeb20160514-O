# unjfscJavaWeb20160514-O
Proyecto Java Web del 2016/05/14 - Original (Sesion06)

#BD Script - Oracle
drop table tbl_usuario;
commit;
drop table tbl_docente;
commit;

create table tbl_usuario
(
usuario varchar2(50) primary key not null,
clave varchar2(50),
f_regstro date,
estado int
);
commit;
create table tbl_docente
(
id_docente varchar2(50) primary key not null,
nombre varchar2(50),
apellido varchar2(50),
f_registro date,
estado int,
usuario varchar2(50),
foreign key (usuario) references tbl_usuario(usuario)
);
commit;

insert into tbl_usuario values('U001','123',to_date('14/05/2016 09:37:00','DD/MM/YYYY HH24:MI:SS'),'1');
commit;
insert into tbl_docente values('D001','roberto','sosa',sysdate,'1','U001');
commit;
select * from tbl_usuario;
select * from tbl_docente;
