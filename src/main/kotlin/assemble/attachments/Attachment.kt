package assemble.attachments

data class Photo(val text: String = "This is some photo")
data class Audio(val title: String = "some audio")
data class Video(val title: String = "some video")
data class Doc(val title: String = "some document")
data class Link(val title: String = "some link")

sealed class Attachment(val type: String)

data class PhotoAttachment(val photo: Photo) : Attachment("photo")
data class AudioAttachment(val audio: Audio) : Attachment("audio")
data class VideoAttachment(val video: Video) : Attachment("video")
data class DocAttachment(val file: Doc) : Attachment("doc")
data class LinkAttachment(val link: Link) : Attachment("link")