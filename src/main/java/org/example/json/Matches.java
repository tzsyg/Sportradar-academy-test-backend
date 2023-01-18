package org.example.json;

import java.util.List;

//Class for mapping the Matches.

public class Matches {
    private String sport_event_id;
    private String start_date;
    private String sport_name;
    private String competition_name;
    private String competition_id;
    private String season_name;
    private List<Competitors> competitors;
    private Venue venue;
    private double probability_home_team_winner;
    private double probability_draw;
    private double probability_away_team_winner;

    public Matches(String sport_event_id, String start_date, String sport_name, String competition_name, String competition_id, String season_name, List<Competitors> competitors, Venue venue, double probability_home_team_winner, double probability_draw, double probability_away_team_winner) {
        this.sport_event_id = sport_event_id;
        this.start_date = start_date;
        this.sport_name = sport_name;
        this.competition_name = competition_name;
        this.competition_id = competition_id;
        this.season_name = season_name;
        this.competitors = competitors;
        this.venue = venue;
        this.probability_home_team_winner = probability_home_team_winner;
        this.probability_draw = probability_draw;
        this.probability_away_team_winner = probability_away_team_winner;
    }

    public String getSport_event_id() {
        return sport_event_id;
    }

    public void setSport_event_id(String sport_event_id) {
        this.sport_event_id = sport_event_id;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getSport_name() {
        return sport_name;
    }

    public void setSport_name(String sport_name) {
        this.sport_name = sport_name;
    }

    public String getCompetition_name() {
        return competition_name;
    }

    public void setCompetition_name(String competition_name) {
        this.competition_name = competition_name;
    }

    public String getCompetition_id() {
        return competition_id;
    }

    public void setCompetition_id(String competition_id) {
        this.competition_id = competition_id;
    }

    public String getSeason_name() {
        return season_name;
    }

    public void setSeason_name(String season_name) {
        this.season_name = season_name;
    }

    public List<Competitors> getCompetitors() {
        return competitors;
    }

    public void setCompetitors(List<Competitors> competitors) {
        this.competitors = competitors;
    }

    public Venue getVenue() {
        return venue;
    }

    public void setVenue(Venue venue) {
        this.venue = venue;
    }

    public double getProbability_home_team_winner() {
        return probability_home_team_winner;
    }

    public void setProbability_home_team_winner(double probability_home_team_winner) {
        this.probability_home_team_winner = probability_home_team_winner;
    }

    public double getProbability_draw() {
        return probability_draw;
    }

    public void setProbability_draw(double probability_draw) {
        this.probability_draw = probability_draw;
    }

    public double getProbability_away_team_winner() {
        return probability_away_team_winner;
    }

    public void setProbability_away_team_winner(double probability_away_team_winner) {
        this.probability_away_team_winner = probability_away_team_winner;
    }

    //Method for printing the competitors list the proper way.
    public String list_competitors_Print(){
        String string_comptetitors_List ="";
        int counter=0;
        for(Competitors x : competitors) {
            if(counter==1)
            {
                string_comptetitors_List+=" vs ";
            }
            string_comptetitors_List += x;
            counter++;
        }
        return string_comptetitors_List;
    }
    //Method for finding the highest probability result of the match and also for mapping the resoult to the TopTen map.
    public String map_highest_probability(){
        double home_team_winner = probability_home_team_winner;
        double draw = probability_draw;
        double away_team_winner = probability_away_team_winner;
        double largest;
        largest = away_team_winner > (home_team_winner > probability_draw ? home_team_winner :
                probability_draw) ? away_team_winner : ((home_team_winner > probability_draw) ? home_team_winner : probability_draw);

        if(largest == home_team_winner){
            TopTen.map.put("\n"+"Start date: " + start_date + "\n" +list_competitors_Print()+
                    "\n" + venue + "Highest probable result :HOME_TEAM_WIN ",home_team_winner);

            return "HOME_TEAM_WIN" + "("+home_team_winner+")";
        }
        else if(largest == draw){
            TopTen.map.put("\n"+"Start date: " + start_date + "\n" +list_competitors_Print()+
                    "\n" + venue + "Highest probable result :DRAW ",draw);

            return "DRAW" + "("+draw+")";
        }
        else{
            TopTen.map.put("\n"+"Start date: " + start_date + "\n" +list_competitors_Print()+
                    "\n" + venue + "Highest probable result :AWAY_TEAM_WIN ",away_team_winner);

            return "AWAY_TEAM_WIN" + "("+away_team_winner+")";
        }
    }


    @Override
    public String toString() {
        return
                "Start date: " + start_date + "\n" +list_competitors_Print()+
                        "\n" + venue + "Highest probable result :"+map_highest_probability()+ "\n"+"\n";
    }



}
