package com.example.bookcatalog.infrastructure;

import com.example.bookcatalog.application.business.events.BookEvent;

public interface EventPublisher {
	void publishEvent(BookEvent businessEvent);
}
