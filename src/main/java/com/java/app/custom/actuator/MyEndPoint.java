package com.java.app.custom.actuator;

import com.java.app.DTO.MyEndPointResponse;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

@Endpoint(id = "myEndPoint")
@Component
public class MyEndPoint {
    @ReadOperation
    public MyEndPointResponse feature() {
        return new MyEndPointResponse("1", "Prateek", "Active");
    }
}
