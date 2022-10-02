package com.fksrd.library;

import org.json.JSONObject;

import java.io.*;
import java.util.Scanner;

public class ReadCache {

    public static ApplicationList ReadCache() throws IOException {

        File file = new File("data.json");

        Scanner scanner = new Scanner(file);

        StringBuilder stringBuilder = new StringBuilder();

        while (scanner.hasNext()) {

            stringBuilder.append(scanner.nextLine());

        }

        String jsonData = stringBuilder.toString();

        JSONObject json = new JSONObject(jsonData);

        JsonObjectToApplicationDataList jsonObjectToApplicationDataList = new JsonObjectToApplicationDataList(json);

        return jsonObjectToApplicationDataList.applicationList;

    }

}
