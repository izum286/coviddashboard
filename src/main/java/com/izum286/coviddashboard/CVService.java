package com.izum286.coviddashboard;



import com.example.Timeline;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "corona-api", url = "https://corona-api.com/")
public interface  CVService {
    @RequestMapping(value = "/timeline")
    Timeline timeline();
}
