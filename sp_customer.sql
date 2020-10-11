ALTER TABLE clientes
ADD COLUMN total_compras DOUBLE NULL DEFAULT 0.00 AFTER telefono;

CREATE PROCEDURE ins_customer(in _surnames VARCHAR(50),in _names VARCHAR(50), in _email VARCHAR(50), in _telephone VARCHAR(50), in _total_compras DOUBLE)
     insert into clientes (apellidos, nombres, correo, telefono, total_compras) values(_surnames,_names,_email,_telephone,_total_compras);

CREATE PROCEDURE upd_customer(in idCustomer INT, in _surnames VARCHAR(50),in _names VARCHAR(50), in _email VARCHAR(50), in _telephone VARCHAR(50), in _total_compras DOUBLE)
     update clientes set apellidos=_surnames, nombres=_names, correo=_email, telefono=_telephone, telefono=_telephone, total_compras=_total_compras where idcliente=idCustomer;

CREATE PROCEDURE del_customer(in idCustomer VARCHAR(3))
     delete from clientes where idcliente=idCustomer;

CREATE PROCEDURE findAll_customer()
     select * from clientes;

CREATE PROCEDURE find_customer(in idCustomer VARCHAR(3))
     select * from clientes where idcliente=idCustomer;

CREATE PROCEDURE findBySurnamesAndNames_customer(in _surnames VARCHAR(50),in _names VARCHAR(50))
     select * from clientes where apellidos=_surnames and nombres=_names;

