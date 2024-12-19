package com.textprocessingscrum.utils;

import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class Validator {

    public static ValidationResult validate(String input, String ...args) {

        for (String string : args) {
            if(string.equals("not_null")){
                if(input.equals("")){
                    return new ValidationResult("Field is required", false);
                }
            }
            if(string.equals("regex")) {
                try {
                    Pattern.compile(input);
                } catch (PatternSyntaxException e) {
                    return new ValidationResult("Regex syntax error: " + e.getDescription(), false);
                }
            }
            if(string.equals("unique")) {
                
            }
        }
        return new ValidationResult();
    }
}
