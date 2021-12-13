package com.kh.spring15.repository;
import java.io.IOException;
import org.springframework.web.multipart.MultipartFile;
import com.kh.spring15.entity.MemberProfileDto;

public interface MemberProfileDao {
	void save(MemberProfileDto memberProfileDto, MultipartFile multipartFile) throws IllegalStateException, IOException;
	MemberProfileDto get(int memberProfileNo);
	MemberProfileDto get(String memberId);
	byte[] load(int memberProfileNo) throws IOException;
}
