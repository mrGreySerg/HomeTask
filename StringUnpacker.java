package ru.sergGrey;

/**
 * Класс преобразовывает строку вида "2[abc]dd" в строку "abcabcdd".
 * Распаковывает квадратные скобки и повторяет содержимое столько раз
 * какое число стоит перед скобками.
 * @author Kustrin Sergei.
 * @version 1.0.
 */
public class StringUnpacker {

    /**
     * Метод проверяет соответствует ли входящая строка шаблону.
     * @param validateString - строка для проверки.
     * @return boolean результат проверки.
     */
    public static boolean validate(String validateString) {
        String templateForString = "([a-z]+)*([1-9][\\[][a-z]+[\\]])*([a-z]+)*([1-9][\\[][a-z]+[\\]])*";
        return validateString.matches(templateForString) ? true : false;
    }

    /**
     * Метод распаковки квадратных скобок строки и создающий новую
     * преобразованную строку.
     * @param baseString - строка с квадратными скобками для преобразования.
     * @return - преобразованная строка.
     */
    public static String unpacker(String baseString) {
        char[] baseInChar = baseString.toCharArray();
        StringBuilder unpackedString = new StringBuilder();
        for (int i = 0; i < baseInChar.length; i++) {
            if (baseInChar[i] == ']') continue;
            if (Character.isLetter(baseInChar[i])) {
                unpackedString.append(baseInChar[i]);
            }
            if (Character.isDigit(baseInChar[i])) {
                int numberInString = Character.getNumericValue(baseInChar[i]);
                i += 2;
                StringBuilder temp = new StringBuilder();
                do {
                    temp.append(baseInChar[i++]);
                    if (baseInChar[i] == ']') {
                            for (int j = 0; j < numberInString; j++)
                            unpackedString.append(temp);
                    }
                } while (baseInChar[i] != ']');
            }
        }
        return unpackedString.toString();
    }

    public static void main(String[] args) {
        String baseString = "ff3[abc]ff";
        if (validate(baseString)) {
            System.out.println(unpacker(baseString));
        } else {
            System.out.println("Строка не валидна и не может быть преобразована");
        }
    }
}

