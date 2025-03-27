package com.cm.cmconfigurationservice.controllers

import com.cm.cmconfigurationservice.dtos.MenuResponseDto
import com.cm.cmconfigurationservice.services.api.IMenuService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("Configurations")
class MenuController(private val menuService: IMenuService) {

    @GetMapping("GetAssignedMenuList")
    fun getMenus(): ResponseEntity<List<MenuResponseDto>> {

        val assignedMenus = menuService.getAssignedMenus()
        return ResponseEntity.ok(assignedMenus)
    }
}