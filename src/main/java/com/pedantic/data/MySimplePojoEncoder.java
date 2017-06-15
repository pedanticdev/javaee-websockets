package com.pedantic.data;

import javax.json.bind.JsonbBuilder;
import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

public class MySimplePojoEncoder implements Encoder.Text<MySimplePojo> {
    @Override
    public String encode(MySimplePojo mySimplePojo) throws EncodeException {
        return JsonbBuilder.create().toJson(mySimplePojo);

    }

    @Override
    public void init(EndpointConfig endpointConfig) {

    }

    @Override
    public void destroy() {

    }
}
