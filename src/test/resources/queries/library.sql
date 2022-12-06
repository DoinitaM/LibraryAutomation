--US107-Anahit
SELECT name,author,year FROM books
where name='Chordeiles minor';

--US06-Valeriia
select b.name as book_name, b.author, b.isbn, b.year, bc.name as book_category from books b
    inner join book_categories bc on b.book_category_id = bc.id
where b.name in ('Woe from Wit');

select b.name as book_name, b.author, b.isbn, b.year, bc.name as book_category from books b
     inner join book_categories bc on b.book_category_id = bc.id
where b.name in ('Crime and Punishment');

select b.name as book_name, b.author, b.isbn, b.year, bc.name as book_category from books b
  inner join book_categories bc on b.book_category_id = bc.id
where b.name in ('Heart of a Dog');

