package org.galatea.starter.service;

import java.util.ArrayList;
import java.util.HashMap;
import org.galatea.starter.domain.ExternalModel;
import org.galatea.starter.domain.InternalModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;


@Service
public class AlphavantageService {

  private final String APIKEY = "1C8399N4QUWX9Q0E";
  private final String function = "TIME_SERIES_DAILY";
  private final String COMPACT = "compact";
  private final String FULL = "full";

  @Autowired
  AlphavantageClient alphavantageClient;


  public ArrayList<InternalModel> query(String stock, ArrayList<String> dates){
    if(dates.size() < 100) {
      return transform(alphavantageClient.getInfo(function, stock, APIKEY, COMPACT), dates, stock);
    }
    return transform(alphavantageClient.getInfo(function, stock, APIKEY, FULL), dates, stock);

  }

  private ArrayList<InternalModel> transform(ExternalModel queryResponse, ArrayList<String> dates, String stock){
    ArrayList<InternalModel> prices = new ArrayList<>();
    HashMap<String, HashMap<String, String>> externalData = queryResponse.getTimeSeries();
    for(String date: dates) {
      HashMap<String, String> curr = externalData.get(date);
      if(curr != null) {
        prices.add(convertToInternalModel(curr, date, stock));
      }
    }

    return prices;
  }

  private InternalModel convertToInternalModel(HashMap<String, String> priceMap, String date, String stock){
    String open = priceMap.get("1. open").toString().replaceAll("[^0-9.]", "");
    String high = priceMap.get("2. high").toString().replaceAll("[^0-9.]", "");
    String low = priceMap.get("3. low").toString().replaceAll("[^0-9.]", "");
    String close = priceMap.get("4. close").toString().replaceAll("[^0-9.]", "");
    String volume = priceMap.get("5. volume").toString().replaceAll("[^0-9.]", "");

    return new InternalModel(stock, date, Float.parseFloat(open), Float.parseFloat(high), Float.parseFloat(low),
        Float.parseFloat(close), Integer.parseInt(volume));

  }

}
