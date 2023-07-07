package problemsolving.programmers.kakao.blind_recruitment_22;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 프로그래머스 Lv.1 / 92334 / 신고 결과 받기<br/>
 * <a href="https://school.programmers.co.kr/learn/courses/30/lessons/92334">문제 링크</a><br/>
 * solve: 27분
 */
public class Solution1 {

    public static final String SEPARATOR = " ";

    public int[] solution(String[] idList, String[] reports, int countReportForStop) {
        int[] mailCount = new int[idList.length];
        Map<String, Integer> reporterIdToIdx = new HashMap<>(idList.length);
        for (int i = 0; i < idList.length; i++) {
            reporterIdToIdx.put(idList[i], i);
        }
        Map<String, Set<String>> reportedToReporter = new HashMap<>(idList.length);

        for (String reportInfo : reports) {
            String[] reportInfoSplit = reportInfo.split(SEPARATOR);
            String reporterId = reportInfoSplit[0];
            String reportedId = reportInfoSplit[1];

            Set<String> reporters = reportedToReporter.getOrDefault(reportedId, new HashSet<>());
            reporters.add(reporterId);
            reportedToReporter.put(reportedId, reporters);
        }

        reportedToReporter.entrySet()
                .stream()
                .filter(stringListEntry -> stringListEntry.getValue().size() >= countReportForStop)
                .forEach(stringListEntry -> {
                    Set<String> reporterIds = stringListEntry.getValue();
                    for (String reporterId : reporterIds) {
                        Integer reporterIdIdx = reporterIdToIdx.get(reporterId);
                        mailCount[reporterIdIdx]++;
                    }
                });


        return mailCount;
    }

    public static void main(String[] args) {
        Solution1 sol = new Solution1();

//        sol.solution(new String[]{"muzi", "frodo", "apeach", "neo"}, new String[]{"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"}, 2);
        sol.solution(new String[]{"muzi", "frodo", "apeach", "neo"}, new String[]{"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"}, 2);
    }

}
