package customers;

import org.testng.annotations.Test;

public class Customer_01_Search {
    @Test(groups = {"customer","category"})
    public void test_01_Edit(){
        System.out.println("Testing category");
    }

    @Test(groups = "customer")
    public void test_02_add_name_and_description(){
        System.out.println("Testing category");
    }

    @Test(groups = "customer")
    public void test_03_by_parent_category(){
        System.out.println("Testing category");
    }
}
