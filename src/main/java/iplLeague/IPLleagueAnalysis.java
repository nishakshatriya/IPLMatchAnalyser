package iplLeague;

import csvFileBuilder.CSVBuilderException;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;


public class IPLleagueAnalysis {
    List<IPLLeagueDAO> list = new ArrayList<>();
    List<IPLLeagueDAO> bowlerList = new ArrayList<>();
    HashMap <Sorting.sortingFields, Comparator> ComparatorMap = new HashMap<>();

    public int loadingData(String csvFilePath) throws IPLException, IOException, CSVBuilderException {
        list = DataLoader.loadIplRunCensusData(csvFilePath);
        return list.size();
    }

    public int loadingBowlersData(String csvFilePath) throws IPLException, IOException, CSVBuilderException {
        bowlerList = DataLoader.loadIplBowlCensusData(csvFilePath);
        return bowlerList.size();
    }

    public ArrayList getSortedFields(Sorting.sortingFields sortfields) {
        Comparator<IPLLeagueDAO> comparator = new Sorting().getField(sortfields);
        ArrayList arrayList = (ArrayList) list.stream().sorted(comparator)
                .collect(Collectors.toList());
        return arrayList;
    }
    public ArrayList getBowlingSortedData(Sorting.sortingFields sortingFields) {
        Comparator<IPLLeagueDAO> comparator = new Sorting().getField(sortingFields);
        ArrayList arrayList = (ArrayList) bowlerList.stream().sorted(comparator)
                .collect(Collectors.toList());
        return arrayList;
    }
}


