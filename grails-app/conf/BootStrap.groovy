
import com.test.Role
import com.test.User
import com.test.UserRole

class BootStrap {

    def init = { servletContext ->
      
      def adminRole = new Role(authority: 'ROLE_ADMIN').save(flush: true)
      def userRole = new Role(authority: 'ROLE_USER').save(flush: true)

      def testUser1 = new User(username: 'admin', password: '1234')
      testUser1.save(flush: true)
      def testUser2 = new User(username: 'user', password: '1234')
      testUser2.save(flush: true)

      UserRole.create testUser1, adminRole, true
      UserRole.create testUser2, userRole, true

      assert User.count() == 2
      assert Role.count() == 2
      assert UserRole.count() == 2
      
    }
    def destroy = {
    }
}
