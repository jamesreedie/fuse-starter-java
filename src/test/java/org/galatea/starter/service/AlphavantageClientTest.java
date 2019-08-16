package org.galatea.starter.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.HashMap;
import java.util.Iterator;
import org.galatea.starter.domain.ExternalModel;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AlphavantageClientTest {

  @Autowired
  AlphavantageClient alphavantageClient;



  private String stock;
  private String function;
  private String APIKEY;
  private ExternalModel testModel;

  @Before
  public void setUp() {
    stock = "DNKN";
    function = "TIME_SERIES_DAILY";
    APIKEY = "1C8399N4QUWX9Q0E";

  }

  @Test
  public void checkExternalModel() {

  }



}
