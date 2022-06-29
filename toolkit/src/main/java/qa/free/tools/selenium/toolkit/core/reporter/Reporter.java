package qa.free.tools.selenium.toolkit.core.reporter;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import qa.free.tools.selenium.toolkit.core.reporter.events.Event;

public class Reporter {
	
	@Getter
	@Setter
	private List<Event> events = new ArrayList<>();
	
	@Getter(AccessLevel.PRIVATE)
	static final Logger logger = LoggerFactory.getLogger(Reporter.class);
	
	public void addEvent(Event event) {
		events.add(event);
		displayEvent(event);
	}
	
	private void displayEvent(Event event) {
		logger.info("{}", event);
	}
	
}
