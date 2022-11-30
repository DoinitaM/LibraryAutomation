
select name, author,year from books
where name='Chordeiles minor';


select name from book_categories;

select count(*) as borrowedBooks from users u
inner join book_borrow b on u.id = b.user_id where is_returned = 0;

select count(*) from book_borrow
where is_returned=0;

