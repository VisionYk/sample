package kr.co.fico.framework.test.mapper;

import java.util.List;

import kr.co.fico.framework.test.model.dto.SelectTradeByUserIdParameter;
import kr.co.fico.framework.test.model.dto.SelectTradeByUserIdResult;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * user 관련 maper
 *
 * @since 2024.02.23 
 */
@Transactional
@ActiveProfiles(profiles = "local")
@SpringBootTest
public class UserIdMapperTests {

    @Autowired
    private UserIdMapper useridMapper;

    @Test
    void selectTradeByUserIdTest() {
        SelectTradeByUserIdParameter param = SelectTradeByUserIdParameter.builder().userId("sam").build();
        List<SelectTradeByUserIdResult> result = useridMapper.selectTradeByUserId(param);
        assertNotNull(result);
    }
}
