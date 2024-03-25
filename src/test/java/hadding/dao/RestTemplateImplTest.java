package hadding.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class RestTemplateImplTest {
    @Autowired
    private RestTemplateDAO restTemplateDAO;

    @Test
    void convert() {
        Double result = restTemplateDAO.convert(1, 100L);
        assertEquals(Double.class, result.getClass());
    }

    @Test
    void update() {
        String response = restTemplateDAO.update();
        assertNotNull(response);
    }

}

