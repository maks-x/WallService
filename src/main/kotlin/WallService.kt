import assemble.postObjects.Post
import assemble.wallObjects.Comment
import exceptions.PostNotFoundException

object WallService {
    private var posts = emptyArray<Post>()
    private var comments = emptyArray<Comment>()

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
        findPostByID(comment.postID) ?: throw PostNotFoundException("post #${comment.postID} not found")
        comments += comment
        return comment
    }
}
