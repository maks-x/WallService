package assemble.postObjects

data class Likes(
    val count: Int = 0,
    val userLikes: Boolean = false,
    val canLike: Boolean = true,
    val canPublish: Boolean = true
){
    override fun toString(): String {
        return "Likes: $count"
    }
}