package com.cschoenfelder.rsp.resource;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class RspErrorResult {

    private String message;
    private String errorCode;

}
