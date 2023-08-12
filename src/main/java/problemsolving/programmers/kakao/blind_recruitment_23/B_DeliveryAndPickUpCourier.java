package problemsolving.programmers.kakao.blind_recruitment_23;

public class B_DeliveryAndPickUpCourier {

  /**
   * @param cap        트럭에 실을 수 있는 재활용 택배 상자의 최대 개수 (range: 1 <= cap <= 50)
   * @param n          배달할 집의 개수 (range: 1 <= n <= 100_000)
   * @param deliveries 각 집에 배달할 재활용 택배 상자의 개수 배열 (상자개수 range: 0 <= delivery <= 50)
   * @param pickups    집에서 수거할 빈 재활용 택배 상자의 개수 배열 (상자개수 range: 0 <= pickup <= 50)
   * @return 트럭 하나로 모든 배달과 수거를 마치고 물류창고까지 돌아올 수 있는 최소 이동 거리
   */
  public long solution(int cap, int n, int[] deliveries, int[] pickups) {
    long totalDistance = 0L;
    int nextDeliveryHouseNumber = getNextHouseNumber(deliveries, deliveries.length);
    int nextPickUpHouseNumber = getNextHouseNumber(pickups, pickups.length);

    while (nextDeliveryHouseNumber != 0 || nextPickUpHouseNumber != 0) {
      // 최대 이동 거리 계산
      totalDistance += 2L * Math.max(nextDeliveryHouseNumber, nextPickUpHouseNumber);

      // 배달
      nextDeliveryHouseNumber = move(deliveries, cap, nextDeliveryHouseNumber);

      // 수거
      nextPickUpHouseNumber = move(pickups, cap, nextPickUpHouseNumber);
    }

    return totalDistance;
  }

  private int move(int[] amounts, int currentCap, int nextHouseNumber) {
    while (currentCap != 0 && nextHouseNumber != 0) {
      int amount = Math.min(currentCap, amounts[nextHouseNumber - 1]);
      currentCap -= amount;
      amounts[nextHouseNumber - 1] -= amount;
      nextHouseNumber = getNextHouseNumber(amounts, nextHouseNumber);
    }
    return nextHouseNumber;
  }

  private int getNextHouseNumber(int[] amounts, int nextHouseNumber) {
    while (nextHouseNumber > 0 && amounts[nextHouseNumber - 1] == 0) {
      nextHouseNumber--;
    }
    return nextHouseNumber;
  }

  public static void main(String[] args) {
    long result = new B_DeliveryAndPickUpCourier().solution(2, 7, new int[]{1, 0, 2, 0, 1, 0, 2},
        new int[]{0, 2, 0, 1, 0, 2, 0});
    System.out.println(result);
  }

}
