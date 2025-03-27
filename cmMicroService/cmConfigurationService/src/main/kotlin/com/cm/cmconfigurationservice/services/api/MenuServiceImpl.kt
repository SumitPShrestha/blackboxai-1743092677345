package com.cm.cmconfigurationservice.services.api

import com.cm.cmconfigurationservice.dtos.MenuResponseDto
import com.cm.cmconfigurationservice.models.Menu
import com.cm.cmconfigurationservice.repository.IMenuRepository
import com.cm.cmconfigurationservice.utils.MenuUtil
import org.springframework.stereotype.Service

@Service
class MenuServiceImpl(private val menuRepository: IMenuRepository) : IMenuService {
    override fun getAssignedMenus(): List<MenuResponseDto> {
        val menuList: List<Menu> = menuRepository.findAll().toList();
        return MenuUtil.convertToMenuResponseDto(menuList)
    }
}