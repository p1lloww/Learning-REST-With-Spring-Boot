package com.br.neptune.Learning_REST_With_Spring_Boot.controllers;

import com.br.neptune.Learning_REST_With_Spring_Boot.exception.UnsupportedMathOperationException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/math")
public class MathController {

    @GetMapping("/sum/{a}/{b}")
    public Double sum(
            @PathVariable("a") String a,
            @PathVariable("b") String b
    ) throws UnsupportedMathOperationException {
        validNumber(a);
        validNumber(b);
        return convertToDouble(a) + convertToDouble(b);
    }

    @GetMapping("/sub/{a}/{b}")
    public Double subtract(
            @PathVariable("a") String a,
            @PathVariable("b") String b
    ) throws UnsupportedMathOperationException {
        validNumber(a);
        validNumber(b);
        return convertToDouble(a) - convertToDouble(b);
    }

    @GetMapping("/division/{a}/{b}")
    public Double division(
            @PathVariable("a") String a,
            @PathVariable("b") String b
    ) throws UnsupportedMathOperationException {
        validNumber(a);
        validNumber(b);
        return convertToDouble(a) / convertToDouble(b);
    }

    @GetMapping("/media/{a}/{b}")
    public Double media(
            @PathVariable("a") String a,
            @PathVariable("b") String b
    ) throws UnsupportedMathOperationException {
        validNumber(a);
        validNumber(b);
        return (convertToDouble(a) + convertToDouble(b)) / 2;
    }

    @GetMapping("/sqrt/{a}/{b}")
    public Double sqrt(
            @PathVariable("a") String a,
            @PathVariable("b") String b
    ) throws UnsupportedMathOperationException {
        validNumber(a);
        validNumber(b);
        return Math.sqrt(convertToDouble(a) + convertToDouble(b));
    }

    public boolean isNumber(String a) {
        verifyNull(a);
        String number = a.replaceAll(",", ".");
        return verifyNumberRegex(number);
    }

    public Double convertToDouble(String a) throws UnsupportedMathOperationException {
        validNumber(a);
        return Double.parseDouble(a);
    }

    public Boolean validNumber(String a) throws UnsupportedMathOperationException {
        if (!isNumber(a)) {
            throw new UnsupportedMathOperationException("Please set a valid number");
        }
        return true;
    }

    public Boolean verifyNumberRegex(String number) {
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }

    public Boolean verifyNull(String number) {
        if (number == null || number.isEmpty()) {
            return false;
        }
        return true;
    }
}
