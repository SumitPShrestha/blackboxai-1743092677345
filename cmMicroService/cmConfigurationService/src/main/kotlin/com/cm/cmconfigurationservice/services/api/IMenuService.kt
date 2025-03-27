package com.cm.cmconfigurationservice.services.api

import com.cm.cmconfigurationservice.dtos.MenuResponseDto

interface IMenuService {
    fun getAssignedMenus():List<MenuResponseDto>
}