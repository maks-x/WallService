import assemble.*

fun main() {
    WallService.add(
        Post(
            text = "This is the first post on our wall!",
            likes = Likes(count = 89),
            comments = Comments(count = 65),
            views = Views(count = 134),
            reposts = Reposts(count = 20)
        )
    )

    WallService.add(
        Post(
            text = "This is the second post on our wall!"
        )
    )

    WallService.printPostWithID(2)

    Thread.sleep(2000)
    WallService.update(Post(id = 2, text = "We have updated the second post"))

    WallService.printPostWithID(2)
}