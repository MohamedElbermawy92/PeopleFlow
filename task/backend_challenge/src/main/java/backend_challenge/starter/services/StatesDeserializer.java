package backend_challenge.starter.services;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

public class StatesDeserializer extends JsonDeserializer<States>{

	@Override
	public States deserialize(JsonParser jsonParser, DeserializationContext arg1)
			throws IOException, JsonProcessingException {
		System.out.println("in deserialize>>>>>>>>>>>>>>>>>>>>>");
		 ObjectCodec oc = jsonParser.getCodec();
	        JsonNode node = oc.readTree(jsonParser);

	        if (node == null) {
	            return null;
	        }

	        String text = node.textValue(); // gives "A" from the request

	        if (text == null) {
	            return null;
	        }

	        return States.fromText(text);
	    }
	

}
