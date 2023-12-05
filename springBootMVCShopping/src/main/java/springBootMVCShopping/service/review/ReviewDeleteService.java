package springBootMVCShopping.service.review;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springBootMVCShopping.repository.ReviewRepository;

@Service
public class ReviewDeleteService {
	@Autowired
	ReviewRepository repository;
	public void execute(String reviewNum) {
		repository.reviewDelete(Integer.parseInt(reviewNum));
	}
}
