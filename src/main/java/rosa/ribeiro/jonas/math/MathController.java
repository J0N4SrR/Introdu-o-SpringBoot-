package rosa.ribeiro.jonas.math;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rosa.ribeiro.jonas.exception.UnsupportedMathOperationExeption;

import static rosa.ribeiro.jonas.math.util.NumberConverter.convertToDouble;
import static rosa.ribeiro.jonas.math.util.NumberVerification.isNumeric;


@RestController
@RequestMapping("/math")
public class MathController {

    private final SimpleMath math = new SimpleMath();

    @RequestMapping("/sum/{numberOne}/{numberTwo}")
    public Double sum(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo
    ) throws Exception {
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) throw new UnsupportedMathOperationExeption("Please set a numeric value!");
        return math.sum(convertToDouble(numberOne), convertToDouble(numberTwo));

    }

    @RequestMapping("/sub/{numberOne}/{numberTwo}")
    public Double sub(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo
    ) throws Exception {
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) throw new UnsupportedMathOperationExeption("Please set a numeric value!");
        return math.sub(convertToDouble(numberOne), convertToDouble(numberTwo));

    }

    @RequestMapping("/mul/{numberOne}/{numberTwo}")
    public Double mul(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo
    ) throws Exception {
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) throw new UnsupportedMathOperationExeption("Please set a numeric value!");
        return math.mul(convertToDouble(numberOne), convertToDouble(numberTwo));

    }


    @RequestMapping("/div/{numberOne}/{numberTwo}")
    public Double div(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo
    ) throws Exception {
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) throw new UnsupportedMathOperationExeption("Please set a numeric value!");
        if(convertToDouble(numberTwo) == 0) throw new UnsupportedMathOperationExeption("There is no division by zero. Please set another number value!");
        return math.div(convertToDouble(numberOne), convertToDouble(numberTwo));

    }

    @RequestMapping("/ave/{numberOne}/{numberTwo}")
    public Double ave(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo
    ) throws Exception {
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) throw new UnsupportedMathOperationExeption("Please set a numeric value!");
        return math.ave(convertToDouble(numberOne), convertToDouble(numberTwo));

    }

    @RequestMapping("/squ/{number}")
    public Double squ(
            @PathVariable("number") String number
    ) throws Exception {
        if(!isNumeric(number))throw new UnsupportedMathOperationExeption("Please set a numeric value!");
        return math.squ(convertToDouble(number));

    }

}
