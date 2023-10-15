package com.plinio.circuitbreaker.controllers.v1;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
public class GetDevelopersParams {
    @NonNull
    private String t;
}
