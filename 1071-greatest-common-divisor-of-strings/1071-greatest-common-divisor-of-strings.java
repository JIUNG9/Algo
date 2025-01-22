import java.util.*;
import java.util.regex.*;

class Solution {
    public String gcdOfStrings(String str1, String str2) {
        if (str1.length() < str2.length()) {
            String temp = str1;
            str1 = str2;
            str2 = temp;
        }

        for (int i = str2.length(); i > 0; i--) {
            String candidate = str2.substring(0, i);
            if (isGCD(candidate, str1) && isGCD(candidate, str2)) {
                return candidate;
            }
        }
        return "";
    }

    public boolean isGCD(String pat, String input) {
        int times = input.length() / pat.length();
        String regex = "(" + Pattern.quote(pat) + "){" + times + "}";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(input);
        return m.matches();
    }
}
