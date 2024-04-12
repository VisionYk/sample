package kr.co.fico.framework.test.mapper;

import java.util.List;

import kr.co.fico.framework.test.model.dto.SelectItembyUserNoParameter;
import kr.co.fico.framework.test.model.dto.SelectItembyUserNoResult;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * TdMapper
 *
 * @since 2024.04.09 
 */
@Transactional
@ActiveProfiles(profiles = "local")
@SpringBootTest
public class TdMapperTests {

    @Autowired
    private TdMapper tdMapper;

    @Test
    void selectItembyUserNoTest() {
        SelectItembyUserNoParameter param = SelectItembyUserNoParameter.builder().userNo(null).build();
        List<SelectItembyUserNoResult> result = tdMapper.selectItembyUserNo(param);
        assertNotNull(result);
    }
}
