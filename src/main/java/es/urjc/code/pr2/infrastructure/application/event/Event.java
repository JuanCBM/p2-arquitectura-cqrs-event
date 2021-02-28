package es.urjc.code.pr2.infrastructure.application.event;

import java.time.Instant;

public abstract class Event {

  private final Instant timestamp = Instant.now();
}
