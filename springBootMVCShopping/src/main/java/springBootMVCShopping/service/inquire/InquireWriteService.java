package springBootMVCShopping.service.inquire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import jakarta.servlet.http.HttpSession;
import springBootMVCShopping.command.InquireCommand;
import springBootMVCShopping.domain.AuthInfoDTO;
import springBootMVCShopping.domain.InquireDTO;
import springBootMVCShopping.domain.MemberDTO;
import springBootMVCShopping.mapper.InquireMapper;
import springBootMVCShopping.mapper.MemberMyMapper;

@Service
public class InquireWriteService {
	@Autowired
	MemberMyMapper memberMyMapper;
	@Autowired
	InquireMapper inquireMapper;
	public void execute(InquireCommand inquireCommand,HttpSession session
			, BindingResult result) {
		if(inquireCommand.getInquireSubject()=="") {
			result.rejectValue("inquireSubject","wrong","제목을 입력해주세요");
			//result.rejectValue("inquireSubject","inquireCommand.inquireSubject","제목을 입력해주세요");
			return;
		}
		if(inquireCommand.getInquireContent()=="") {
			result.rejectValue("inquireContent","bad","내용을 입력해주세요");
			return;
		}
		
		
		AuthInfoDTO auth = (AuthInfoDTO	)session.getAttribute("auth");
		MemberDTO memDto = memberMyMapper.memberInfo(auth.getUserId());
		InquireDTO dto = new InquireDTO();
		dto.setGoodsNum(inquireCommand.getGoodsNum());
		dto.setInquireContent(inquireCommand.getInquireContent());
		dto.setInquireKind(inquireCommand.getInquireKind());
		dto.setInquireSubject(inquireCommand.getInquireSubject());
		dto.setMemberNum(memDto.getMemberNum());
		inquireMapper.inquireInsert(dto);
	}
}