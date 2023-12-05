package springBootMVCShopping.domain;

import java.util.Date;

import org.apache.ibatis.type.Alias;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
@Alias("mem")
public class MemberDTO { //table 의 컬럼명과 같아야 함
	   String memberNum;
	   String memberId;
	   String memberPw;
	   String memberName;
	   String memberAddr;
	   String memberAddrDetail;
	   String memberPost;
	   String gender;
	   String memberPhone1;
	   String memberPhone2;
	   String memberEmail;
	   @DateTimeFormat(pattern = "yyyy-MM-dd")
	   Date memberRegist;
	   Date memberBirth;
	   String memberEmailConf;
	   Integer point;
}
