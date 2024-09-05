package design.jaine.spring.test.ajax;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import design.jaine.spring.test.ajax.domain.Booking;
import design.jaine.spring.test.ajax.service.BookingService;

@Controller
@RequestMapping("/ajax/pension")
public class BookingController {
	@Autowired
	private BookingService bookingservice;
	
	@GetMapping("/info")
	public String getInfo() {
		return "ajax/pensionInfo";
	}
	
	@GetMapping("/list") 
	public String getList(Model model) {
		List<Booking> bookingList = bookingservice.getBookingList();
		model.addAttribute("bookingList", bookingList);
		
		return "ajax/pensionList";
	}
	
	@GetMapping("/book")
	public String getBook() {
		return "ajax/pensionBook";
	}
	
	@GetMapping("/create")
	@ResponseBody
	public Map<String, String> createBooking(
			@RequestParam("name") String name
			, @RequestParam("date") @DateTimeFormat(pattern="yyyy년 M월 d일") LocalDate date
			, @RequestParam("day") int day
			, @RequestParam("headcount") int headcount
			, @RequestParam("phoneNumber") String phoneNumber) {
		
		int count = bookingservice.addBooking(name, date, day, headcount, phoneNumber);
		
		// {"result" : success} or fail
		
		Map<String, String> resultMap = new HashMap<>();
		
		if(count == 1) {
			resultMap.put("result", "success");
		} else {
			resultMap.put("result", "fail");
		}
		
		return resultMap;
	}
	
	@GetMapping("/delete")
	@ResponseBody
	public Map<String, String> deleteBooking(@RequestParam("id") int id) {
		int count = bookingservice.deleteBooking(id);
		// {"result" : success} or fail
		
		Map<String, String> resultMap = new HashMap<>();
		
		if(count == 1) {
			resultMap.put("result", "success");
		} else {
			resultMap.put("result", "fail");
		}
		
		return resultMap;
	}
	
	// 이름과 전화번호를 전달받고, 일치하는 예약 정보를 response에 data로 채우는 API
	
	@GetMapping("/search")
	@ResponseBody
	public Booking searchBooking(
			@RequestParam("name") String name
			, @RequestParam("phoneNumber") String phoneNumber
			) {
		Booking booking = bookingservice.getBooking(name, phoneNumber);
		
		// {"name": "김인규" ... }
		return booking;
	}
}








