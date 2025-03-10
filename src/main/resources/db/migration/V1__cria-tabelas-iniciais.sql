create table cliente (
    id bigserial not null,
    nome varchar(255) not null,

    constraint pk_cliente primary key (id)
);

create table categoria (
    id bigserial not null,
    nome varchar(255) not null,

    constraint pk_categoria primary key (id)
);

create table produto (
    id bigserial not null,
    nome varchar(255) not null,
    preco decimal(10,2) not null default 0,
    categoria_id bigint not null,

    constraint pk_produto primary key (id),
    constraint fk_produto_categoria foreign key (categoria_id) references categoria(id)
);

create table pedido (
    id bigserial not null,
    cliente_id bigint not null,
    data timestamp not null default current_timestamp,

    constraint pk_pedido primary key (id),
    constraint fk_pedido_cliente foreign key (cliente_id) references cliente(id)
);

create table item_pedido (
    id bigserial not null,
    quantidade integer not null default 1,
    preco_compra decimal(10,2) not null default 0,

    pedido_id bigint not null,
    produto_id bigint not null,



    constraint pk_item_pedido primary key (id),
    constraint fk_item_pedido_pedido foreign key (pedido_id) references pedido(id),
    constraint fk_item_pedido_produto foreign key (produto_id) references produto(id)
);