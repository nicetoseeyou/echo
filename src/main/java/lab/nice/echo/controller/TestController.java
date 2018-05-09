package lab.nice.echo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/")
public class TestController {

	@RequestMapping(value = "/index")
	public String index() {
		return "index";
	}
}
