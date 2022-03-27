object WallService {
    private var posts = emptyArray<Post>()
    private var postID = 1

    fun add(post: Post): Post {
        val newPost = post.copy(id = postID)
        posts += newPost
        postID++
        return posts.last()
    }

    fun update(post: Post): Boolean {
        for ((index, item) in posts.withIndex()) {
            when (item.id) {
                post.id -> {
                    posts[index] = post.copy(fromId = item.fromId, date = item.date)
                    return true
                }
            }
        }
        return false
    }

    fun printPostWithID(ID: Int) {
        for (item in posts) {
            when (item.id) {
                ID -> println(item)
            }
        }
    }

    fun clearWall(){
        posts = emptyArray()
        postID = 1
    }
}