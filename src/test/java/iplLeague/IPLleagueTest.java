package iplLeague;

import csvFileBuilder.CSVBuilderException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.IOException;
import java.util.List;

public class IPLleagueTest {
    private  String MOSTRUNSFILE = "/home/admin1/CricketLeagueProblem/src/test/resources/IPLMOSTRUNDATACSV.csv";
    private String WRONG_RUN_PATH = "./src/main/resources/IndiaStateCensusData.csv";
    @Test
    public void givenMostRunFile_ShouldReturnCorrectData() throws IOException, IPLException, CSVBuilderException {
        IPLleagueAnalysis ipLleagueAnalysis = new IPLleagueAnalysis();
        int totalRecords = ipLleagueAnalysis.loadIplRunCensusData(MOSTRUNSFILE);
        Assert.assertEquals(101,totalRecords);
    }

    @Test
    public void givenMostRunFile_ShouldReturnTopRunAverage() throws IPLException, IOException, CSVBuilderException {
        IPLleagueAnalysis ipLleagueAnalysis = new IPLleagueAnalysis();
        ipLleagueAnalysis.loadIplRunCensusData(MOSTRUNSFILE);
        List<IPLleagueAnalysisCSV> sortedCensusData = ipLleagueAnalysis.sortingPlayersDataInReverse();
        Assert.assertEquals(83.2,sortedCensusData.get(0).avg,0);
    }

    @Test
    public void givenIncorrectRunsFile_ShouldThroughException() throws IPLException, IOException, CSVBuilderException {
        IPLleagueAnalysis ipLleagueAnalysis = new IPLleagueAnalysis();
        ExpectedException exception = ExpectedException.none();
        exception.expect(IPLException.class);
        ipLleagueAnalysis.loadIplRunCensusData(WRONG_RUN_PATH);
    }

    @Test
    public void givenMostRunFile_ShouldReturnTopStriker() throws IPLException, IOException, CSVBuilderException {
        IPLleagueAnalysis ipLleagueAnalysis = new IPLleagueAnalysis();
        ipLleagueAnalysis.loadIplRunCensusData(MOSTRUNSFILE);
        List<IPLleagueAnalysisCSV> sortedCensusData = ipLleagueAnalysis.sortingPlayersForStriker();
        System.out.println(sortedCensusData);
        Assert.assertEquals(333.33,sortedCensusData.get(0).strikeRate,0);
    }
}
