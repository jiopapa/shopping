package springBootMVCShopping.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import springBootMVCShopping.domain.ReviewDTO;
import springBootMVCShopping.service.goods.GoodsDetailService;
import springBootMVCShopping.service.review.ReviewDeleteService;
import springBootMVCShopping.service.review.ReviewDetailService;
import springBootMVCShopping.service.review.ReviewListService;
import springBootMVCShopping.service.review.ReviewUpdateService;
import springBootMVCShopping.service.review.ReviewWriteService;

@Controller
@RequestMapping("review")
public class ReviewController {
	@Autowired
	GoodsDetailService goodsDetailService;
	@Autowired
	ReviewWriteService reviewWriteService;
	@Autowired
	ReviewDeleteService reviewDeleteService;
	@Autowired
	ReviewDetailService reviewDetailService; 
	@Autowired
	ReviewUpdateService reviewUpdateService;
	@Autowired
	ReviewListService reviewListService; 
	
	@RequestMapping(value="goodsReview", method=RequestMethod.GET)
	public String goodsReview(
			@ModelAttribute("goodsNum") String goodsNum
			, @ModelAttribute("purchaseNum") String purchaseNum
			, Model model) {
		goodsDetailService.execute(goodsNum, model);
		return "thymeleaf/review/goodsReview";
	}
	@PostMapping("reviewWrite")
	public String reviewWrite(
			@RequestParam(value ="goodsNum") String goodsNum
			,@RequestParam(value ="purchaseNum") String purchaseNum
			,@RequestParam(value ="reviewContent") String reviewContent
			,HttpSession session) {
		reviewWriteService.execute(goodsNum, reviewContent, purchaseNum, session);
		return "redirect:/purchase/orderList";
	}
	@GetMapping("goodsReviewUpdate")
	public String goodsReviewUpdate(
			@ModelAttribute(value="reviewNum") String reviewNum
			, @RequestParam(value="goodsNum") String goodsNum
			, Model model) {
			goodsDetailService.execute(goodsNum, model);
			return "thymeleaf/review/goodsReviewUpdate";
	}
	@PostMapping("goodsReviewUpdate")
	public void goodsReviewUpdate(
			@RequestParam(value="reviewNum") Integer reviewNum
			, HttpServletResponse response) {
		ReviewDTO dto = reviewDetailService.execute(reviewNum);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String reviewDate = sdf.format(dto.getReviewDate());
		response.setCharacterEncoding("utf-8");
		String reviewJson="{ \"reviewNum\":\""+dto.getReviewNum() + "\"";
				reviewJson+=", \"reviewContent\":\""+dto.getReviewContent() + "\"";
				reviewJson+=", \"reviewDate\":\""+reviewDate + "\"}";
				try {
					response.getWriter().print(reviewJson);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}
			
	@GetMapping("goodsReviewDelete")
	public String goodsReviewDelete(
			@RequestParam(value="reviewNum") String reviewNum) {
		reviewDeleteService.execute(reviewNum);
		return "redirect:/purchase/orderList";
	}
	@PostMapping("goodsReviewModify")
	public String goodsReviewModify(
			@RequestParam(value ="reviewNum") Integer reviewNum
			,@RequestParam(value ="reviewContent") String reviewContent
			) {
		reviewUpdateService.execute(reviewNum, reviewContent);
		return "redirect:/purchase/orderList";
	}
	
	@PostMapping("reviewList")
	public String reviewList(
			@RequestParam(value="goodsNum") String goodsNum,
			Model model) {
		reviewListService.execute(goodsNum, model);
		model.addAttribute("newLineChar", "\n");
		return "thymeleaf/review/reviewList";
	}
	
}
