select * from books;

select count(*) as borrowedBooks from users u
inner join book_borrow bb on u.id = bb.user_id
where is_returned=0;

