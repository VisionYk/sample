package kr.co.fico.framework.test.mapper;

import java.util.List;

import kr.co.fico.framework.test.model.dto.SelectUserByIdParameter;
import kr.co.fico.framework.test.model.dto.SelectUserByIdResult;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * selectUser
 *
 * @since 2024.04.08 
 */
@Transactional
@ActiveProfiles(profiles = "local")
@SpringBootTest
public class SelectUserMapperTests {

    @Autowired
    private SelectUserMapper selectuserMapper;

    @Test
    void selectUserByIdTest() {
        SelectUserByIdParameter param = SelectUserByIdParameter.builder().userId("null").build();
        List<SelectUserByIdResult> result = selectuserMapper.selectUserById(param);
        assertNotNull(result);
    }
}
