package fr.aelion.helpers;

public class CaseConverter {
    public static String camelToSnake(String camelString) {
        String regex = "([a-z])([A-Z]+)";
        String replacement = "$1_$2";

        return camelString
                .replaceAll(
                        regex,
                        replacement
                ).toLowerCase();
    }

    public static String snakeToCamel(String snakeString) {
        char underscore = '_';
        String camelString = "";

        for (int i = 0; i < snakeString.length(); i++) {
            char ch = snakeString.charAt(i);
            if (ch == underscore) {
                camelString += snakeString.substring(i + 1, i + 2).toUpperCase();
                i = i + 1;
            } else {
                camelString += snakeString.substring(i, i + 1);
            }
        }
        return camelString;

    }
}
