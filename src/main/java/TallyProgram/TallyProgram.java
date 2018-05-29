package TallyProgram;

import jdk.nashorn.internal.objects.NativeString;

import java.util.stream.Collectors;

import static java.lang.Character.isLowerCase;
import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.reducing;

/*
    DESCRIPTION 5 Friends (let's call them a, b, c, d and e) are playing a game and need to keep track of the scores.
    Each time someone scores a point, the letter of his name is typed in lowercase.
    If someone loses a point, the letter of his name is typed in uppercase.
    Give the resulting score from highest to lowest.
*/


public class TallyProgram {
    public static void main(String[] args) {
        "EbAAdbBEaBaaBBdAccbeebaec".chars().mapToObj(i -> (char) i)
                .collect(Collectors.groupingBy(NativeString::toLowerCase, reducing(0, k -> isLowerCase(k) ? 1 : -1, Integer::sum)))
                .entrySet().stream().sorted(comparingInt(e -> -e.getValue()))
                .forEach(System.out::println);

    }
}
