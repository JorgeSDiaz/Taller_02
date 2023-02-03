package org.myorg.HttpConnectionTest;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.myorg.http.HttpConnection;

import java.io.IOException;

public class GetDataTest {
    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void Given_Parameters_When_AreCorrectly_Then_MakeQuery() throws IOException {
        // Test Connections
        HttpConnection connectionMoviesTest = new HttpConnection("https://www.omdbapi.com/",
                "apikey=2701988f");
        HttpConnection connectionUsaDataTest = new HttpConnection("https://datausa.io/api/data");

        // Results
        String resultMovies = connectionMoviesTest.getData("?t=indiana");
        String resultUsaData = connectionUsaDataTest.getData("?drilldowns=Nation&measures=Population");

        // Asserts
//        Assert.assertEquals("{\"Title\":\"Indiana Jones and the Raiders of the Lost Ark\",\"Year\":\"1981\",\"Rated\":\"PG\",\"Released\":\"12 Jun 1981\",\"Runtime\":\"115 min\",\"Genre\":\"Action, Adventure\",\"Director\":\"Steven Spielberg\",\"Writer\":\"Lawrence Kasdan, George Lucas, Philip Kaufman\",\"Actors\":\"Harrison Ford, Karen Allen, Paul Freeman\",\"Plot\":\"Archaeology professor Indiana Jones ventures to seize a biblical artefact known as the Ark of the Covenant. While doing so, he puts up a fight against Renee and a troop of Nazis.\",\"Language\":\"English, German, Hebrew, Spanish, Arabic, Nepali\",\"Country\":\"United States\",\"Awards\":\"Won 4 Oscars. 38 wins & 24 nominations total\",\"Poster\":\"https://m.media-amazon.com/images/M/MV5BNTU2ODkyY2MtMjU1NC00NjE1LWEzYjgtMWQ3MzRhMTE0NDc0XkEyXkFqcGdeQXVyMjM4MzQ4OTQ@._V1_SX300.jpg\",\"Ratings\":[{\"Source\":\"Internet Movie Database\",\"Value\":\"8.4/10\"},{\"Source\":\"Rotten Tomatoes\",\"Value\":\"96%\"},{\"Source\":\"Metacritic\",\"Value\":\"85/100\"}],\"Metascore\":\"85\",\"imdbRating\":\"8.4\",\"imdbVotes\":\"972,272\",\"imdbID\":\"tt0082971\",\"Type\":\"movie\",\"DVD\":\"13 May 2008\",\"BoxOffice\":\"$248,159,971\",\"Production\":\"N/A\",\"Website\":\"N/A\",\"Response\":\"True\"}",
//                resultMovies
//        );
        Assert.assertEquals("{\"data\":[{\"ID Nation\":\"01000US\",\"Nation\":\"United States\",\"ID Year\":2020,\"Year\":\"2020\",\"Population\":326569308,\"Slug Nation\":\"united-states\"},{\"ID Nation\":\"01000US\",\"Nation\":\"United States\",\"ID Year\":2019,\"Year\":\"2019\",\"Population\":324697795,\"Slug Nation\":\"united-states\"},{\"ID Nation\":\"01000US\",\"Nation\":\"United States\",\"ID Year\":2018,\"Year\":\"2018\",\"Population\":322903030,\"Slug Nation\":\"united-states\"},{\"ID Nation\":\"01000US\",\"Nation\":\"United States\",\"ID Year\":2017,\"Year\":\"2017\",\"Population\":321004407,\"Slug Nation\":\"united-states\"},{\"ID Nation\":\"01000US\",\"Nation\":\"United States\",\"ID Year\":2016,\"Year\":\"2016\",\"Population\":318558162,\"Slug Nation\":\"united-states\"},{\"ID Nation\":\"01000US\",\"Nation\":\"United States\",\"ID Year\":2015,\"Year\":\"2015\",\"Population\":316515021,\"Slug Nation\":\"united-states\"},{\"ID Nation\":\"01000US\",\"Nation\":\"United States\",\"ID Year\":2014,\"Year\":\"2014\",\"Population\":314107084,\"Slug Nation\":\"united-states\"},{\"ID Nation\":\"01000US\",\"Nation\":\"United States\",\"ID Year\":2013,\"Year\":\"2013\",\"Population\":311536594,\"Slug Nation\":\"united-states\"}],\"source\":[{\"measures\":[\"Population\"],\"annotations\":{\"source_name\":\"Census Bureau\",\"source_description\":\"The American Community Survey (ACS) is conducted by the US Census and sent to a portion of the population every year.\",\"dataset_name\":\"ACS 5-year Estimate\",\"dataset_link\":\"http://www.census.gov/programs-surveys/acs/\",\"table_id\":\"B01003\",\"topic\":\"Diversity\",\"subtopic\":\"Demographics\"},\"name\":\"acs_yg_total_population_5\",\"substitutions\":[]}]}",
                resultUsaData);
    }

    @After
    public void tearDown() throws Exception {
    }
}