INSERT INTO appointments (id, date, time)
VALUES
    (1, "October 24th", "10.00"),
    (2, "October 24th", "11.00");

INSERT INTO users (username, password, enabled)
VALUES
--    ('user', '{noop}password', TRUE),
--    ('admin', '{noop}password', TRUE);
    --in plaats hiervan gaan we encrypted ww gebruiken:
('user', '$2a$12$2CSgm1e2tLltFx9ltNc/puAT1YRdd9qLXdYtRecoJWDGEYwjCK0FK', TRUE),
('admin', '$2a$12$A4hm/D8B6jYtFscTBBf9Q.OhzLeK9773U925KKiL9jhNi.fFvsxm2', TRUE);

INSERT INTO authorities (username, authority)
VALUES
    ('user', 'ROLE_USER'),
    ('admin', 'ROLE_USER'),
    ('admin', 'ROLE_ADMIN');