package com.jecarm.calculator;

import com.jecarm.calculator.command.Numeral;

import com.jecarm.calculator.command.Numerals;
import com.jecarm.calculator.util.NumeralUtil;
import com.jecarm.calculator.util.TypeUtil;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class CalculatorTest {
  Calculator calculator;
  @Before
  public void before() {
    calculator = new Calculator();
  }

  @Test
  public void evaluateTest() {
//    Mockito.when()
  }

  @Test
  public void inferValueTypeTest() {
    calculator.parseInputs("5 2");
    Numeral literal = TypeUtil.inferValueType("5");
    Numeral expected = Numerals.from(5);
    assertTrue(expected.equals(literal));
    assertTrue(Numerals.from(5.2d).equals(TypeUtil.inferValueType("5.2")));
  }

  @Test(expected = IllegalArgumentException.class)
  public void inferValueTypeExceptionTest() {
    TypeUtil.inferValueType("5.f6");
  }

  @Test
  public void isNumeralTest() {
    assertTrue(NumeralUtil.isNumeral("2233"));
    assertTrue(NumeralUtil.isNumeral("1.234"));
    assertTrue(NumeralUtil.isNumeral("0.1"));
    assertFalse(NumeralUtil.isNumeral("abc"));
    assertFalse(NumeralUtil.isNumeral("0...2"));
  }
}