<<<<<<< HEAD
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class FrequencyPrint {
//runtime: O(nlogn)
    static String frequencyPrint(String s) {
        Map<String, Integer> map = new HashMap<>();
        String[] words = s.split("\\W+");
        for (int i = 0; i < words.length; i++) {
            map.put(words[i], map.getOrDefault(words[i], 0) + 1);
        }

        Map<String, Integer> sortedMap = map.entrySet().stream()
                .sorted((k1, k2) -> -k1.getValue().compareTo(k2.getValue()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (e1, e2) -> e1, LinkedHashMap::new));

        String result = "";
        for (String key: sortedMap.keySet()) {
            result = String.join("", Collections.nCopies(map.get(key), key+" "))+result;
        }

        return result;
=======
public class FrequencyPrint {

    static String frequencyPrint(String s) {
        // TODO
        return "";
>>>>>>> 6d575f706f119b08b97decb6f08819793baa6f35
    }

}
