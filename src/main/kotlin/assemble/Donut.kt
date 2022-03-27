package assemble

import Post

data class Donut(
    val isDonut: Boolean = false,
    val paidDuration: Int = 0,
    val placeholder: Post? = null, //TODO ?
    val canPublishFreeCopy: Boolean = false,
    val editMode: String = "all"
)
