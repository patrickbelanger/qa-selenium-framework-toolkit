package qa.free.tools.selenium.toolkit.core.reporter.events;

import java.sql.Timestamp;

import lombok.Builder;
import lombok.Data;
import qa.free.tools.selenium.toolkit.core.reporter.Status;

@Builder
@Data
public class Event {

	private String message;
	private Status status;
	private Timestamp timestamp;
	private String exception;
	
}
