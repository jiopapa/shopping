package springBootMVCShopping.command;

import java.util.Date;

import org.apache.ibatis.type.Alias;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Alias("delivery")
public class DeliveryCommand {
	String purchaseNum;
	@NotBlank(message="송장번호를 입력해 주세요.")
	String deliveryNumber;
	Date deliveryDate;
	String deliveryState;
	String deliveryCompany;
}
