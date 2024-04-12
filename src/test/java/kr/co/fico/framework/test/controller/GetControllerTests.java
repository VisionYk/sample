package kr.co.fico.framework.test.controller;

import kr.co.fico.framework.test.model.vo.APITEST001In;
import kr.co.fico.framework.test.model.vo.APITEST001Out;
import kr.co.fico.framework.test.model.vo.SMPLTXT001Out;
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
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * 제목 : 
 *
 * @author 000
 * @since 2024.02.26
 *
 * <pre>
 * 테스트아이디 : GetControllerTests
 * =================================================================================================
 * <<< 프로그램 변경 정보 >>>
 * -------------------------------------------------------------------------------------------------
 * 변경 일자 : 변경자 : 변경 내역
 * -------------------------------------------------------------------------------------------------
 * 2024.02.26 : 000 : 프로그램 신규 작성
 * =================================================================================================
 * </pre>
 */
@Slf4j
@ActiveProfiles(profiles = "local")
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class GetControllerTests {

    @Value("${local.server.port}")
    private int port;

    @Autowired
    private RetryableRestTemplate restTemplate;

    @Test
    public void apitest001Test() throws URISyntaxException {
        String path = "/TT/APITEST001";

        APITEST001In param = APITEST001In.builder()
                .msgCode(null)
                .msgId(null)
                .tradeId(null)
                .build();
        CommonHeader header = CommonHeader.builder().build();
        CommonRequest<APITEST001In> body = CommonRequest.create(param);
        body.setCommonHeader(header);
//        CommonResponse<APITEST001Out> response = restTemplate.postForObject(
//                "http://localhost:" + port + path,
//                new HttpEntity<>(body),
//                CommonResponse.class);
        
        URI uri = new URI("http://localhost:" + port + path);
        log.info("uri : {}", uri);
        CommonResponse<APITEST001Out> response = 
        		restTemplate.getForObject(uri, CommonResponse.class);

        assertTrue(response.isSuccess());
    }
}
