package iplLeague;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Sorting {
    public enum sortingFields{
        AVG_BATTING, STRIKING_RATE, SIXES_FOURS, SIXES_FOUR_STRIKES, GREATAVG_BESTSTRIKE
    }
    static Map<sortingFields, Comparator<Batsmans>> comparatorMap = new HashMap<>();

    public Comparator getField(Sorting.sortingFields sortField)
    {
        comparatorMap.put(sortingFields.AVG_BATTING,(Player1,Player2)-> (int) (Player2.avg-Player1.avg));
        comparatorMap.put(sortingFields.STRIKING_RATE,(Player1,Player2)-> (int) (Player2.strikeRate-Player1.strikeRate));
        comparatorMap.put(sortingFields.SIXES_FOURS,(Player1,Player2) -> new Integer((Player1.fours*4 + Player1.sixer*6) > (Player2.fours*4 + Player2.sixer*6) ? -1 : 1));
        comparatorMap.put(sortField.SIXES_FOUR_STRIKES, comparatorMap.get(sortingFields.SIXES_FOURS).thenComparing(comparatorMap.get(sortingFields.STRIKING_RATE)));
        comparatorMap.put(sortField.GREATAVG_BESTSTRIKE, comparatorMap.get(sortingFields.AVG_BATTING).thenComparing((Player1,Player2) -> Player1.strikeRate - Player2.strikeRate > 0 ? -1 :1));
        Comparator comparator=comparatorMap.get(sortField);
        return comparator;
    }
}
