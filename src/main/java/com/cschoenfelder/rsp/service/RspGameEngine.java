package com.cschoenfelder.rsp.service;

import com.cschoenfelder.rsp.resource.RspResult;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;


@Service
public class RspGameEngine {

    /**
     * rsp game data structure
     */
    private Map<Choice, Choice> choiceToBeatenByChoiceMap = new HashMap<>(){{
        put(Choice.ROCK, Choice.PAPER);
        put(Choice.PAPER, Choice.SCISSOR);
        put(Choice.SCISSOR, Choice.ROCK);
    }};


    public RspResult determineRspResult(Choice userChoice, Choice computerChoice) {
        Choice beatenByChoice  = choiceToBeatenByChoiceMap.get(userChoice);
        GameResult gameResultFromUserPerspective  = computerChoice == beatenByChoice ? GameResult.LOST : (computerChoice == userChoice ? GameResult.DRAW : GameResult.WON);
        return new RspResult(userChoice, computerChoice, gameResultFromUserPerspective);
    }
}
