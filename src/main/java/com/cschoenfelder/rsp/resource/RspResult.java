package com.cschoenfelder.rsp.resource;

import com.cschoenfelder.rsp.service.Choice;
import com.cschoenfelder.rsp.service.GameResult;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class RspResult {

    private Choice userChoice;
    private Choice computerChoice;
    private GameResult userGameResult;

}
