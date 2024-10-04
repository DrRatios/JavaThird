package HWLesson7TestsAnnotationReflection;

public class TestsForms {

    @BeforeSuite
    public void BeforeSuite() {
        System.out.println(getClass().getName() + " beforeSuite execute...");
    }

    @AfterSuite
    public void AfterSuite() {
        System.out.println(getClass().getName() + " afterSuite execute...");
    }

    @Test(1)
    public void Test1() {
        System.out.println(getClass().getName() + " test № 1 testing...");
    }

    @Test(2)
    public void Test2() {
        System.out.println(getClass().getName() + " test № 2  testing...");
    }

    @Test(3)
    public void Test3() {
        System.out.println(getClass().getName() + " test № 3 testing...");
    }

    @Test(4)
    public void Test4() {
        System.out.println(getClass().getName() + " test № 4 testing...");
    }

    @Test(5)
    public void Test5() {
        System.out.println(getClass().getName() + " test № 5 testing...");
    }

}
