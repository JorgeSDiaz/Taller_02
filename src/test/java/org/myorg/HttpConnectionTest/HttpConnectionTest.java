package org.myorg.HttpConnectionTest;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.myorg.server.http.HttpConnection;

public class HttpConnectionTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void Given_ApiKey_When_IsNull_Then_CreateCorrectlyConnection() {
        HttpConnection connectionWithoutApiKey = new HttpConnection("https://datausa.io/api/data");
        Assert.assertEquals("https://datausa.io/api/data", connectionWithoutApiKey.getUrl());
        Assert.assertEquals("", connectionWithoutApiKey.getApi_key());
    }

    @Test
    public void Given_ApiKey_When_NotIsNull_Then_CreateCorrectlyConnection() {
        HttpConnection connectionWithApiKey = new HttpConnection("https://www.omdbapi.com/", "&apikey=2701988f");
        Assert.assertEquals("https://www.omdbapi.com/", connectionWithApiKey.getUrl());
        Assert.assertEquals("&apikey=2701988f", connectionWithApiKey.getApi_key());
    }

    @After
    public void tearDown() throws Exception {
    }
}
