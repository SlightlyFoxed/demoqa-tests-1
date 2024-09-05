import org.junit.jupiter.api.*;

public class JUnitExamples {

    @BeforeAll
    static void beforeAll(){
        System.out.println("here is beforeAll()");
    }
    @BeforeEach
    static void beforeEach() {
        System.out.println("here is beforeEach()");
    }
    @AfterAll
    static void afterAll(){
        System.out.println("here is afterAll()");

    }
    @AfterEach
    static void afterEach(){
        System.out.println("here is afterEach()");
    }
    @Test
    void firstTest (){
        System.out.println("here is first test");
    }
    @Test
    void secondTest (){
        System.out.println("here is second test");
    }
}
