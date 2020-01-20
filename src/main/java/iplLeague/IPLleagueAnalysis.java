package iplLeague;

import csvFileBuilder.CSVBuilderException;
import csvFileBuilder.CSVBuilderFactory;
import csvFileBuilder.ICSVBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;


public class IPLleagueAnalysis {

    List<Batsmans> list = new ArrayList<>();

    public List<Batsmans> loadIplRunCensusData(String csvFilePath) throws IPLException, IOException, CSVBuilderException {

        try (Reader reader = Files.newBufferedReader(Paths.get(csvFilePath))) {
            ICSVBuilder icsvBuilder = CSVBuilderFactory.CreateCSVBuilder();
            List playersList = icsvBuilder.getCSVInList(reader, Batsmans.class);
            playersList.stream().filter(CensusData -> list.add((Batsmans) CensusData)).collect(Collectors.toList());
            return playersList;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (CSVBuilderException e) {
            throw new IPLException(e.getMessage(), e.type.name());
        }
        return null;
    }

    public ArrayList getSortedFields(Sorting.sortingFields sortfields) {
        Comparator<Batsmans> comparator = new Sorting().getField(sortfields);
        ArrayList arrayList = (ArrayList) list.stream().sorted(comparator)
                .collect(Collectors.toList());
        return arrayList;
    }
}


