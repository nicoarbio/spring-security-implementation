--V1.0 create users in DB

INSERT INTO app_user (EMAIL, PASSWORD, ROLE, EXTRA_INFO)
VALUES
    ('test@test.com', '$2a$12$HqClAMfPtE96XAPK2lcaMectfzvaL7EcY9H.7nw4aknbc/pI/UrSG', 'ROLE_ADMIN', 'This user, is the admin!'),
    ('test2@test2.com', '$2a$12$HqClAMfPtE96XAPK2lcaMectfzvaL7EcY9H.7nw4aknbc/pI/UrSG', 'ROLE_READ_ONLY', 'This user, is only-read user');
