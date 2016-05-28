package dev.roanixs.eurekaclient.hello;

import dev.roanixs.eurekaclient.hello.domain.Greeting;
import io.swagger.annotations.*;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by coumaj on 28/05/2016.
 */
@RestController
public class GreetingController {

    private static final String template = "Hello, %s";

    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(method = RequestMethod.GET, path = "/greeting", produces = "application/json")
    @ApiOperation(value = "getGreetings", nickname = "getGreetings")
    @ApiImplicitParams( value = {
            @ApiImplicitParam(name = "name", value = "User's name", required = false, dataType = "string", paramType = "query", defaultValue = "Joani"),
            @ApiImplicitParam(name = "message", value = "Message", required = false, dataType = "string", paramType = "query", defaultValue = "This is a message")
    })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Sucess", response = Greeting.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not found"),
            @ApiResponse(code = 500, message = "Failure")
    })
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name, @RequestParam(value = "message" , defaultValue = "This is a message") String message) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name), message);
    }

}
