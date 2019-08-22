package org.galatea.starter.entrypoint;

import static java.time.temporal.ChronoUnit.MILLIS;

import java.time.Duration;
import java.time.LocalTime;
import org.galatea.starter.domain.Metadata;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import org.galatea.starter.domain.ResponseObject;
import org.galatea.starter.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PriceController extends BaseRestController {

  private final String APIKEY = "1C8399N4QUWX9Q0E";

  @Autowired
  PriceService svc;

  protected void processRequestId(final String requestId) {
    return;
  }
  /**
   * Receives and responds to requests for yahoo finance stock information.
   */

  @RequestMapping(value = "/prices", method = RequestMethod.GET)
  public ResponseObject hello(@RequestParam(value = "stock") final String stock,
      @RequestParam(value = "numDays") final int numDays) {
    LocalTime timeOfRequest = LocalTime.now();
    UriComponents url = ServletUriComponentsBuilder.fromCurrentRequest().build();

    Metadata metadata = new Metadata();
    metadata.setUrl(url.toString());
    metadata.setHostName(url.getHost());
    metadata.setTimeReceived(timeOfRequest.toString());

    ResponseObject response = svc.handleRequest(stock, numDays);

    LocalTime timeCompleted = LocalTime.now();
    metadata.setTimeCompleted(timeCompleted.toString());
    metadata.setResponseSize(response.getResponseSize());

    response.setMetadata(metadata);
    return response;

  }


}
