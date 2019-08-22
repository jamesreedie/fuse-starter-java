package org.galatea.starter.service;

import java.util.List;
import java.util.Map;
import org.galatea.starter.domain.ExternalModel;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import springfox.documentation.spring.web.json.Json;

@FeignClient(name="Alphavantage", url="${spring.rest.alphavantageBasePath}")
public interface AlphavantageClient {

  @GetMapping("/query")
  ExternalModel getInfo(@RequestParam("function") final String function, @RequestParam("symbol") final String symbol,
      @RequestParam("apikey") final String apikey, @RequestParam("outputsize") final String outputsize);

}
