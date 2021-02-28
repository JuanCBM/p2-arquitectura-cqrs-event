package es.urjc.code.pr2.domain.event;

import java.time.Instant;

public abstract class Event {

  private final Instant timestamp = Instant.now();
}
