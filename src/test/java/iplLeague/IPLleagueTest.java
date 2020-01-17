package iplLeague;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class IPLleagueTest {
    private  String MOSTRUNSFILE = "/home/admin1/CricketLeagueProblem/src/test/resources/IPLMOSTRUNDATACSV.csv";
    @Test
    public void givenMostRunFile_ShouldReturnCorrectData() throws IOException, IPLException {
        IPLleagueAnalysis ipLleagueAnalysis = new IPLleagueAnalysis();
        int totalRecords = ipLleagueAnalysis.loadIplRunCensusData(MOSTRUNSFILE);
        Assert.assertEquals(101,totalRecords);
    }
}
