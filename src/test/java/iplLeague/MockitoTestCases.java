package iplLeague;

import CSVBuilder.CSVBuilderException;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.when;

public class MockitoTestCases {

    private  String MOSTRUNSFILE = "/home/bridgelabz/Desktop/IPLMatchAnalyser/src/test/resources/IPLMOSTRUNDATACSV.csv";

    @Mock
    MockingFactory  mockingFactory;

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @Test
    public void WhenGivenDataList_ShouldReturnDataInMockito() throws IOException, CSVBuilderException {
        try {
            Map<String,IPLLeagueDAO> cricketMap = new HashMap<>();
            IPLleagueAnalysis ipLleagueAnalysis = new IPLleagueAnalysis(IPLleagueAnalysis.Cricket.BATSMANS,mockingFactory);
            IPLLeagueDAO iplLeagueDAO = new IPLLeagueDAO();
            cricketMap.put("Virat Kohli", iplLeagueDAO);
            when(mockingFactory.getData(IPLleagueAnalysis.Cricket.BATSMANS, MOSTRUNSFILE)).thenReturn(cricketMap);
            int totalRecords = ipLleagueAnalysis.loadingData(MOSTRUNSFILE);
            System.out.printf( "total record: "+totalRecords);
            Assert.assertEquals(1, totalRecords);
        } catch (IPLException e) {

        }
    }
}
