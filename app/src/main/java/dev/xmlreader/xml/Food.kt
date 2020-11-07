package dev.xmlreader.xml

import org.simpleframework.xml.Element
import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root

@Root(name = "food")
data class Food (

    @field:Element(name = "name")
    @param:Element(name = "name")
    var name: String? = null,

    @field:Element(name = "price")
    @param:Element(name = "price")
    var price: String? = null,

    @field:Element(name = "description")
    @param:Element(name = "description")
    var description: String? = null,

    @field:Element(name = "calories")
    @param:Element(name = "calories")
    var calories: String? = null
)