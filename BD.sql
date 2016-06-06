create database Prueba
go

use Prueba
go

create table Atleta(
cod_atl int identity,
nom_atl varchar(12),
dni_atl int,
sex_atl varchar(14),
eda_atl int,
talla numeric(8, 2)
)
go

create proc sp_grabaratleta
@nom_atl varchar(12),
@dni_atl int,
@sex_atl varchar(14),
@eda_atl int,
@talla numeric(8, 2)
as
insert into Atleta values(@nom_atl,
@dni_atl,
@sex_atl,
@eda_atl,
@talla)
go

create proc sp_listaratleta
as
select * from atleta
go

create proc sp_atletaXcodigo
@cod int
as
select * from atleta where cod_atl=@cod
go

create proc sp_eliminaratleta
@cod int
as
delete from Atleta where cod_atl=@cod
go

create proc sp_atletaXtalla
@talla numeric(8,2)
as
select * from Atleta where talla=@talla
go


create proc sp_listartodo
as
select * from Atleta
go
select cod_atl,nom_atl,dni_atl,talla from atleta