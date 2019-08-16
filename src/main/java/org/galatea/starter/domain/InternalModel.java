package org.galatea.starter.domain;

public class InternalModel {

  private String stock;
  private String date;
  private float open;
  private float high;
  private float low;
  private float close;
  private int volume;

  public InternalModel(String stock, String date, float open, float high, float low, float close, int volume) {
    this.stock = stock;
    this.date = date;
    this.open = open;
    this.high = high;
    this.low = low;
    this.close = close;
    this.volume = volume;
  }

  public void setStock(String stock) {
    this.stock = stock;
  }

  public void setDate(String date){
    this.date = date;
  }

  public void setOpen(float open) {
    this.open = open;
  }

  public void setHigh(float high) {
    this.high = high;
  }

  public void setLow(float low ){
    this.low = low;
  }

  public void setClose(float close) {
    this.close = close;
  }

  public void setVolume(int volume) {
    this.volume=volume;
  }

  public String getStock() {
    return stock;
  }

  public String getDate() {
    return date;
  }

  public float getOpen() {
    return open;
  }

  public float getHigh() {
    return high;
  }

  public float getLow() {
    return low;
  }

  public float getClose() {
    return close;
  }

  public int getVolume() {
    return volume;
  }

  public boolean equals(InternalModel other){
    if(!stock.equals(other.getStock())){
      return false;
    } else if(!date.equals(other.getDate())) {
      return false;
    } else if(open != other.getOpen()) {
      return false;
    } else if(high != other.getHigh()) {
      return false;
    } else if(low != other.getLow()) {
      return false;
    } else if(close != other.getClose()) {
      return false;
    } else if(volume != other.getVolume()) {
      return false;
    } else {
      return true;
    }
  }
}
