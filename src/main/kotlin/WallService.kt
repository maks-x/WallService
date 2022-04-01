object WallService {
    private var posts = emptyArray<Post>()
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

    fun printPostWithID(requiredID: Int) {
        for (item in posts) {
            when (item.id) {
                requiredID -> println(item)
            }
        }
    }

    fun clearWall(): Boolean {
        posts = emptyArray()
        newPostID = 1
        return true
    }
}
