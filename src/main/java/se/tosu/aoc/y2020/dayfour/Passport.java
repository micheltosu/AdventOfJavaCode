package se.tosu.aoc.y2020.dayfour;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Passport {
    private final String byr;
    private final String iyr;
    private final String eyr;
    private final String hgt;
    private final String hcl;
    private final String ecl;
    private final String pid;
    private final String cid;

    Passport(String byr, String iyr, String eyr, String hgt, String hcl, String ecl, String pid, String cid) {
        this.byr = byr;
        this.iyr = iyr;
        this.eyr = eyr;
        this.hgt = hgt;
        this.hcl = hcl;
        this.ecl = ecl;
        this.pid = pid;
        this.cid = cid;
    }

    public static Passport createPassportFromMap(Map<String, String> passportProperties) {
        if (hasRequiredProperties(passportProperties)) {
            return new Passport(
                    passportProperties.get("byr"),
                    passportProperties.get("iyr"),
                    passportProperties.get("eyr"),
                    passportProperties.get("hgt"),
                    passportProperties.get("hcl"),
                    passportProperties.get("ecl"),
                    passportProperties.get("pid"),
                    passportProperties.get("cid")
            );
        } else {
            throw new RuntimeException("Passport doesn't have all required fields");
        }
    }

    public static boolean propertiesAreValid(Passport passport) {
        return validateBirthYear(passport.getByr()) &&
                validateIssuedYear(passport.getIyr()) &&
                validateExpirationYear(passport.getEyr()) &&
                validateHeight(passport.getHgt()) &&
                validateHairColor(passport.getHcl()) &&
                validateEyeColor(passport.getEcl()) &&
                validatePassportId(passport.getPid());
    }

    static boolean validatePassportId(String pid) {
        return Pattern.compile("^\\d{9}$").matcher(pid).find();
    }

    static boolean validateEyeColor(String ecl) {
        return Pattern.compile("^(amb|blu|brn|gry|hzl|oth|grn)$").matcher(ecl).find();
    }

    static boolean validateHairColor(String hcl) {
        return Pattern.compile("^#[0-9,a-f]{6}$").matcher(hcl.toLowerCase()).find();
    }

    static boolean validateHeight(String hgt) {
        Pattern pattern = Pattern.compile("^([0-9]{2,3})(in|cm)$");
        Matcher matcher = pattern.matcher(hgt.toLowerCase());
        if (matcher.find()) {
            int height = Integer.parseInt(matcher.group(1));
            String unit = matcher.group(2);
            if (unit.equals("cm")) {
                return height >= 150 && height <= 193;
            } else if (unit.equals("in")) {
                return height >= 59 && height <= 76;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    static boolean validateExpirationYear(String eyr) {
        int year = Integer.parseInt(eyr);
        return year >= 2020 && year <= 2030;
    }

    static boolean validateIssuedYear(String iyr) {
        int year = Integer.parseInt(iyr);
        return year >= 2010 && year <= 2020;
    }

    static boolean validateBirthYear(String byr) {
        int year = Integer.parseInt(byr);
        return year >= 1920 && year <= 2002;
    }

    private static boolean hasRequiredProperties(Map<String, String> passportProperties) {
        return passportProperties.containsKey("byr")
                && passportProperties.containsKey("iyr")
                && passportProperties.containsKey("eyr")
                && passportProperties.containsKey("hgt")
                && passportProperties.containsKey("hcl")
                && passportProperties.containsKey("ecl")
                && passportProperties.containsKey("pid");
    }

    public String getEcl() {
        return ecl;
    }

    public String getPid() {
        return pid;
    }

    public String getHcl() {
        return hcl;
    }

    public String getHgt() {
        return hgt;
    }

    public String getEyr() {
        return eyr;
    }

    public String getIyr() {
        return iyr;
    }

    public String getByr() {
        return byr;
    }

    public String getCid() {
        return cid;
    }
}
