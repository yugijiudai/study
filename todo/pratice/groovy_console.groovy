class ProjectVersion {
    private int major
    private int minor

    ProjectVersion(int major, int minor) {
        this.major = major
        this.minor = minor
    }

    int getMajor() {
        //不需要写return
        major
    }

    int getMinor() {
        return minor
    }
}

ProjectVersion v1 = new ProjectVersion(3, 1)
println v1.major

ProjectVersion v2 = null
println v1 == v2