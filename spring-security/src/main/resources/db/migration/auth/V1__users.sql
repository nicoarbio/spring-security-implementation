--V1.0 create users in DB

INSERT INTO role (role)
VALUES
    ('ROLE_ADMIN'),
    ('ROLE_READ_ONLY');

INSERT INTO app_user (ID, EMAIL, PASSWORD, EXTRA_INFO, ACCOUNT_LOCKED)
VALUES
    ('6300efed-959c-42fb-9fbc-4955a44767fe', 'test@test.com', '$2a$12$HqClAMfPtE96XAPK2lcaMectfzvaL7EcY9H.7nw4aknbc/pI/UrSG', 'This user, is the admin!', FALSE),
    ('43d76c8d-8207-4f9e-ac6d-8d36d15508d5', 'test2@test2.com', '$2a$12$HqClAMfPtE96XAPK2lcaMectfzvaL7EcY9H.7nw4aknbc/pI/UrSG', 'This user, is only-read user', FALSE);


INSERT INTO users_roles (USER_ID, ROLE_ID)
VALUES
    ('6300efed-959c-42fb-9fbc-4955a44767fe', 'ROLE_ADMIN'),
    ('43d76c8d-8207-4f9e-ac6d-8d36d15508d5', 'ROLE_READ_ONLY');