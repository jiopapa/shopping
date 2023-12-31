package springBootMVCShopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpSession;
import springBootMVCShopping.command.FileCommand;
import springBootMVCShopping.service.EmailCheckService;
import springBootMVCShopping.service.FileDelService;
import springBootMVCShopping.service.UserEmailCheckService;

@RestController
public class CheckRestController {
	@Autowired
	EmailCheckService emailCheckService;
	@Autowired
	UserEmailCheckService userEmailCheckService;
	@Autowired
	FileDelService fileDelService;
	
	@PostMapping("goods/fileDel")
	public String fileDel(FileCommand fileCommand, HttpSession session) {
		return fileDelService.execute(fileCommand, session);
	}
	
	@RequestMapping("userConfirm")
	public String userConfirm(@RequestParam(value="chk") String chk) {
		int i = userEmailCheckService.execute(chk);
		if(i == 0 ) {
			return "이미 인증되었습니다.";
		}else return "인증되었습니다.";
	}
	@RequestMapping(value = "checkRest/userEmailCheck", method = RequestMethod.POST)

	public String userEmailCheck(@RequestParam(value = "userEmail") String userEmail) {

		String result = emailCheckService.execute(userEmail);
		if (result == null) {
			return "사용가능한 이메일입니다.";
		} else {
			return "사용중인 이메일입니다.";
		}
	}
}
