package springBootMVCShopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import springBootMVCShopping.command.LoginCommand;
import springBootMVCShopping.service.CookieService;
import springBootMVCShopping.service.goods.MainGoodsListService;

@Controller
public class MainController {
	@Autowired
	MainGoodsListService mainGoodsListService;
	@Autowired
	CookieService cookieService;
	
	@RequestMapping("/")
	public String index(
			@ModelAttribute("loginCommand") LoginCommand loginCommand,
			Model model ,HttpSession session
			, HttpServletRequest request) {
		cookieService.excute(request, model);
		mainGoodsListService.execute(null, model, session, request);
		return "thymeleaf/index";
	}
}