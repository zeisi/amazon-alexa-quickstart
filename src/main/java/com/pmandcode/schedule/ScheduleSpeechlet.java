package com.pmandcode.schedule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.amazon.speech.slu.Intent;
import com.amazon.speech.speechlet.IntentRequest;
import com.amazon.speech.speechlet.LaunchRequest;
import com.amazon.speech.speechlet.Session;
import com.amazon.speech.speechlet.SessionEndedRequest;
import com.amazon.speech.speechlet.SessionStartedRequest;
import com.amazon.speech.speechlet.Speechlet;
import com.amazon.speech.speechlet.SpeechletException;
import com.amazon.speech.speechlet.SpeechletResponse;
import com.amazon.speech.ui.PlainTextOutputSpeech;
import com.pmandcode.schedule.service.HelpService;
import com.pmandcode.schedule.service.EventLocationService;
import com.pmandcode.schedule.service.EventScheduleService;
import com.pmandcode.schedule.util.SpeechUtil;

public class ScheduleSpeechlet implements Speechlet {
	private static final Logger log = LoggerFactory.getLogger(ScheduleSpeechlet.class);


	@Override
	public void onSessionStarted(final SessionStartedRequest request, final Session session) throws SpeechletException {
		log.info("onSessionStarted requestId={}, sessionId={}", request.getRequestId(), session.getSessionId());

		// any initialization logic goes here
	}

	@Override
	public SpeechletResponse onLaunch(final LaunchRequest request, final Session session) throws SpeechletException {
		log.info("onLaunch requestId={}, sessionId={}", request.getRequestId(), session.getSessionId());

		String speechOutput = "Welcome to the test schedule service, you can search for stations or train schedules. Now, how can I help you?";
		// If the user either does not reply to the welcome message or says
		// something that is not understood, they will be prompted again with
		// this text.
		String repromptText = "For help, just say help";

		// Here we are prompting the user for input
		return SpeechUtil.newAskResponse(speechOutput, repromptText);
	}

	@Override
	public SpeechletResponse onIntent(final IntentRequest request, final Session session) throws SpeechletException {

		Intent intent = request.getIntent();
		String intentName = (intent != null) ? intent.getName() : null;
		
		if(intentName != null){
			log.info("{} Intent requestId={}, sessionId={}", intentName, request.getRequestId(), session.getSessionId());
		} else {
			throw new SpeechletException("Invalid Intent");
		}
		
		// I'd call this event routing
		switch (intentName) {
        case "GetEventSchedule":
        	return EventScheduleService.getNextEvent(intent);
        case "GetEventLocations":
        	return EventLocationService.getLocationInfo(intent);
        case "AMAZON.HelpIntent":
        	return HelpService.getHelp();
        case "AMAZON.StopIntent":
        	PlainTextOutputSpeech outputSpeech = new PlainTextOutputSpeech();
			outputSpeech.setText("Goodbye");
			return SpeechletResponse.newTellResponse(outputSpeech);
        case "AMAZON.CancelIntent":
        	PlainTextOutputSpeech cancelOutputSpeech = new PlainTextOutputSpeech();
        	cancelOutputSpeech.setText("Goodbye");
			return SpeechletResponse.newTellResponse(cancelOutputSpeech);
        default:
        	throw new SpeechletException("Invalid Intent");
		}
	}

	@Override
	public void onSessionEnded(final SessionEndedRequest request, final Session session) throws SpeechletException {
		log.info("onSessionEnded requestId={}, sessionId={}", request.getRequestId(), session.getSessionId());

		// any cleanup logic goes here
	}

	
	



}
