package iplLeague;

import csvFileBuilder.CSVBuilderException;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;


public class IPLleagueAnalysis {
    List<Batsmans> list = new ArrayList<>();
    HashMap <Sorting.sortingFields, Comparator> ComparatorMap = new HashMap<>();

    public int loadingData(String csvFilePath) throws IPLException, IOException, CSVBuilderException {
        list = DataLoader.loadIplRunCensusData(csvFilePath);
        return list.size();
    }

    public ArrayList getSortedFields(Sorting.sortingFields sortfields) {
        Comparator<Batsmans> comparator = new Sorting().getField(sortfields);
        ArrayList arrayList = (ArrayList) list.stream().sorted(comparator)
                .collect(Collectors.toList());
        System.out.println(arrayList);
        return arrayList;
    }
}


