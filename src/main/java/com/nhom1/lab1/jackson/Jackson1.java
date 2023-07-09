package com.nhom1.lab1.jackson;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.nhom1.lab1.jackson.bean.Contact;
import com.nhom1.lab1.jackson.bean.Student;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Jackson1 {
    public static void main(String[] args) {
        try {
//            demo1();
//            demo2();
//            demo3();
//            demo4();
//            demo5();
//            demo6();
//            demo7();
//            demo8();
            demo9();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void demo9() throws IOException {
        String path = "D:\\Gawr Gura\\DiscordStuff\\FPTDocuments\\JAVA_6\\code\\Labs\\Lab1\\src\\main\\resources\\student.json";
        ObjectMapper mapper = new ObjectMapper();
        Student student = mapper.readValue(new File(path), Student.class);
        String jsonAsString = mapper.writeValueAsString(student);
        mapper.writerWithDefaultPrettyPrinter().writeValue(System.out, student);
        mapper.writeValue(new File("c:/tmp/student.json"), student);
    }

    private static void demo8() throws IOException {
        String path = "D:\\Gawr Gura\\DiscordStuff\\FPTDocuments\\JAVA_6\\code\\Labs\\Lab1\\src\\main\\resources\\student.json";
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> student = mapper.readValue(new File(path), Map.class);
        String jsonAsString = mapper.writeValueAsString(student);
        mapper.writeValue(System.out, student);
        mapper.writeValue(new File("c:/tmp/student.json"), student);
    }

    private static void demo7() throws IOException {
        String path = "D:\\Gawr Gura\\DiscordStuff\\FPTDocuments\\JAVA_6\\code\\Labs\\Lab1\\src\\main\\resources\\student.json";
        ObjectMapper mapper = new ObjectMapper();
        JsonNode studentNode = mapper.readTree(new File(path));
        ObjectNode studentObjectNode = studentNode.deepCopy();
        String jsonAsString = mapper.writeValueAsString(studentObjectNode);
        mapper.writeValue(System.out, studentObjectNode);
        mapper.writeValue(new File("c:/tmp/student.json"), studentObjectNode);
    }

    private static void demo6() throws IOException {
        String path = "D:\\Gawr Gura\\DiscordStuff\\FPTDocuments\\JAVA_6\\code\\Labs\\Lab1\\src\\main\\resources\\students.json";
        ObjectMapper mapper = new ObjectMapper();
        TypeReference<List<Student>> type = new TypeReference<>() {};
        List<Student> students = mapper.readValue(new File(path), type);
//        students.iterator().forEachRemaining(student -> System.out.println(">> Name: " + student.getName()));
        students.forEach(student -> System.out.println(">> Name: " + student.getName()));
    }

    private static void demo5() throws IOException {
        String path = "D:\\Gawr Gura\\DiscordStuff\\FPTDocuments\\JAVA_6\\code\\Labs\\Lab1\\src\\main\\resources\\student.json";
        ObjectMapper mapper = new ObjectMapper();
        Student student = mapper.readValue(new File(path), Student.class);
        System.out.println(">> Name: " + student.getName());
        System.out.println(">> Gender: " +student.getGender());
        System.out.println(">> Marks: " +student.getMarks());
        Contact contact = student.getContact();
        System.out.println(">> Email: " + contact.getEmail());
        System.out.println(">> Phone: " + contact.getPhone());
        List<String> subjects = student.getSubjects();
        subjects.forEach(s -> System.out.println(">> Subject: " + s));
    }

    private static void demo4() throws IOException {
        String path = "D:\\Gawr Gura\\DiscordStuff\\FPTDocuments\\JAVA_6\\code\\Labs\\Lab1\\src\\main\\resources\\students.json";
        ObjectMapper mapper = new ObjectMapper();
        List<Map<String, Object>> students = mapper.readValue(new File(path), List.class);
        students.iterator().forEachRemaining(student -> System.out.println(">> Name: " + student.get("name")));
    }

    private static void demo3() throws IOException {
        String path = "D:\\Gawr Gura\\DiscordStuff\\FPTDocuments\\JAVA_6\\code\\Labs\\Lab1\\src\\main\\resources\\student.json";
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> student = mapper.readValue(new File(path), Map.class);
        System.out.println(">> Name: " + student.get("name"));
        System.out.println(">> Gender: " +student.get("gender"));
        System.out.println(">> Marks: " +student.get("marks"));
        Map<String, Object> contact = (Map<String, Object>) student.get("contact");
        System.out.println(">> Email: " + contact.get("email"));
        System.out.println(">> Phone: " + contact.get("phone"));
        List<String> subjects = (List<String>) student.get("subjects");
        subjects.forEach(s -> System.out.println(">> Subject: " + s));
    }

    private static void demo2() throws IOException{
        String path = "D:\\Gawr Gura\\DiscordStuff\\FPTDocuments\\JAVA_6\\code\\Labs\\Lab1\\src\\main\\resources\\students.json";
        ObjectMapper mapper = new ObjectMapper();
        JsonNode studentsNode = mapper.readTree(new File(path));
        studentsNode.iterator().forEachRemaining(jsonNode -> System.out.println(">> Name: " + jsonNode.get("name").asText()));
    }

    private static void demo1() throws IOException {
//        String json = "{" +
//                "\"name\":\"NguyễnVănTèo\"," +
//                "\"gender\":true," +
//                "\"marks\":8.0," +
//                "\"contact\":{" +
//                "   \"email\":\"tennv@gmail.com\"," +
//                "   \"phone\":\"0913745789\"" +
//                "}," +
//                "\"subjects\":[\"WEB205\",\"COM108\"]" +
//        "}";
        String path = "D:\\Gawr Gura\\DiscordStuff\\FPTDocuments\\JAVA_6\\code\\Labs\\Lab1\\src\\main\\resources\\student.json";
        ObjectMapper mapper = new ObjectMapper();
        JsonNode studentNode = mapper.readTree(new File(path));
        System.out.println(">> Name: " + studentNode.get("name").asText());
        System.out.println(">> Gender: " +studentNode.get("gender").asBoolean());
        System.out.println(">> Marks: " +studentNode.get("marks").asDouble());
        System.out.println(">> Email: " +studentNode.get("contact").get("email").asText());
        System.out.println(">> Phone: " +studentNode.findValue("phone").asText());
        studentNode.get("subjects").iterator().forEachRemaining(jsonNode -> System.out.println(">> Subject: " + jsonNode.asText()));
    }
}
