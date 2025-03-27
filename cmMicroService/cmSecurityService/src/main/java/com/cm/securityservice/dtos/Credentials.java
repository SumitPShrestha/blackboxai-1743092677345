package com.cm.securityservice.dtos;

import lombok.Builder;

@Builder
public record Credentials(String username, String password) {
}
