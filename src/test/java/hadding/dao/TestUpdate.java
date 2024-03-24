package hadding.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class TestUpdate {
    @Autowired
    private RestTempateDAO restTempateDAO;

    @Test
    void update() {
        String response = restTempateDAO.update();
        assertNotNull(response);
    }

}

