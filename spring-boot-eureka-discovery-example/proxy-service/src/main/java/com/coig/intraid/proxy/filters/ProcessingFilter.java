package com.coig.intraid.proxy.filters;

import com.coig.intraid.proxy.dto.JwtRequestDto;
import com.coig.intraid.proxy.dto.UnauthorizedResponseDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;


@Slf4j
public class ProcessingFilter extends ZuulFilter {

    private static final String contentType = "application/json";
    private static final String invalidAccessMessage = "Invalid access!";

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();

        if(!authorize(ctx.getRequest().getHeader("X-Auth-Token"), ctx.getRequest().getRequestURL().toString())){
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());

            try {
                ctx.setResponseBody(new ObjectMapper().writeValueAsString(new UnauthorizedResponseDto(false, invalidAccessMessage)));
            } catch (JsonProcessingException e) {
                ctx.setResponseBody(invalidAccessMessage);
            }

            ctx.getResponse().setContentType(contentType);
        }

        log.info(String.format("%s request to %s", ctx.getRequest().getMethod(), ctx.getRequest().getRequestURL().toString()));
        return null;
    }

    private boolean authorize(String jwt, String path) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<JwtRequestDto> request = new HttpEntity<>(new JwtRequestDto(jwt, path), headers);
        try {
            Boolean result = restTemplate.postForObject("http://auth-service/validate/jwt", request, Boolean.class);
            return result != null && result;
        } catch (HttpClientErrorException e) {
            return false;
        }
    }
}
