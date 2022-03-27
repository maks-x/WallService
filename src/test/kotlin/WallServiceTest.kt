import assemble.Comments
import assemble.Likes
import assemble.Reposts
import assemble.Views
import org.junit.Test

import org.junit.Assert.*

class WallServiceTest {

    @Test
    fun add() {
        val newPost = Post(
            id = 4,
            text = "test post"
        )
        val addedId = WallService.add(newPost).id

        val result = addedId != 4 && addedId >= 1

        assertEquals(true, result)
    }

    @Test
    fun updateExisting() {
        val postId = WallService.add(Post(text = "")).id
        val result = WallService.update(Post(id = 1, text = "W"))

        assertTrue(result)
    }

    @Test
    fun updateNoneExisting() {
        val postId = WallService.add(Post(text = "")).id
        val result = WallService.update(Post(id = 5, text = "W"))

        assertFalse(result)
    }
}