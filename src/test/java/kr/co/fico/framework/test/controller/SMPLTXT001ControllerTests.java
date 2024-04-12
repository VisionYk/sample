package kr.co.fico.framework.test.controller;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.net.URISyntaxException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpEntity;
import org.springframework.test.context.ActiveProfiles;

import kr.co.fico.framework.test.model.vo.SMPLTXT001In;
import kr.co.fico.framework.test.model.vo.SMPLTXT001Out;
import kr.co.openlabs.fico.framework.internal.RetryableRestTemplate;
import lombok.extern.slf4j.Slf4j;

/**
 * 제목 : 
 *
 * @author 000
 * @since 2024.02.23
 *
 * <pre>
 * 테스트아이디 : SMPLTXT001ControllerTests
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
public class SMPLTXT001ControllerTests {

    @Value("${local.server.port}")
    private int port;

    @Autowired
    private RetryableRestTemplate restTemplate;

    @Test
    public void smpltxt001Test() throws URISyntaxException {
        String path = "/SL/SMPLTXT001";

        SMPLTXT001In param = SMPLTXT001In.builder()
                .userId("sam")
                .build();
        SMPLTXT001Out response = restTemplate.postForObject(
                "http://localhost:" + port + path,
                new HttpEntity<>(param),
                SMPLTXT001Out.class);

        assertNotNull(response);
    }
}
