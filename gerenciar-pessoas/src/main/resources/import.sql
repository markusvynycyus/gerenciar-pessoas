INSERT INTO pessoa (id, nome, data_nascimento) VALUES (1, 'MARCOS', '1990-01-01');
INSERT INTO pessoa (id, nome, data_nascimento) VALUES (2, 'VENICIOS', '1992-03-15');
INSERT INTO pessoa (id, nome, data_nascimento) VALUES (3, 'EVANGELISTA', '1985-05-20');
INSERT INTO pessoa (id, nome, data_nascimento) VALUES (4, 'CHAVES', '1998-11-30');


-- Insere endereços para a pessoa de ID 1
INSERT INTO endereco (logradouro, cep, numero, cidade, principal, pessoa_id) VALUES ('Rua das Flores', '01234-567', '123', 'São Paulo', true, 1);
INSERT INTO endereco (logradouro, cep, numero, cidade, principal, pessoa_id) VALUES ('Rua dos Bem-te-vis', '09876-543', '456', 'São Paulo', false, 1);

-- Insere endereços para a pessoa de ID 2
INSERT INTO endereco (logradouro, cep, numero, cidade, principal, pessoa_id) VALUES ('Rua das Palmeiras', '01234-567', '789', 'São Paulo', true, 2);
INSERT INTO endereco (logradouro, cep, numero, cidade, principal, pessoa_id) VALUES ('Rua dos Sabiás', '09876-543', '987', 'São Paulo', false, 2);

-- Insere endereços para a pessoa de ID 3
INSERT INTO endereco (logradouro, cep, numero, cidade, principal, pessoa_id) VALUES ('Rua dos Girassóis', '01234-567', '456', 'São Paulo', true, 3);
INSERT INTO endereco (logradouro, cep, numero, cidade, principal, pessoa_id) VALUES ('Rua das Hortênsias', '09876-543', '321', 'São Paulo', false, 3);

-- Insere endereços para a pessoa de ID 4
INSERT INTO endereco (logradouro, cep, numero, cidade, principal, pessoa_id) VALUES ('Rua das Aroeiras', '01234-567', '654', 'São Paulo', true, 4);
INSERT INTO endereco (logradouro, cep, numero, cidade, principal, pessoa_id) VALUES ('Rua dos Pinheiros', '09876-543', '111', 'São Paulo', false, 4);
