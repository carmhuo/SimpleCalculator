package com.jecarm.calculator.types;

import java.math.BigDecimal;

public interface Type {
  enum TypeID {
    INTEGER(Integer.class),
    LONG(Long.class),
    FLOAT(Float.class),
    DOUBLE(Double.class),
    DECIMAL(BigDecimal.class),
    STRING(CharSequence.class);

    private final Class<?> javaClass;
    TypeID(Class<?> javaClass) {
      this.javaClass = javaClass;
    }

    public Class<?> javaClass() {return this.javaClass;}
  }

  TypeID typeId();

}

