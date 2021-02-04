package ru.job4j.tracker;

public class ValidateInput extends ConsoleInput {

    @Override
    public int askInt(String question){
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = super.askInt(question);
                invalid = false;
            } catch (NumberFormatException nfe) {
                System.out.println("Пожалуйста, введите данные подтверждения еще раз.");
            }
        } while (invalid);
        return value;
    }
}