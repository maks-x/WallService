package assemble.wallObjects

import assemble.attachments.*

data class Comment(
    val id: Int? = null,
    val fromID: Int = 1,
    val date: Int? = (System.currentTimeMillis() / 1000).toInt(),
    val text: String = "there is no comment yet",
    val donut: Donut = Donut(),
    val replyToUser: Int? = null,
    val replyToComment: Int? = null,
    val attachments: Array<Attachment>? = null,
    val parents_stack: Array<Int>? = null,
    val thread: Thread? = null
){
    //TODO equals() and hashCode()
}

//TODO необходим ли отдельный класс Donut, если подобный(только с расширенными свойствами) мы уже создавали для Post?
data class Donut(
    val isDon: Boolean = false,
    val placeholder: String = "no VK Donut"
)

data class Thread(
    val count: Int = 1,
    val items: Array<Comment>? = null,
    val canPost: Boolean = true,
    val showReplyButton: Boolean = true,
    val groupsCanPost: Boolean = true
){
    //TODO equals() and hashCode()
}