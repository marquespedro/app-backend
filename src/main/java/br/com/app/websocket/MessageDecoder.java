package br.com.app.websocket;

import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;

import com.google.gson.Gson;


public class MessageDecoder implements Decoder.Text<Message> {

	 private static Gson gson = new Gson();
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void init(EndpointConfig arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public Message decode(String message) throws DecodeException {
		
		   return gson.fromJson(message, Message.class);
	}

	@Override
	public boolean willDecode(String s) {
        return (s != null);
	}

}
