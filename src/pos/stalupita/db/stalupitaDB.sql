-- Respaldo de BD StaLupita
-- ------------------------------------------------------
-- Database: StaLupita Tables: pos
-- ------------------------------------------------------
-- Server version	5.5.34
-- ------------------------------------------------------
-- By Adrian.Ake adrianaaae@gmail.com
-- ------------------------------------------------------
DROP DATABASE stalupita ;
CREATE DATABASE IF NOT EXISTS stalupita;
USE stalupita ;

DROP TABLE IF EXISTS unidad_medida;
CREATE TABLE unidad_medida (
  idume varchar(11) NOT NULL UNIQUE primary key,
  descripcion varchar(100) NULL,      
  cantidad decimal(10,2) NULL,  
  estado tinyint(1) DEFAULT '1'
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
-- ALIMENTAR TABLA stalupita.unidad_medida
INSERT INTO stalupita.unidad_medida VALUES('GRC','Sin Unidad Medida',1.00,1);
INSERT INTO stalupita.unidad_medida VALUES('KG','Kilogramo',1.00,1);
INSERT INTO stalupita.unidad_medida VALUES('PZA','Pieza',1.00,1);
INSERT INTO stalupita.unidad_medida VALUES('BULTO','Bulto - Saco(Mayoreo)',1.00,1);
INSERT INTO stalupita.unidad_medida VALUES('CAJA','Caja del Producto(Mayoreo)',1.00,1);

DROP TABLE IF EXISTS categoria;
CREATE TABLE categoria (
  idcategoria int(11) NOT NULL AUTO_INCREMENT primary key,
  descripcion varchar(100) NULL,        
  estado tinyint(1) DEFAULT '1'
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
-- ALIMENTAR TABLA stalupita.categoria
INSERT INTO stalupita.categoria VALUES(0,'Sin Categoria',1);

INSERT INTO stalupita.categoria VALUES(0,'Inicio Pollo',1);
INSERT INTO stalupita.categoria VALUES(0,'Crecimiento Pollo',1);
INSERT INTO stalupita.categoria VALUES(0,'Engorda Pollo',1);

INSERT INTO stalupita.categoria VALUES(0,'Inicio Cerdo',1);
INSERT INTO stalupita.categoria VALUES(0,'Crecimiento Cerdo',1);
INSERT INTO stalupita.categoria VALUES(0,'Engorda Cerdo',1);

INSERT INTO stalupita.categoria VALUES(0,'Inicio Pavo',1);
INSERT INTO stalupita.categoria VALUES(0,'Crecimiento Pavo',1);
INSERT INTO stalupita.categoria VALUES(0,'Engorda Pavo',1);

INSERT INTO stalupita.categoria VALUES(0,'Salvadillo Ganado',1);
INSERT INTO stalupita.categoria VALUES(0,'Fertilizantes',1);
INSERT INTO stalupita.categoria VALUES(0,'Herbicidas',1);
INSERT INTO stalupita.categoria VALUES(0,'Granos(Maiz)',1);
INSERT INTO stalupita.categoria VALUES(0,'Alimento Perro',1);
INSERT INTO stalupita.categoria VALUES(0,'Alimento Gato',1);
INSERT INTO stalupita.categoria VALUES(0,'Alimento Gallo Pelea',1);
INSERT INTO stalupita.categoria VALUES(0,'Tuberias',1);
INSERT INTO stalupita.categoria VALUES(0,'Material de Construccion',1);

DROP TABLE IF EXISTS producto;
CREATE TABLE producto (
  idproducto int(11) NOT NULL AUTO_INCREMENT primary key,
  idume varchar(11) NOT NULL,
  idcategoria int(11) NOT NULL,
  descripcion varchar(100) DEFAULT NULL,      
  costo decimal(10,2) DEFAULT NULL,
  precio decimal(10,2) DEFAULT NULL,  
  estado tinyint(1) DEFAULT '1',
  created_at timestamp NULL,
  updated_at timestamp NULL,
  deleted_at timestamp NULL,
  foreign key (idume) references unidad_medida (idume)  on delete cascade on update cascade,  
  foreign key (idcategoria) references categoria (idcategoria)  on delete cascade on update cascade
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS ticket;
CREATE TABLE ticket (
  idticket int(11) NOT NULL AUTO_INCREMENT primary key,
  total decimal(10,2)  NULL,
  pago decimal(10,2)  NULL,
  cambio decimal(10,2)  NULL,  
  fecha_registrado timestamp  NULL,
  fecha_cancelado timestamp  NULL,  
  pagado tinyint(1) DEFAULT '0',
  estado tinyint(1) DEFAULT '1'
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS detalle_ticket;
CREATE TABLE detalle_ticket (
  iddetticket int(11) NOT NULL AUTO_INCREMENT primary key,
  idticket int(11) NOT NULL,
  idproducto int(11) NOT NULL,
  precio decimal(10,2)  NULL,
  cantidad decimal(10,2)  NULL,
  total decimal(10,2)  NULL,  
foreign key (idticket) references ticket (idticket)  on delete cascade on update cascade,       
foreign key (idproducto) references producto (idproducto)  on delete cascade on update cascade
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS inventario;
CREATE TABLE inventario (
  idinventario int(11) NOT NULL AUTO_INCREMENT primary key,
  idproducto int(11) NOT NULL,
  cantidad_comprada decimal(10,2)  NULL,
  precio decimal(10,2)  NULL,  
  total decimal(10,2)  NULL,   
  cantidad_vendida decimal(10,2)  NULL,
  fecha_compra timestamp NULL,
  fecha_vendido timestamp NULL,  
  estado tinyint(1) DEFAULT '1',
  foreign key (idproducto) references producto (idproducto)  on delete cascade on update cascade
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS configuracion;
CREATE TABLE configuracion (
    idconfig int(11) NOT NULL primary key,
    descripcion varchar(100) NOT NULL,
    valor varchar(100) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
