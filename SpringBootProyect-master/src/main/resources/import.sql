INSERT INTO CLIENTES (Id , Nombre , Apellido , Email , create_at) values (1 , 'Pablo' , 'Mira' , 'p@gmail.com','2023-02-10' );
INSERT INTO CLIENTES (Id , Nombre , Apellido , Email , create_at) values (2 , 'luis' , 'rendon' , 'ls@gmail.com','2023-02-11' );
INSERT INTO PRODUCTOS (id, nombre, descripcion , precio , unidades ) values (1 , 'Jugo' , 'Jugo de lulo' , '3000','12' );
INSERT INTO PRODUCTOS (id, nombre, descripcion , precio , unidades ) values (2 , 'papas' , 'papas de limon' , '2000','50' );
INSERT INTO VENTAS (Id, idUsuario, total, fecha ) values (1, 4, 2500, '2023-02-11');
INSERT INTO DETALLE (Id, idProducto, idVenta, valorVenta ) values (1, 4, 2500, 25, 25000);