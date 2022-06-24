package com.example.core;

import org.junit.jupiter.api.Test;

public class AdderTest {

  @Test
  public void test(){
    Adder adder = new Adder();
    assert 3 == adder.add(1,2);
  }
}
