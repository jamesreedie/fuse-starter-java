package org.galatea.starter.service;

import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


import com.github.tomakehurst.wiremock.junit.WireMockClassRule;
import java.util.ArrayList;
import junitparams.JUnitParamsRunner;
import org.galatea.starter.ASpringTest;
import org.galatea.starter.domain.InternalModel;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ActiveProfiles;

import org.springframework.test.context.junit4.SpringRunner;
import org.galatea.starter.service.AlphavantageService;

@SpringBootTest
@RunWith(JUnitParamsRunner.class)
public class AlphavantageServiceTest extends ASpringTest {



  @ClassRule
  public static WireMockClassRule wiremock = new WireMockClassRule(options().port(9939).usingFilesUnderClasspath("wiremock"));



  @Autowired
  AlphavantageService alphavantageService;

  private final String APIKEY = "1C8399N4QUWX9Q0E";
  private final String function = "TIME_SERIES_DAILY";
  private final String COMPACT = "compact";
  private final String FULL = "full";
  private final String stock = "DNKN";
  private final String date = "2019-08-12";

  private InternalModel August12th;
  private ArrayList<String> dates = new ArrayList();
  private ArrayList<InternalModel> response;





  @Before
  public void setUp() {
    dates.add(date);
    August12th = new InternalModel(stock, date, (float)81.75, (float)81.84, (float)79.56, (float)79.88,688800);

  }


  @Test
  public void checkQueryCompact() {
    response = alphavantageService.query(stock, dates);
    assertTrue(response.get(0).equals(August12th));
  }







}
