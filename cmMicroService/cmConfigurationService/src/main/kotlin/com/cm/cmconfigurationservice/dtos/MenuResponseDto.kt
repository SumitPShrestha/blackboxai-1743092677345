package com.cm.cmconfigurationservice.dtos

import lombok.Builder

@Builder
data class MenuResponseDto(
    val id: Long, val title: String, val description: String, val url: String, val subMenu: List<MenuResponseDto>
)