package files;

public class Payload {
    public static String addPlacePayload() {
        return "{\n" +
                "  \"location\": {\n" +
                "    \"lat\": -38.383494,\n" +
                "    \"lng\": 33.427362\n" +
                "  },\n" +
                "  \"accuracy\": 50,\n" +
                "  \"name\": \"Frontline house\",\n" +
                "  \"phone_number\": \"(+91) 983 893 3937\",\n" +
                "  \"address\": \"29, side layout, cohen 09\",\n" +
                "  \"types\": [\n" +
                "    \"shoe park\",\n" +
                "    \"shop\"\n" +
                "  ],\n" +
                "  \"website\": \"http://google.com\",\n" +
                "  \"language\": \"French-IN\"\n" +
                "}";
    }

//    public static String updatePlacePayload(){
//        return "{\n" +
//                "\"place_id\":"+placeid+",\n" +
//                "\"address\":\"70 Summer walk, USA\",\n" +
//                "\"key\":\"qaclick123\"\n" +
//                "}";

        /*
        * "{\n" +
                "\"place_id\":8d2573bdf6ceec0e474c5f388fa917fb,\n" +
                "\"address\":\"70 Summer walk, USA\",\n" +
                "\"key\":\"qaclick123\"\n" +
                "}";
        *
        * */

}
