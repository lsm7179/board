insert into user
    (id, account_type, account_id, nickname, quit)
values (1, 'NORMAL', 'lsm', '이승민', false);

insert into board
(id, created_date, modified_date, contents, deleted, title, writer_id)
values
    (1, CURRENT_TIMESTAMP , CURRENT_TIMESTAMP, '내용입니다', false , '제목', 1);