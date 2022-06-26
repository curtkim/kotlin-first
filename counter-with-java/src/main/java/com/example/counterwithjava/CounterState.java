package com.example.counterwithjava;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public class CounterState {
  long value;
  ZonedDateTime at;

  public CounterState(long value, ZonedDateTime at) {
    this.value = value;
    this.at = at;
  }

  public CounterState(long value) {
    this(value, ZonedDateTime.now(ZoneId.of("UTC")));
  }

  public long getValue() {
    return value;
  }

  public ZonedDateTime getAt() {
    return at;
  }

  public CounterEvent toEvent(CounterAction action) {
    return new CounterEvent(value, action, at);
  }
}
