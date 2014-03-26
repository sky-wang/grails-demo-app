import co.soochow.Profile
import co.soochow.ProfileRole
import co.soochow.Role

class BootStrap {

    def init = { servletContext ->

        def adminRole = new Role(authority: 'ROLE_ADMIN').save(flush: true)
        def userRole = new Role(authority: 'ROLE_USER').save(flush: true)

        def testUser = new Profile(username: 'me', password: 'password')
        testUser.save(flush: true)

        ProfileRole.create testUser, adminRole, true

        assert Profile.count() == 1
        assert Role.count() == 2
        assert ProfileRole.count() == 1
    }
    def destroy = {
    }
}
