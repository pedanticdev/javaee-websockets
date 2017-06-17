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
import javax.websocket.EncodeException;

public class MyProgrammaticEndpoint extends Endpoint {

    @Override
    public void onOpen(Session session, EndpointConfig endpointConfig) {



        session.addMessageHandler(new MessageHandler.Whole<String>() {
            @Override
            public void onMessage(String s) {
                System.out.println("Server: " + s);
                try {
                    session.getBasicRemote().sendText("In response to message received from client. This is the server");
                } catch (IOException ex) {
                    Logger.getLogger(MyProgrammaticEndpoint.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });

    }
}
