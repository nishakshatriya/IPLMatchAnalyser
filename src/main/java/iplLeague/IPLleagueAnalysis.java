package iplLeague;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.stream.StreamSupport;


public class IPLleagueAnalysis {

    public int loadIplRunCensusData(String csvFilePath) throws IPLException, IOException {

      try (Reader reader = Files.newBufferedReader(Paths.get(csvFilePath))) {
            CsvToBeanBuilder<IPLleagueAnalysisCSV> csvToBeanBuilder = new CsvToBeanBuilder<>(reader);
            csvToBeanBuilder.withType(IPLleagueAnalysisCSV.class);
            csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
            CsvToBean<IPLleagueAnalysisCSV> csvToBean = csvToBeanBuilder.build();
            Iterator<IPLleagueAnalysisCSV> ipLleagueAnalysisCSVIterator = csvToBean.iterator();
          Iterable<IPLleagueAnalysisCSV> csvIterable=() -> ipLleagueAnalysisCSVIterator;
          int numOfPlayers= (int) StreamSupport.stream(csvIterable.spliterator(),false).count();
          return numOfPlayers;
        } catch (IOException e) {
            throw new IPLException(e.getMessage(), IPLException.ExceptionType.FILE_NOT_FOUND);
        }
    }
}

