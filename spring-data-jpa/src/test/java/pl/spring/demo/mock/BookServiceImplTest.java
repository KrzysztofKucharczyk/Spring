package pl.spring.demo.mock;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import pl.spring.demo.dao.BookDao;
import pl.spring.demo.entity.BookEntity;
import pl.spring.demo.mapper.BookMapper;
import pl.spring.demo.service.impl.BookServiceImpl;
import pl.spring.demo.to.AuthorTo;
import pl.spring.demo.to.BookTo;

public class BookServiceImplTest {

	@InjectMocks
	private BookServiceImpl bookService;

	@Mock
	private BookDao bookDao;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@After
	public void validate() {
		Mockito.validateMockitoUsage();
	}

	@Test
	public void testShouldSaveBook() {
		// given
		BookTo book = new BookTo(null, "title", "firstName lastName");
		Mockito.when(bookDao.save(BookMapper.bookToConversionToBookEntity(book))).thenReturn(new BookEntity(1L, "title", Arrays.asList(new AuthorTo(null, "firstName", "lastName"))));
		// when
		BookTo result = bookService.saveBook(book);
		// then
		Mockito.verify(bookDao).save(BookMapper.bookToConversionToBookEntity(book));
		assertEquals(1L, result.getId().longValue());
	}
}