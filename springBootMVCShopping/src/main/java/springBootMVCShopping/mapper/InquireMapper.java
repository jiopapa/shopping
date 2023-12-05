package springBootMVCShopping.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import springBootMVCShopping.domain.InquireDTO;

@Mapper
public interface InquireMapper {
	public List<InquireDTO> inquireList(@Param("goodsNum")String goodsNum, @Param("inquireNum")Integer inquireNum);
	public void inquireInsert(InquireDTO dto);
	public InquireDTO inquireUpdate(InquireDTO dto);
	public void inquireDelete(Integer inquireNum);
	public int inquireAnswerUpdate(InquireDTO dto);
}
