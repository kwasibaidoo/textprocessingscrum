package com.textprocessingscrum.utils;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
public class ValidatorTest {

    @InjectMocks
    private Validator validator;

    @ParameterizedTest
    @CsvSource({
            "not_null,'', false",
            "regex, '*', false",
            "regex, '[a-zA-Z]', true ",
            "not_null, 'validInput', true "
    })
    void testValidate(String arg, String input, boolean expectedValidity) {
        if(expectedValidity) {
            ValidationResult validationResult = validator.validate(input, arg);
            assertTrue(validationResult.isSuccess());
        }
        else{
            ValidationResult validationResult = validator.validate(input, arg);
            assertFalse(validationResult.isSuccess());
        }
    }

}
