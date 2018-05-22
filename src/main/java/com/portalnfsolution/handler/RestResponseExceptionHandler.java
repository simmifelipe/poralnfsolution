package com.portalnfsolution.handler;

import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.client.DefaultResponseErrorHandler;

import java.io.IOException;

/**
 * Created by felipe.simmi on 21/10/2017.
 */
@ControllerAdvice
public class RestResponseExceptionHandler extends DefaultResponseErrorHandler {

    @Override
    public boolean hasError(ClientHttpResponse response) throws IOException {
        System.out.println("Entrou hasError");
        return super.hasError(response);
    }

    @Override
    public void handleError(ClientHttpResponse response) throws IOException {
        System.out.println("Fazendo alguma coisa com codigo de status: " + response.getStatusCode());
        System.out.println("Fazendo alguma coisa com corpo: " + response.getBody());
    }
}
