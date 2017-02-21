package com.pmandcode.schedule.service;

import com.amazon.speech.speechlet.SpeechletResponse;
import com.pmandcode.schedule.util.SpeechUtil;

public class HelpService {
	/**
	 * Creates a {@code SpeechletResponse} for the HelpIntent.
	 *
	 * @return SpeechletResponse spoken and visual response for the given intent
	 */
	//TODO include card with help message, see https://developer.amazon.com/public/solutions/alexa/alexa-skills-kit/docs/best-practices-for-skill-card-design
	public static SpeechletResponse getHelp() {
		String speechOutput = "You can ask questions regarding station or the train schedule, like \"When does the next train from vienna to salzburg leave?\". Now, how can I help you?";
		String repromptText = "To get information regarding the train schedule, ask a question like \"When does the next train from vienna to salzburg leave?\". Or you can cancel by saying \"Cancel\"";
		return SpeechUtil.newAskResponse(speechOutput, repromptText);
	}

}
