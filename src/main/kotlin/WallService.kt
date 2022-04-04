import assemble.postObjects.Post
import assemble.wallObjects.Comment
import exceptions.*

object WallService {
    private var posts = emptyArray<Post>()
    private var comments = emptyArray<Comment>()
    private var commentReports = emptyArray<String>()

    private var newPostID = 1

    fun add(post: Post): Post {
        val newPost = post.copy(id = newPostID)
        posts += newPost
        newPostID++
        return posts.last()
    }

    fun update(post: Post): Boolean {
        for ((index, item) in posts.withIndex()) {
            when (item.id) {
                post.id -> {
                    posts[index] = post.copy(fromID = item.fromID, date = item.date)
                    return true
                }
            }
        }
        return false
    }

    fun findPostByID(requiredID: Int): Post? {
        var post: Post? = null
        for ((index, item) in posts.withIndex()) {
            when (item.id) {
                requiredID -> post = posts[index]
            }
        }
        return post
    }

    fun clearWall(): Boolean {
        posts = emptyArray()
        newPostID = 1
        return true
    }

    fun createComment(comment: Comment): Comment {
        findPostByID(comment.postID) ?: throw PostNotFoundException("Post #${comment.postID} not found")
        comments += comment
        return comment
    }

    fun findCommentByID(requiredID: Int): Comment? {
        var comment: Comment? = null
        for ((index, item) in comments.withIndex()) {
            when (item.id) {
                requiredID -> comment = comments[index]
            }
        }
        return comment
    }

    fun reportComment(ownerID: Int = 1, commentID: Int, reason: Int): Boolean {
        findCommentByID(commentID) ?: throw CommentNotFoundException("Comment #${commentID} not found")
        val text = when (reason) {
            0 -> "спам"
            1 -> "детская порнография"
            2 -> "экстремизм"
            3 -> "насилие"
            4 -> "пропаганда наркотиков"
            5 -> "материал для взрослых"
            6 -> "оскорбление"
            8 -> "призывы к суициду"
            else -> throw UnknownReportReasonException("reason #$reason: unknown (0-8 expected)")
        }
        commentReports += "$text: commentID $commentID, ownerID $ownerID"
        return true
    }

    fun getReports(): Array<String> {
        return commentReports
    }
}
