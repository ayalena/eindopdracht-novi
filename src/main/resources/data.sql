--INSERT INTO appointments
--(id, date, time)
--
--VALUES
--(1, "October 24th", "10.00"),
--(2, "October 24th", "11.00");

    INSERT INTO users (username, password, enabled)
    VALUES
    ('user', '{noop}password', TRUE),
    ('admin', '{noop}password', TRUE);
    --in plaats hiervan gaan we encrypted ww gebruiken:
    --('user', '$2a$12$/qvUQlMHbJ0mc.BYL.NUme41on.RaDNkPIswk6Md1mAduUdvemnKi', TRUE),
    --('admin', '$2a$12$/qvUQlMHbJ0mc.BYL.NUme41on.RaDNkPIswk6Md1mAduUdvemnKi', TRUE);

    INSERT INTO authorities (username, authority)
    VALUES
    ('user', 'ROLE_USER'),
    ('admin', 'ROLE_USER'),
    ('admin', 'ROLE_ADMIN');