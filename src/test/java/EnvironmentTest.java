import org.aeonbits.owner.ConfigFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class EnvironmentTest {


    Environment testEnvironment = ConfigFactory.create(Environment.class);




        @Test
        public void functionalTest() {
            System.out.println(testEnvironment.url());

        }

        @BeforeTest
        @Parameters({"environment"})
        public void beforeTest(String environemnt) {
            ConfigFactory.setProperty("env", environemnt);
            testEnvironment = ConfigFactory.create(Environment.class);
        }

    }

