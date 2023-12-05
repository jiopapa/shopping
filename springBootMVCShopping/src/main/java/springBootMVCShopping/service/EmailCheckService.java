package springBootMVCShopping.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springBootMVCShopping.mapper.LoginMapper;

@Service
public class EmailCheckService {
	@Autowired
	LoginMapper loginmapper;
	
	public String execute(String userEmail) {
		String resultEmail = loginmapper.selectEmailCheck(userEmail);
		
		return resultEmail;
	}
}
