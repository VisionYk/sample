package kr.co.fico.framework.test.service;

import java.util.List;

import kr.co.fico.framework.test.mapper.SMPLJSN002Mapper;
import kr.co.fico.framework.test.model.dto.SelectTradeDetailByUserAndStockParameter;
import kr.co.fico.framework.test.model.dto.SelectTradeDetailByUserAndStockResult;

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
 * 테스트아이디 : SMPLJSN002ServiceTests
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
public class SMPLJSN002ServiceTests {

    @Autowired
    private SMPLJSN002Mapper smpljsn002Mapper;

    @Test
    public void smpljsn002serviceTest() {
        // 쿼리 파라미터
        SelectTradeDetailByUserAndStockParameter selectTradeDetailByUserAndStockParameter = SelectTradeDetailByUserAndStockParameter
                .builder()
                .userName("박정우")
                .stockName("apple")
                .buy(true)
                .build();

        // 쿼리 결과
        List<SelectTradeDetailByUserAndStockResult> selectTradeDetailByUserAndStockResult = smpljsn002Mapper
                .selectTradeDetailByUserAndStock(selectTradeDetailByUserAndStockParameter);

        assertNotNull(selectTradeDetailByUserAndStockResult);

    }
}
