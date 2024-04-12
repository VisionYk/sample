package kr.co.fico.framework.test.service;

import java.util.List;

import kr.co.fico.framework.test.mapper.UserIdMapper;
import kr.co.fico.framework.test.model.dto.SelectTradeByUserIdParameter;
import kr.co.fico.framework.test.model.dto.SelectTradeByUserIdResult;

import lombok.extern.slf4j.Slf4j;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 제목 : 
 *
 * @author 000
 * @since 2024.02.23
 * 
 * <pre>
 * 테스트아이디 : SMPLTXT001ServiceTests
 * 설 명 : 거래 내역을 상세하게 조회한다.
 * =================================================================================================
 * <<< 프로그램 변경 정보 >>>
 * -------------------------------------------------------------------------------------------------
 * 변경 일자 : 변경자 : 변경 내역
 * -------------------------------------------------------------------------------------------------
 * 2024.02.23 : 000 : 프로그램 신규 작성 
 * =================================================================================================
 * </pre>
 */
@Slf4j
@ActiveProfiles(profiles = "local")
@Transactional
@SpringBootTest
public class SMPLTXT001ServiceTests {

    @Autowired
    private UserIdMapper useridMapper;

    @Test
    public void smpltxt001serviceTest() {
        // 쿼리 파라미터
        SelectTradeByUserIdParameter selectTradeByUserIdParameter = SelectTradeByUserIdParameter.builder()
                .userId("sam")
                .build();

        // 쿼리 결과
        List<SelectTradeByUserIdResult> selectTradeByUserIdResult = useridMapper
                .selectTradeByUserId(selectTradeByUserIdParameter);

        assertNotNull(selectTradeByUserIdResult);

    }
}
