package springBootMVCShopping.service.corner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpSession;
import springBootMVCShopping.domain.AuthInfoDTO;
import springBootMVCShopping.domain.MemberDTO;
import springBootMVCShopping.mapper.CartWishMapper;
import springBootMVCShopping.mapper.MemberMyMapper;

@Service
public class GoodsWishService {
	@Autowired
	MemberMyMapper memberMyMapper;
	@Autowired
	CartWishMapper cartWishMapper;
	public String execute(String goodsNum, HttpSession session) {
		AuthInfoDTO auth = (AuthInfoDTO)session.getAttribute("auth");
		MemberDTO memDTO = memberMyMapper.memberInfo(auth.getUserId());
		Integer i = cartWishMapper.wishGoodsSelect(goodsNum, memDTO.getMemberNum());
		if(i ==null) {
			cartWishMapper.wishInsert(goodsNum, memDTO.getMemberNum());
			return "1";
		}else if(i == 1) {
			cartWishMapper.wishDelete(goodsNum, memDTO.getMemberNum());
			return "0";
		}else {
			return null;
		}

	}
}
