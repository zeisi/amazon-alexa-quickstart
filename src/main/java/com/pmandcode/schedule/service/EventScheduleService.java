package com.pmandcode.schedule.service;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.amazon.speech.slu.Intent;
import com.amazon.speech.speechlet.SpeechletResponse;
import com.amazon.speech.ui.PlainTextOutputSpeech;
import com.amazon.speech.ui.SimpleCard;

public class EventScheduleService {
	
	private static final Logger log = LoggerFactory.getLogger(EventScheduleService.class);
	
	private static final String LOCATION_SLOT = "Location";
	private static final String DATE_SLOT = "Intentdate";

	public static SpeechletResponse getNextEvent(Intent intent) {

		String location = intent.getSlot(LOCATION_SLOT) != null ? intent.getSlot(LOCATION_SLOT).getValue() : null;
		String date = intent.getSlot(DATE_SLOT) != null ? intent.getSlot(DATE_SLOT).getValue() : null;
		
		// If one of the above slots is empty, you should handle it acordingly, like with a further inquiry to the user (left out for brevity here)
		if (StringUtils.isNotEmpty(location) && StringUtils.isNotEmpty(date)) {

			PlainTextOutputSpeech outputSpeech = new PlainTextOutputSpeech();
			outputSpeech.setText("Test Output, you should hear something about event schedules here.");

			SimpleCard card = new SimpleCard();
			card.setTitle("Event Info");
			card.setContent("Rock Concert - 12.03.2017, Ticket cost 20 euros.");

			return SpeechletResponse.newTellResponse(outputSpeech, card);

		} else {
			// There where empty slots in the intent so return the help prompt.
			log.error("Not all fields were filled.");
			return HelpService.getHelp();
		}
	}

}
