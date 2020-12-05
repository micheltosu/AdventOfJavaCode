package se.tosu.aoc.y2020.dayfour;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PassportTest {
    @Test
    void testValidatePassportId() {
        assertTrue(Passport.validatePassportId("000000001"));
    }

    @Test
    void testInvalidPassportIdValidatesFalse() {
        assertFalse(Passport.validatePassportId("0123456789"));
    }

    @Test
    void testValidateBirthYear() {
        assertTrue(Passport.validateBirthYear("2002"));
    }

    @Test
    void testInvalidBirthYearValidatesFalse() {
        assertFalse(Passport.validateBirthYear("2003"));
    }

    @Test
    void testValidateEyeColor() {
        assertTrue(Passport.validateEyeColor("brn"));
    }

    @Test
    void testInvalidEyeColorValidatesFalse() {
        assertFalse(Passport.validateEyeColor("brnn"));
    }

    @Test
    void testValidateHairColor() {
        assertTrue(Passport.validateHairColor("#123abc"));
    }

    @Test
    void testInvalidHairColorValidatesFalse() {
        assertFalse(Passport.validateHairColor("#123abz"));
    }

    @Test
    void testValidHairColorInCapitalsIsValid() {
        assertTrue(Passport.validateHairColor("#ABC123"));
    }

    @Test
    void testInvalidHairColorFormatValidatesFalse() {
        assertFalse(Passport.validateHairColor("123abc"));
    }

    @Test
    void testTooLongHairColorValueValidatesFalse() {
        assertFalse(Passport.validateHairColor("#FFFFFFF"));
    }

    @Test
    void testHairColorStringWithPrefixValidatesFalse() {
        assertFalse(Passport.validateHairColor("x#fff123"));
    }

    @Test
    void testValidateHeightIn() {
        assertTrue(Passport.validateHeight("60in"));
    }

    @Test
    void testValidateHeightInUpperCase() {
        assertTrue(Passport.validateHeight("60IN"));
    }

    @Test
    void testValidateHeightCm() {
        assertTrue(Passport.validateHeight("175cm"));
    }

    @Test
    void testInvalidHeightFormatValidatesFalse() {
        assertFalse(Passport.validateHeight("190"));
    }

    @Test
    void testInvalidHeightInValidatesFalse() {
        assertFalse(Passport.validateHeight("190in"));
    }

    @Test
    void testInvalidHeightCmValidatesFalse() {
        assertFalse(Passport.validateHeight("50cm"));
    }

    @Test
    void testValidPassportValidatesTrue() {
        assertTrue(Passport.propertiesAreValid(new Passport("2001", "2015", "2022", "164cm", "#888785", "hzl", "545766238", "88")));
    }

    @Test
    void testValidPassportWithoutCidValidatesTrue() {
        assertTrue(Passport.propertiesAreValid(new Passport("2001", "2015", "2022", "164cm", "#888785", "hzl", "545766238", null)));
    }

    @Test
    void testValidPassword() {
        assertTrue(Passport.propertiesAreValid(new Passport("1980", "2012", "2030", "74in", "#623a2f", "grn", "087499704", null)));
    }
}