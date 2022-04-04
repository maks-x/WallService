import assemble.*
import assemble.attachments.*
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneOffset

data class Post(
    val id: Int? = null,
    val ownerID: Int = 1,
    val fromID: Int = 1,
    val createdBy: Int = 0,
    val date: Int = (System.currentTimeMillis() / 1000).toInt(),
    val text: String? = null,
    val replyOwnerID: Int = 0,
    val replyPostID: Int = 0,
    val friendsOnly: Boolean = false,
    val comments: Comments = Comments(),
    val copyright: Copyright = Copyright(),
    val likes: Likes = Likes(),
    val reposts: Reposts = Reposts(),
    val views: Views = Views(),
    val postType: String = "post",
    val postSource: PostSource? = null,
    val attachments: Array<Attachment>? = null,
    val geo: Geo? = null,
    val signerID: Int = 0,
    val copyHistory: Array<Post>? = null,
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

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Post

        if (id != other.id) return false
        if (fromID != other.fromID) return false
        if (date != other.date) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id ?: 0
        result = 31 * result + fromID
        result = 31 * result + date
        return result
    }

}