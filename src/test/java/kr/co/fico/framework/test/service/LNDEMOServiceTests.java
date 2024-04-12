package kr.co.fico.framework.test.service;

import java.util.List;

import kr.co.fico.framework.test.mapper.LNMapper;
import kr.co.fico.framework.test.model.dto.SelcetLnByuserNoParameter;
import kr.co.fico.framework.test.model.dto.SelcetLnByuserNoResult;

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
 * @since 2024.04.08
 * 
 * <pre>
 * 테스트아이디 : LNDEMOServiceTests
 * 설 명 : LN 데모입니다.
 * =================================================================================================
 * <<< 프로그램 변경 정보 >>>
 * -------------------------------------------------------------------------------------------------
 * 변경 일자 : 변경자 : 변경 내역
 * -------------------------------------------------------------------------------------------------
 * 2024.04.08 : 000 : 프로그램 신규 작성 
 * =================================================================================================
 * </pre>
 */
@Slf4j
@ActiveProfiles(profiles = "local")
@Transactional
@SpringBootTest
public class LNDEMOServiceTests {

    @Autowired
    private LNMapper lnMapper;

    @Test
    public void lndemoserviceTest() {
        // 쿼리 파라미터
        SelcetLnByuserNoParameter selcetLnByuserNoParameter = SelcetLnByuserNoParameter.builder()
                .userNo(1)
                .build();

        // 쿼리 결과
        List<SelcetLnByuserNoResult> selcetLnByuserNoResult = lnMapper.selcetLnByuserNo(selcetLnByuserNoParameter);

        assertNotNull(selcetLnByuserNoResult);

    }
}
