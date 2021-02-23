package backend_challenge.starter.services;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import backend_challenge.starter.ExceptionHandler.NotFoundException;

@JsonDeserialize(using = StatesDeserializer.class)
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum States {

	//VALUE1("ADDED"),VALUE2("CHECK");
	A("ADDED"),I("IN"),C("CHECK"),AP("APPROVED"),AC("ACTIVE");
	
	private States(){};
	
	private  String text;

	States(String text)
	{this.text = text;}

    public String getText(){return this.text;}

    @JsonCreator
    public static States fromText(String text){
        for(States r : States.values()){
            if(r.getText().equals(text)){
                return r;
            }
        }
        throw new NotFoundException("This state not definded");
    }
    
    @Override
    public String toString() {
        return text;
    }
}
