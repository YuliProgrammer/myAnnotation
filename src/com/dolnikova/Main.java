package com.dolnikova;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        Map<String, String> map = new HashMap<>();
        map.put("full_name", "Alex Ivanovych");
        map.put("surName", "Smit");
        map.put("age", "22");
        map.put("group", "java");

        AnnotationAnalyzer analyzer = new AnnotationAnalyzer();
        analyzer.analyze(map, User.class);

    }
}
