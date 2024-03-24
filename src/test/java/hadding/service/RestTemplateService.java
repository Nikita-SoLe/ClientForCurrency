package hadding.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
@SpringBootTest
class RestTemplateServiceTest {

    @Autowired
    private RestTemplateService service;

    @Test
    void update() {
        String result = service.update();
        assertThat(result).isEqualTo("{\"updated\":\"true\"}");
    }
}

