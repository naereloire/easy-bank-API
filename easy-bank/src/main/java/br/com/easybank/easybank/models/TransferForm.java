package br.com.easybank.easybank.models;

public class TransferForm {
    private long originId;
    private long destinyId;
    private double money;

    public long getOriginId() {
        return originId;
    }

    public void setOriginId(long originId) {
        this.originId = originId;
    }

    public long getDestinyId() {
        return destinyId;
    }

    public void setDestinyId(long destinyId) {
        this.destinyId = destinyId;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }
}
