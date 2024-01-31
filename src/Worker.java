
import java.util.Scanner;

public class Worker {
    int id;
    String name;
    String gender;
    String position;
    float hours;
    float rate;
    String number = "^[0-9]+$";
    String text = "[a-zA-Z]+";
    String floatNum = "[+-]?([0-9]+([.][0-9]*)?|[.][0-9]+)";
    String genderRegex = "(?:m|M|male|Male|f|F|female|Female|FEMALE|MALE)$";
    private final static int FEMALETAXRATE = 30;
    private final static int MALETAXRATE = 50;
    private String inputValidation(Scanner input, String message, String regex) {
        while (true) {
            System.out.print(message);
            String userInput = input.nextLine();
            if (userInput.matches(regex)) {
                return userInput;
            } else {
                System.out.println("Invalid input!");
            }
        }
    }

    public void inputWorker(Scanner input) {
        id = Integer.parseInt(inputValidation(input, "Enter ID: ", number));
        name = inputValidation(input, "Enter Name: ", text);
        gender = inputValidation(input, "Enter Gender: ", genderRegex);
        position = inputValidation(input, "Enter Position: ", text);
        hours = Float.parseFloat(inputValidation(input, "Enter Hours: ", floatNum));
        rate = Float.parseFloat(inputValidation(input, "Enter Rate: ",   floatNum));

    }
    public void displayWorker() {
        float deduction = 0;
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Gender: " + gender);
        System.out.println("Position: " + position);
        System.out.println("Hours: " + hours);
        System.out.println("Rate: " + rate);
        System.out.println("Salary Before Tax: " + salary());
        if(salary() >= 1000) {
            deduction = findTaxDeduction();
            System.out.println("Final Salary: " + (salary() - deduction) + "$");
        }
    }

    public float salary() {
        return hours * rate;
    }

    private float findTaxDeduction() {
        float rate = 0;
        if (gender.equalsIgnoreCase("female")) {
            rate = FEMALETAXRATE;
        }  else {
            rate = MALETAXRATE;
        }
        float deduction = salary() * (rate / 100);
        System.out.println("Tax: " + rate + "%");
        System.out.println("Tax Salary Deduction: " + deduction + "$");
        return deduction;
    }
}
