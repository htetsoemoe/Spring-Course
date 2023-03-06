package com.example.demoresponsestatus.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BANDWIDTH_LIMIT_EXCEEDED, reason = "Custom Bandwidth Limit Exceeded Exception")
public class CustomBandwidthLimitException extends RuntimeException{
}
