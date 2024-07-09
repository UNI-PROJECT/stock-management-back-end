package utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {

    // Método estático para extrair a data yyyy-MM-dd de uma string com formato yyyy-MM-dd HH:mm:ss.SSSSSS
    public static String extractDate(String dateTimeString) {
        String regex = "^(\\d{4}-\\d{2}-\\d{2})\\s";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(dateTimeString);

        if (matcher.find()) {
            return matcher.group(1);
        } else {
            return null; 
        }
    }


