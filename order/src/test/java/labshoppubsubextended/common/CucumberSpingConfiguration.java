package labshoppubsubextended.common;

import io.cucumber.spring.CucumberContextConfiguration;
import labshoppubsubextended.OrderApplication;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = { OrderApplication.class })
public class CucumberSpingConfiguration {}
