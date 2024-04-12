package kr.co.fico.framework.test.controller;

import java.net.URI;
import java.net.URISyntaxException;

import kr.co.fico.framework.test.model.vo.LNDEMOIn.LNDEMOUserInfo;
import kr.co.fico.framework.test.model.vo.LNDEMOIn;
import kr.co.fico.framework.test.model.vo.LNDEMOOut;
import kr.co.openlabs.fico.framework.internal.RetryableRestTemplate;

import lombok.extern.slf4j.Slf4j;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * 제목 : 
 *
 * @author 000
 * @since 2024.04.08
 *
 * <pre>
 * 테스트아이디 : LNControllerTests
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
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class LNControllerTests {

    @Value("${local.server.port}")
    private int port;

    @Autowired
    private RetryableRestTemplate restTemplate;

    @Test
    public void lndemoTest() throws URISyntaxException {
        String path = "/LN/LNDEMO";

        LNDEMOIn param = LNDEMOIn.builder()
            .userInfo(LNDEMOUserInfo.builder()
                .userNo(1)
                .build())
            .build();
        URI uri = new URI("http://localhost:" + port + path);

        LNDEMOOut response = restTemplate.postForObject(
                uri,
                new HttpEntity<>(param),
                LNDEMOOut.class);

        assertNotNull(response);
    }
}
