package files;

import io.restassured.path.json.JsonPath;

public class ComplexJsonParse {
    public static void main(String[] args) {
        /*
        *
        1. Print No of courses returned by API

        2.Print Purchase Amount

        3. Print Title of the first course

        4. Print All course titles and their respective Prices

        5. Print no of copies sold by RPA Course

        6. Verify if Sum of all Course prices matches with Purchase Amount
        * */

        JsonPath js = new JsonPath(Payload.CoursePrice());

        //Print courses
        System.out.println(js.getInt("courses.size()"));;

        //Print Purchase Amount
        System.out.println(js.getString("dashboard.purchaseAmount"));

        //Print title of first course
        System.out.println(js.getString("courses[0].title"));

        //Print all courses
        for(int i=0;i<js.getInt("courses.size()");i++){
            System.out.println("*******************");
            System.out.println("Course number:" +(i+1));
            System.out.println("Title is : " + js.getString("courses["+i+"].title"));
            System.out.println("Price is : " + js.getInt("courses["+i+"].price"));

        }

        //Print number of copies sold by RPA
        for(int i=0;i<js.getInt("courses.size()");i++){
            String title = js.getString("courses["+i+"].title");
          if(title.equalsIgnoreCase("RPA")){
              System.out.println("Course RPA's value is  : " + js.getInt("courses["+i+"].copies"));
              break;
          }

        }

        //Check if sum is equal to purchase Amount
//        SumValidation.
    }
}
