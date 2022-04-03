package assemble.postObjects

data class Reposts(
    val count: Int = 0,
    val userReposted: Boolean = false
){
    override fun toString(): String {
        return "Reposts: $count"
    }
}
