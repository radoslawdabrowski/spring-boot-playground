package org.architecture.poc.springcloudclientpoc.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * RefreshScope oznacza że dany bean, w tym przypadku Kontroler jest podatna na odświeżanie właściwości
 */
@RefreshScope
@RestController
public class GlobalPropertyController {

    @Value("${user.role}")
    private String role;

    @GetMapping(value = "/whoami/{username}", produces = MediaType.TEXT_PLAIN_VALUE)
    public String whoamid(@PathVariable("username") String username) {
        return String.format("Twoja rola: %s\n", role);
    }

}
