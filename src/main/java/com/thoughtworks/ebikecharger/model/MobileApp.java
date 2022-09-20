package com.thoughtworks.ebikecharger.model;

public record MobileApp(String username) {

  public void checkBike(Server server) {
    String threadName = Thread.currentThread().getName();
    System.out.printf("[%s]%s正在检查电动车状态：%s\n", threadName, username, server.checkBikeStatus());
    if (server.getRidingUser().length() == 0) {
      System.out.println("目前电动车处于闲置状态");
    } else {
      System.out.printf("目前%s正在使用电动车\n", server.getRidingUser());
    }
  }

}
