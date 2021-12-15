package com.kh.spring20.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.kh.spring20.repository.CertificationDao;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ScheduleServiceImpl implements ScheduleService{

	@Autowired
	private CertificationDao certificationDao;

//	스케쥴러 설정
//	= 매 정각마다, 매주 수요일마다, 매월 첫째 금요일마다와 같은 주기적인 작업을 처리하는 도구
//	= cron 표현식을 이용하여 문자열 형태의 식으로 주기를 설정할 수 있다.

//	cron 표현식
//	= 좌측부터 (초, 분, 시, 일, 월, 요일, 연도)를 설정할 수 있으며, 연도는 일반적으로 설정을 안한다.
//	= *를 사용하면 매 주기마다(바뀔 때마다) 라는 뜻을 가진다
//	= /를 사용하면 주기를 설정할 수 있다(ex : 맨 좌측에 */5 라고 쓰면 매 5초마다)
//	= -를 사용하면 범위를 설정할 수 있다(ex : 맨 좌측에 10-20을 작성하면 10초부터 20초까지)
//	= ,를 사용하면 여러 개의 값을 설정할 수 있다.
//	= ?를 사용하면 값이 어느 것이어도 무방하다는 의미를 가진다.

//	@Scheduled(initialDelay = 1000L, fixedDelay = 2000L)//1초후부터 2초마다
//	@Scheduled(cron = "* * * * * *")//매초 매분 매시각 매일 매월 매요일마다(1초마다)
//	@Scheduled(cron = "*/2 * * * * *")//매 2초 매분 매시각 매일 매월 매요일마다(2초마다)
//	@Scheduled(cron = "10-20 * * * * *")//매 분 10~20초 사이에만
	@Scheduled(cron = "0 0 * * * *")//매 정각마다
//	@Scheduled(cron = "0 0 9-18 * * 1-5")//업무시간 중 매 정각
//	@Scheduled(cron = "0 0 9,18 * * 1-5")//출,퇴근시에만 (오전9시, 오후6시)
//	@Scheduled(cron = "0 0 9,18 * * mon-fri")//출,퇴근시에만 (오전9시, 오후6시)
//	@Scheduled(cron = "0 0 15 25 * ?")//매월 25일 오후 3시(요일무관)
//	@Scheduled(cron = "* * * ? * 4L")//매월 마지막 목요일(L은 마지막이란 의미)
//	@Scheduled(cron = "* * * ? * 4#4")//매월 4주차 목요일
	@Override
	public void execute() {
		log.debug("DB 삭제를 진행합니다.");
		certificationDao.clean();
	}

}
