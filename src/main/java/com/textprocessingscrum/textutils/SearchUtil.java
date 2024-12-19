package com.textprocessingscrum.textutils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SearchUtil {

    public static List<List<Integer>> search(String regex, String text, boolean isSelected) {
        if(isSelected){
            List<List<Integer>> positions = new ArrayList<>();
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(text);

            while (matcher.find()) {
                ArrayList<Integer> temp = new ArrayList<>(); 
                temp.add(matcher.start());
                temp.add(matcher.end());
                positions.add(temp);
            }

            return positions;
        }
        else{
            List<List<Integer>> positions = new ArrayList<>();
            Pattern pattern = Pattern.compile(regex,Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(text);

            while (matcher.find()) {
                ArrayList<Integer> temp = new ArrayList<>(); 
                temp.add(matcher.start());
                temp.add(matcher.end());
                positions.add(temp);
            }

            return positions;
        }
    }
}
