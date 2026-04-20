CREATE TABLE users (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    phone VARCHAR(30),
    address VARCHAR(255),
    status VARCHAR(20) DEFAULT 'draft',
    avatar VARCHAR(500)
);