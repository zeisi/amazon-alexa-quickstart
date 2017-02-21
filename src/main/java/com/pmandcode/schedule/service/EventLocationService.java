package com.pmandcode.schedule.service;

import org.apache.commons.lang3.StringUtils;

import com.amazon.speech.slu.Intent;
import com.amazon.speech.speechlet.SpeechletResponse;
import com.amazon.speech.ui.PlainTextOutputSpeech;
import com.amazon.speech.ui.SimpleCard;

public class EventLocationService {
	
	private static final String LOCATION_SLOT = "Location";
	
	public static SpeechletResponse getLocationInfo(Intent intent) {
		
		String location = intent.getSlot(LOCATION_SLOT) != null ? intent.getSlot(LOCATION_SLOT).getValue() : null;
		
		// If one of the above slots is empty, you should handle it acordingly, like with a further inquiry to the user (left out for brevity here)
		if (StringUtils.isNotEmpty(location) ) {
			// At this point you'd query a database or another API for the required information
			PlainTextOutputSpeech outputSpeech = new PlainTextOutputSpeech();
			outputSpeech.setText("Test Output, you should here something about the event location here");

			SimpleCard card = new SimpleCard();
			card.setTitle("Location Info");
			card.setContent("Bla Bla Bla Bla Bla Bla");
			
			return SpeechletResponse.newTellResponse(outputSpeech, card);

		} else {
			// There was no item in the intent so return the help prompt.
			return HelpService.getHelp();
		}
	}
}
