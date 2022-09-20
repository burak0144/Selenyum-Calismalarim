package practice_Mrt;

import org.junit.*;

public class C02JUnit {
@BeforeClass
public static void beforeClass(){
    System.out.println("Before Class"); //Her CLASS icin 1 kere calisir
}
@Before
public void before(){
    System.out.println("Before"); //Her TESTTEN once 1 kere calisir
}

    @Test
    public void test01(){
        System.out.println("Test 01");
    }
    @Test
    public void test02(){
        System.out.println("Test 02");
    }
    @Test
    public void test03(){
        System.out.println("Test 03");
    }
     @After
    public void after(){
        System.out.println("After"); //Her TESTTEN sonra 1 kere calisir
    }
    @AfterClass
    public static void afterClass(){
        System.out.println("After Class"); //Her CLASS'ta 1 kere calisir
    }
}
