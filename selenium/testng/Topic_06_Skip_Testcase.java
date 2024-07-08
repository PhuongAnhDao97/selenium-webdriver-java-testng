package testng;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_06_Skip_Testcase {
    @BeforeClass
    public void beforeClass() {
        System.out.println("Run before class");
    }

    @Test(priority = 2)
    public void test_01_addnew() {
        System.out.println("Testing category");
    }

    @Test(priority = 1)
    public void test_02_add_name_and_description() {
        System.out.println("Testing category");
    }

    @Test(enabled = false)
    public void test_03_by_parent_category() {
        System.out.println("Testing category");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("Run after class");
    }
}
