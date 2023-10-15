package com.plinio.circuitbreaker.clients;

import com.plinio.circuitbreaker.entities.Developer;
import com.plinio.circuitbreaker.controllers.v1.GetDevelopersParams;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;

@FeignClient(name = "developers", url = "http://localhost:9090")
public interface DevelopersClient {
    @RequestMapping(method = RequestMethod.GET, value = "/pessoas")
    ArrayList<Developer> getDevelopers(@SpringQueryMap GetDevelopersParams developerParams);
}
