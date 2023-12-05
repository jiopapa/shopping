package springBootMVCShopping.service.goodsIpgo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import springBootMVCShopping.domain.GoodsDTO;
import springBootMVCShopping.domain.StartEndPageDTO;
import springBootMVCShopping.mapper.GoodsMapper;
import springBootMVCShopping.service.StartEndPageService;

@Service
public class GoodsItemService {
	@Autowired
	GoodsMapper goodsMapper;
	String searchWord;
	@Autowired
	StartEndPageService startEndPageService;
	
	
	public Map<String,Object> execute(String searchWord, int page) {
		Map<String, Object>map = new HashMap<String,Object>();
		int limit = 3;
		if(searchWord != null) {
			this.searchWord = searchWord.trim();
		}
		StartEndPageDTO sepDTO = startEndPageService.execute(page, this.searchWord);
		List<GoodsDTO> list = goodsMapper.allSelect(sepDTO);

		int count = goodsMapper.goodsCount(this.searchWord);
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
		map.put("dtos", list);
		map.put("searchWord", searchWord);
		map.put("page", page);
		map.put("startPage", startPage);
		map.put("endPage", endPage);
		map.put("count", count);
		map.put("maxPage", maxPage);
			
		return map;
	}

}
