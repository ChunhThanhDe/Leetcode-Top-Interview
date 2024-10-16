import java.util.List;
import java.util.ArrayList;

/**
 * Solution
 */
public class Solution {

    // method to fully justify the given words to fit a specified maxwidth
    public List<String> fullJustify(String[] words, int maxwidth){
        int n = words.length;
        int i = 0; // index to track position 

        List<String> result = new ArrayList<>();

        // process th words in groups that ca fit in one line
        while (i < n) {
            int lineLength = words[i].length();
            int last = i + 1; // track the position of the next words

            // Calculate how many words can fit in the current line
            // keep adding words to the line until adding another would would exceed maxwidth
            while (last < n && lineLength + 1 + words[last].length() <= maxwidth){
                lineLength += 1 + words[last].length(); // update the current line length (+ 1 for space)
                last++;
            }

            StringBuilder sb = new StringBuilder(); // sb to construct the justified line
            int wordCount = last - i; // count how many word in this line

            // if it's the last line or there is only word. left justify
            if (last == n || wordCount == 1){
                for(int j = i; j  < last; j ++){
                    sb.append(words[j]); // append each word to the line
                    if (j < last - 1) sb.append(" "); // add a single space between words
                }

                // fill the remaining space to ensure the line matches maxWidth
                sb.append(" ".repeat(maxwidth - sb.length()));
            } else {
                //calculate the total number of space to distribute between words
                int totalSpaces = maxwidth - lineLength + wordCount - 1; // Extra space to fill
                int spaceBetWeen = totalSpaces / (wordCount - 1); // base number of spaces between word
                int extraSpaces = totalSpaces % (wordCount - 1); // Extra spaces to distribute evenly

                // distribute spaces  between the words
                for (int j = i; j < last - 1; j ++){
                    sb.append(words[j]); // append each word
                    // add spaces: some words get an extra if extraSpaces > 0
                    sb.append(" ".repeat(spaceBetWeen + (extraSpaces-- > 0 ? 1 : 0 )));
                }
                sb.append(words[last - 1]); // add the last word in the line without extra space after it
            }

            result.add(sb.toString()); // add the fully justified line to the result
            i = last; // move to the next set of words
        }

        return result; // return the list of justified lines

    }
}
