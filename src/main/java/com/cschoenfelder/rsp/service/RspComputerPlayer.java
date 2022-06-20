package com.cschoenfelder.rsp.service;


import org.springframework.stereotype.Service;

/**
 *  represents the computer player abilities
 */
@Service
public class RspComputerPlayer {

    public Choice choose(){
        return Choice.randomChoice();
    }


    /*
        can do this later on
     */
    public void feedMyElephantBrainAfterResult(Object data) {
        // e.g. persist and make future choices more data based
    }






}
