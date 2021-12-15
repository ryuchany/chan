package com.kh.spring20.repository;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.kh.spring20.entity.CertificationDto;
@Repository
public class CertificationDaoImpl implements CertificationDao{
	@Autowired
	private SqlSession sqlSession;

	@Override
	public void insert(CertificationDto certificationDto) {
//		인증번호 발송이력 조회(프로그래밍 위주 방식)
//		CertificationDto findDto = sqlSession.selectOne("certification.get", certificationDto.getEmail());
//		if(findDto != null) {//인증번호가 발송된 적이 있다면 -> update
//			sqlSession.update("certification.update", certificationDto);
//		}
//		else {//인증번호가 발송된 적이 없다면 -> insert
//			sqlSession.insert("certification.insert", certificationDto);
//		}

//		merge into 구문 호출
		sqlSession.insert("certification.allInOneInsert", certificationDto);
	}

	@Override
	public boolean check(CertificationDto certificationDto) {
		CertificationDto findDto = sqlSession.selectOne("certification.check", certificationDto);
		if(findDto != null) {//인증 성공 시
			sqlSession.delete("certification.delete", certificationDto.getEmail());
			return true;
		}
		else {//인증 실패 시
			return false;
		}
	}
	
	@Override
	public void clean() {
		sqlSession.delete("certification.clean");
	}
	
}