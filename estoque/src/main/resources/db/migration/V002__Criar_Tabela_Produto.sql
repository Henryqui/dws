create table produto(
    id int not null primary key auto_increment,
    categoria_id int not null,
    nomeproduto varchar(120),
    preco decimal(12,2)
);

alter table produto add constraint fk_categoria_produto foreign key(categoria_id) references categoria(id);