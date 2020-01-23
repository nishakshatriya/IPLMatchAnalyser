package iplLeague;

import com.opencsv.bean.CsvBindByName;

public class Bowlers {

    @CsvBindByName(column = "POS", required = true)
    public int position;

    @CsvBindByName(column = "PLAYER", required = true)
    public String player;

    @CsvBindByName(column = "Mat", required = true)
    public int match;

    @CsvBindByName(column = "Inns", required = true)
    public int innings;

    @CsvBindByName(column = "Ov", required = true)
    public double overs;

    @CsvBindByName(column = "Runs", required = true)
    public int runs;

    @CsvBindByName(column = "Wkts", required = true)
    public int wickets;


    @CsvBindByName(column = "BBI", required = true)
    public int best_balling_index;

    @CsvBindByName(column = "Avg", required = true)
    public double avg;

    @CsvBindByName(column = "Econ", required = true)
    public double Economy;

    @CsvBindByName(column = "SR", required = true)
    public double sr;

    @CsvBindByName(column = "4w", required = true)
    public int four_wkts;

    @CsvBindByName(column = "5w", required = true)
    public int five_wkts;

    @Override
    public String toString() {
        return "Bowlers{" +
                "position=" + position +
                ", player='" + player + '\'' +
                ", match=" + match +
                ", innings=" + innings +
                ", overs=" + overs +
                ", runs=" + runs +
                ", wickets=" + wickets +
                ", best_balling_index=" + best_balling_index +
                ", avg=" + avg +
                ", Economy=" + Economy +
                ", strikeRate=" + sr +
                ", four_wkts=" + four_wkts +
                ", five_wkts='" + five_wkts + '\'' +
                '}';
    }
}
