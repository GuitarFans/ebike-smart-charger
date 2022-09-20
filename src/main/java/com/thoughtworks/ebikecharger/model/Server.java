package com.thoughtworks.ebikecharger.model;

import java.util.List;

public class Server {

    private boolean electricityStatus = false;

    private String ridingUser = "";

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

    public void receiveUserInfo(String username) {
        this.ridingUser = username;
    }

    public String checkBikeStatus() {
        if (electricityStatus) {
            return "电动车正在充电";
        }
        return "电动车未处于充电状态";
    }

    public String getRidingUser() {
        return ridingUser;
    }
}
