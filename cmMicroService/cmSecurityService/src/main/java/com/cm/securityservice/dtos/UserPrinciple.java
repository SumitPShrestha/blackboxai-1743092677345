package com.cm.securityservice.dtos;

import lombok.Builder;

@Builder
public record UserPrinciple(String username, String token) {
}
