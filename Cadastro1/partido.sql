	CREATE TABLE estado(
		id SERIAL PRIMARY KEY,
		nome VARCHAR(255) NOT NULL,
		regiao VARCHAR(30) NOT NULL
	);
	CREATE TABLE deputado(
		id SERIAL PRIMARY KEY,
		nome VARCHAR(255) NOT NULL,
		data_ingresso DATE NOT NULL,
		partido VARCHAR(30) NOT NULL,
		idEstado INT,
		FOREIGN KEY (idEstado) REFERENCES estado(id)
	);