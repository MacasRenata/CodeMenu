CREATE DATABASE codemenu;

USE codemenu;



CREATE TABLE estabelecimentos (
  
id INT AUTO_INCREMENT NOT NULL,
   
nome VARCHAR(200) NOT NULL, 
  
telefone VARCHAR(20) NOT NULL, 
  
email VARCHAR(255) NOT NULL, 
  
endereco TEXT NOT NULL,
  
PRIMARY KEY (id)
);

CREATE TABLE mesa (
  
id INT AUTO_INCREMENT NOT NULL,
identificacao VARCHAR(20) NOT NULL,  
qrcode VARCHAR(200) NOT NULL,  
estabelecimento_id INTEGER NOT NULL,
PRIMARY KEY (id)
);

CREATE TABLE cliente (
  
id INT AUTO_INCREMENT NOT NULL,
   
telefone VARCHAR(20) NOT NULL, 
PRIMARY KEY (id)
);

CREATE TABLE item (
  
id INT AUTO_INCREMENT NOT NULL,
   
nome VARCHAR(200) NOT NULL, 
tipo INT NOT NULL,
preco DECIMAL(10,2),
imagem BLOB,  
estabelecimento_id INTEGER NOT NULL,
PRIMARY KEY (id)
);

CREATE TABLE pedidos (
  
id INT AUTO_INCREMENT NOT NULL,
   
hora DATETIME NOT NULL, 
  
status INT,
valor DECIMAL(10,2),
quantidade INT NOT NULL,
cliente_id INTEGER NOT NULL,
mesa_id INTEGER NOT NULL,
item_id INTEGER NOT NULL, 
comanda_id INTEGER NOT NULL, 
PRIMARY KEY (id)
);

CREATE TABLE comanda (
  
id INT AUTO_INCREMENT NOT NULL,
   
hora DATETIME NOT NULL, 
  
status INT,
valor_total DECIMAL(10,2),
PRIMARY KEY (id)
);

ALTER TABLE mesa ADD CONSTRAINT mesa_estabelecimento_fk FOREIGN KEY (estabelecimento_id)REFERENCES estabelecimentos(id);
ALTER TABLE item ADD CONSTRAINT item_estabelecimento_fk FOREIGN KEY (estabelecimento_id)REFERENCES estabelecimentos(id);
ALTER TABLE pedidos ADD CONSTRAINT pedido_cliente_fk FOREIGN KEY (cliente_id)REFERENCES cliente(id);
ALTER TABLE pedidos ADD CONSTRAINT pedido_mesa_fk FOREIGN KEY (mesa_id)REFERENCES mesa(id);
ALTER TABLE pedidos ADD CONSTRAINT pedido_item_fk FOREIGN KEY (item_id)REFERENCES item(id);
ALTER TABLE pedidos ADD CONSTRAINT pedido_comanda_fk FOREIGN KEY (comanda_id)REFERENCES comanda(id);
