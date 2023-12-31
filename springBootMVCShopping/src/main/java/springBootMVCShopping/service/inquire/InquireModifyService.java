package springBootMVCShopping.service.inquire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springBootMVCShopping.command.InquireCommand;
import springBootMVCShopping.domain.InquireDTO;
import springBootMVCShopping.mapper.InquireMapper;

@Service
public class InquireModifyService {
	@Autowired
	InquireMapper inquireMapper;
	public void execute(InquireCommand inquireCommand) {
		InquireDTO dto = new InquireDTO();
		dto.setInquireContent(inquireCommand.getInquireContent());
		dto.setInquireKind(inquireCommand.getInquireKind());
		dto.setInquireNum(inquireCommand.getInquireNum());
		dto.setInquireSubject(inquireCommand.getInquireSubject());
		inquireMapper.inquireUpdate(dto);
		
	}
}
