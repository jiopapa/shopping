package springBootMVCShopping.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpSession;
import springBootMVCShopping.command.FileCommand;

@Service
public class FileDelService {

	//이것을 이용하면 session을 이용한 장바구니도 가능하다.
	public String execute(FileCommand fileCommand, HttpSession session) {
		String num = "";
		Boolean newFile = true; //새로운 상품인지 아닌지를 확인 하기 위한 변수;
		//이미 상품이 등록되어 있으면 session이 있으므로 session 유뮤를 먼저 확인
		List<FileCommand> list = (List<FileCommand>)session.getAttribute("fileList");
		//첫 상품인 경우 session이 없으니 session 및 list가 없다. list를 먼저 생성해야 한다.
		if(list ==null) {
			list = new ArrayList<FileCommand>();
		}
		// session이 있으면 list가 있으므로 list에 어떤 상품이 존재하는지 확인
		for(int i = 0 ; i <list.size(); i++) {
			if(list.get(i).getStoreFile().equals(fileCommand.getStoreFile())) {
				
				//fileInfoCommand.setQty(fileInfoCommand.getQty()+1); 장바구니일때는 수량 +1
				list.remove(i);
				newFile = false;
				num= "0";
			}
		}
		//새로운 상품인 경우
		if(newFile) {
			list.add(fileCommand);
			num= "1";
		}
		session.setAttribute("fileList", list);
		return num;
	}
}
