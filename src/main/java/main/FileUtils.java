package main;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.List;

public class FileUtils {

    private static final String ADVICES_FILE_NAME = "advices.json";

    public static String getPathToAdvicesFile(String[] args) {
        if (args.length == 0) return System.getProperty("user.home") + File.separator + ADVICES_FILE_NAME;
        return args[0];
    }

    public static String getRandomMessageFromFile(String pathToJsonFile) throws ParseException, IOException {
        JSONParser parser = new JSONParser();
        Reader reader = new FileReader(pathToJsonFile);
        JSONObject jsonObj = (JSONObject) parser.parse(reader);
        List<String> messages = (List<String>) jsonObj.get("advices");
        int random = (int) (Math.random() * (messages.size()));
        return messages.get(random);
    }
}
