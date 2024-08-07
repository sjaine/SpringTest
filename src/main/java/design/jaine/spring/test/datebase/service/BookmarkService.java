package design.jaine.spring.test.datebase.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import design.jaine.spring.test.datebase.domain.Bookmark;
import design.jaine.spring.test.datebase.repository.BookmarkRepository;

@Service
public class BookmarkService {
	
	@Autowired
	private BookmarkRepository bookmarkRepository;
	
	public List<Bookmark> getBookmarkList() {
		List<Bookmark> bookmarkList = bookmarkRepository.selectBookmarkList();
		return bookmarkList;
	}
}
