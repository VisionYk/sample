package kr.co.fico.framework.test.controller;

import kr.co.fico.framework.test.model.vo.SMPLJSN002In;
import kr.co.fico.framework.test.model.vo.SMPLJSN002Out;
import kr.co.openlabs.fico.common.model.CommonHeader;
import kr.co.openlabs.fico.common.model.CommonRequest;
import kr.co.openlabs.fico.common.model.CommonResponse;
import kr.co.openlabs.fico.framework.internal.RetryableRestTemplate;

import lombok.extern.slf4j.Slf4j;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * 제목 : 
 *
 * @author 000
 * @since 2024.02.23
 *
 * <pre>
 * 테스트아이디 : SMPLJSN002ControllerTests
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
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class SMPLJSN002ControllerTests {

    @Value("${local.server.port}")
    private int port;

    @Autowired
    private RetryableRestTemplate restTemplate;

    @Test
    public void smpljsn002Test() {
        String path = "/SL/SMPLJSN002";

        SMPLJSN002In param = SMPLJSN002In.builder()
                .userName("박정우")
                .stockName("apple")
                .buyYn(true)
                .build();
        CommonHeader header = CommonHeader.builder().build();
        CommonRequest<SMPLJSN002In> body = CommonRequest.create(param);
        body.setCommonHeader(header);
        CommonResponse<SMPLJSN002Out> response = restTemplate.postForObject(
                "http://localhost:" + port + path,
                new HttpEntity<>(body),
                CommonResponse.class);

        assertTrue(response.isSuccess());
    }
}
