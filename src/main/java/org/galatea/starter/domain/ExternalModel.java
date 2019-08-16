package org.galatea.starter.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.HashMap;

public class ExternalModel {

  @JsonProperty("Meta Data")
  private HashMap<String, String> metadata;

  @JsonProperty("Time Series (Daily)")
  private HashMap<String, HashMap<String, String>> timeSeries;

  public void setMetadata(HashMap<String, String> metadata) {
    this.metadata = metadata;
  }

  public void setTimeSeries(HashMap<String, HashMap<String,String>> timeSeries) {
    this.timeSeries = timeSeries;
  }

  public HashMap<String, String> getMetadata() {
    return metadata;
  }

  public HashMap<String, HashMap<String,String>> getTimeSeries() {
    return timeSeries;
  }
}
