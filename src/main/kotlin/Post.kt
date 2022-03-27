import assemble.*
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneOffset

data class Post(
    val id: Int = 0,
    val ownerId: Int = 1,
    val fromId: Int = 1,
    val createdBy: Int = 0,
    val date: Int = (System.currentTimeMillis() / 1000).toInt(),
    val text: String,
    val replyOwnerId: Int = 0,
    val replyPostId: Int = 0,
    val friendsOnly: Boolean = false,
    val comments: Comments = Comments(),
    val copyright: Copyright = Copyright(),
    val likes: Likes = Likes(),
    val reposts: Reposts = Reposts(),
    val views: Views = Views(),
    val postType: String = "post",
    val signerId: Int = 0,
    val canPin: Boolean = false,
    val can_delete: Boolean = false,
    val can_edit: Boolean = false,
    val is_pinned: Boolean = true,
    val marked_as_ads: Boolean = false,
    val is_favorite: Boolean = false,
    val donut: Donut = Donut(),
    val postponedId: Boolean = false
    ) {

    @Override
    override fun toString(): String {
        return """
            ///////////////////////////////////
            Post ID: $id  Author: $fromId    ${
                LocalDateTime.ofInstant(Instant.ofEpochSecond(date.toLong()), ZoneOffset.systemDefault())
            }
            ***
                $text
            ***
            $views  $likes  $comments   $reposts
        """.trimIndent()
    }

}