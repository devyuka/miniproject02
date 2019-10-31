import java.util.Scanner;

public class InputCollector {
    public final static int MENU_OPTION_NUM_FIRST = 1;
    public final static int MENU_OPTION_NUM_LAST = 5;

    public static String getUserInput(String prompt, String type, boolean required) {
        boolean inputValid = false;
        String userInput = null;
        String inputType = type;

        while (!inputValid) {
            Scanner scanner = new Scanner(System.in);
            System.out.print(prompt);
            userInput = scanner.nextLine();

            if (inputType.equals("string")) {
                try {
                    if (required && userInput.length() <= 0) {
                        throw new IllegalArgumentException();
                    } else if ((userInput == null) || (!userInput.matches("[a-zA-Z ]+"))) {
                        throw new Exception();
                    } else {
                        inputValid = true;
                    }
                } catch (IllegalArgumentException e) {
                    System.out.println("You must enter this field.");
                } catch (Exception e) {
                    System.out.println("Invalid input. You can enter only letters or space.");
                }
            }

            if (inputType.equals("phoneNum")) {
                try {
                    if (required && userInput.length() <= 0) {
                        throw new IllegalArgumentException();
                    } else if ((userInput.length() > 0) && (!userInput.matches("[0-9-]+"))) {
                        throw new Exception();
                    } else {
                        inputValid = true;
                    }
                } catch (IllegalArgumentException e) {
                    System.out.println("You must enter this field.");
                } catch (Exception e) {
                    System.out.println("Invalid input. You can enter only numbers or hyphens.");
                }
            }

            if (inputType.equals("optionNum")) {
                try {
                    if (userInput.length() <= 0) {
                        throw new IllegalArgumentException();
                    }
                    if ((userInput == null) || (!userInput.matches("[1-9]+")) || (Integer.parseInt(userInput) < MENU_OPTION_NUM_FIRST) || (Integer.parseInt(userInput) > MENU_OPTION_NUM_LAST)) {
                        throw new Exception();
                    } else {
                        inputValid = true;
                    }
                } catch (IllegalArgumentException e) {
                    System.out.println("Please enter an option number from the menu.");
                } catch (Exception e) {
                    System.out.println("Invalid input. You can enter only a number from " + MENU_OPTION_NUM_FIRST + " to " + MENU_OPTION_NUM_LAST + ".");
                }
            }

            if (inputType.equals("indexNum")) {
                try {
                    if (userInput.length() <= 0) {
                        throw new IllegalArgumentException();
                    } else if ((userInput == null) || (!userInput.matches("[0-9]+")) || (Integer.parseInt(userInput) < 0) || Integer.parseInt(userInput) > (Contact.getCount() - 1)) {
                        throw new Exception();
                    } else {
                        inputValid = true;
                    }
                } catch (IllegalArgumentException e) {
                    System.out.println("Please enter an index number.");
                } catch (Exception e) {
                    System.out.println("Invalid input. You can enter only a number " +
                            ((Contact.getCount() > 1) ? "from 0 to " + (Contact.getCount() - 1) : "0") + ".");
                }
            }

            if (inputType.equals("yn")) {
                try {
                    if (required && userInput.length() <= 0) {
                        throw new IllegalArgumentException();
                    } else if ((userInput == null) || (!userInput.matches("[nNyY]+"))) {
                        throw new Exception();
                    } else {
                        inputValid = true;
                    }
                } catch (IllegalArgumentException e) {
                    System.out.println("Please enter Y(y) or N(n).");
                } catch (Exception e) {
                    System.out.println("Invalid input. You can enter only Y(y) or N(n).");
                }
            }
        }

        return userInput;
    }
}