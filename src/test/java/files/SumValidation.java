package files;

import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SumValidation {
    @Test
    public void sumOfCourses(){
        JsonPath js = new JsonPath(Payload.CoursePrice());
        int sum=0;
        //Verify if sum of all courses matches with purchaseAmount
        for(int i=0;i<js.getInt("courses.size()");i++){
            sum+=(js.getInt("courses["+i+"].price"))*(js.getInt("courses["+i+"].copies"));
        }
        Assert.assertEquals(sum, js.getInt("dashboard.purchaseAmount"));
}
}