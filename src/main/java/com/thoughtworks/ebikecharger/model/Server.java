package com.thoughtworks.ebikecharger.model;

import java.util.List;

public class Server {

  private boolean electricityStatus = false;

  private String ridingUser = "";

  private final Object lock = new Object();

  public void receivePlugEvent(boolean plugIn) {
    electricityStatus = plugIn;
    if (plugIn) {
      System.out.println("[电动车]：进入充电状态");
    } else {
      System.out.println("[电动车]：解除充电状态");
    }
  }

  public void receiveEnergyKnots(List<Integer> energyKnots) {
    System.out.println("[电动车]当前的充电功率曲线为:" + energyKnots.toString());
  }

  public String checkBikeStatus() {
    StringBuilder res = new StringBuilder();
    if (electricityStatus) {
      res.append("电动车正在充电");
    } else {
      res.append("电动车未处于充电状态");
    }
    res.append(",");
    synchronized (lock) {
      if (ridingUser.length() == 0) {
        res.append("目前电动车处于闲置状态");
      } else {
        res.append(String.format("目前%s正在使用电动车", ridingUser));
      }
    }
    return res.toString();
  }

  public void receiveRidingUser(String username) {
    synchronized (lock) {
      this.ridingUser = username;
    }
  }

}
