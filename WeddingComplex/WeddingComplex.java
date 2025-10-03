import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class WeddingComplex {
    public static Map<String, String> createBestCouple(Map<String, List<String>> first, Map<String, List<String>> second) {
        Map<String, String> couples = new HashMap<>();
        Map<String, String> engaged = new HashMap<>();
        Map<String, Integer> proposalIndex = new HashMap<>();

        for (String person : first.keySet()){
            proposalIndex.put(person, 0);
        }

        Queue<String> free = new LinkedList<>(first.keySet());

        while (!free.isEmpty()) {
            String proposer = free.poll();
            List<String> preferences = first.get(proposer);
            int idx = proposalIndex.get(proposer);

            if (idx >= preferences.size()) {
                continue;
            }

            String chosen = preferences.get(idx);
            proposalIndex.put(proposer, idx+1);

            if (!engaged.containsKey(chosen)){
                couples.put(proposer, chosen);
                engaged.put(chosen, proposer);
            }else {
                String currentPartner = engaged.get(chosen);
                List<String> chosenPrefs = second.get(chosen);

                if (chosenPrefs.indexOf(proposer) < chosenPrefs.indexOf(currentPartner)) {
                    couples.remove(currentPartner);
                    couples.put(proposer, chosen);
                    engaged.put(chosen, proposer);

                    free.add(currentPartner);
                }else {
                    free.add(proposer);
                }
            }
        }
        return couples;

    }
}