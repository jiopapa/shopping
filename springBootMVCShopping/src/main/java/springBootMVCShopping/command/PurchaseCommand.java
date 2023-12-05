package springBootMVCShopping.command;

import lombok.Data;

@Data
public class PurchaseCommand {
	Integer sumTotalPrice;
	Integer sumDeliveryCost;
	Integer sumPrice;
	String goodsNums;
	String deliveryName;
	String deliveryAddr;
	String deliveryAddrDetail;
	String deliveryPost;
	String deliveryPhone;
	String message;	
}
