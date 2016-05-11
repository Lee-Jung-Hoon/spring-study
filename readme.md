# 5장. 서비스 추상화

> [토비의 스프링 3.1](http://book.naver.com/bookdb/book_detail.nhn?bid=7006516) (이일민 저. 에이콘출판. 2010) 을 공부하며 책 내용 중 일부를 요약.

예제 소스를 따라해 본 것은  github에  각 챕터별로 branch를 나눠 커밋하고 있다. (`Java8`, `Spring4.2`)
> [https://github.com/iamkyu/spring-study/tree/chap05] (https://github.com/iamkyu/spring-study/tree/chap05)

<br>
환경과 상황에 따라 기술이 바뀌고, 그에 따라 다른 API를 사용해야 하거나 다른 스타일의 접근 방법을 따라야 하는건 매우 피곤한 일이다. 스프링 프레임워크는 비슷한 여러 종류의 기술을 `추상화`하고 이를 일관된 방법으로 사용할 수 있도록 지원한다.


## 트랜젝션 추상화
스프링에서는 `Connection` 을 특별한 저장소에 보관해두고 이후에 호출되는 `Datebase Access Object (DAO)` 에서는 이 커넥션을 가져다 쓰는 방식인 `트랜젝션 동기화(Transaction Synchronization) 방식` 을 제공. 또한 JDBC, JTA, HIBERNATE, JPA, JDO 등 트랜잭션 개념을 가지고 있는 서로 다른 기술들의 공통적인 특징을 모아서 추상화 된 트랜잭션 추상계층을 제공.

```
public void testTransaction() {

	// JDBC 트랜잭션 추상 오브젝트 생성
	PlatformTransactionManager transactionManager =
				new DataSourceTransactionManager(dataSource);
				
	// 트랜잭션 시작			
	TransactionStatus status = 
				transactionManager.getTransaction(new DefaultTransactionDefinition());
				
	try {
		// 트랜잭션 안에서 진행되는 작업
		
		transactionManager.commit(status) // 트랜잭션 커밋
	} catch ( RuntimeException e) {
		transactinoManager.rollback(status); // 트랜잭션 롤백
		throw e;
	}

}

```