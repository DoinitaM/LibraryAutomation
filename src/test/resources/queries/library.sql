
select name, author,year from books
where name='Chordeiles minor';


select name from book_categories;

select count(*) as borrowedBooks from users u
inner join book_borrow b on u.id = b.user_id where is_returned = 0;

select count(*) from book_borrow
where is_returned=0;

select * from users;

select id from users;

select count(id)  from users;

select count( distinct id)  from users;

select * from users;

select bc.name,count(*) from book_borrow bb
                                 inner  join books b on bb.book_id = b.id
                                 inner join book_categories bc on b.book_category_id=bc.id
group by name
order by 2 desc;

select book_id,count(*) from book_borrow
group by book_id
order by 2 desc;