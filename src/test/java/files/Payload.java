package files;

public class Payload {
    public static String addPlacePayload() {
        return "{\n" +
                "  \"location\": {\n" +
                "    \"lat\": -38.383494,\n" +
                "    \"lng\": 33.427362\n" +
                "  },\n" +
                "  \"accuracy\": 50,\n" +
                "  \"name\": \"Partha\",\n" +
                "  \"phone_number\": \"(+91) 983 893 3937\",\n" +
                "  \"address\": \"Guwahati\",\n" +
                "  \"types\": [\n" +
                "    \"shoe park\",\n" +
                "    \"shop\"\n" +
                "  ],\n" +
                "  \"website\": \"http://google.com\",\n" +
                "  \"language\": \"French-IN\"\n" +
                "}";
    }

        public static String CoursePrice(){
            return "{\n" +
                    "  \"dashboard\": {\n" +
                    "    \"purchaseAmount\": 910,\n" +
                    "    \"website\": \"rahulshettyacademy.com\"\n" +
                    "  },\n" +
                    "  \"courses\": [\n" +
                    "    {\n" +
                    "      \"title\": \"Selenium Python\",\n" +
                    "      \"price\": 50,\n" +
                    "      \"copies\": 6\n" +
                    "    },\n" +
                    "    {\n" +
                    "      \"title\": \"Cypress\",\n" +
                    "      \"price\": 40,\n" +
                    "      \"copies\": 4\n" +
                    "    },\n" +
                    "    {\n" +
                    "      \"title\": \"RPA\",\n" +
                    "      \"price\": 45,\n" +
                    "      \"copies\": 10\n" +
                    "    }\n" +
                    "  ]\n" +
                    "}";
        }

        public static String AddBookPayload(String isbn, String aisle){
            String payload =  "{\n" +
                    "\n" +
                    "\"name\":\"Learn Appium Automation with Java\",\n" +
                    "\"isbn\":\""+isbn+"\",\n" +
                    "\"aisle\":\""+aisle+"\",\n" +
                    "\"author\":\"John foe\"\n" +
                    "}";
            return payload;
        }

        public static String deleteBookPayload(String id){
            String deleteBookPayload = "" +
                    "{\n" +
                    "    \"ID\": \""+id+"\"\n" +
                    "}";
            return deleteBookPayload;
        }

}
