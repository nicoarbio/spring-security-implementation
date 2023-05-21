--V1.0 create main tables

CREATE TABLE users (
    ID BIGINT PRIMARY KEY AUTO_INCREMENT,
    EMAIL VARCHAR(255),
    PASSWORD VARCHAR(255),
    ROLE VARCHAR(255),
    EXTRA_INFO VARCHAR(255)
);

INSERT INTO users (EMAIL, PASSWORD, ROLE, EXTRA_INFO)
VALUES
    ('test@test.com', '$2a$12$HqClAMfPtE96XAPK2lcaMectfzvaL7EcY9H.7nw4aknbc/pI/UrSG', 'ROLE_ADMIN', 'Este usuario, es el admin!'),
    ('test2@test2.com', '$2a$12$HqClAMfPtE96XAPK2lcaMectfzvaL7EcY9H.7nw4aknbc/pI/UrSG', 'ROLE_READ_ONLY', 'Este usuario, es de solo lectura');
