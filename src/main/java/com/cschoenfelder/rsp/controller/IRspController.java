package com.cschoenfelder.rsp.controller;
import com.cschoenfelder.rsp.resource.RspRequest;
import com.cschoenfelder.rsp.resource.RspResult;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

public interface IRspController {

//    SWAGGER / UI not working out of the box with SB 2.7 TBD
//    @ResponseBody
//    @ApiResponses({
//            @ApiResponse(
//                    code = 200,
//                    message = "game result could be retrieved"),
//            @ApiResponse (
//                    code = 400,
//                    message = "Bad request, error in resource object")
//    })
//    @ApiOperation(
//            value = "Gets a ROCK SCISSOR PAPER Game Result by given user choice and generating a computer choice")
    public ResponseEntity<RspResult> getRspResult(@RequestBody RspRequest rspRequest);
}
