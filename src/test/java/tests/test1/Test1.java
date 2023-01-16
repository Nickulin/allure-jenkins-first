package tests.test1;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Test1 {
    @Test
    public void test1() {
        int countCard = 22;
        Assert.assertEquals(countCard, 20);
        System.out.println("test1");
    }

}
