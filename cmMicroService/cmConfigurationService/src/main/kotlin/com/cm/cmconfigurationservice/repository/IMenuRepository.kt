package com.cm.cmconfigurationservice.repository

import com.cm.cmconfigurationservice.models.Menu
import org.springframework.data.repository.CrudRepository

interface IMenuRepository: CrudRepository<Menu, Long> {

}
