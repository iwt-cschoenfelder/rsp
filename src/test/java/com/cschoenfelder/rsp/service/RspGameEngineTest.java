package com.cschoenfelder.rsp.service;

import com.cschoenfelder.rsp.resource.RspResult;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class RspGameEngineTest {

    private RspGameEngine classUnderTest;


    @BeforeEach
    public void setUp() {
        classUnderTest = new RspGameEngine();
    }

    // ROCK

    @Test
    public void testDetermineRspResult_ROCK_LOST() {
        RspResult result = classUnderTest.determineRspResult(Choice.ROCK, Choice.PAPER);
        assertThat(result.getUserGameResult(), is(GameResult.LOST));
    }

    @Test
    public void testDetermineRspResult_ROCK_DRAW() {
        RspResult result = classUnderTest.determineRspResult(Choice.ROCK, Choice.ROCK);
        assertThat(result.getUserGameResult(), is(GameResult.DRAW));
    }

    @Test
    public void testDetermineRspResult_ROCK_WON() {
        RspResult result = classUnderTest.determineRspResult(Choice.ROCK, Choice.SCISSOR);
        assertThat(result.getUserGameResult(), is(GameResult.WON));
    }

    // SCISSOR

    @Test
    public void testDetermineRspResult_SCISSOR_LOST() {
        RspResult result = classUnderTest.determineRspResult(Choice.SCISSOR, Choice.ROCK);
        assertThat(result.getUserGameResult(), is(GameResult.LOST));
    }

    @Test
    public void testDetermineRspResult_SCISSOR_DRAW() {
        RspResult result = classUnderTest.determineRspResult(Choice.SCISSOR, Choice.SCISSOR);
        assertThat(result.getUserGameResult(), is(GameResult.DRAW));
    }

    @Test
    public void testDetermineRspResult_SCISSOR_WON() {
        RspResult result = classUnderTest.determineRspResult(Choice.SCISSOR, Choice.PAPER);
        assertThat(result.getUserGameResult(), is(GameResult.WON));
    }

    // PAPER

    @Test
    public void testDetermineRspResult_PAPER_LOST() {
        RspResult result = classUnderTest.determineRspResult(Choice.PAPER, Choice.SCISSOR);
        assertThat(result.getUserGameResult(), is(GameResult.LOST));
    }

    @Test
    public void testDetermineRspResult_PAPER_DRAW() {
        RspResult result = classUnderTest.determineRspResult(Choice.PAPER, Choice.PAPER);
        assertThat(result.getUserGameResult(), is(GameResult.DRAW));
    }

    @Test
    public void testDetermineRspResult_PAPER_WON() {
        RspResult result = classUnderTest.determineRspResult(Choice.PAPER, Choice.ROCK);
        assertThat(result.getUserGameResult(), is(GameResult.WON));
    }
}