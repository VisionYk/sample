package kr.co.fico.framework.test.mapper;

import java.util.List;

import kr.co.fico.framework.test.model.dto.SelcetLnByuserNoParameter;
import kr.co.fico.framework.test.model.dto.SelcetLnByuserNoResult;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * 대출관리 mapper
 *
 * @since 2024.04.08 
 */
@Transactional
@ActiveProfiles(profiles = "local")
@SpringBootTest
public class LNMapperTests {

    @Autowired
    private LNMapper lnMapper;

    @Test
    void selcetLnByuserNoTest() {
        SelcetLnByuserNoParameter param = SelcetLnByuserNoParameter.builder().userNo(1).build();
        List<SelcetLnByuserNoResult> result = lnMapper.selcetLnByuserNo(param);
        assertNotNull(result);
    }
}
