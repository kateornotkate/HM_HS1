import java.util.HashMap;
import java.util.Map;

public class Main {

    // для более точного подсчета символов удалим все пробелы и пунктуацию из текста, а также приведем его к нижнему регистру;
    // \P{Alpha} соответствует любому неалфавитному символу;
    // \p{Alpha} любому алфавитному символу;

    static String text = ("Lorem ipsum dolor sit amet, consectetur adipiscing elit, " +
            "sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, " +
            "quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. " +
            "Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. " +
            "Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia " +
            "deserunt mollit anim id est laborum.").replaceAll("\\P{Alpha}+", "").toLowerCase();

    public static void main(String[] args) {
        Map<Character, Integer> map = new HashMap<>();
        // заполним мапу символами и их кол-ом в тексте;
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i); // charAt() — возвращает символ, расположенный по указанному индексу строки;
            if (!map.containsKey(c)) {
                map.put(c, 1);
            } else {
                int value = map.get(c);
                value++;
                map.put(c, value);
            }
        }

        int max = -1;
        char maxChar = 0;

        int min = Integer.MAX_VALUE;
        char minChar = 0;
        // пройдемся по мапе, найдем максимум и минимум;
        for (char key : map.keySet()) {
            int value = map.get(key);
            if (value > max) {
                max = value;
                maxChar = key;
            } else if (value < min) {
                min = value;
                minChar = key;
            }
        }
        System.out.println("Буква " + maxChar + " встречалась максимальное количество раз, а именно: " + max);
        System.out.println("Буква " + minChar + " встречалась минимальное количество раз, а именно: " + min);
    }
}