CREATE TABLE categoria (
      id SERIAL PRIMARY KEY,
      nome VARCHAR(100) NOT NULL UNIQUE,
      descricao VARCHAR(255)
  );