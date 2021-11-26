CREATE TABLE `cinema`.`films`
(      `id` BIGINT NOT NULL AUTO_INCREMENT ,
        `title` VARCHAR(50) NOT NULL ,
        `length` SMALLINT NOT NULL ,
        PRIMARY KEY (`id`)
);

CREATE TABLE `cinema`.`sessions`
(     `id` BIGINT NOT NULL AUTO_INCREMENT ,
      `film_id` BIGINT NOT NULL ,
      `date` DATE NOT NULL ,
      `time` TIME NOT NULL ,
      `price` DECIMAL NOT NULL ,
      PRIMARY KEY (`id`),
      FOREIGN KEY (film_id) REFERENCES films (id)
;

CREATE TABLE `cinema`.`tickets`
(    `id` BIGINT NOT NULL AUTO_INCREMENT ,
     `session_id` BIGINT NOT NULL ,
     `number` INT NOT NULL ,
     PRIMARY KEY (`id`),
     FOREIGN KEY (session_id) REFERENCES sessions (id)
;

INSERT INTO `films` (`title`, `length`) VALUES
    ('Джентельмены удачи', '88'),
    ('Иван Васильевич меняет профессию', '93'),
    ('Операция Ы', '96'),
    ('Кавказская пленница', '88'),
    ('Бриллиантовая рука', '100')

INSERT INTO `sessions` (`film_id`, `date`, `time`, `price`) VALUES
    (1, '2021-12-30', '08:00:00', 100),
    (2, '2021-12-30', '09:30:00', 100),
    (3, '2021-12-30', '11:30:00', 120),
    (4, '2021-12-30', '11:40:00', 150),
    (5, '2021-12-30', '14:30:00', 150),
    (1, '2021-12-30', '16:00:00', 200),
    (2, '2021-12-30', '18:30:00', 200),
    (3, '2021-12-30', '19:30:00', 220),
    (4, '2021-12-30', '20:40:00', 250),
    (5, '2021-12-30', '21:00:00', 250)


INSERT INTO `tickets` (`session_id`, `number`) VALUES
    (1, 100101),
    (1, 100102),
    (2, 100201),
    (2, 100203),
    (4, 100401),
    (4, 100402),
    (4, 100403),
    (5, 100501),
    (5, 100502),
    (6, 100601),
    (7, 100701),
    (8, 100801),
    (9, 100901),
    (10, 101001),
    (10, 101002),
    (10, 101003),
    (10, 101004),
    (10, 101005),
    (10, 101006),
    (10, 101007),
    (10, 101008),
    (10, 101009)

#ошибки в расписании (фильмы накладываются друг на друга), отсортированные по возрастанию времени. Выводить надо колонки «фильм 1», «время начала», «длительность», «фильм 2», «время начала», «длительность»;
SELECT films_3.title AS 'Фильм 1', sessions_2.time AS 'Время начала', films.title AS 'Фильм 2', sessions.time AS 'Время начала', TIMESTAMPDIFF(MINUTE, sessions_2.time, sessions.time) - films_3.length AS 'Длительность перерыва'
FROM sessions
         JOIN films ON sessions.film_id = films.id
         LEFT JOIN sessions AS sessions_2 ON sessions_2.id = sessions.id - 1
         LEFT JOIN films AS films_3 ON films_3.id = sessions_2.film_id
WHERE TIMESTAMPDIFF(MINUTE, sessions_2.time, sessions.time) - films_3.length < 0
ORDER BY sessions.time

#перерывы 30 минут и более между фильмами — выводить по уменьшению длительности перерыва. Колонки «фильм 1», «время начала», «длительность», «время начала второго фильма», «длительность перерыва»;
SELECT films_3.title AS 'Фильм', sessions_2.time AS 'Время начала', films_3.length AS 'Длительность', sessions.time AS 'Время начала второго фильма', TIMESTAMPDIFF(MINUTE, sessions_2.time, sessions.time) - films_3.length AS 'Длительность перерыва'
FROM sessions
         JOIN films ON sessions.film_id = films.id
         LEFT JOIN sessions AS sessions_2 ON sessions_2.id = sessions.id - 1
         LEFT JOIN films AS films_3 ON films_3.id = sessions_2.film_id
WHERE TIMESTAMPDIFF(MINUTE, sessions_2.time, sessions.time) - films_3.length >= 30
ORDER BY sessions.time