package pl.spring.demo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pl.spring.demo.common.Sequence;
import pl.spring.demo.dao.BookDao;
import pl.spring.demo.entity.BookEntity;
import pl.spring.demo.exception.BookNotNullIdException;
import pl.spring.demo.mapper.BookMapper;
import pl.spring.demo.to.IdAware;

@Aspect
@Component
public class BookDaoAdvisor {

	@Autowired
	private Sequence sequence;

	@Autowired
	private BookDao bookDao;

	// -----------------------------------------------------
	// PointCut -> Before methods
	@Pointcut("execution(public pl.spring.demo.entity.BookEntity pl.spring.demo.dao.BookDao.save(pl.spring.demo.entity.BookEntity))")
	public void pointCutSave() {
	}

	@Pointcut("@annotation(pl.spring.demo.annotation.NullableId)")
	public void pointCutNullableId() {
	}

	// -----------------------------------------------------
	
	@Before("pointCutSave()")
	public void beforeSave(JoinPoint join) {
		BookEntity book = (BookEntity) join.getArgs()[0];
		if (book.getId() == null) {
			book.setId(sequence.nextValue(BookMapper.bookEntityConversionToBookTo(bookDao.findAll())));
		}
	}

	@Before("pointCutNullableId()")
	public void beforeNullableId(JoinPoint join) {
		checkNotNullId(join.getArgs()[0]);
	}

	// -----------------------------------------------------
	
	private void checkNotNullId(Object o) {
		if (o instanceof IdAware && ((IdAware) o).getId() != null) {
			throw new BookNotNullIdException();
		}
	}

}