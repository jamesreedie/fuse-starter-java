package org.galatea.starter.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import org.galatea.starter.domain.InternalModel;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.galatea.starter.service.AlphavantageService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AlphavantageServiceTest {

  private final String APIKEY = "1C8399N4QUWX9Q0E";
  private final String function = "TIME_SERIES_DAILY";
  private final String COMPACT = "compact";
  private final String FULL = "full";
  private final String stock = "DNKN";
  private final String date = "2019-08-12";
  private final ArrayList<String> dates = new ArrayList();

  @Autowired
  AlphavantageService alphavantageService;

  @Before
  public void setUp() {
    dates.add(date);
  }

  @Test
  public void checkQueryCompact() {

  }







}
