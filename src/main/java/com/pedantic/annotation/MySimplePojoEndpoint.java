package com.pedantic.annotation;

import com.pedantic.data.MySimplePojo;
import com.pedantic.data.MySimplePojoDecoder;
import com.pedantic.data.MySimplePojoEncoder;

import javax.inject.Inject;
import javax.websocket.EncodeException;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

@ServerEndpoint(value = "/pojo", encoders = MySimplePojoEncoder.class,
        decoders = MySimplePojoDecoder.class)
public class MySimplePojoEndpoint {

    @Inject
    private Logger logger;


    @OnOpen
    public void opened(final Session session) throws IOException, EncodeException {
        MySimplePojo mySimplePojo = new MySimplePojo("Java EE", "bla@bla.com", "Great day! How is life?");
        session.getBasicRemote().sendObject(mySimplePojo);

    }

    @OnMessage
    public void processMessage(final Session session, MySimplePojo mySimplePojo) throws IOException, EncodeException {
        logger.log(Level.INFO, "My simple pojo received on the server *************");
        logger.log(Level.INFO, mySimplePojo.toString());
        session.getBasicRemote().sendObject(mySimplePojo);

    }


}
