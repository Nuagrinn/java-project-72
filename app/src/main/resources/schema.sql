DROP TABLE IF EXISTS url_checks;
DROP TABLE IF EXISTS urls;

CREATE TABLE urls (
    id SERIAL PRIMARY KEY NOT NULL,
    name VARCHAR NOT NULL,
    created_at TIMESTAMP,
    CONSTRAINT pk_url PRIMARY KEY (id)
);

CREATE TABLE url_checks
(
    id SERIAL PRIMARY KEY NOT NULL,
    url_id BIGINT REFERENCES urls (id),
    status_code INT,
    h1 VARCHAR,
    title VARCHAR,
    description TEXT,
    created_at TIMESTAMP,
    CONSTRAINT pk_url_checks PRIMARY KEY (id)

);








