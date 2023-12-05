package springBootMVCShopping.command;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class GoodsCommand {
	String goodsNum;
	
	@NotEmpty(message = "이름을 입력해 주세요.")
	String goodsName;
	
	@NotNull(message = "금액을 입력해 주세요.")
	@Min(value =0 ,message = "최저값은 0이어야 합니다.")
	Integer goodsPrice;
	
	@NotNull(message = "배송비를 입력해 주세요.")
	@Min(value =0, message = "최저값은 0이어야 합니다.")
	Integer deliveryCost;
	
	@NotEmpty(message = "설명을 입력해 주세요.")
	String goodsContent;
	
	String empNum;
	Integer visitCount;
	Date goodsRegist;
	String updateEmpNum;
	Date goodsUpdateDate;
	

	MultipartFile goodsMainStore;
	MultipartFile goodsImages[];
}
