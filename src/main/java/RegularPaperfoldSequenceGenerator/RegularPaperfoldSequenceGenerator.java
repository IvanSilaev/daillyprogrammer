package RegularPaperfoldSequenceGenerator;


/*
    In mathematics the regular paperfolding sequence, also known as the dragon curve sequence, is an infinite automatic sequence of 0s and 1s.
    At each stage an alternating sequence of 1s and 0s is inserted between the terms of the previous sequence.
    The first few generations of the sequence look like this:

    1
    1 1 0
    1 1 0 1 1 0 0
    110110011100100
    110110011100100

    The sequence takes its name from the fact that it represents the sequence of left and right folds along a strip of paper
    that is folded repeatedly in half in the same direction. If each fold is then opened out to create a right-angled corner,
    the resulting shape approaches the dragon curve fractal.

*/

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularPaperfoldSequenceGenerator {
    public static void main(String[] args) {
        int folding = 8;

        Pattern p = Pattern.compile("\\d");
        String paperFoldingSequnce = "1";

        for (int i = 0; i < folding; i++) {
            StringBuilder newPaperFoldingSequence = new StringBuilder(paperFoldingSequnce + "1");


            for(int x = paperFoldingSequnce.length() - 1; x >= 0; x--) {
                if(paperFoldingSequnce.charAt(x) == '1') newPaperFoldingSequence.append(0);
                else newPaperFoldingSequence.append("1");
            }

            paperFoldingSequnce = newPaperFoldingSequence.toString();

            System.out.println(i + " folding: " + paperFoldingSequnce);
        }
    }
}
