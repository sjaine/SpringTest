package design.jaine.spring.test.datebase;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import design.jaine.spring.test.datebase.domain.Bookmark;
import design.jaine.spring.test.datebase.service.BookmarkService;

@Controller
public class BookmarkController {

	@Autowired
	private BookmarkService bookmarkService;
	
	@RequestMapping("/db/bookmark/list")
	@ResponseBody
	public List<Bookmark> bookmarkList() {
		List<Bookmark> bookmarkList = bookmarkService.getBookmarkList();
		return bookmarkList;
	}
}
