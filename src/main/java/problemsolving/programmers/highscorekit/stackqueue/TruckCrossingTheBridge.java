package problemsolving.programmers.highscorekit.stackqueue;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class TruckCrossingTheBridge {
  public int solution(int bridgeLength, int weight, int[] truckWeights) {
    Queue<Truck> truckList = initTruckList(truckWeights);
    final Bridge bridge = new Bridge(weight, bridgeLength);
    BridgeManager bridgeManager = new BridgeManager(bridge);

    return bridgeManager.manage(truckList);
  }

  private Queue<Truck> initTruckList(int[] truckWeights) {
    Queue<Truck> truckList = new ArrayDeque<>();

    for (int truckWeight : truckWeights) {
      truckList.add(new Truck(truckWeight));
    }

    return truckList;
  }

  private class Bridge {
    private final int maxWeight;
    private final int length;

    private int currentWeight = 0;

    private final Queue<Truck> bridgeQueue = new LinkedList<>();

    private Bridge(int maxWeight, int length) {
      this.maxWeight = maxWeight;
      this.length = length;

      initBridge();
    }

    private void initBridge() {
      for (int i = 0; i < length; i++) {
        bridgeQueue.add(null);
      }
    }

    public Truck out() {
      Truck outTruck = bridgeQueue.poll();
      if (outTruck != null) {
        currentWeight -= outTruck.weight;
      }
      return outTruck;
    }

    public void in(Truck truck) {
      bridgeQueue.add(truck);
      if (truck != null) {
        currentWeight += truck.weight;
      }
    }

    public boolean isEmpty() {
      return bridgeQueue.isEmpty();
    }
  }

  private class Truck {
    private final int weight;

    private Truck(int weight) {
      this.weight = weight;
    }
  }

  private class BridgeManager {
    private final Bridge bridge;

    private BridgeManager(Bridge bridge) {
      this.bridge = bridge;
    }

    public int manage(Queue<Truck> truckList) {
      int duration = 0;

      while (!truckList.isEmpty()) {
        bridge.out();
        bridge.in(isEnter(truckList.peek()) ? truckList.poll() : null);
        duration++;
      }

      while (!bridge.isEmpty()) {
        bridge.out();
        duration++;
      }

      return duration;
    }

    private boolean isEnter(Truck truck) {
      return bridge.currentWeight + truck.weight <= bridge.maxWeight;
    }
  }
}
