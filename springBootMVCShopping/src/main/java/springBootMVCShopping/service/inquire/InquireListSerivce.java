package springBootMVCShopping.service.inquire;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import springBootMVCShopping.domain.InquireDTO;
import springBootMVCShopping.mapper.InquireMapper;

@Service
public class InquireListSerivce {
	@Autowired
	InquireMapper inquireMapper;
	public void execute(String goodsNum, Model model) {
	
		List<InquireDTO>list = inquireMapper.inquireList(goodsNum,null);
		model.addAttribute("list", list);
	}
}
