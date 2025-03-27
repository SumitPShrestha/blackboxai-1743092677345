package com.cm.cmconfigurationservice.models

import jakarta.persistence.*

@Table
@Entity
class Menu(
    @Id @GeneratedValue(strategy = GenerationType.AUTO) var id: Long,
    @Column(name = "display_name") var displayName: String,
    var description: String,
    var url: String,
    @Column(name = "parent_menu")
    var parentMenu: Long?,
)