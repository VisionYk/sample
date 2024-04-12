package kr.co.fico.framework.test.mapper;

import java.util.List;

import kr.co.fico.framework.test.model.dto.SelectTradeDetailByUserAndStockParameter;
import kr.co.fico.framework.test.model.dto.SelectTradeDetailByUserAndStockResult;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * SMPLJSN002
 *
 * @since 2024.02.23 
 */
@Transactional
@ActiveProfiles(profiles = "local")
@SpringBootTest
public class SMPLJSN002MapperTests {

    @Autowired
    private SMPLJSN002Mapper smpljsn002Mapper;

    @Test
    void selectTradeDetailByUserAndStockTest() {
        SelectTradeDetailByUserAndStockParameter param = SelectTradeDetailByUserAndStockParameter.builder()
                .userName("박정우").stockName("apple").buy(true).build();
        List<SelectTradeDetailByUserAndStockResult> result = smpljsn002Mapper.selectTradeDetailByUserAndStock(param);
        assertNotNull(result);
    }
}
