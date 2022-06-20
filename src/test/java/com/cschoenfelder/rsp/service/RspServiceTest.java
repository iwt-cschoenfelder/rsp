package com.cschoenfelder.rsp.service;

import com.cschoenfelder.rsp.resource.RspResult;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;

import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

@MockitoSettings(strictness = Strictness.LENIENT)
@ExtendWith(MockitoExtension.class)
class RspServiceTest {

    @InjectMocks
    RspService classUnderTest;

    @Mock
    RspComputerPlayer mockedRspComputerPlayer;

    @Mock
    RspGameEngine mockedRspGameEngine;

    @Captor
    ArgumentCaptor<Choice> capturedUserChoice;

    @Captor
    ArgumentCaptor<Choice> capturedComputerChoice;



    @Test
    void testGetRspResult() {
        Choice userChoice = Choice.ROCK;
        when(mockedRspComputerPlayer.choose()).thenReturn(Choice.SCISSOR);

        RspResult rspResult = classUnderTest.getRspResult(userChoice);

        verify(mockedRspComputerPlayer, times(1)).choose();
        verify(mockedRspGameEngine, times(1)).determineRspResult(capturedUserChoice.capture(), capturedComputerChoice.capture());

        assertThat(capturedUserChoice.getValue(), is(Choice.ROCK));
        assertThat(capturedComputerChoice.getValue(), is(Choice.SCISSOR));

    }


}