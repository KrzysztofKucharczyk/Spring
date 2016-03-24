package pl.spring.demo.mapper;

import java.util.ArrayList;
import java.util.List;

import pl.spring.demo.entity.BookEntity;
import pl.spring.demo.to.AuthorTo;
import pl.spring.demo.to.BookTo;

public class BookMapper {

	public static BookEntity bookToConversionToBookEntity(BookTo book) {
		List<AuthorTo> authors = new ArrayList<>();
		for (String authorsName : book.getAuthors().split("\t")) {
			String[] authorName = authorsName.split(" ");
			authors.add(new AuthorTo(null, authorName[0], authorName[1]));
		}
		return new BookEntity(book.getId(), book.getTitle(), authors);
	}

	public static BookTo bookEntityConversionToBookTo(BookEntity book) {
		String authors = new String();
		for (AuthorTo author : book.getAuthors())
			authors += author.getFirstName() + " " + author.getLastName();

		return new BookTo(book.getId(), book.getTitle(), authors);
	}

	public static List<BookEntity> bookToConversionToBookEntity(List<BookTo> books) {
		List<BookEntity> result = new ArrayList<>();
		for (BookTo book : books)
			result.add(bookToConversionToBookEntity(book));
		return result;
	}

	public static List<BookTo> bookEntityConversionToBookTo(List<BookEntity> books) {
		List<BookTo> result = new ArrayList<>();
		for (BookEntity book : books)
			result.add(bookEntityConversionToBookTo(book));
		return result;
	}

}