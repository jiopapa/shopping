package springBootMVCShopping.domain;

import java.util.Date;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("review")
public class ReviewDTO {
	Integer reviewNum;
	String goodsNum;
	Date reviewDate;
	String reviewContent;
	String purchaseNum;
	Integer score;
	
	String memberId; //추가속성
}
