-- Create roles table
CREATE TABLE IF NOT EXISTS roles
(
    id   BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

-- Insert default roles
INSERT INTO roles (name)
VALUES ('ROLE_USER'),
       ('ROLE_ADMIN');

-- Create users table
CREATE TABLE IF NOT EXISTS users
(
    username    VARCHAR(255) PRIMARY KEY,
    password VARCHAR(255) NOT NULL
);

-- Create user_roles table
CREATE TABLE IF NOT EXISTS user_roles
(
    role_id    BIGINT       NOT NULL,
    user_username VARCHAR(255) NOT NULL,
    PRIMARY KEY (role_id, user_username),
    CONSTRAINT fk_user_roles_role FOREIGN KEY (role_id) REFERENCES roles (id),
    CONSTRAINT fk_user_roles_user FOREIGN KEY (user_username) REFERENCES users (username)
);
