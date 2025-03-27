package com.cm.cmuserservice.dto;

import lombok.Builder;

import java.time.LocalDate;

@Builder
public record UserDetailsRequestDto(String firstName, String middleName, String lastName, String gender,
                                    LocalDate birthDate) {
}
