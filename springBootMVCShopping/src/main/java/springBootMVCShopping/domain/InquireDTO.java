package springBootMVCShopping.domain;

import java.util.Date;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("inquire")
public class InquireDTO {
	Integer inquireNum;
	String goodsNum;
	String memberNum;
	String inquireSubject;
	String inquireContent;
	String inquireKind;
	Date inquireDate;
	String inquireAnswer;
	Date inquireAnswerDate;
	String empNum;
	
	String memberId;
	String goodsName;
}
