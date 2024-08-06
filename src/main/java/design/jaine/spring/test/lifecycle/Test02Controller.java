package design.jaine.spring.test.lifecycle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lifecycle/test02")
public class Test02Controller {
	
	@RequestMapping("1")
	public List<Map<String, Object>> movieList() {
		List<Map<String, Object>> movieList = new ArrayList<>();
		
		Map<String, Object> movieMap = new HashMap<>();
		movieMap.put("rate", 15);
		movieMap.put("director", "봉준호");
		movieMap.put("time", 131);
		movieMap.put("title", "기생충");
		movieList.add(movieMap);
		
		movieMap = new HashMap<>();
		movieMap.put("rate", 0);
		movieMap.put("director", "로베르토 베니");
		movieMap.put("time", 116);
		movieMap.put("title", "인생은 아름다워");
		movieList.add(movieMap);
		
		movieMap = new HashMap<>();
		movieMap.put("rate", 12);
		movieMap.put("director", "크리스토퍼 놀란");
		movieMap.put("time", 147);
		movieMap.put("title", "인셉션");
		movieList.add(movieMap);
		
		movieMap = new HashMap<>();
		movieMap.put("rate", 19);
		movieMap.put("director", "윤종빈");
		movieMap.put("time", 133);
		movieMap.put("title", "범죄와의 전쟁: 나쁜놈들 전성시대");
		movieList.add(movieMap);
		
		movieMap = new HashMap<>();
		movieMap.put("rate", 15);
		movieMap.put("director", "프란시스 로렌스");
		movieMap.put("time", 137);
		movieMap.put("title", "헝거게임");
		movieList.add(movieMap);
		
		return movieList;
	}
	
	
	@RequestMapping("2")
	public List<Board> board() {
		List<Board> boardList = new ArrayList<>();
		
		Board first = new Board("안녕하세요 가입인사 드립니다.", "hagulu", "안녕하세요. 가입했어요. 앞으로 잘 부탁드립니다. 활동 열심히 하겠습니다.");
		Board second = new Board("헐 대박", "bada", "오늘 목요일이었어... 금요일인줄");
		Board third = new Board("오늘 데이트 한 이야기 해드릴게요.", "dulumary", "...");
		
		boardList.add(first);
		boardList.add(second);
		boardList.add(third);
		
		return boardList;
	}
	
	@RequestMapping("3")
	public ResponseEntity responseEntity() {
		Board first = new Board("안녕하세요 가입인사 드립니다.", "hagulu", "안녕하세요. 가입했어요. 앞으로 잘 부탁드립니다. 활동 열심히 하겠습니다.");
		return new ResponseEntity(first, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
