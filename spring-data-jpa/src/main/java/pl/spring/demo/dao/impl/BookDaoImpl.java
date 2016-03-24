package pl.spring.demo.dao.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Component;

import pl.spring.demo.annotation.NullableId;
import pl.spring.demo.dao.BookDao;
import pl.spring.demo.entity.BookEntity;
import pl.spring.demo.to.AuthorTo;

@Component
public class BookDaoImpl implements BookDao {

	private final Set<BookEntity> ALL_BOOKS = new HashSet<>();

	public BookDaoImpl() {
		addTestBooks();
	}

	@Override
	public List<BookEntity> findAll() {
		return new ArrayList<>(ALL_BOOKS);
	}

	@Override
	public List<BookEntity> findBookByTitle(String title) {
		List<BookEntity> result = new ArrayList<>();
		
		for(BookEntity book : ALL_BOOKS)
			if(book.getTitle().equals(title))
				result.add(book);
		
		return result;
	}

	@Override
	public List<BookEntity> findBooksByAuthor(String author) {
		List<BookEntity> result = new ArrayList<>();
		author = author.trim();
		String[] wantedAuthor = author.split(" ");

		for(BookEntity book : ALL_BOOKS)
			for(AuthorTo bookAuthor: book.getAuthors()) 
				if(bookAuthor.getFirstName().equals(wantedAuthor[0]) && bookAuthor.getLastName().equals(wantedAuthor[1])) {
					result.add(book);
			}
			
		return result;
	}

	@Override
	@NullableId
	public BookEntity save(BookEntity book) {
		ALL_BOOKS.add(book);
		return book;
	}

	private void addTestBooks() {
		ALL_BOOKS.add(new BookEntity(0L, "Romeo i Julia", Arrays.asList(new AuthorTo(0L, "William", "Szekspir"))));
		ALL_BOOKS.add(new BookEntity(1L, "Opium w rosole", Arrays.asList(new AuthorTo(1L, "Małgorzata", "Musierowicz"))));
		ALL_BOOKS.add(new BookEntity(2L, "Przygody Odyseusza", Arrays.asList(new AuthorTo(2L, "Jan", "Parandowski"))));
		ALL_BOOKS.add(new BookEntity(3L, "Awantura w Niekłaju", Arrays.asList(new AuthorTo(3L, "Edmund", "Niziurski"))));
		ALL_BOOKS.add(new BookEntity(4L, "Pan Samochodzik i Fantomas", Arrays.asList(new AuthorTo(4L, "Zbigniew", "Nienacki"))));
		ALL_BOOKS.add(new BookEntity(5L, "Zemsta", Arrays.asList(new AuthorTo(5L, "Aleksander", "Fredro"))));
	}

}