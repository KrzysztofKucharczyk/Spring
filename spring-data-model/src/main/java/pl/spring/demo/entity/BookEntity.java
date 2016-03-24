package pl.spring.demo.entity;

import java.util.List;

import pl.spring.demo.to.AuthorTo;
import pl.spring.demo.to.IdAware;

public class BookEntity implements IdAware {

	private Long id;
	private String title;
	private List<AuthorTo> authors;

	public BookEntity() {
	}
	
	public BookEntity(Long id, String title, List<AuthorTo> authors) {
		this.id = id;
		this.title = title;
		this.authors = authors;
	}

	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public List<AuthorTo> getAuthors() {
		return authors;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BookEntity other = (BookEntity) obj;
		if (authors == null) {
			if (other.authors != null)
				return false;
		} else if (!authors.equals(other.authors))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
	
	@Override
	public int hashCode() {
		final int prime = 3;
		int result = 1;
		result = prime * result + ((authors == null) ? 0 : authors.hashCode());
		result += prime * result + ((id == null) ? 0 : id.hashCode());
		result += prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

}