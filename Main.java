import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

import static java.lang.Integer.parseInt;

public class Main {

    public static void main(String[] args) throws IOException {
        String phoneNumber;
        do {
            phoneNumber = getNumberFromInput();
        } while (!isNumberValid(phoneNumber));

        long phone = Long.parseLong(phoneNumber);

        System.out.println("Phone number - " + phone);

        do {
            phone = summPhoneDigitals(phone);
            System.out.println("Phone numbers summ = " + phone);
        } while (phone > 10);

        System.out.println("The final number is: " + getFinalNumber(phone));
    }

    private static String getFinalNumber(long phone) {
        switch ((int) phone) {
            case 1: {
                return "One";
            }
            case 2: {
                return "Two";
            }
            case 3: {
                return "Three";
            }
            case 4: {
                return "Four";
            }
            default: {
                return String.valueOf(phone);
            }
        }
    }

    private static Integer summPhoneDigitals(long phone) {
        Integer result = 0;
        for (char c : String.valueOf(phone).toCharArray()) {
            result += parseInt(String.valueOf(c));
        }
        return result;
    }

    private static boolean isNumberValid(String phoneNumber) {
        Pattern pattern = Pattern.compile("\\+?\\d*");
        if (!pattern.matcher(phoneNumber).matches()) {
            System.out.println("Can't parse number!");
            return false;
        }
        if (phoneNumber.length() < 10) {
            System.out.println("Number length too short!");
            return false;
        }
        if (phoneNumber.length() > 14) {
            System.out.println("Number length too short!");
            return false;
        }
        return true;
    }

    private static String getNumberFromInput() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        return input.readLine();
    }


}
