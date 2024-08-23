package design.jaine.spring.test.ajax;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BookingController {
	@GetMapping("/ajax/pension/info")
	public String getInfo() {
		return "ajax/pensionInfo";
	}
}
