package org.galatea.starter.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.ArrayList;

public class ResponseObject {

  private Metadata metadata;
  private ArrayList<InternalModel> prices;

  public void setMetadata(Metadata metadata) {
    this.metadata = metadata;
  }

  public void setPrices(ArrayList<InternalModel> prices) {
    this.prices = prices;
  }

  public Metadata getMetadata() {
    return metadata;
  }

  public ArrayList<InternalModel> getPrices() {
    return prices;
  }

  @JsonIgnore
  public int getResponseSize() {
    return prices.size();
  }

}
