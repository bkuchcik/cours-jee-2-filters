rootProject.name = "cours-jee-2-filters"

include("cours-filters-java", "cours-filters-kotlin")
includeIfExists(projectName = "tp-arithmetic-java")
includeIfExists(projectName = "tp-arithmetic-kotlin")

fun includeIfExists(projectName: String) {
    if (file(projectName).exists()) {
        include(projectName)
    }
}
