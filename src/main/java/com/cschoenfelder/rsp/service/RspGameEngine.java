package com.cschoenfelder.rsp.service;

import com.cschoenfelder.rsp.resource.RspResult;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class RspGameEngine {

    /**
     * rsp game data structure
     */
    private final Map<Choice, List<Choice>> choiceToBeatenByChoicesMap = new HashMap<>(){{
        put(Choice.ROCK, Arrays.asList(Choice.PAPER, Choice.WELL));
        put(Choice.PAPER, Arrays.asList(Choice.SCISSOR));
        put(Choice.SCISSOR, Arrays.asList(Choice.ROCK, Choice.WELL));
        put(Choice.WELL, Arrays.asList(Choice.PAPER));
    }};


    public RspResult determineRspResult(Choice userChoice, Choice computerChoice) {
        List<Choice> beatenByChoices  = choiceToBeatenByChoicesMap.get(userChoice);
        GameResult gameResultFromUserPerspective  = beatenByChoices.contains(computerChoice) ? GameResult.LOST : (computerChoice == userChoice ? GameResult.DRAW : GameResult.WON);
        return new RspResult(userChoice, computerChoice, gameResultFromUserPerspective);
    }
}
