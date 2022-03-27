package assemble

data class Comments(
    val count: Int = 0,
    val canPost: Boolean = true,
    val groupsCanPost: Boolean = true,
    val canClose: Boolean = true,
    val canOpen: Boolean = true
){
    override fun toString(): String {
        return "Comments: $count"
    }
}
