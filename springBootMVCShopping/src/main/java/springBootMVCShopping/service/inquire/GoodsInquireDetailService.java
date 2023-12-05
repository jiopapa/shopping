package springBootMVCShopping.service.inquire;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import springBootMVCShopping.domain.InquireDTO;
import springBootMVCShopping.mapper.InquireMapper;

@Service
public class GoodsInquireDetailService {
	@Autowired
	InquireMapper inquireMapper;
	public void execute(Integer inquireNum, Model model) {
		List<InquireDTO>list = inquireMapper.inquireList(null, inquireNum);
		model.addAttribute("list", list);
	}
}
