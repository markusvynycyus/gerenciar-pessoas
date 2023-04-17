INSERT INTO pessoa (nome, data_nascimento) VALUES ('MARCOS', '1990-01-01');
--INSERT INTO pessoa (id, nome, data_nascimento) VALUES (2, 'VENICIOS', '1992-03-15');
--INSERT INTO pessoa (id, nome, data_nascimento) VALUES (3, 'EVANGELISTA', '1985-05-20');
--INSERT INTO pessoa (id, nome, data_nascimento) VALUES (4, 'CHAVES', '1998-11-30');

--- Inserindo Endereço ---
INSERT INTO endereco (logradouro, cep, numero, cidade, principal, pessoa_id) VALUES ('Rua A', '12345-678', '100', 'São Paulo', true, 1);