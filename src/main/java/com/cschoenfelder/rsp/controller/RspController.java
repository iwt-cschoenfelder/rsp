package com.cschoenfelder.rsp.controller;


import com.cschoenfelder.rsp.resource.RspErrorResult;
import com.cschoenfelder.rsp.resource.RspRequest;
import com.cschoenfelder.rsp.resource.RspResult;
import com.cschoenfelder.rsp.service.RspService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(
        path = "v1/rsp",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
public class RspController implements IRspController {

    private final RspService rspService;

    public RspController(@Autowired RspService rspService) {
        this.rspService = rspService;
    }

    @CrossOrigin
    @PostMapping
    public ResponseEntity<RspResult> getRspResult(@RequestBody RspRequest rspRequest) {
       return ResponseEntity.ok(rspService.getRspResult(rspRequest.getUserChoice()));
    }

    @ExceptionHandler({HttpMessageNotReadableException.class})
    public ResponseEntity<RspErrorResult> handleChoiceValidation() {
        RspErrorResult rspErrorResult = new RspErrorResult("please enter a valid choice, allowed values are ROCK, SCISSOR od STONE", "value.invalid");
        return new ResponseEntity<>(rspErrorResult, HttpStatus.BAD_REQUEST);
    }

}
