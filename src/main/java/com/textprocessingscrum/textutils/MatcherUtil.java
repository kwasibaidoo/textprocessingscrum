package com.textprocessingscrum.textutils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatcherUtil {
    public boolean match(String regex, String text, boolean isSelected) {
        if(isSelected) {
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(text);

            boolean matchFound = matcher.matches();
            return matchFound;
        }
        else{
            Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(text);

            boolean matchFound = matcher.matches();
            return matchFound;
        }
    }
}
