create table produto(
    id int not null primary key auto_increment,
    idcategoria int not null,
    nomeproduto varchar(120),
    preco decimal(3,2)
);

alter table produto add constraint fk_categoria_produto foreign key(idcategoria) references categoria(id);