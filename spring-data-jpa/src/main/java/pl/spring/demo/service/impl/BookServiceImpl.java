package pl.spring.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import pl.spring.demo.dao.BookDao;
import pl.spring.demo.mapper.BookMapper;
import pl.spring.demo.service.BookService;
import pl.spring.demo.to.BookTo;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
    private BookDao bookDao;

    @Override
    @Cacheable("booksCache")
    
    public List<BookTo> findAllBooks() {
    	return BookMapper.bookEntityConversionToBookTo(bookDao.findAll());
    }

    @Override
    public List<BookTo> findBooksByTitle(String title) {
        return BookMapper.bookEntityConversionToBookTo(bookDao.findBookByTitle(title));
    }

    @Override
    public List<BookTo> findBooksByAuthor(String author) {
        return BookMapper.bookEntityConversionToBookTo(bookDao.findBooksByAuthor(author));
    }

    @Override
    public BookTo saveBook(BookTo book) {
        return BookMapper.bookEntityConversionToBookTo(bookDao.save(BookMapper.bookToConversionToBookEntity(book)));
    }

    public void setBookDao(BookDao bookDao) {
        this.bookDao = bookDao;
	}
    
}