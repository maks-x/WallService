import assemble.*
import assemble.attachments.*

fun main() {
//    WallService.add(
//        Post(
//            text = "This is the first post on our wall!",
//            likes = Likes(count = 89),
//            comments = Comments(count = 65),
//            views = Views(count = 134),
//            reposts = Reposts(count = 20)
//        )
//    )
//
//    WallService.add(
//        Post(
//            text = "This is the second post on our wall!"
//        )
//    )
//
//    println(WallService.postByID(2))
//
//    Thread.sleep(2000)
//    WallService.update(Post(id = 2, text = "We have updated the second post"))
//
//    println(WallService.postByID(2))
    val post =
        WallService.add(
            Post(
                fromID = 5,
                attachments = arrayOf(
                    VideoAttachment(Video()),
                    PhotoAttachment(Photo()),
                    DocAttachment(Doc()),
                    AudioAttachment(Audio()),
                    LinkAttachment(Link()),
                )
            )
        )
    for (item in post.attachments!!) {
        println("${item.type} -> $item")
    }
    val newVideo = VideoAttachment(Video("new video!!!"))
    println("${newVideo.type} -> ${newVideo.video.title}")
}