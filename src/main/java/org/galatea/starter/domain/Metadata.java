package org.galatea.starter.domain;

public class Metadata {

  private String url;
  private String timeReceived;
  private String timeCompleted;
  private String hostName;
  private int responseSize;

  public void setUrl(String url) {
    this.url = url;
  }

  public void setTimeReceived(String time) {
    timeReceived = time;
  }

  public void setTimeCompleted(String time) {
    timeCompleted = time;
  }

  public void setHostName(String hostName) {
    this.hostName = hostName;
  }

  public void setResponseSize(int size) {
    responseSize = size;
  }

  public String getUrl() {
    return url;
  }

  public String getTimeReceived() {
    return timeReceived;
  }

  public String getTimeCompleted() {
    return timeCompleted;
  }

  public String getHostName() {
    return hostName;
  }

  public int getResponseSize() {
    return responseSize;
  }

}
