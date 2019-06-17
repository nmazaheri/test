package interview.healthChecker;

import java.util.HashMap;
import java.util.Map;

public class VisitCounter {

    Map<Long, Long> count(Map<String, UserStats>... visits) {
        Map<Long, Long> result = new HashMap<>();
        if (visits == null) {
            return result;
        }

        for (Map<String, UserStats> visit : visits) {
            if (visit == null) {
                continue;
            }
            for (Map.Entry<String, UserStats> entry : visit.entrySet()) {
                try {
                    UserStats userStats = entry.getValue();
                    if (userStats == null || !userStats.getVisitCount().isPresent()) {
                        continue;
                    }
                    Long newVisitCount = userStats.getVisitCount().get();
                    long userId = Long.parseLong(entry.getKey());

                    result.putIfAbsent(userId, 0L);
                    Long previousVisits = result.get(userId);
                    result.put(userId, previousVisits + newVisitCount);
                } catch (NumberFormatException e) {
                    // invalid key
                }
            }
        }
        return result;
    }
}
