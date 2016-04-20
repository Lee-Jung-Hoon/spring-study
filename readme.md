## 2장. 테스트

> [토비의 스프링 3.1](http://book.naver.com/bookdb/book_detail.nhn?bid=7006516) (이일민 저. 에이콘출판. 2010) 을 공부하며 책 내용 중 일부를 요약.

<br>
일반적인 웹 애플리케이션 개발에서 DAO 를 테스트하기 위해서는 서비스, 컨트롤, 뷰 까지 모든 레이어가 완성되어야 하는 문제가 있음.

##### 단위 테스트(Unit Test)
- 단위의 범위는 정형화 되어 있지 않지만 작을 수록 좋다.
- 테스트 검증의 자동화를 구현하여 빠르게 테스트 한다.

##### JUnit을 통한 단위 테스트
```
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class UserDaoTest {    
    @Test
    public void addAndGet() throws SQLException {
    	// 테스트코드
        // (중략)
        assertThat(user2.getName(), is(user.getName()));
        assertThat(user2.getPassword(), is(user.getPassword()));
	}
}   
```

예외상황에 대한 테스트는 아래 코드와 같이 기대되는 예외를 명시한다. 해당 메소드를 테스트할 때 명시 된 예외가 발생해야 성공하는 테스트가 된다.
```
@Test(expected = EmptyResultDataAccessException.class)

```