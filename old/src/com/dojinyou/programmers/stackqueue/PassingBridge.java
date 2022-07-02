import java.util.ArrayDeque;

// 프로그래머스 : 코딩테스트 > 스택/큐 > 다리를 지나는 트럭
// 관련 링크 : https://programmers.co.kr/learn/courses/30/lessons/42583

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        ArrayDeque<Truck> waitingTrucks = new ArrayDeque<>();
        for (int truck_weight : truck_weights) {
            waitingTrucks.add(new Truck(truck_weight));
        }

        Bridge bridge = new Bridge(bridge_length, weight);
        int now = 0;
        for (Truck truck : waitingTrucks) {
            while (true) {
                now++;
                if (bridge.offBridge(now)) {
                    bridge.removeTruck();
                }
                if (bridge.onBridge(now, truck)) {
                    truck.onBridge(now, bridge.getLength());
                    bridge.addTruck(truck);
                    break;
                }
            }
        }
        return bridge.getResult();
    }
}
class Truck {
    private final int WEIGHT;
    private int onBridgeTime;
    private int offBridgeTime;

    Truck(int weight) {
        this.WEIGHT = weight;
        this.onBridgeTime = -1;
        this.offBridgeTime = -1;
    }

    public int getWeight() {return this.WEIGHT;}
    public int getOffBridgeTime() {return this.offBridgeTime;}
    public void onBridge(int now, int bridgeLength) {
        this.onBridgeTime = now;
        this.offBridgeTime = now + bridgeLength;
    }
}

class Bridge {
    private final int MAXWEIGHT;
    private final int LENGTH;

    private ArrayDeque<Truck> onBridgeTrucks;
    private int weight;

    Bridge(int length, int weight) {
        this.LENGTH = length;
        this.MAXWEIGHT = weight;
        this.onBridgeTrucks = new ArrayDeque<>();
        this.weight = 0;
    }
    public int getLength() {return this.LENGTH;}
    public int getMaxWeight() {return this.MAXWEIGHT;}
    public int getOnBridgeTrucks() {return this.onBridgeTrucks.size();}

    public boolean onBridge(int now, Truck truck) {
        if (this.onBridgeTrucks.size() != 0 && truck.getWeight() + this.weight > this.MAXWEIGHT) {
            return false;
        }
        return true;
    }

    public boolean offBridge(int now) {
        if (this.onBridgeTrucks.size() != 0 && this.onBridgeTrucks.peek().getOffBridgeTime() == now) {
            return true;
        }
        return false;
    }

    public void addTruck(Truck truck) {
        this.onBridgeTrucks.add(truck);
        this.weight += truck.getWeight();
    }

    public void removeTruck() {
        this.weight -= this.onBridgeTrucks.peek().getWeight();
        this.onBridgeTrucks.pop();
    }

    public int getResult() {
        return this.onBridgeTrucks.peekLast().getOffBridgeTime();
    }
}