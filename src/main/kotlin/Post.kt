import assemble.*
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneOffset

data class Post(
    val id: Int = 0,
    val ownerID: Int = 1,
    val fromID: Int = 1,
    val createdBy: Int = 0,
    val date: Int = (System.currentTimeMillis() / 1000).toInt(),
    val text: String,
    val replyOwnerID: Int = 0,
    val replyPostID: Int = 0,
    val friendsOnly: Boolean = false,
    val comments: Comments = Comments(),
    val copyright: Copyright = Copyright(),
    val likes: Likes = Likes(),
    val reposts: Reposts = Reposts(),
    val views: Views = Views(),
    val postType: String = "post",
    val signerID: Int = 0,
    val canPin: Boolean = false,
    val canDelete: Boolean = false,
    val canEdit: Boolean = false,
    val isPinned: Boolean = true,
    val markedAsAds: Boolean = false,
    val isFavorite: Boolean = false,
    val donut: Donut = Donut(),
    val postponedID: Boolean = false
    ) {

    @Override
    override fun toString(): String {
        return """
            ///////////////////////////////////
            Post ID: $id  Author: $fromID    ${
                //TODO возможно с датой можно проще и лаконичнее, но пока так)
                LocalDateTime.ofInstant(Instant.ofEpochSecond(date.toLong()), ZoneOffset.systemDefault())
            }
            ***
                $text
            ***
            $views  $likes  $comments   $reposts
        """.trimIndent()
    }

}