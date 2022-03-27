package assemble

data class Views(
    val count: Int = 0
){
    override fun toString(): String {
        return "Views: $count"
    }
}