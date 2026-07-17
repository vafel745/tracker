package ru.tracker.input;

public class ValidateInput extends ConsoleInput {

    @Override
    public int askInt(String question) {
        int result;
        while (true) {
            try {
                result = Integer.parseInt(askStr(question));
                break;
            } catch (NumberFormatException e) {
                System.out.println("Пожалуйста, введите корректные данные");
            }
        }
        return result;
    }
}
