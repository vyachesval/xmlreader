package dev.xmlreader.xml

import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root

@Root(name = "breakfast_menu")
data class BreakfastMenu @JvmOverloads constructor(
    @field:ElementList(inline = true)
    @param:ElementList(inline = true)
    var foodList: List<Food> = emptyList()
)