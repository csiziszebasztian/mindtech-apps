-- changeset dev:001-creat-users-table
CREATE TABLE IF NOT EXISTS users
(
    id       UUID DEFAULT GEN_RANDOM_UUID() PRIMARY KEY,
    name     VARCHAR(255),
    email    VARCHAR(255) UNIQUE NOT NULL,
    password VARCHAR(255)        NOT NULL
);

-- changeset dev:002-create-user-pokemons-table
CREATE TABLE IF NOT EXISTS user_pokemons
(
    id         UUID    DEFAULT GEN_RANDOM_UUID() PRIMARY KEY,
    pokemon_id BIGINT,
    user_id    UUID NOT NULL,
    isReleased BOOLEAN DEFAULT FALSE,
    CONSTRAINT fk_user FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
);

