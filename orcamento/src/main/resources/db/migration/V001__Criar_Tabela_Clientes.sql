create table clientes(
    id bigint not null primary key auto_increment,
    nome varchar(100),
    endereco varchar(120),
    numero varchar(50),
    bairro varchar(80,
    idmunicipio int not null,
    telefone varchar(30),
    celular varchar(30)
);

create table municipio(
    id int not null primary key auto_increment,
    nome varchar(100),
    estado char(2)
);

create table lancamento(
    id bigint not null primary key auto_increment,
    datalancamento date,
    idcliente bigint not null,
    tipolancamento varchar(10),
    valorlancamento decimal(12,2)
);

alter table clientes add constraint fk_clientes_municipio foreign key idmunicipio references municipio(id);

alter table lancamento add constraint fk_lancamento_clientes foreign key idcliente references clientes(id);
