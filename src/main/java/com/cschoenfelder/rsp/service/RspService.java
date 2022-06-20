package com.cschoenfelder.rsp.service;


import com.cschoenfelder.rsp.resource.RspResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RspService {

    private RspComputerPlayer rspComputerPlayer;
    private RspGameEngine rspGameEngine;


    public RspService(@Autowired RspComputerPlayer rspComputerPlayer, @Autowired RspGameEngine rspGameEngine) {
        this.rspComputerPlayer = rspComputerPlayer;
        this.rspGameEngine = rspGameEngine;
    }

    public RspResult getRspResult(Choice userChoice) {
      Choice computerChoice = rspComputerPlayer.choose();
      return rspGameEngine.determineRspResult(userChoice, computerChoice);
    }




}
