package springBootMVCShopping.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import springBootMVCShopping.domain.StartEndPageDTO;

@Service
public class StartEndPageService {
	int limit;
	
	public StartEndPageDTO execute(int page, String searchWord) {
		
	
	limit = 3; //페이지당 최대 수량.
	int startRow = ((page -1 )* limit) +1 ;
	int endRow = startRow + limit -1 ; 
	StartEndPageDTO sepDTO = new StartEndPageDTO();
	sepDTO.setEndRow(endRow);
	sepDTO.setSearchWord(searchWord);
	sepDTO.setStartRow(startRow);
	
	return sepDTO;
	}
	public void execute(int page, int count, Model model, 
						List list, String searchWord) {
		
		int limitPage = 10; //페이지 최대 수량.
		// 1 ~ 10  : 1
		// 11 ~ 20 : 11
		// 21 ~ 30 : 21
		// (int)((page - 1 )/limitPage) * limitPage +1 ; 
		//		11 - 1   10        * 10    + 1  = 1;
		//		20	- 1 / 10 		*10    + 1 = 11;
		//      25   - 1 / 10		*10		+1	= 21;
		int startPage = (int)((double)page / limitPage + 0.999 -1) * limitPage +1;
		
		//1
		int endPage = startPage + limitPage - 1;
		//10
		int maxPage = (int)((double)count / limit + 0.95);
		if(maxPage < endPage) endPage = maxPage;
		

		model.addAttribute("dtos", list);
		model.addAttribute("searchWord", searchWord);
		model.addAttribute("page", page);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("count", count);
		model.addAttribute("maxPage", maxPage);
		
	}
}
