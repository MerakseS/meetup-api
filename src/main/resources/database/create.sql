create table if not exists meetup
(
    id          bigserial primary key,
    description varchar(255),
    organizer   varchar(255),
    time        timestamp(6),
    title       varchar(255),
    venue       varchar(255)
);