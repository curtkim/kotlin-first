package com.example.counterwithjava;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public class CounterEvent {
  long value;
  CounterAction action;
  ZonedDateTime at;

  public CounterEvent(long value, CounterAction action, ZonedDateTime at) {
    this.value = value;
    this.action = action;
    this.at = at;
  }

  public CounterEvent(long value, CounterAction action) {
    this(value, action, ZonedDateTime.now(ZoneId.of("UTC")));
  }

  public long getValue() {
    return value;
  }

  public CounterAction getAction() {
    return action;
  }

  public ZonedDateTime getAt() {
    return at;
  }
}
