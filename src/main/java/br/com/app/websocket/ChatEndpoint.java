package br.com.app.websocket;

import java.io.IOException;
import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

import javax.websocket.EncodeException;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

/**
 * @author pedro
 * url websocket : ws://localhost:8080/app/chat/{username}
 */
@ServerEndpoint(value = "/chat/{username}", 
				decoders = MessageDecoder.class, 
				encoders = MessageEncoder.class)
public class ChatEndpoint {

	private Session session;
	private static Set<ChatEndpoint> chatEndpoints = new CopyOnWriteArraySet<>();
	private static HashMap<String, String> users = new HashMap<>();

	@OnOpen
	public void onOpen(Session session, @PathParam("username") String username) throws IOException, EncodeException {

		this.session = session;

		chatEndpoints.add(this);

		users.put(session.getId(), username);

		Message message = Message.builder().from(username).content("Conected!").build();

		broadcast(message);
	}

	@OnMessage
	public void onMessage(Session session, Message message) throws IOException, EncodeException {
		
		String usuario = users.get(session.getId());		
		
		message.setFrom(usuario);
		
		broadcast(message);
	}

	@OnClose
	public void onClose(Session session) throws IOException, EncodeException {

		chatEndpoints.remove(this);

		String usuario = users.get(session.getId());
		
		Message message = Message.builder().from(usuario).content("Disconnected").build();
		
		broadcast(message);

	}

	@OnError
	public void onError(Session session, Throwable throwable) {

	}

	private synchronized static void broadcast(Message message) throws IOException, EncodeException {
			
		for (ChatEndpoint chatEndpoint : chatEndpoints) {
			
			try {
			
				chatEndpoint.session.getBasicRemote().sendObject(message);
		
			} catch (IOException | EncodeException e) {
			
				e.printStackTrace();
			}
		}
	}
}
