CREATE TABLE zapatos (
        id int primary key AUTO_INCREMENT,
        modelo VARCHAR(100) not null,
        tallas TEXT not null,
        imagen text not null,
        precio float not null,
        tipo text not null
        fecha TIMESTAMP default CURRENT_TIMESTAMP
);

CREATE TABLE ofertas(
        id int primary key AUTO_INCREMENT,
        descripcion TEXT not null
);
