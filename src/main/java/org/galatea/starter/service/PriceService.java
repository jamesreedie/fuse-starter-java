package org.galatea.starter.service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import org.galatea.starter.domain.InternalModel;
import org.galatea.starter.domain.ResponseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PriceService {

  @Autowired
  AlphavantageService AlphavantageService;

  public ResponseObject handleRequest(String stock, int numDays){
    ResponseObject response = new ResponseObject();

    ArrayList<String> dates = getDates(numDays);
    ArrayList<InternalModel> prices = AlphavantageService.query(stock, dates);
    response.setPrices(prices);

    return response;
  }

  private ArrayList<String> getDates(int numDays) {
    ArrayList<String> dates = new ArrayList();
    LocalDate curr = LocalDate.now().minusDays(1);
    for(int i = 0; i < numDays; i++){
      while(isWeekend(curr)){
        curr = curr.minusDays(1);
      }
      dates.add(curr.toString());
      curr = curr.minusDays(1);
    }
    return dates;
  }

  private boolean isWeekend(LocalDate date) {
    if(date.getDayOfWeek() == DayOfWeek.SATURDAY || date.getDayOfWeek() == DayOfWeek.SUNDAY){
      return true;
    }
    return false;
  }

}
