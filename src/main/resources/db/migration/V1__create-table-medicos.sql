CREATE TABLE Consertos (
                           id BIGINT AUTO_INCREMENT PRIMARY KEY,
                           data_entrada DATE NOT NULL,
                           data_saida DATE NOT NULL,
                           anos_experiencia INT CHECK (anos_experiencia >= 0),
                           nome VARCHAR(100) NOT NULL,
                           ano INT CHECK (ano >= 1886),
                           marca VARCHAR(50) NOT NULL,
                           modelo VARCHAR(50) NOT NULL
);
