package org.galatea.starter.service;

import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;
import com.github.tomakehurst.wiremock.junit.WireMockClassRule;
import java.util.ArrayList;
import java.util.HashMap;
import junitparams.JUnitParamsRunner;
import org.galatea.starter.ASpringTest;
import org.galatea.starter.domain.ExternalModel;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;


@SpringBootTest
@RunWith(JUnitParamsRunner.class)
public class AlphavantageClientTest extends ASpringTest {

  @ClassRule
  public static WireMockClassRule wiremock = new WireMockClassRule(options().port(9939).usingFilesUnderClasspath("wiremock"));

  @Autowired
  private AlphavantageClient alphavantageClient;

  private String stock;
  private String function;
  private String APIKEY;
  private ExternalModel response;

  @Before
  public void setUp() {
    stock = "DNKN";
    function = "TIME_SERIES_DAILY";
    APIKEY = "1C8399N4QUWX9Q0E";
    response = alphavantageClient.getInfo(function, stock, APIKEY, "compact");
  }

  @Test
  public void checkMetadata() {
    HashMap<String, String> metadata = response.getMetadata();

    assertEquals(metadata.get("1. Information"), "Daily Prices (open, high, low, close) and Volumes");
    assertEquals(metadata.get("2. Symbol"), "DNKN");
    assertEquals(metadata.get("3. Last Refreshed"), "2019-08-15 14:14:34");
    assertEquals(metadata.get("4. Output Size"), "Compact");
    assertEquals(metadata.get("5. Time Zone"), "US/Eastern");
  }

  @Test
  public void checkDateToPriceMapping() {
    HashMap<String, HashMap<String, String>> prices = response.getTimeSeries();
    HashMap<String, String> date = prices.get("2019-08-15");

    assertEquals(date.get("1. open"), "81.2500");
    assertEquals(date.get("2. high"), "83.3200");
    assertEquals(date.get("3. low"), "81.2500");
    assertEquals(date.get("4. close"), "82.5900");
    assertEquals(date.get("5. volume"), "653296");
  }



}
