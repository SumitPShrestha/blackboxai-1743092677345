package com.cm.cmconfigurationservice.utils

import com.cm.cmconfigurationservice.dtos.MenuResponseDto
import com.cm.cmconfigurationservice.models.Menu

class MenuUtil {
    companion object Converter {

        fun convertToMenuResponseDto(menus: List<Menu>): List<MenuResponseDto> {
            // Helper function to recursively find submenus for a given menu
            fun findSubMenus(parentId: Long, allMenus: List<Menu>): List<MenuResponseDto> {
                // Find all menus where parentMenu is the given parentId
                return allMenus.filter { it.parentMenu == parentId }.map { menu ->
                    // Recursively create MenuResponseDto for each submenu
                    MenuResponseDto(
                        id = menu.id,
                        title = menu.displayName,
                        description = menu.description,
                        url = menu.url,
                        subMenu = findSubMenus(menu.id, allMenus) // Recursively find submenus
                    )
                }
            }

            // Iterate over all menus and convert them into MenuResponseDto, adding submenus
            return menus.filter { it.parentMenu == null }.map { rootMenu ->
                MenuResponseDto(
                    id = rootMenu.id,
                    title = rootMenu.displayName,
                    description = rootMenu.description,
                    url = rootMenu.url,
                    subMenu = findSubMenus(rootMenu.id, menus) // Find submenus for the root menu
                )
            }
        }
    }

}