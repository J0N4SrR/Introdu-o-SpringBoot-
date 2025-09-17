package rosa.ribeiro.jonas.util;

import rosa.ribeiro.jonas.exception.UnsupportedMathOperationExeption;

public class NumberConverter {
    public static Double convertToDouble(String strNumber) {
        if( strNumber == null || strNumber.isEmpty()) throw new UnsupportedMathOperationExeption("Please set a numeric value!");
        String number = strNumber.replace(",", ".");
        return Double.parseDouble(number);
    }


}
