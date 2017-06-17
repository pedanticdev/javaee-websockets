package com.pedantic.programmatic;

import com.pedantic.data.MySimplePojo;
import com.pedantic.data.MySimplePojoDecoder;
import com.pedantic.data.MySimplePojoEncoder;

import javax.websocket.Endpoint;
import javax.websocket.EndpointConfig;
import javax.websocket.MessageHandler;
import javax.websocket.Session;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.websocket.ClientEndpoint;
import javax.websocket.EncodeException;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;

public class MyProgrammaticClient extends Endpoint {

    @Override
    public void onOpen(Session session, EndpointConfig config) {
        try {
            session.getBasicRemote().sendText("Hello server from client");
        } catch (IOException ex) {
            Logger.getLogger(MyProgrammaticClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        session.addMessageHandler(new MessageHandler.Whole<String>(){
            @Override
            public void onMessage(String message) {
                System.out.println("Client: " + message);
                try {
                    session.getBasicRemote().sendText("In response to what was received from the server. This is the client");
                } catch (IOException ex) {
                    Logger.getLogger(MyProgrammaticClient.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        });
    }
    
}
