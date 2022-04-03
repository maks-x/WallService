import assemble.postObjects.Post
import assemble.wallObjects.Comment
import exceptions.PostNotFoundException
import org.junit.Test

import org.junit.Assert.*

class WallServiceTest {

    @Test
    fun add() {
        WallService.clearWall()

        WallService.add(Post(id = 1, text = "new post"))
        val newestPost = WallService.add(
            Post(
                id = 4,
                text = "newest post"
            )
        )

        val result = newestPost.id == 2

        assertEquals(true, result)
    }

    @Test
    fun updateExisting() {
        WallService.clearWall()

        WallService.add(Post(text = ""))
        val result = WallService.update(Post(id = 1, text = "W"))

        assertTrue(result)
    }

    @Test
    fun updateNoneExisting() {
        WallService.clearWall()

        WallService.add(Post(text = ""))
        val result = WallService.update(Post(id = 2, text = "W"))

        assertFalse(result)
    }

    @Test
    fun testPostByID() {
        WallService.clearWall()

        val post1 = WallService.add(Post(1))
        WallService.add(Post(2))
        val result = WallService.findPostByID(1)

        assertEquals(post1, result)
    }

    @Test
    fun testCreateComment() {
        WallService.clearWall()

        WallService.add(Post()) //id = 1
        val comment1 = Comment(postID = 1, text = "")
        val result = WallService.createComment(comment1) == comment1

        assertTrue(result)
    }

    @Test(expected = PostNotFoundException::class)
    fun createCommentException() {
        WallService.clearWall()

        WallService.add(Post()) //id = 1
        WallService.createComment(Comment(postID = 2, text = ""))
    }
}