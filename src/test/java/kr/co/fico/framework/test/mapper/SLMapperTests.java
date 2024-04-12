package kr.co.fico.framework.test.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import kr.co.fico.framework.test.model.dto.SelectTradeListParameter;
import kr.co.fico.framework.test.model.dto.SelectTradeListResult;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * SL 그룹 Mapper
 *
 * @since 2024.02.22
 */
@Transactional
@ActiveProfiles(profiles = "local")
@SpringBootTest
public class SLMapperTests {

    @Autowired
    private SLMapper slMapper;

    @Test
    void selectTradeListTest() {
        SelectTradeListParameter param = SelectTradeListParameter.builder().userId("null").build();
        List<SelectTradeListResult> result = slMapper.selectTradeList(param);
        assertNotNull(result);
    }
}
