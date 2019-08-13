package org.galatea.starter.entrypoint;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PriceController extends BaseRestController {

  protected void processRequestId(final String requestId) {
    return;
  }
  /**
   * Receives and responds to requests for yahoo finance stock information.
   */

  @RequestMapping("/prices")
  public String hello(@RequestParam(value = "stock") final String stock,
      @RequestParam(value = "numDays") final String numDays) {
    return stock + ", " + numDays + "\t";
  }

}
