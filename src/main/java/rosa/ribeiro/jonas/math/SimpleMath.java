package rosa.ribeiro.jonas.math;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import rosa.ribeiro.jonas.exception.UnsupportedMathOperationExeption;

public class SimpleMath {

    public Double sum(Double numberOne, Double numberTwo){
        return numberOne + numberTwo;
    }

    public Double sub(Double numberOne, Double numberTwo) {
        return numberOne - numberTwo;

    }

    public Double mul(Double numberOne, Double numberTwo) {
        return numberOne * numberTwo;
    }

    public Double div(Double numberOne, Double numberTwo) {
        if(numberTwo == 0) throw new UnsupportedMathOperationExeption("There is no division by zero. Please set another number value!");
        return numberOne / numberTwo;
    }

    public Double ave(Double numberOne, Double numberTwo)  {
        return (numberOne + numberTwo)/2;
    }

    public Double squ(Double number) {
        return Math.sqrt(number);
    }

}
